package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
	
		//Step 1: Need to get user name,password and submit button
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Step 2: Click hyperlink
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Step 3: Create Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Wipro");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("ABC");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("qwerty");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Create Lead");
		driver.findElement(By.className("smallSubmit")).click();
		
		String Tit2 = driver.getTitle();
		System.out.println(Tit2);
		
		Thread.sleep(4000);
		
		
		
		
		
		
		
		driver.close();

	}

}
