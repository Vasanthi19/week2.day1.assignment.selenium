package week2.day1.assignment.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		// Step 1: Download and set the path
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver cd = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		cd.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		cd.manage().window().maximize();
		// Step 5: Add implicit wait
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Step 6: Click on Create New Account button
		//			Create New Account
		cd.findElement(By.linkText("Create New Account")).click();

		// Step 7: Enter the first name
		cd.findElement(By.name("firstname")).sendKeys("aaa");
		// Step 8: Enter the last name
		cd.findElement(By.name("lastname")).sendKeys("lll");
		// Step 9: Enter the mobile number
		cd.findElement(By.name("reg_email__")).sendKeys("xyz@abc.com");
		// Step 10: Enterthe password
		cd.findElement(By.id("password_step_input")).sendKeys("aaalll123");
		// Step 11: Handle all the three drop downs
		WebElement day = cd.findElement(By.id("day"));
		Select dayobj = new Select(day);
		dayobj.selectByValue("10");

		WebElement mon = cd.findElement(By.id("month"));
		Select monobj = new Select(mon);
		monobj.selectByValue("9");

		WebElement year = cd.findElement(By.id("year"));
		Select yearobj = new Select(year);
		yearobj.selectByValue("1986");

		// Step 12: Select the radio button "Female"
		cd.findElement(By.className("_58mt")).click();
		// ( A normal click will do for this step)

		cd.close();
	}

}
