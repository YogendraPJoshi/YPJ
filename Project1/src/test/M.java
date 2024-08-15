package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class M {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.get("");
		
		WebElement city = driver.findElement(By.xpath(""));
		
		Select scity= new Select(city);
		
		List<WebElement> allCities = driver.findElements(By.xpath(""));//li
		
		for(WebElement al:allCities)
		{
			
			String actUaltext = al.getAttribute("city");
			String expectedtext="Pune";
			if(actUaltext.equals(expectedtext))
			{
				al.click();
				break;
			}
			else {
				System.out.println("Pune is not listed");
			}
		}

	}
	
	

}
