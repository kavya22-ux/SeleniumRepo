package week5.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class CreateLead extends ProjectSpecificMethod {
	@DataProvider(name="getData",indices = {0,4})
	
	public String[][] setValue() throws IOException{
		return IntegrationWithTC.readExcel();
	}
	
	public void runCreate(String companyName, String fName, String lName, String phoneNumber) throws InterruptedException {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
	}

}
