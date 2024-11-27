package marathonweek2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowOrder {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev186929.service-now.com/");
		Thread.sleep(2000);
		
		//1.Passing Username, password for ServiceNow login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2AqjN!lC2!Vy");
		driver.findElement(By.id("sysverb_login")).click();
		System.out.println("1.Logged in successfully");
		
		//2.Converting to Shadow DOM and clicking ALL option and selecting Service Catalog option
		Shadow sha = new Shadow(driver);
		sha.setImplicitWait(5);
		sha.findElementByXPath("//div[text()='All']").click();
		sha.findElementByXPath("//span[text()='Service Catalog']").click();
		System.out.println("2.Clicked All option and Service Catalog option");
		
		//3.For Clicking Mobile, converting to Iframe and clicking the mobiles option.
		WebElement elementxpath = sha.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(elementxpath);
		driver.findElement(By.xpath("//h2[contains(text(), 'Mobiles')]")).click();
		System.out.println("3.Clicked Mobiles option");
		
		//4.Clicking Apple iPhone 13 pro option
		driver.findElement(By.xpath("//strong[normalize-space()='Apple iPhone 13 pro']")).click();
		System.out.println("4.Clicked Apple iPhone 13 pro option");
		
		//5.Click yes option on lost/broken iPhone
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		System.out.println("5.Clicked Yes option on lost/broken");
		
		//6.Orginal phone number 
		driver.findElement(By.xpath("//input[@id='IO:4afecf4e9747011021983d1e6253af34']")).sendKeys("443455433");
		System.out.println("6.Gave Original phone number value");
		
		//7.Select unlimited from dropdown option on monthly allowance
		WebElement monthlyallowance = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select allowanceoption = new Select(monthlyallowance);
		allowanceoption.selectByValue("unlimited");
		System.out.println("7.Selected Monthly allowance option as unlimited");
		
		//8.Select sierra blue color
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		System.out.println("8.Clicked Sierra Blue option");
		
		//9.select GB Option
		driver.findElement(By.xpath("//label[normalize-space()='512 GB [add $300.00]']")).click();
		System.out.println("9.Clicked 512GB option");
		
		//10.Click order now button
		driver.findElement(By.id("oi_order_now_button")).click();
		System.out.println("10.Clicked order now option");
		
		//11.Verify the Request number.
		String Requestnumber = driver.findElement(By.id("requesturl")).getText();
		System.out.println("11.Request number generated");
		System.out.println("Request number is: "+Requestnumber);
		
		//12.Take Screenshot of Last order placed page.
		File screenshotAs1 = driver.getScreenshotAs(OutputType.FILE);
		File desSnap1 = new File("./snaps/watch.png");
		FileUtils.copyFile(screenshotAs1, desSnap1);
		

	}

}
