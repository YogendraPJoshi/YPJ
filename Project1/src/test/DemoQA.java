package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoQA {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/date-picker");
		Thread.sleep(1000);
		WebElement datePickerMonthYearInput = driver.findElement(By.id("datePickerMonthYearInput"));
		datePickerMonthYearInput.click();
		Thread.sleep(1000);
		//select month
		WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
		
		Select sMonth= new Select(month);
		
		sMonth.selectByVisibleText("December");
		Thread.sleep(1000);
		//select year
		WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
		
		Select sYear= new Select(year);
		
		sYear.selectByVisibleText("2025");
		Thread.sleep(1000);
		//select Date
		driver.findElement(By.xpath("//div[text()='"+"1"+"']")).click();
		

	}

}
