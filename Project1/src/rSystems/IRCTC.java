package rSystems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		String stationName="KALKA";
		String reqStationName=stationName.substring(0, 3);
		driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys(reqStationName);
		Thread.sleep(3000);
		List<WebElement> sNames = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
	for(WebElement s:sNames)
	{
		System.out.println(s.getText());
		if(s.getText().contains(stationName))
		{
			Thread.sleep(200);
			s.click();
			
			break;
		}
	}
	}
	
	
	

}
