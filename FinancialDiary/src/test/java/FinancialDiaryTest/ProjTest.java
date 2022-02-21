package FinancialDiaryTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjTest {
  @Test
  public void f ()throws InterruptedException{
      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      
 
      // Get to the register page
//      driver.get("http://localhost:8090/FinancialDiary/Register.jsp");
      
      //register
//      driver.findElement(By.name("username")).sendKeys("selenium");
//      driver.findElement(By.name("password")).sendKeys("123");
//      driver.findElement(By.name("email")).sendKeys("selenium@gmail.com");
//      driver.findElement(By.name("firstname")).sendKeys("selenium");
//      driver.findElement(By.name("lastname")).sendKeys("test");

//      Thread.sleep(2000); 
//      driver.findElement(By.name("register")).click();
      
   // Get to the login page
      driver.get("http://localhost:8090/FinancialDiary/Login.jsp");
      Thread.sleep(2000);
      
    //Login
      driver.findElement(By.name("username")).sendKeys("dennis");
      Thread.sleep(2000);
      driver.findElement(By.name("password")).sendKeys("123456");
      Thread.sleep(2000); 
      driver.findElement(By.name("login")).click();
      Thread.sleep(2000);
      

      
      }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
