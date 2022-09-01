package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
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
		
		//click on the learn more option in the Mobile publisher  
		driver.findElement(By.xpath("//span[text() ='Learn More']")).click();
		//Switch to the next window using Windowhandles
		Set<String>windowHandles = driver.getWindowHandles();
		List<String>list = new ArrayList<String>(windowHandles);
	
		driver.switchTo().window(list.get(1));
		
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text() ='Confirm']")).click();
		String title1 = driver.getTitle();
		System.out.println("Page title:" +title1);
		
		//get back to parent window
		driver.switchTo().window(list.get(0));
		driver.quit();

	}

}
