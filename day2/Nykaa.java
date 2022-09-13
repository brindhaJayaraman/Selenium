package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//MouseHover on brands
		WebElement elementBrands = driver.findElement(By.linkText("brands"));
		elementBrands.click();
		Actions act = new Actions(driver);
		act.moveToElement(elementBrands).build().perform();
		
		//Search for L'Oreal Paris
		WebElement elementSearch = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		elementSearch.sendKeys("L'Oreal Paris");
		
		//Click L'Oreal Paris by linktext
		WebElement elementParis = driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]"));
		elementParis.click();
		
		//Verify the title contains L'Oreal Paris
		String title = driver.getTitle();
		System.out.println();
		if (title.contains("L'Oreal Paris")) {
			System.out.println("The page title contains L'Oreal Paris");
		}else
			System.out.println("You landed on incorrect page");
		
		//Click sort by and select customer top rated
		driver.findElement(By.xpath("//span[contains(text(),'Sort By : ')]/parent::button")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		// Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		// Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//check whether the Filter is applied with Shampoo
		List<WebElement>elementFilter = driver.findElements(By.xpath("//span[@class='filter-value']"));
		String elementShampoo = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
		for (int i=0;i<elementFilter.size();i++) {
			String text1 = elementFilter.get(i).getText();
			if(text1.equals(elementShampoo)) {
				System.out.println("Filter applied:" +text1);
			}
		}
		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		
		// GO to the new window and select size as 175ml
		Set<String>windowHandles = driver.getWindowHandles();
		List<String>listWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listWindows.get(1));
		
		// Print the MRP of the product
		WebElement elementselect = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select elementDD = new Select(elementselect);
		elementDD.selectByVisibleText("175ml");
		
		String textMRP = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
		System.out.println("The MRP of the product:" +textMRP);
		
		//Click on Add to Bag
		driver.findElement(By.xpath("(//span[text()='Add to Bag']/parent::button)[1]")).click();
		
		//Go to shopping bag
		driver.findElement(By.xpath("//span[@class='cart-count']/parent::button")).click();
		
		//Print the grand total amount
		WebElement elementFrame = driver.findElement(By.xpath("//iframe[contains(@src,'mobileCartIframe')]"));
		driver.switchTo().frame(elementFrame);
		Thread.sleep(3000);
		
		String grandTotalBefore = driver.findElement(By.xpath("//div[@class='payment-tbl-data']/div[4]/div[2]")).getText();
		System.out.println("The grand total before:" +grandTotalBefore);
		
		//Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		//Check if this grand total is the same
		String grandTotalAfter = driver.findElement(By.xpath("(//div[text()='Grand Total']/following::span)[1]")).getText();
		System.out.println("The grand total after:" +grandTotalAfter);
		
		if(grandTotalBefore.contains(grandTotalAfter))
		{
			System.out.println("The Grand total matches");
		}else
			System.out.println("The Grand total doesn't match");
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
