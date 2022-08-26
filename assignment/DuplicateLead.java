package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		        //Launch URL
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
				
				//Click on Create Lead
				WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
				elementCreateLead.click();
				
				//Enter CompanyName Field Using id Locator
				WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
				elementCompanyName.sendKeys("HCL");
				
				//Enter FirstName Field Using id Locator
				WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
				elementFirstName.sendKeys("Brindha");
				
				//Enter LastName Field Using id Locator
				WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
				elementLastName.sendKeys("Jayaraman");
				
				//Enter FirstName(Local) Field Using id Locator
				WebElement elementFirstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
				elementFirstNameLocal.sendKeys("Bindhu");
				
				//Enter Department Field Using any Locator of Your Choice
				WebElement elementDeptName = driver.findElement(By.name("departmentName"));
				elementDeptName.sendKeys("Finance");
				
				//Enter Description Field Using any Locator of your choice
				WebElement elementDescription = driver.findElement(By.id("createLeadForm_description"));
				elementDescription.sendKeys("Finance Dept");
				
				//Enter your email in the E-mail address Field using the locator of your choice
				WebElement elementEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
				elementEmail.sendKeys("jbrindha03@gmail.com");
				
				//Select State/Province as NewYork Using Visible Text
				WebElement elementStateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				Select StateProvinceDD = new Select(elementStateProvince);
				StateProvinceDD.selectByVisibleText("New York");
				
				//Click on Create Button
				WebElement elementCreateButton = driver.findElement(By.className("smallSubmit"));
				elementCreateButton.click();
				
				//Get the Title of Resulting Page
				System.out.println("Title of Resulting Page 1: " + driver.getTitle());
				
				//Click on Duplicate button
				WebElement elementDuplicateLead = driver.findElement(By.linkText("Duplicate Lead"));
				elementDuplicateLead.click();
				
				//Clear the CompanyName Field using .clear() And Enter new CompanyName
				WebElement elementClearAndNewCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
				elementClearAndNewCompanyName.clear();
				elementClearAndNewCompanyName.sendKeys("CTS");
				
				//Clear the FirstName Field using .clear() And Enter new FirstName
				WebElement elementClearAndNewFirstName = driver.findElement(By.id("createLeadForm_firstName"));
				elementClearAndNewFirstName.clear();
				elementClearAndNewFirstName.sendKeys("Banu");
				
				//Click on Create Lead Button
				WebElement elementCreateButton1 = driver.findElement(By.className("smallSubmit"));
				elementCreateButton1.click();
				
				//Get the Title of Resulting Page
				System.out.println("Title of Resulting Page 2: " + driver.getTitle());
	}

}
