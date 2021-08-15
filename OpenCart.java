package week2.day1.assignment.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.opencart.com/index.php?route=account/register");

		cd.findElement(By.id("input-username")).sendKeys("un");
		cd.findElement(By.id("input-firstname")).sendKeys("fn");
		cd.findElement(By.id("input-lastname")).sendKeys("ln");
		cd.findElement(By.name("email")).sendKeys("mail@xyz.com");
		WebElement ic = cd.findElement(By.id("input-country"));
		Select icobj = new Select(ic);
		icobj.selectByValue("4");

		cd.findElement(By.id("input-password")).sendKeys("ln");

	}

}
