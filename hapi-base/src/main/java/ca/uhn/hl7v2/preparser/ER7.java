package ca.uhn.hl7v2.preparser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import ca.uhn.hl7v2.parser.EncodingCharacters;

/*
The point of this class (all static members, not instantiatable) is to take a
traditionally-encoded HL7 message and add all it's contents to a Properties
object, via the parseMessage() method.

The key-value pairs added to the Properties argument have keys that represent a
datum's location in the message.  (in the ZYX-1-2[0] style.  TODO: define
exactly.)  See Datum, particularly the toString() of that class.
Anyway, the Properties keys are those and the values are the tokens found.

Note: we accept useless field repetition separators at the end of a 
field repetition sequence.  i.e. |855-4545~555-3792~~~| , and interpret this
as definining repetitions 0 and 1.  This might not be allowed.  (HL7 2.3.1
section 2.10 explicitly allows this behaviour for fields / components /
subcomponents, but the allowance is notably absent for repetitions.  TODO:
nail down.)  We allow it anyway.

Also, we accept things like |855-4545~~555-3792|, and interpret it as defining
repetitions 0 and 2.  The spec would seem to disallow this too, but there's no
harm.  :D  
*/
public class ER7 {
	
	private ER7() {}

	/** characters that delimit segments.  for use with StringTokenizer.
	We are forgiving: HL7 2.3.1 section 2.7 says that carriage return ('\r') is
	the only segment delimiter.  TODO: check other versions. */ 
	static final String segmentSeparators = "\r\n\f";

	/** Parses message and dumps contents to props, with keys in the 
	ZYX[a]-b[c]-d-e style.
	*/
	public static boolean parseMessage(/*out*/ Properties props, 
		/*in*/ List<DatumPath> msgMask, /*in*/ String message)
	{
		boolean ok = false;
		if(message != null) {
			if(props == null)
				props = new Properties();

			StringTokenizer messageTokenizer 
				= new StringTokenizer(message, segmentSeparators);
			if(messageTokenizer.hasMoreTokens()) {
				String firstSegment = messageTokenizer.nextToken();
				EncodingCharacters encodingChars = new EncodingCharacters('0', "0000");
				if(parseMSHSegmentWhole(props, msgMask, encodingChars, firstSegment)) {
					ok = true;
					SortedMap<String, Integer> segmentId2nextRepIdx = new TreeMap<String, Integer>();
					segmentId2nextRepIdx.put(new String("MSH"), 1); 
						// in case we find another MSH segment, heh.
					while(messageTokenizer.hasMoreTokens()) {
						parseSegmentWhole(props, segmentId2nextRepIdx, 
							msgMask, encodingChars, messageTokenizer.nextToken());
					}
				}
			}
		}
		return ok;
	}
	
	/** given segment, starting with "MSH", then encoding characters, etc...
	put MSH[0]-1[0]-1-1 (== MSH-1) and MSH[0]-2[0]-1-1 (== MSH-2) into props, if found,
	plus everything else found in 'segment' */
	protected static boolean parseMSHSegmentWhole(/*out*/ Properties props, 
		/*in*/ List<DatumPath> msgMask, /*in*/ EncodingCharacters encodingChars, 
		/*in*/ String segment) 
	{
		boolean ret = false;
		try {
			ER7SegmentHandler handler = new ER7SegmentHandler();
			handler.m_props = props;
			handler.m_encodingChars = encodingChars;
			handler.m_segmentId = "MSH";
			handler.m_segmentRepIdx = 0;
			if(msgMask != null)
				handler.m_msgMask = msgMask;
			else {
				handler.m_msgMask = new ArrayList<DatumPath>();
				handler.m_msgMask.add(new DatumPath()); // everything will pass this
					// (every DatumPath startsWith the zero-length DatumPath)
			}

			encodingChars.setFieldSeparator(segment.charAt(3));
			List<Integer> nodeKey = new ArrayList<Integer>();
			nodeKey.add(new Integer(0));
			handler.putDatum(nodeKey, String.valueOf(encodingChars.getFieldSeparator()));
			encodingChars.setComponentSeparator(segment.charAt(4));
			encodingChars.setRepetitionSeparator(segment.charAt(5));
			encodingChars.setEscapeCharacter(segment.charAt(6));
			encodingChars.setSubcomponentSeparator(segment.charAt(7));
			nodeKey.set(0, new Integer(1));
			handler.putDatum(nodeKey, encodingChars.toString());

			if(segment.charAt(8) == encodingChars.getFieldSeparator()) {	
				ret = true; 
				// now -- we recurse 
				// through fields / field-repetitions / components / subcomponents.
				nodeKey.clear();
				nodeKey.add(new Integer(2));
				parseSegmentGuts(handler, segment.substring(9), nodeKey);
			}
		}
		catch(IndexOutOfBoundsException e) {}
		catch(NullPointerException e) {}

		return ret;
	}

	/** pass in a whole segment (of type other than MSH), including message type
	at the start, according to encodingChars, and we'll parse the contents and
	put them in props. */
	protected static void parseSegmentWhole(/*out*/ Properties props, 
		/*in/out*/ Map<String, Integer> segmentId2nextRepIdx, 
		/*in*/ List<DatumPath> msgMask, /*in*/ EncodingCharacters encodingChars, 
		/*in*/ String segment)
	{
		try {
			String segmentId = segment.substring(0, 3);

			int currentSegmentRepIdx = 0;
			if(segmentId2nextRepIdx.containsKey(segmentId))
				currentSegmentRepIdx = ((Integer)segmentId2nextRepIdx.get(segmentId)).intValue();
			else
				currentSegmentRepIdx = 0;
			segmentId2nextRepIdx.put(segmentId, new Integer(currentSegmentRepIdx+1));

			// will only bother to parse this segment if any of it's contents will 
			// be dumped to props.
			boolean parseThisSegment = false;
			DatumPath segmentIdAsDatumPath = new DatumPath().add(segmentId);
			for(Iterator<DatumPath> maskIt = msgMask.iterator(); !parseThisSegment && maskIt.hasNext(); ) 
				parseThisSegment = segmentIdAsDatumPath.startsWith(maskIt.next());
			for(Iterator<DatumPath> maskIt = msgMask.iterator(); !parseThisSegment && maskIt.hasNext(); ) 
				parseThisSegment = maskIt.next().startsWith(segmentIdAsDatumPath);

			if(parseThisSegment && (segment.charAt(3) == encodingChars.getFieldSeparator())) {
				ER7SegmentHandler handler = new ER7SegmentHandler();
				handler.m_props = props;
				handler.m_encodingChars = encodingChars;
				handler.m_segmentId = segmentId;
				handler.m_msgMask = msgMask;
				handler.m_segmentRepIdx = currentSegmentRepIdx;

				List<Integer> nodeKey = new ArrayList<Integer>();
				nodeKey.add(new Integer(0));
				parseSegmentGuts(handler, segment.substring(4), nodeKey);
			}
		}
		catch(NullPointerException e) {}
		catch(IndexOutOfBoundsException e) {}
	}

	static protected interface Handler
	{
		public int specDepth();
		public char delim(int level);

		public void putDatum(List<Integer> nodeKey, String value);
	}

	static protected class ER7SegmentHandler implements Handler
	{
		Properties m_props;

		EncodingCharacters m_encodingChars;

		String m_segmentId;
		int m_segmentRepIdx;

		List<DatumPath> m_msgMask;

		public int specDepth() {return 4;}

		public char delim(int level)
		{
			if(level == 0)
				return m_encodingChars.getFieldSeparator();
			else if(level == 1)
				return m_encodingChars.getRepetitionSeparator();
			else if(level == 2)
				return m_encodingChars.getComponentSeparator();
			else if(level == 3)
				return m_encodingChars.getSubcomponentSeparator();
			else
				throw new java.lang.Error();
		}

		public void putDatum(List<Integer> valNodeKey, String value)
		{
			// make a DatumPath from valNodeKey and info in this: 
			DatumPath valDatumPath = new DatumPath();
			valDatumPath.add(m_segmentId).add(m_segmentRepIdx);
			for(int i=0; i<valNodeKey.size(); ++i) {
				// valNodeKey: everything counts from 0 -- not so with DatumPath ... sigh. 
				int itval = ((Integer)valNodeKey.get(i)).intValue();
				valDatumPath.add(new Integer(i == 1 ? itval : itval+1));
			}

			// see if valDatumPath passes m_msgMask: 
			boolean valDatumPathPassesMask = false;
			for(Iterator<DatumPath> maskIt = m_msgMask.iterator(); 
				!valDatumPathPassesMask && maskIt.hasNext(); )
			{
				valDatumPathPassesMask = valDatumPath.startsWith(maskIt.next());
			}

			if(valDatumPathPassesMask)
				m_props.setProperty(valDatumPath.toString(), value);
		}
	}

	/** recursively tokenize "guts" (a segment, or part of one) into tokens, 
	according to separators (aka delimiters) which are different at each level
	of recursion, and to a recursive depth which is discovered through "handler"
	via handler.delim(int) and handler.specDepth()  As tokens are found, they
	are reported to handler via handler.putDatum(), which presumably stashes them
	away somewhere.  We tell the handler about the location in the message via
	putDatum()'s key argument, which is a List of Integers representing the 
	position in the parse tree (size() == depth of recursion).

	TODO: say more.
	*/
	protected static void parseSegmentGuts(/*in/out*/ Handler handler,  
		/*in*/ String guts, /*in*/List<Integer> nodeKey)
	{
		char thisDepthsDelim = handler.delim(nodeKey.size()-1);
		//nodeKey.add(new Integer(0)); // will change nodeKey back before function exits

		StringTokenizer gutsTokenizer 
			= new StringTokenizer(guts, String.valueOf(thisDepthsDelim), true);
		while(gutsTokenizer.hasMoreTokens()) {
			String gutsToken = gutsTokenizer.nextToken();

			if(gutsToken.charAt(0) == thisDepthsDelim) {
				// gutsToken is all delims -- skipping over as many fields or
				// components or whatevers as there are characters in the token: 
				int oldvalue = ((Integer)nodeKey.get(nodeKey.size()-1)).intValue();
				nodeKey.set(nodeKey.size()-1, new Integer(oldvalue + gutsToken.length()));
			}
			else {
				if(nodeKey.size() < handler.specDepth()) {
					nodeKey.add(new Integer(0));
					parseSegmentGuts(handler, gutsToken, nodeKey);
					nodeKey.remove(nodeKey.size()-1);
				}
				else 
					handler.putDatum(nodeKey, gutsToken);
			}
		}
		//nodeKey.setSize(nodeKey.size()-1); // undoing add done at top of this func
	}

	public static void main(String args[])
	{
		if(args.length >= 1) {
			//String message = "MSH|^~\\&||||foo|foo|foo";
			System.out.println(args[0]);

			Properties props = new Properties();

			List<DatumPath> msgMask = new ArrayList<DatumPath>();
			msgMask.add(new DatumPath());

			System.err.println("ER7.parseMessage returned " + parseMessage(props, msgMask, args[0]));
			props.list(System.out);
		}
	}
	
}

