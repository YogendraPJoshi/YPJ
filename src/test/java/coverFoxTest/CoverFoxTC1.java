package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultPage;
import coverFoxUtility.Utility;

public class CoverFoxTC1 extends Base {

	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxMemberDetailsPage memberDetailsPage;
	CoverFoxResultPage resultPage;
	String filePath;
	public static Logger logger;

	
	

	@BeforeTest
	public void launchBrowser() {
		
		logger=Logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("opening browser");
		openBrowser();
		homePage = new CoverFoxHomePage(driver);
		healthPlanPage = new CoverFoxHealthPlanPage(driver);
		addressDetailsPage = new CoverFoxAddressDetailsPage(driver);
		memberDetailsPage = new CoverFoxMemberDetailsPage(driver);
		resultPage = new CoverFoxResultPage(driver);
		filePath = System.getProperty("user.dir")+"\\excelTest.xlsx";

	}

	@BeforeClass
	public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage.clickOnGenderButton();
		logger.info("Clicking on Gender button");
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		logger.info("Clicking on next button");
		Thread.sleep(1000);
		memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(filePath, "Sheet5", 0, 0));
		logger.warn("enter age between 18-90 years");
		logger.info("Handeling age drop doen");
		//memberDetailsPage.handleAgeDropDown(Utility.readDataFromPropertiesFile("age"));
		memberDetailsPage.clickOnNextButton();
		logger.info("Clicking on next button");
		Thread.sleep(1000);
		addressDetailsPage.enterPincode(Utility.readDataFromExcel(filePath, "Sheet5", 0, 1));
		//addressDetailsPage.enterPincode(Utility.readDataFromPropertiesFile("pinCode"));
		logger.warn("Please enter valid pin code");
		logger.info("entering pin code");
		addressDetailsPage.enterMobileNumber(Utility.readDataFromExcel(filePath, "Sheet5", 0, 2));
		logger.warn("Please enter valid mobile number");
		logger.info("entering mobile number");
		//addressDetailsPage.enterMobileNumber(Utility.readDataFromPropertiesFile("mobNum"));

		addressDetailsPage.clickOnContinueButton();
		logger.info("Clicking on continue button");
	}

	@Test
	public void validateBanners() throws InterruptedException {
		Thread.sleep(4000);
		//Assert.fail();
		int bannerPlanNumbers = resultPage.getPlanNumersFromBanners();
		int StringplanNumbers = resultPage.getPlanNumersFromString();
		logger.info("validating banners");
		Assert.assertEquals(StringplanNumbers, bannerPlanNumbers,
				"Plans on banners not matching with results, TC failed");
	}

	@Test
	public void validatePresenceOfSortButton() throws InterruptedException, IOException {
		
		Thread.sleep(4000);
		//Assert.fail();
		logger.info("validating presence of sort button");
		Assert.assertTrue(resultPage.sortPlanFilterIsDisplayed(), "Sort Plan filter is not displayed,TC is failed");

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		logger.info("closing browser");
		browserClose();
	}
}
