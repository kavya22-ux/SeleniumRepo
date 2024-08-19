package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//Username - DemoSalesManager
		//password - crmsfa
		
		//Step 1: Need to get user name,password and submit button
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Step 2: Click hyperlink
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Step 3: Create Account
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("UBS");
		driver.findElement(By.name("description")).sendKeys("Seleniumm Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("5000");
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		driver.findElement(By.className("smallSubmit")).click();
		String Title = driver.getTitle();
		//System.out.println(Title);
		
		if(Title == "Create Account | opentaps CRM") {
			System.out.println("Logged in Successfully");
		}
		else {
			System.out.println("Title name is not matched!!!");
		}
		
		Thread.sleep(2000);
		
		
	
		driver.close();
		

	}

}
