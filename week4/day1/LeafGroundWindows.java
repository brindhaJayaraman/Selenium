package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click and Confirm new Window Opens
		String title1 = driver.getTitle();
		System.out.println("Page title:" +title1);
		
		driver.findElement(By.xpath("//button/span[text()='Open']")).click();
		Set<String>windowHandles = driver.getWindowHandles();
		List<String>list = new ArrayList<String>(windowHandles);
	
		driver.switchTo().window(list.get(1));
		String title2 = driver.getTitle();
		System.out.println("Page title:" +title2);
		
		if(title1.equals(title2)) {
			System.out.println("You are not on a new window");
		}else
			System.out.println("New window opened");
		
		driver.switchTo().window(list.get(0));
		
		// Find the number of opened tabs
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']//parent::button")).click();
		Set<String>windowHandlesNoOfOpenTabs = driver.getWindowHandles();
		List<String>listOfOpenTabs = new ArrayList<String>(windowHandlesNoOfOpenTabs);
		int count = listOfOpenTabs.size();
		System.out.println("Number of opened tabs:" +count);
		driver.switchTo().window(listOfOpenTabs.get(0));

        //Close all window except primary
		driver.findElement(By.xpath("//button/span[text()='Close Windows']")).click();
		String mainWindow1 = driver.getWindowHandle();
		Set<String>windowClose = driver.getWindowHandles();
		List<String>listClose = new ArrayList<String>(windowClose);
		int count1 = listClose.size();
		for (int i=0; i<count1; i++) {
			if(!(listClose.get(i).equals(mainWindow1))) {
				driver.switchTo().window(listClose.get(i));
				Thread.sleep(2000);
				driver.close();
				
			}
		}
	driver.switchTo().window(listClose.get(0));
	
	//Wait for 2 new tabs to open  
	driver.findElement(By.xpath("//button/span[text()='Open with delay']")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	Set<String>windowDelay = driver.getWindowHandles();
	List<String>listDelay = new ArrayList<String>(windowDelay);
	int count2 = listDelay.size();
	System.out.println("Number of opened tabs:" +count2);
	
	Thread.sleep(2000);
	driver.quit();
	
		
		
		
		
		
		
		
	}

}
