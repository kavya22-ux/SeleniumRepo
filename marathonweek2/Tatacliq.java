package marathonweek2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tatacliq.com/");
	
		Thread.sleep(2000);
		driver.findElement(By.id("wzrk-cancel")).click();
		
		//1.Mouse hover on Brands
		WebElement brand = driver.findElement(By.xpath("//div[text()='Brands']"));
		Actions action = new Actions(driver);
		action.moveToElement(brand).perform();
		
		//2.Hover on Watches and Accessories
		WebElement watch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		action.moveToElement(watch).perform();
		
		//3.Clicking first brand on watches category.
		driver.findElement(By.xpath("//div[text()='Casio']")).click();
		Thread.sleep(4000);
		
		//4.Sorting based on New Arrivals
		WebElement sortwatch = driver.findElement(By.xpath("//select[@label='Popularity']"));
		Select option = new Select(sortwatch);
		option.selectByValue("isProductNew");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='l2FilterDiv-0']//div[@class='CheckBox__base']")).click();
		
		Thread.sleep(2000);
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		int size = element.size();
		System.out.println("Prices of All watch:----------");
		
		String price = null;
		for(int i = 0; i < size; i++) {
			 price = element.get(i).getText();
			System.out.println(price);
		}
		System.out.println("------------");
		
		driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv']")).click();
		
		Thread.sleep(2000);
		Set<String> window  = driver.getWindowHandles();
		List<String> childwindow = new ArrayList<String>(window);
		driver.switchTo().window(childwindow.get(1));
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@class='wzrkClose']")).click();
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		
		Thread.sleep(2000);
		String bagcount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("Total count in bag cart: "+bagcount);
		
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		
		Thread.sleep(2000);
		String cartprice = driver.findElement(By.xpath("//div[@class='CartItemForDesktop__informationTextWithBolder']")).getText();
		System.out.println("----------------------------");

		if(cartprice.contains(price)) {
			System.out.println("Both prices are equal");
		}
		else {
			System.out.println("Prices are not equal");
		}
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File desSnap = new File("./snaps/watch.png");
		FileUtils.copyFile(screenshotAs, desSnap);
		
		driver.close();
		

	}

}
