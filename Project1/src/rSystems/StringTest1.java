package rSystems;

public class StringTest1 
{
	public static void main(String[] args) {
		String rev="";
		String temp = "&6G%8HK%&9e6&";
		System.out.println(temp);
		String tempNew="";
		
		for(int i=0;i<=temp.length()-1;i++)
		{
			char m=temp.charAt(i);
			if(!Character.isLetterOrDigit(m))
			{
				continue;
			}
			tempNew=tempNew+m;
			
			
		}
		
		System.out.println(tempNew);
		for(int i=tempNew.length()-1;i>=0;i--)
		{
			rev=rev+tempNew.charAt(i);
		}
		
		
		String test="";
		
		for(int i=0;i<=temp.length()-1;i++)
		{
			char m=temp.charAt(i);
			if(Character.isLetterOrDigit(m))
			{
				test=test+rev.charAt(i);
			}
		
			
		}
		System.out.println(test);
	}
	

}
