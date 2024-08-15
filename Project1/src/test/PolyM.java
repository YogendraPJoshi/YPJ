package test;

public abstract class PolyM {

	private int x=10;
	private int y=100;
	
	public static void main(String[] args)
	{
//		PolyM pm= new PolyM();
//		pm.addition();
//		pm.addition(10, 1);
//		
//		pm.greetings();
//		
//		MyClass mc= new MyClass();
//		mc.greetings();
		
	}
	
	public void addition()
	{
		int a=10;
		int b=30;
		int sum=a+b;
		System.out.println(sum);
	}
	
	public void addition(int a, int b)
	{
		int sum=a+b;
		System.out.println(sum);
	}
	
	public void greetings()
	{
		System.out.println("Good Morning");
	}
	
	public abstract void multilpication();

}
