package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter username,password and login
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		//click on the learn more option in the Mobile publisher  
		driver.findElement(By.xpath("//span[text() ='Learn More']")).click();
		
		//Switch to the next window using Windowhandles
		Set<String>windowHandles = driver.getWindowHandles();
		List<String>list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
				
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text() ='Confirm']")).click();
		
		//shodow dom
		Shadow dom = new Shadow(driver);
		
		//Click on Learning
		WebElement elementLearning = dom.findElementByXPath("//span[contains(text(),'Learning')]");
	    elementLearning.click();
		Thread.sleep(2000);
		
		//Mouse hover on Learning On Trailhead
		WebElement elementLearningOnTrailhead = dom.findElementByXPath("//span[text()='Learning on Trailhead']/parent::div");
		elementLearningOnTrailhead.click();
		//actions class
		Actions act = new Actions(driver);
		//mouse hover on the element
		act.moveToElement(elementLearningOnTrailhead).build().perform();
		//perform to be used at the end of actions class
		
		//Clilck on Salesforce Certifications
		WebElement elementSalesForceCert = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		dom.scrollTo(elementSalesForceCert);
		elementSalesForceCert.click();
		
		//Choose Your Role as Salesforce Architect
		WebElement elementSalesForceArch = driver.findElement(By.xpath("(//div[text()='Salesforce'])[2]"));
		elementSalesForceArch.click();
		
		//Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']/parent::a")).click();
				
		//Get the Text(Summary) of Salesforce Architect	
		String elementSummary=driver.findElement(By.xpath("(//h1[text()='Salesforce Architect']/following-sibling::div)[1]")).getText();
		System.out.println("===================================");
		System.out.println("Salesforce Architect:");
		System.out.println("===================================");
		System.out.println(elementSummary);
		
		
		//Get the List of Salesforce Architect Certifications Available		
		List<WebElement>elementCert = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		int count = elementCert.size();
		System.out.println("Salesforce Architect Certifications:");
		for (int i =0; i<count; i++)
		{
			System.out.println(elementCert.get(i).getText());
		}
		
		//Click on Application Architect
		driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)[1]")).click();
		
		//Get the List of Certifications available
		List<WebElement>  elementAppCert=driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		System.out.println("===================================");
		System.out.println("Application Architect Certifications:");
		System.out.println("===================================");
		for (int i=0;i<4;i++)
		{
			System.out.println(elementAppCert.get(i).getText());
		}

		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
		}
		

	}


