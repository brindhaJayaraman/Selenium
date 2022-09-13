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

public class CustomerServiceOptions {

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
		
		//switch to next window using windowhandles
		Set<String>windowHandles = driver.getWindowHandles();
		List<String>list = new ArrayList<String>(windowHandles);
        driver.switchTo().window(list.get(1));
        
        //click on the confirm button in the redirecting page
        driver.findElement(By.xpath("//button[text() ='Confirm']")).click();
        
        //Shadow dom
        Shadow dom = new Shadow(driver);
        
        //Click on Products
        WebElement elementProduct = dom.findElementByXPath("//span[contains(text(),'Products')]");
        elementProduct.click();
        Thread.sleep(2000);
        
        //MouseHover on Service
        WebElement elementService = dom.findElementByXPath("//span[text()='Service']/parent::div");
        elementService.click();
        Actions act = new Actions(driver);
        act.moveToElement(elementService).build().perform();
        
        //Click on Customer Service
        WebElement elementCustSer = dom.findElementByXPath("//a[text()='Customer Service']");
        elementCustSer.click();
        
        //Get the name of services Available
        List<WebElement>elementServiceAvail = driver.findElements(By.xpath("//a[text()='Customer Service']/following-sibling::ul/li"));
        System.out.println("Customer Services Available:");
        for (int i=0; i<elementServiceAvail.size(); i++) {
        	System.out.println(elementServiceAvail.get(i).getText());
        }
        		
        //Verify the title
        String title = driver.getTitle();
        System.out.println();
        if(title.contains("Customer Service"))
        {
        	System.out.println("You landed on page:"+title);
        }
        
        Thread.sleep(3000);
		driver.quit();
        
        
        
        
        
        
	}

}
