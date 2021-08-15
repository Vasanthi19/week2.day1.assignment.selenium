package week2.day1.assignment.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver cd= new ChromeDriver();
		// Step 3: Load the URL 
		cd.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		// Step 4: Maximise the window
		cd.manage().window().maximize();
		// Step 5: Add implicit wait
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Step 6: Fill in all the text boxes
		cd.findElement(By.name("UserFirstName")).sendKeys("fn");
		cd.findElement(By.name("UserLastName")).sendKeys("ln");
		cd.findElement(By.name("UserEmail")).sendKeys("email@gmail.com");
		cd.findElement(By.name("CompanyName")).sendKeys("fnxy");
		cd.findElement(By.name("UserPhone")).sendKeys("09876543332");
		
		// Step 7: Handle all the dropdowns
		WebElement ut=cd.findElement(By.name("UserTitle"));
		Select utobj = new Select(ut);
		utobj.selectByValue("Customer_Service_Manager_AP");
		
		WebElement ce=cd.findElement(By.name("CompanyEmployees"));
		Select ceobj = new Select(ce);
		ceobj.selectByValue("9");
		
		WebElement cc=cd.findElement(By.name("CompanyCountry"));
		Select ccobj = new Select(cc);
		ccobj.selectByValue("US");
		
		WebElement cs=cd.findElement(By.name("CompanyState"));
		Select csobj = new Select(cs);
		csobj.selectByValue("AK");
		
		// Step 8: Click the check box
		cd.findElement(By.className("checkbox-ui")).click();
		// Step 9: Close the browser
		//*Note: No need click Start my freeTrial
		//cd.close();
	}

}
