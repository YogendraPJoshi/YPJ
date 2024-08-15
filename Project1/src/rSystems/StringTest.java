package rSystems;

public class StringTest {

	public static void main(String[] args) {
		String xyz = "Chamberlain has a good workCulture";
		String []ar=xyz.split(" ");
		for(int i=0;i<=ar.length-1;i++)
		{
			
			System.out.println(createSPace(ar[i])+ar[i]);
		}
		
		

	}
	public static String createSPace(String s)
	{
		String s1="Chamberlain";
		int space=s1.length()-s.length();
		 String spaceString="";
		for(int i=0;i<=space-1;i++)
		{
			spaceString=spaceString+" ";
		}
		return spaceString;
	}
	
}
