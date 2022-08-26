package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		//Launch URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on Create New Account button
		WebElement createNewAccount = driver.findElement(By.linkText("Create New Account"));
		createNewAccount.click();
		
		//Enter the first name
		WebElement elementFirstName = driver.findElement(By.name("firstname"));
		elementFirstName.sendKeys("Niranjana");
		
		//Enter the Last Name
		WebElement elementLastName = driver.findElement(By.name("lastname"));
		elementLastName.sendKeys("Ninja");
		
		//Enter the mobile number
		WebElement elementMobileNum = driver.findElement(By.name("reg_email__"));
		elementMobileNum.sendKeys("9548632157");
		
		//Enter the password
		WebElement elementPassword = driver.findElement(By.xpath("//div[contains(@class, 'uiSticky')]/input[@type='password']"));
		elementPassword.sendKeys("Password@1");
		
		//Handle all the three drop downs
		Select day = new Select (driver.findElement (By.id("day")));
		day.selectByVisibleText("3");
		
		Select month = new Select (driver.findElement (By.id("month")));
		month.selectByVisibleText("May");
		
		Select year = new Select (driver.findElement (By.id("year")));
		year.selectByVisibleText("1991");
		
		driver.findElement(By.name("sex")).click();
		
		

	}

}
