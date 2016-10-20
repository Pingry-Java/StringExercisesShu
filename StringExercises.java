public class StringExercises
{
	public static void main(String[] args)
	{
		String s1 = "hello world dillon";
		String s2 = "o";
		System.out.println(findString(s1, s2, 5));
		System.out.println(countStrings(s1, s2));
		String s3 = "This is _very_ good";
		System.out.println(convertItalics(s3));
		s3 = "_This_ is _very_ _good_.";
		System.out.println(convertItalics(s3));
		s3 = "This is _very good.";
		System.out.println(convertItalics(s3));
		s3 = "This is __very good.";
		System.out.println(convertItalics(s3));
		s3 = "This is very _good_";
		System.out.println(convertItalics(s3));
	}
/**
 * Finds the first instance of s in line,
 * starting at the position start
 *
 * @param o the orignal string 
 * @param s the string to find 
 * @param start the position to start searching. Precondition: 
 * Guaranteed to be less than the string length.
 *
 * @return the index of the first single instance of
 * s if the string is found OR -1 if it is not found.
 */
	public static int findString (String o, String s, int start)
	{  //TODO Implement this
		int length = o.length();
		
		for (int i = start; i < length; i++)
		{
			if (o.substring(i, i + s.length()).equals(s))
				return i;
		}
		return -1;
	}
	 /**
 * Count the number of times instances of s appear in the line.
 *
 * @param o the original string
 * @param s the string to find.
 *
 * @return the number of times the string appears in the line
 */
 
	public static int countStrings (String o, String s)
	{  //TODO Implement this
		int length = o.length();
		int count = 0;	
		
		for (int i = 0; i + s.length() < length; i++)
		{
			if (s.length() > o.length())
				return 0;
			if (o.substring(i, i + s.length()).equals(s)) // o = "o"   and    s = "hello world dillon"
				count++;
		}
		return count;
	}
 
/**
 * Replace all instances of underscores in the line given by
 * line with italics tags.  There must be an even number of underscores
 * in the line, and they will be replaced by <I>, </I>, alternating.
 * @param line a string with 0 or more underscores
 * @return the line that has underscores replaced with <I> </I> tags or 
 * the original line if there are not an even number of underscores.
 */
 

	public static String convertItalics (String line)
	{
	  /* 
	  Here are some examples
	  line                             value returned by convertItalics
	  
	  "This is _very_ good."           "This is <I>very</I> good."
	  "_This_ is _very_ _good_."       "<I>This</I> is <I>very</I> <I>good</I>."
	  "This is _very good."            "This is _very good."
	  "This is __very good."           "This is __very good."
	  
	  boolean i = false
	  while(s.indexOf("_") != -1){
		  s = s.substring(0,s.indexOf("_"))+i?"<i>":"</i>"+s.substring(s.indexOf("_")+1)
		  i = !i;
	  }
	  */

	  //TODO Implement this
		int length = line.length();
		int count = 0;	
		
		for (int i = 0; i < length; i++)
		{
			//System.out.println(line.substring(i, i + 1));
			if (line.substring(i, i + 1).equals("_"))
			{
				for (int z = i; z < length; z++)
				{
					if ((int) line.substring(z, z + 1).equals(" ")||line.substring(z, z + 1).equals("."))
					{
						if (line.substring(z - 1, z).equals("_"))
						{
							z = length;
							String part1 = line.substring(0, i);
							String part2 = "<I>";
							String part3 = line.substring(i + 1, line.length());
							String newstring = part1 + part2 + part3;
							int status = 2;
							int theCount = countStrings(newstring,"<I>");
							System.out.println(theCount);
							int theCount2 = countStrings(newstring,"</I>");
							System.out.println(theCount2);
							if ((theCount - theCount2) ==1)
								status = 1;
							else
								status = 0;
							//System.out.println(status);
							//1 = even, 0 = odd 
							if (status == 0)
							{
								part2 = "</I>";
							}
							newstring = part1 + part2 + part3;
						return convertItalics(newstring);
						}
					}
				}
			}
				
		}
	
		return line;
				
	}
		
}

	
