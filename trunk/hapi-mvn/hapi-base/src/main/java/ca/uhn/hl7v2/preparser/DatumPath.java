
package ca.uhn.hl7v2.preparser;


import java.util.ArrayList;

/** An object of this class represents a variable-size path for identifying
the location of a datum within an HL7 message, which we can use for
maintaining parser state and for generating a suitable string key (in the
ZYX[a]-b[c]-d-e style) for a piece of data in the message (see toString()).

The elements are: 
segmentID / segmentRepIdx / fieldIdx / fieldRepIdx / compIdx / subcompIdx 

("rep" means "repetition")

segmentID is a String, the rest are Integers.

It is variable-size path-style in that if it has a size of 1, the one element
will be the segmentID; if it has a size of two, element 0 will be the segmentID
and element 1 will be the segmentRepIdx, etc.  This class can't represent a
fieldIdx without having segmentID / segmentRepIdx, etc. etc. 

possible sizes: 0 to 6 inclusive

As toString() simply converts this's integer values to strings (1 => "1"), and
since for some reason the ZYX[a]-b[c]-d-e style counts b, d, e starting from 1
and a, c from 0 -- it is intended that one store the numeric values in this
class starting from 1 for fieldIdx (element 2), compIdx (4) and subcompIdx
(5), and from 0 for segmentRepIdx (1) and fieldRepIdx (3).  default values
provided by setSize() and by toString() do this.
*/
public class DatumPath implements Cloneable {

	public static final int s_maxSize = 6;

	protected ArrayList<Object> m_path = null;

	public DatumPath()
	{
		m_path = new ArrayList<Object>(s_maxSize);
	}

	/** copy constructor */
	public DatumPath(DatumPath other)
	{
		this();
		copy(other);
	}

	public boolean equals(Object otherObject)
	{
        if (otherObject == null) return false;
        if (!getClass().equals(otherObject.getClass())) return false;
        DatumPath other = (DatumPath)otherObject;
		return m_path.equals(other.m_path);
	}

	/** Works like String.startsWith: 
	returns true iff prefix.size() <= this.size()
	 AND if, for 0 <= i < prefix.size(), this.get(i).equals(prefix.get(i))
	*/
	public boolean startsWith(DatumPath prefix)
	{
		boolean ret = false;
		if(prefix.size() <= this.size()) {
			ret = true;
			for(int i=0; i<prefix.size(); ++i)
				ret &= this.get(i).equals(prefix.get(i));
		}
		return ret;
	}

	/** like a copy constructor without the constructor */
	public void copy(DatumPath other)
	{
		setSize(0);
		for(int i=0; i<other.size(); ++i)
			add(other.get(i));
	}

	/** set() sets an element of the path.  
	
	idx must be in [0, size()). else => IndexOutOfBoundsException. 
	
	(new_value == null) => NullPointerException  

	new_value must be either a String or an Integer depending on what part 
	of the path you're setting:  

	(idx == 0) => String
	(idx >= 1) => Integer

	If new_value can't be cast to the appropriate type, a ClassCastException 
	is thrown before new_value is stored.

	Of course, on success, this will discard it's reference that used to be at
	position idx.
	*/
	public void set(int idx, Object new_value)
	{
		if((0 <= idx) && (idx < m_path.size())) {
			if(new_value != null) {
				if(idx == 0)
					m_path.set(idx, new_value);
				else if(idx >= 1)
					m_path.set(idx, new_value);
			}
			else
				throw new NullPointerException();
		}
		else
			throw new IndexOutOfBoundsException();
	}

	/** get() returns an element, which will be either a String or an Integer.

	((idx == 0) => String
	(idx >= 1) => Integer
	((idx < 0) || (idx >= size())) => IndexOutOfBoundsException

	We will attempt to cast the gotten object to the appropriate type before
	returning it as an Object.  That way, if there's an object of the wrong type
	in the wrong place in here (that got past set() somehow), then a
	ClassCastException will be thrown even if the caller of this function
	doesn't try to cast it.  (consider System.out.println("val: " + path.get(n))
	nothing would barf it this get() wasn't vigilant.)
	*/
	public Object get(int idx)
	{
		Object gottenObj = m_path.get(idx);
		if(idx == 0)
			return gottenObj;
		else
			return gottenObj;
	}

	public int size() { return m_path.size(); }

	/** toString() outputs the path (from segmentID onward) in the ZYX[a]-b[c]-d-e
	style (TODO: give it a name), suitable for a key in a map of 
	message datum paths to values. 
	
	Integer values are converted to strings directly (1 => "1") so when you
	constructed this you should have started counting from 1 for everything but
	the "repeat" fields, if you truly want the ZYX[a]-b[c]-d-e style.

	If toString() is called when this has a size in [1, 6) (=> missing numeric
	elments), then we act as though the elements in [size(), 6) are 0 or 1 as
	appropriate for each element.  We don't provide a default for the element 0
	(the String element): will throw an IndexOutOfBoundsException if (size() ==
	1).

	eg. a (new DatumPath()).add(new String("ZYX")).add(2).add(6).toString() 
	would yield "ZYX[2]-6[0]-1-1"
	*/
	public String toString()
	{

		StringBuilder strbuf = new StringBuilder();

		if(m_path.size() >= 1) {
			DatumPath extendedCopy = (DatumPath)this.clone();
			extendedCopy.setSize(s_maxSize);

			for(int i=0; i<extendedCopy.size(); ++i) {
				if(i == 0)
					strbuf.append(extendedCopy.get(0));
				else if((i == 1) || (i == 3))
					strbuf.append("[").append(extendedCopy.get(i)).append("]");
				else if((i == 2) || (i == 4) || (i == 5))
					strbuf.append("-").append(extendedCopy.get(i));
			}
		}
		else 
			throw new IndexOutOfBoundsException();	

		return strbuf.toString();
	}

	/** add() grows this by 1, inserting newValue at the end.
	newValue must be a String or an Integer depending on the index where it will
	be inserted, as noted at DatumPath.set().  
	returns this.
	(newValue == null) => NullPointerException 
	*/
	public DatumPath add(Object newValue)
	{
//		m_path.ensureCapacity(m_path.size() + 1);
//		set(m_path.size() - 1, newValue);
		m_path.add(newValue);
		return this;
	}

	/** Like add(String).  convenient wrapper for add(Object), when the object
	to be added must be an Integer anyway (size() > 0 on entry).  

	For the user, it turns 
	path.add(new Integer(i)).add(new Integer(j)).add(new Integer(k)) 
	into 
	path.add(i).add(j).add(k), that's all.  

	size() == 0 on entry throws a ClassCastException (which it is, kindof), 
	otherwise calls add(new Integer(new_value)).
	*/
	public DatumPath add(int new_value)
	{
		if(size() > 0)
			add(new Integer(new_value));
		else 
			throw new ClassCastException();

		return this;
	}

	/** convenience!  Like add(int), but the other way around. */
	public DatumPath add(String new_value)
	{
		if(size() == 0) 
			add((Object)new_value);
		else
			throw new ClassCastException();

		return this;
	}

	/** setSize(): resize.  If this will grow the object, then we put default
	values into the new elements: "" into the String element, Integer(1) into the
	elements 2, 4, and 5, and Integer(0) into elements 1 and 3.
	returns this.
	*/
	public DatumPath setSize(int newSize)
	{
		int oldSize = m_path.size();
		
		while (m_path.size() < newSize) {
			m_path.add(null);
		}
		
		while (m_path.size() > newSize) {
			m_path.remove(m_path.size() - 1);
		}

		if(newSize > oldSize) {
			// give the new elements some default values: 
			for(int i=oldSize; i<newSize; ++i) {
				if(i == 0)
					set(i, "");
				else
					set(i, (i==1 || i==3) ? 0 : 1);
			}
		}

		return this;
	}

	/** setSize(0).  returns this. */
	public DatumPath clear() 
	{
		setSize(0);
		return this;
	}

	public Object clone()
	{
		return new DatumPath(this);
	}

	/* Compare the numeric parts of "this" and "other".  string-style, start from
	the left: if this[1] < other[1], then return true, if this[1] > other[1] then
	return false, else repeat with [2] ... if we compare all elements, then return
	false (they're the same.)

	What are actually compared are copies of this and other that have been grown
	to s_maxSize (default values in effect), so they'll have the same size.
	
	This is just a little thing that gets used in the class XML.  Look there for 
	a justification of it's existence.

	ex. [1, 1, 1, 1] < [1, 1, 1, 2] 
	[1, 2, 1, 1] < [1, 2, 1, 2]
	[1, 1, 5, 5] < [1, 2]
	[1, 1] < [1, 1, 5, 5] 
	*/
	public boolean numbersLessThan(DatumPath other)
	{
		DatumPath extendedCopyThis = new DatumPath(this);
		extendedCopyThis.setSize(s_maxSize);

		DatumPath extendedCopyOther = new DatumPath(other);
		extendedCopyOther.setSize(s_maxSize);

		boolean lessThan = false;
		for(int i=1; !lessThan && (i<s_maxSize); ++i) {
			int this_i = ((Integer)extendedCopyThis.get(i));
			int other_i = ((Integer)extendedCopyOther.get(i));
			lessThan |= (this_i < other_i);
		}

		return lessThan;
	}

	public static void main(String args[])
	{
		DatumPath dp = new DatumPath();
		dp.add("ZYX");
		dp.add(new Integer(42));

		DatumPath dp2 = new DatumPath().add(-42);

		System.out.println(dp);
		System.out.println(dp2);
	}
}

