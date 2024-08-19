package week2.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		
		//MAximize the browser
		driver.manage().window().maximize();
		
		//Opening the facebook website
		driver.get("https://www.facebook.com/");
		
		//Now give username and password for logging in facebook
		driver.findElement(By.id("email")).sendKeys("keerthanalakshmi1995@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abcdef");
		
		//Login button
		driver.findElement(By.name("login")).click();
		
		//Need to wait browser for few mins to run
		Thread.sleep(2000);
		
		//Get Title of page
		String Fb_tile = driver.getTitle();
		System.out.println(Fb_tile);
		if(Fb_tile == "Facebook - log in or sign up")
		{
			System.out.println("Logged in successs");
		}
		else {
			System.out.println("Fail");
		}
		
		driver.close();
	}

}
