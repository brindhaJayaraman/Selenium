package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter username,password and login
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		//Webdriverwait and confirm title contains
		//WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
		//Thread.sleep(5000);
		
		//click on the learn more option in the Mobile publisher  
		driver.findElement(By.xpath("//span[text() ='Learn More']")).click();
		//Switch to the next window using Windowhandles
		Set<String>windowHandles = driver.getWindowHandles();
		List<String>list = new ArrayList<String>(windowHandles);
	
		driver.switchTo().window(list.get(1));
		
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text() ='Confirm']")).click();
		//String title1 = driver.getTitle();
		//System.out.println("Page title:" +title1);
		
		//Click on resources
		//driver.findElement(By.linkText("Resources")).click();
		
		//Mouse hover on Learning On Trailhead
		//shodow dom
		Shadow dom = new Shadow(driver);
		WebElement elementLearning = dom.findElementByXPath("//span[contains(text(),'Learning')]");
	    elementLearning.click();
		Thread.sleep(2000);
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
		
		//Administrator Certifications
		driver.findElement(By.linkText("Administrator")).click();
		
		//Verify the certification- Administator page
		String text = driver.findElement(By.xpath("//div[contains(@class,'certification-banner_title')]")).getText();
		System.out.println(text);
		if(text.equals("Administrator")) {
			System.out.println("You are in administrator certification page");
			
		}
	}

}
