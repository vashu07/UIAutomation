package Automation.FB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("//a[@title='Electronics']/span"));
		
		Actions action  = new Actions(driver);
		action.moveToElement(element1).perform();
		
		WebElement element2 = driver.findElement(By.xpath("//a[@data-tracking-id='women']/span"));
		Thread.sleep(1000);
		action.moveToElement(element2).build().perform();
		
		
		
	}

}
