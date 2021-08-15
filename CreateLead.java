package week2.day1.assignment.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// webpage setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver cd = new ChromeDriver();
		cd.get("http://leaftaps.com/opentaps");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login
		cd.findElement(By.id("username")).sendKeys("demosalesmanager");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();

		// CreateLeadPage Navigation
		cd.findElement(By.partialLinkText("SFA")).click();
		cd.findElement(By.linkText("Leads")).click();
		cd.findElement(By.linkText("Create Lead")).click();

		// createpage Enter the all the field values
		cd.findElement(By.id("createLeadForm_companyName")).sendKeys("XYZCompany");
		cd.findElement(By.id("createLeadForm_firstName")).sendKeys("EmpA");
		cd.findElement(By.id("createLeadForm_lastName")).sendKeys("B");
		cd.findElement(By.id("createLeadForm_parentPartyId")).sendKeys("10442");

		WebElement drop1 = cd.findElement(By.id("createLeadForm_dataSourceId"));
		Select drop1obj = new Select(drop1);
		drop1obj.selectByIndex(1);

		WebElement drop2 = cd.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drop2obj = new Select(drop2);
		drop2obj.selectByValue("9002");

		cd.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("empA_Local");
		cd.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("b_local");
		cd.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Lead");
		cd.findElement(By.id("createLeadForm_birthDate")).sendKeys("11/05/1987");
		cd.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("specialist");
		cd.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		cd.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("100000000");

		WebElement drop3 = cd.findElement(By.id("createLeadForm_currencyUomId"));
		Select drop3obj = new Select(drop3);
		drop3obj.selectByVisibleText("DZD - Algerian Dinar");

		WebElement currdrop = cd.findElement(By.id("createLeadForm_industryEnumId"));
		Select currdropSelect = new Select(currdrop);
		currdropSelect.selectByValue("IND_SOFTWARE");

		cd.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100");

		WebElement owerEnumdrop = cd.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select owerEnumdropObj = new Select(owerEnumdrop);
		owerEnumdropObj.selectByValue("OWN_PARTNERSHIP");

		cd.findElement(By.id("createLeadForm_sicCode")).sendKeys("123");
		cd.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("$");

		cd.findElement(By.id("createLeadForm_description")).sendKeys("Description content in create Lead");

		cd.findElement(By.id("createLeadForm_importantNote")).sendKeys("important notes");

		WebElement countrycode = cd.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countrycode.clear();
		countrycode.sendKeys("12");

		cd.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("600072");

		cd.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9876453344");

		cd.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("044");

		cd.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Airtel");

		cd.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@xyz.com");
		cd.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://xyz.com");
		cd.findElement(By.id("createLeadForm_generalToName")).sendKeys("ab_xyz");
		cd.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("mno");
		cd.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("13,qwerty street,");
		cd.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("town");
		cd.findElement(By.id("createLeadForm_generalCity")).sendKeys("cheenai");

		WebElement geoiddrop = cd.findElement(By.name("generalStateProvinceGeoId"));
		Select geoiddropobj = new Select(geoiddrop);
		geoiddropobj.selectByValue("AZ");

		cd.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("810");

		WebElement countryId = cd.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select countryIdobj = new Select(countryId);
		countryIdobj.selectByValue("ASM");

		cd.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("987");

		// Get the Firstname and print it
		String fN = cd.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		System.out.println("fn:" + fN);

		// Click CreateLead Button
		cd.findElement(By.name("submitButton")).click();

		// Get and Verify the Title of the resulting Page(View Lead)
		String viewLead = cd.getTitle();
		if (viewLead.equals("View Lead")) {
			System.out.println("create lead process is successfull");
		}
		// CLose the webpage
		cd.close();

	}

}
