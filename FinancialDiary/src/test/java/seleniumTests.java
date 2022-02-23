import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class seleniumTests {

	private WebDriver driver;

	@Test
	public void testRegister() throws InterruptedException {
		// Get to the Login page
		driver.get("http://localhost:8090/FinancialDiary/Login.jsp");

		// Click on register button
		Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();

		// Register
		driver.findElement(By.name("username")).sendKeys("seleniumtest");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("email")).sendKeys("seleniumtest@gmail.com");
		driver.findElement(By.name("firstname")).sendKeys("selenium");
		driver.findElement(By.name("lastname")).sendKeys("test");

		Thread.sleep(2000);
		driver.findElement(By.name("register")).click();

		// Login
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("seleniumtest");
		driver.findElement(By.name("password")).sendKeys("123");

		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();

		// Navigate to profile to show account details after login and registration
		Thread.sleep(2000);
		driver.findElement(By.linkText("Profile")).click();
	}

	@BeforeTest
	public void beforeTest() {
		String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
	}

}
