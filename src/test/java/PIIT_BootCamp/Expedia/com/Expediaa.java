package PIIT_BootCamp.Expedia.com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Expediaa {
	static WebDriver driver;

  @Test
  public void f() throws InterruptedException {
	  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.expedia.com/");
		driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/button/div")).click();

		driver.findElement(By.xpath("//a[@href='?pwaLob=wizard-flight-pwa']")).click();
		driver.findElement(By.xpath("//*[@aria-label='Leaving from']")).sendKeys("was");
		driver.findElement(By.xpath("//*[text()='Washington (WAS - All Airports)']")).click();

		driver.findElement(By.xpath("//button[@aria-label='Going to']")).sendKeys("new");
		driver.findElement(By.xpath("//*[text()='New York (NYC - All Airports)']")).click();

		driver.findElement(By.xpath("//*[@id='d1-btn']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//*[@data-day='27'])[1]")).click();
		driver.findElement(By.xpath("(//*[@data-day='27'])[2]")).click();
		driver.findElement(By.xpath("(//*[text()='Done'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='Search']")).click();
		Thread.sleep(9000);

		driver.findElement(By.xpath("(//*[@data-test-id='select-link'])[1]")).click();


		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//*[@data-test-id='select-link'])[2]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
		
		widowHands(driver);
		
  
		System.out.println("this is child window   " + driver.getTitle());

		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[@id=\"app-layer-base\"]/div/div/div[2]/div/main/section[2]/div[1]/div/div[2]/button"))
				.click();
//		driver.close();
//		switchWin.widowHands(driver, 1);
//		// driver.switchTo().window(parentWindow);
//		System.out.println("this is parent window   " + driver.getTitle());

		Actions custInfo = new Actions(driver);
		custInfo.moveToElement(driver.findElement(By.xpath("//input[@id='firstname[0]']"))).click().sendKeys("Karim")
				.moveToElement(driver.findElement(By.xpath("//input[@id='lastname[0]']"))).click().sendKeys("Khan")
				.moveToElement(driver.findElement(By.xpath("//input[@id='phone-number[0]']"))).click()
				.sendKeys("9147656670").moveToElement(driver.findElement(By.xpath("//*[text()='Male']"))).click()
				.build().perform();
		
		dateOfBirth(driver,"date_of_birth_month0", "03 - Mar");
		dateOfBirth(driver,"date_of_birth_day[0]", "11");
		dateOfBirth(driver,"date_of_birth_year[0]", "1991");



		driver.findElement(By.xpath("(//input[@name='creditCards[0].cardholder_name'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='creditCards[0].cardholder_name'])[2]")).sendKeys("Karim Khan");

		driver.findElement(By.id("creditCardInput")).click();
		driver.findElement(By.id("creditCardInput")).sendKeys("73636884849498");

		driver.findElement(By.name("creditCards[0].expiration_month")).click();
		new Select(driver.findElement(By.name("creditCards[0].expiration_month"))).selectByVisibleText("07-Jul");
		driver.findElement(By.name("creditCards[0].expiration_year")).click();
		new Select(driver.findElement(By.name("creditCards[0].expiration_year"))).selectByVisibleText("2024");

		driver.findElement(By.id("new_cc_security_code")).click();
		driver.findElement(By.id("new_cc_security_code")).sendKeys("123");
		driver.findElement(By.name("creditCards[0].street")).click();
		driver.findElement(By.name("creditCards[0].street")).sendKeys("44 Main St");
		driver.findElement(By.name("creditCards[0].street2")).click();
		driver.findElement(By.name("creditCards[0].city")).click();
		driver.findElement(By.name("creditCards[0].city")).sendKeys("Poughkeepsie");

		driver.findElement(By.name("creditCards[0].state")).click();
		new Select(driver.findElement(By.name("creditCards[0].state"))).selectByVisibleText("NY");
		driver.findElement(By.name("creditCards[0].zipcode")).click();
		driver.findElement(By.name("creditCards[0].zipcode")).sendKeys("12601");

		driver.findElement(By.xpath("(//input[@name='email'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("karim_k1223@gmail.com");
		driver.findElement(By.id("complete-booking")).click();
	  
  }
  @BeforeClass
  public void beforeClass() {
	  beforeClass("Chrome", "https://www.expedia.com/");
  }

  @AfterClass
  public void afterClass() {
  }
  
  public void beforeClass(String browser, String URI) {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			String userDirectory = System.getProperty("user.dir");
			System.out.println(userDirectory);
			System.setProperty("webdriver.chrome.driver", userDirectory + "/chromedriver 2");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URI);
			driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			String userDirectory = System.getProperty("user.dir");
			// System.out.println(userDirectory);
			System.setProperty("webdriver.gecko.driver", userDirectory + "/geckodriver 6");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(URI);
			driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();

		}
}
    public static void widowHands(WebDriver driver) {
	   Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter=windowIds.iterator();
		String pWindow=iter.next();
		String cWindow=iter.next();
		driver.switchTo().window(cWindow);
}
	
public static void dateOfBirth(WebDriver driver, String xpath, String input) {
		driver.findElement(By.id(xpath)).click();
		new Select(driver.findElement(By.id(xpath))).selectByVisibleText(input);

		driver.findElement(By.id(xpath)).click();
		new Select(driver.findElement(By.id(xpath))).selectByVisibleText(input);

		driver.findElement(By.id(xpath)).click();
		new Select(driver.findElement(By.id(xpath))).selectByVisibleText(input);
		driver.findElement(By.id(xpath)).click();
	}


}
