package FinancialDiary;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	private WebDriver driver;

//	@Test
//	public void f() throws InterruptedException {
//	}

	@Test (priority = 1)
	public void Login() throws InterruptedException {
		// Load to webpage
		driver.get("http://localhost:8090/FinancialDiary/Login.jsp");
		// Login
		driver.findElement(By.name("username")).sendKeys("yongshun");
		driver.findElement(By.name("password")).sendKeys("123");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		driver.getCurrentUrl();
	}

	@Test (priority = 2)
	public void createTransaction() throws InterruptedException {
		// Create a new item
		driver.findElement(By.name("add")).click();
		driver.findElement(By.name("name")).sendKeys("DaoYuan");
		driver.findElement(By.name("price")).sendKeys("1");
		driver.findElement(By.name("payment")).sendKeys("Popular Voucher");
		Thread.sleep(2000);
		driver.findElement(By.name("add")).click();
		driver.getCurrentUrl();
	}

	@Test (priority = 3)
	public void EditTransaction() throws InterruptedException {
		// edit
		driver.findElement(By.name("editing")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("payment")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("AhDao");
		driver.findElement(By.name("price")).sendKeys("2");
		driver.findElement(By.name("payment")).sendKeys("Ez-link");
		Thread.sleep(2000);
		driver.findElement(By.name("save")).click();
		driver.getCurrentUrl();
	}
	
	@Test (priority = 4)
	public void DeleteTransaction() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.name("deleting")).click();
		driver.getCurrentUrl();
	}

	@BeforeTest
	public void beforeTest() {
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
	}

}
