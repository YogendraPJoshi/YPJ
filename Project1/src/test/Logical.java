package test;

public class Logical {
	String s1="GeeksforGeeks";
	public static void main(String[] args) 
	{
		
	test("GeeksforGeeks");

	}
	
	public static void test(String s)
	{
		for(int i=0;i<=s.length()-1;i++)
		{
			System.out.print(s.charAt(i)+" ");
		}
	}

}
