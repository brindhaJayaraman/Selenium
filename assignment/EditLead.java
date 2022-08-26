package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
		//Enter Username and password using id locator
		WebElement elementUserName = driver.findElement(By.id("username"));
		elementUserName.sendKeys("Demosalesmanager");
		
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		
		//Click on login button using class location
		WebElement elementLoginButton = driver.findElement(By.className("decorativeSubmit"));
		elementLoginButton.click();
		
		//Click on CRM/SFA Link
		WebElement elementcrmsfa = driver.findElement(By.linkText("CRM/SFA"));
		elementcrmsfa.click();
		
		//Click on Leads Button
		WebElement elementLead = driver.findElement(By.linkText("Leads"));
		elementLead.click();
        
		Thread.sleep(2000);
		
		// Click on first resulting lead
		driver.findElement(By.xpath("(//table)[21]/tbody/tr[1]/td[1]//a")).click();

		String verifyTitle = driver.getTitle();

		// Verify title of the page
		if (verifyTitle.contains("View Lead")) {
			System.out.println("Title Matched");
		} else
			System.out.println("Title not Matched");

		// Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		// Change the Company name
		driver.findElement(By.xpath("//table//input[@id='updateLeadForm_companyName']")).clear();
		WebElement elementNewCompanyName=driver.findElement(By.xpath("//table//input[@id='updateLeadForm_companyName']"));
		elementNewCompanyName.sendKeys("Syntel");
	
			
		//Click Update
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		
		//Confirm the Changed name
		
		String elementConfirmChange=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/span")).getText();
				
		if(elementConfirmChange.contains("Syntel"))
		{
			driver.close();
		}		else 
			System.out.println("Title not matched");	
		}
	}

