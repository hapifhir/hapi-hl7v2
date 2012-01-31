/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MessageQuery.java".  Description:
 * "Queries messages in an SQL-like style.  "
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2005.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

/**
 * Queries messages in an SQL-like style. We get repeated row-like structures by
 * looping over repetitions of groups, segments, or fields.
 * 
 * This is a very advanced class ... maybe too advanced even for you. If you
 * find it confusing, please note that there are simpler ways to get data from a
 * message (like calling its getters or using Terser).
 * 
 * LOOPING: You specify the loop points as part of the query. For example you
 * could specify loop point x like this: <code>x = /.MSH-18(*)</code>. The * is
 * replaced by numbers 0, 1, 2, etc. as you loop through the results, so this
 * example would loop through repetitions of MSH-18. If there are multiple loop
 * points, the loops are nested so that each possible combination is returned.
 * Looping stops when none of the fields under a loop point are valued. The name
 * of the loop point ('x' in the example above) is arbitrary.
 * 
 * SELECTING FIELDS: The syntax is similar to SQL, except that Terser paths are
 * used in place of table.field. You can use the "as" keyword to give a field a
 * name, like this: <code>select /.MSH-7 as msg_date</code>. If your field is
 * under a loop point, replace the path up to the loop point with a loop point
 * reference, like this: <code>select {foo}-1 loop foo = /.PID-3(*)</code>
 * 
 * SELECTING ROWS: A "row" is a combination of all selected fields at one
 * iteration. You can filter which rows are returned using a where clause
 * similar to that in SQL. Use exact values or regular expressions, for example:
 * <code>where {1} like '.*blood.*'</code> or
 * <code>where {1}/PID-3-1 = '111'</code> Multiple filters can be separated with
 * commas (which mean 'and'). Future versions may support 'or', negation,
 * brackets, etc., but this version doesn't.
 * 
 * FULL EXAMPLE: select {pat-id}-1 as id loop pat-id = ./PID-3(*) where
 * {pat-id}-2 = 'mrn'
 * 
 * SUBTLETIES OF LOOPING: A loop point can be under another loop point. For
 * example consider the message:
 * 
 * MSH|etc.|etc. Z01|one~two|a Z01|three~four|b
 * 
 * The query, "select {a}-2, {b} loop a = /Z01(*), b = {a}-1(*)" would return: a
 * one a two b three b four
 * 
 * While the query "select {a}-2, {b} loop a = /Z01(*), b = /Z01(1)-1(*)" would
 * return: a one a two b one b two
 * 
 * In the first case, one loop point refers to another. In the second case the
 * loops are treated as independent, just as if they referred to different
 * branches of the message.
 * 
 * TODO: could support distinct easily by keeping record of rows and comparing
 * each one to previous rows
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:27 $ by $Author:
 *          jamesagnew $
 * @deprecated
 */
public class MessageQuery {

	/**
	 * @param theMessage
	 *            an HL7 message from which data are to be queried
	 * @param theQuery
	 *            the query (see class docs for syntax)
	 * @return data from the message that are selected by the query
	 */
	public static Result query(Message theMessage, String theQuery) {
		Properties clauses = getClauses(theQuery);

		// parse select clause
		StringTokenizer select = new StringTokenizer(
				clauses.getProperty("select"), ", ", false);
		List<String> fieldPaths = new ArrayList<String>(10);
		Map<String, Integer> names = new HashMap<String, Integer>(10);
		while (select.hasMoreTokens()) {
			String token = select.nextToken();
			if (token.equals("as")) {
				if (!select.hasMoreTokens()) {
					throw new IllegalArgumentException(
							"Keyword 'as' must be followed by a field label");
				}
				names.put(select.nextToken(), fieldPaths.size() - 1);
			} else {
				fieldPaths.add(token);
			}
		}

		// parse loop clause
		StringTokenizer loop = new StringTokenizer(clauses.getProperty("loop",
				""), ",", false);
		List<String> loopPoints = new ArrayList<String>(10);
		Map<String, Integer> loopPointNames = new HashMap<String, Integer>(10);
		while (loop.hasMoreTokens()) {
			String pointDecl = loop.nextToken();
			StringTokenizer tok = new StringTokenizer(pointDecl, "=", false);
			String name = tok.nextToken().trim();
			String path = tok.nextToken().trim();
			loopPoints.add(path);
			loopPointNames.put(name, loopPoints.size() - 1);
		}

		// parse where clause
		// TODO: this will do for now but it should really be evaluated like an
		// expression
		// rather than a list
		StringTokenizer where = new StringTokenizer(clauses.getProperty(
				"where", ""), ",", false);
		List<String> filters = new ArrayList<String>();
		while (where.hasMoreTokens()) {
			filters.add(where.nextToken());
		}
		String[] filterPaths = new String[filters.size()];
		String[] filterPatterns = new String[filters.size()];
		boolean[] exactFlags = new boolean[filters.size()];

		for (int i = 0; i < filters.size(); i++) {
			exactFlags[i] = true;
			String filter = filters.get(i);
			String[] parts = splitFromEnd(filter, "=");
			if (parts[1] != null) {
				parts[1] = parts[1].substring(1);
			} else {
				exactFlags[i] = false;
				parts = splitFromEnd(filter, "like");
				parts[1] = parts[1].substring(4);
			}
			filterPaths[i] = parts[0].trim();
			parts[1] = parts[1].trim();
			filterPatterns[i] = parts[1].substring(1, parts[1].length() - 1);
		}

		return new ResultImpl(theMessage,
				loopPoints.toArray(new String[0]), loopPointNames,
				fieldPaths.toArray(new String[0]), names,
				filterPaths, filterPatterns, exactFlags);
	}

	private static Properties getClauses(String theQuery) {
		Properties clauses = new Properties();

		String[] split = splitFromEnd(theQuery, "where ");
		setClause(clauses, "where", split[1]);

		split = splitFromEnd(split[0], "loop ");
		setClause(clauses, "loop", split[1]);
		setClause(clauses, "select", split[0]);

		if (clauses.getProperty("where", "").indexOf("loop ") >= 0) {
			throw new IllegalArgumentException(
					"The loop clause must precede the where clause");
		}
		if (clauses.getProperty("select") == null) {
			throw new IllegalArgumentException(
					"The query must begin with a select clause");
		}
		return clauses;
	}

	private static void setClause(Properties theClauses, String theName,
			String theClause) {
		if (theClause != null) {
			theClauses.setProperty(theName,
					theClause.substring(theName.length()).trim());
		}
	}

	private static String[] splitFromEnd(String theString, String theMarker) {
		String[] result = new String[2];
		int begin = theString.indexOf(theMarker);
		if (begin >= 0) {
			result[0] = theString.substring(0, begin);
			result[1] = theString.substring(begin);
		} else {
			result[0] = theString;
		}
		return result;
	}

	/**
	 * A result set for a message query.
	 * 
	 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
	 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:27 $ by
	 *          $Author: jamesagnew $
	 */
	public static interface Result {

		/**
		 * @param theFieldNumber
		 *            numbered from zero in the order they are specified in the
		 *            query
		 * @return the corresponding value in the current row
		 */
		public String get(int theFieldNumber);

		/**
		 * @param theFieldName
		 *            a field name as specified in the query with the keyword
		 *            "as"
		 * @return the corresponding value in the current row
		 */
		public String get(String theFieldName);

		/**
		 * @return a list of named fields as defined with 'as' in the query
		 */
		public String[] getNamedFields();

		/**
		 * Advances to the next "row" of data if one is available.
		 * 
		 * @return true if another row is available
		 * @throws HL7Exception
		 */
		public boolean next() throws HL7Exception;

	}

	private static class ResultImpl implements Result {

		private Terser myTerser;
		private String[] myValues;
		private String[] myLoopPoints;
		private Map<String, Integer> myLoopPointNames;
		private String[] myFieldPaths;
		private Map<String, Integer> myFieldNames;
		private int[] myIndices;
		private int[] myNumEmpty; // number of empty sub-loops since last
									// non-empty one
		private int[] myMaxNumEmpty;
		private boolean myNonLoopingQuery = false;
		private String[] myWherePaths;
		private String[] myWhereValues;
		private String[] myWherePatterns;
		private boolean[] myExactMatchFlags;

		public ResultImpl(Message theMessage, String[] theLoopPoints,
				Map<String, Integer> theLoopPointNames, String[] theFieldPaths,
				Map<String, Integer> theFieldNames, String[] theWherePaths,
				String[] theWherePatterns, boolean[] theExactMatchFlags) {

			myTerser = new Terser(theMessage);
			myLoopPoints = theLoopPoints;
			myIndices = new int[theLoopPoints.length];
			myNumEmpty = new int[theLoopPoints.length];
			myMaxNumEmpty = getMaxNumEmpty(theLoopPoints);
			myLoopPointNames = theLoopPointNames;
			myFieldPaths = theFieldPaths;
			myValues = new String[theFieldPaths.length];
			myFieldNames = theFieldNames;
			myWherePaths = theWherePaths;
			myWherePatterns = theWherePatterns;
			myExactMatchFlags = theExactMatchFlags;

			if (theLoopPoints.length == 0) {
				myNonLoopingQuery = true; // if no loops, give ourselves 1
											// iteration
			} else {
				myIndices[myIndices.length - 1] = -1; // start before 1st
														// iteration
			}

		}

		// extracts max number of empty iterations for each loop point (this is
		// communicated
		// as an optional integer after the *, e.g. blah(*3) ... default is 0).
		private int[] getMaxNumEmpty(String[] theLoopPoints) {
			int[] retVal = new int[theLoopPoints.length];
			for (int i = 0; i < theLoopPoints.length; i++) {
				retVal[i] = getMaxNumEmpty(theLoopPoints[i]);
			}
			return retVal;
		}

		private int getMaxNumEmpty(String theLoopPoint) {
			int retVal = 0; // default

			Matcher m = Pattern.compile("\\*(\\d+)").matcher(theLoopPoint);
			if (m.find()) {
				String num = m.group(1);
				retVal = Integer.parseInt(num);
			}

			return retVal;
		}

		// returns true if some field under the given loop point has a value at
		// the present
		// iteration
		private boolean currentRowValued(int theLoopPoint) {
			for (int i = 0; i < myFieldPaths.length; i++) {
				if (referencesLoop(myFieldPaths[i], theLoopPoint)) {
					String value = myValues[i];
					if (value != null && value.length() > 0) {
						return true;
					}
				}
			}
			return false;
		}

		// returns true if the current row matches the where clause filters
		private boolean currentRowMatchesFilter() {
			for (int i = 0; i < myWhereValues.length; i++) {
				if (myExactMatchFlags[i]) {
					if (!myWherePatterns[i].equals(myWhereValues[i])) {
						return false;
					}
				} else {
					if (!Pattern.matches(myWherePatterns[i], myWhereValues[i])) {
						return false;
					}
				}
			}
			return true;
		}

		// true if the given path references the given loop point (directly
		// or indirectly)
		private boolean referencesLoop(String theFieldPath, int theLoopPoint) {
			String path = theFieldPath;
			int lp;
			while ((lp = getLoopPointReference(path)) >= 0) {
				if (lp == theLoopPoint) {
					return true;
				} else {
					path = myLoopPoints[lp];
				}
			}
			return false;
		}

		// expands a set of paths to their current loop point iterations, and
		// gets
		// current values from our message
		private String[] getCurrentValues(String[] thePaths)
				throws HL7Exception {
			String[] paths = composePaths(thePaths);
			String[] values = new String[paths.length];
			for (int i = 0; i < paths.length; i++) {
				values[i] = myTerser.get(paths[i]);
				if (values[i] == null) {
					values[i] = "";
				}
			}
			return values;
		}

		// creates full Terser paths from current location, loop points, and
		// given paths
		// with loop point references
		private String[] composePaths(String[] thePaths) {
			String[] currentLoopPoints = composeLoopPoints();
			String[] result = new String[thePaths.length];
			for (int i = 0; i < thePaths.length; i++) {
				result[i] = thePaths[i];
				int ref = getLoopPointReference(thePaths[i]);
				if (ref >= 0) {
					result[i] = expandLoopPointReference(result[i],
							currentLoopPoints[ref]);
				}
			}
			return result;
		}

		// parameterizes loop points with present location (i.e. replaces * with
		// current
		// indices)
		private String[] composeLoopPoints() {
			String[] result = new String[myLoopPoints.length];
			for (int i = 0; i < myLoopPoints.length; i++) {
				result[i] = myLoopPoints[i].replaceAll("\\*\\d*",
						String.valueOf(myIndices[i]));

				int ref = getLoopPointReference(myLoopPoints[i]);
				if (ref >= i) {
					throw new IllegalStateException(
							"Loop point must be defined after the "
									+ "one it references: " + myLoopPoints[i]);
				} else if (ref >= 0) {
					result[i] = expandLoopPointReference(result[i], result[ref]);
				}
			}
			return result;
		}

		// extracts LP# of label between first '{' and first '}', or -1 if there
		// isn't one
		private int getLoopPointReference(String thePath) {
			StringTokenizer tok = new StringTokenizer(thePath, "{}", false);
			if (thePath.indexOf('{') >= 0 && tok.hasMoreTokens()) {
				String ref = tok.nextToken();
				return myLoopPointNames.get(ref);
			} else {
				return -1;
			}
		}

		private String expandLoopPointReference(String thePath,
				String theLoopPoint) {
			return thePath.replaceAll("\\{.*\\}", theLoopPoint);
		}

		/**
		 * @see ca.uhn.hl7v2.util.MessageQuery.Result#get(int)
		 */
		public String get(int theFieldNumber) {
			if (theFieldNumber < 0 || theFieldNumber >= myValues.length) {
				throw new IllegalArgumentException(
						"Field number must be between 0 and "
								+ (myValues.length - 1));
			}
			return myValues[theFieldNumber];
		}

		/**
		 * @see ca.uhn.hl7v2.util.MessageQuery.Result#get(java.lang.String)
		 */
		public String get(String theFieldName) {
			Integer fieldNum = myFieldNames.get(theFieldName);
			if (fieldNum == null) {
				throw new IllegalArgumentException(
						"Field name not recognized: " + theFieldName);
			}
			return get(fieldNum);
		}

		/**
		 * @throws HL7Exception
		 * @see ca.uhn.hl7v2.util.MessageQuery.Result#next()
		 */
		public boolean next() throws HL7Exception {
			if (myNonLoopingQuery) {
				myNonLoopingQuery = false;
				myValues = getCurrentValues(myFieldPaths);
				myWhereValues = getCurrentValues(myWherePaths);
				return currentRowMatchesFilter();
			}

			boolean hasNext = false;
			findNext: for (int i = myIndices.length - 1; i >= 0; i--) {
				boolean gotMatch = false;
				while (!gotMatch && myNumEmpty[i] <= myMaxNumEmpty[i]) {
					myIndices[i]++;
					myValues = getCurrentValues(myFieldPaths);
					myWhereValues = getCurrentValues(myWherePaths);

					if (!currentRowValued(i)) {
						myNumEmpty[i]++;
					} else {
						myNumEmpty[i] = 0;
					}
					if (currentRowMatchesFilter()) {
						gotMatch = true;
					}
				}

				hasNext = myNumEmpty[i] <= myMaxNumEmpty[i];// &&
															// currentRowMatchesFilter();
				if (hasNext) {
					break findNext;
				}

				myIndices[i] = 0;
				myNumEmpty[i] = 0;

				// TODO: if we aren't allowing empties in this loop, and have no
				// value, we want to
				// return the null in the super-loop. However, we don't know
				// which loop point, if
				// any, is the super-loop. If it was the next one we could do
				// this ...
				// if (i > 0 && myMaxNumEmpty[i] == 0 && myMaxNumEmpty[i-1] > 0
				// && myIndices[i-1] == 0) {
				// myIndices[i-1] = -1;
				// } ... but it may not be, so we'll ignore this problem for
				// now.
			}
			return hasNext;
		}

		/**
		 * @see ca.uhn.hl7v2.util.MessageQuery.Result#getNamedFields()
		 */
		public String[] getNamedFields() {
			return myFieldNames.keySet().toArray(new String[0]);
		}

	}

}
