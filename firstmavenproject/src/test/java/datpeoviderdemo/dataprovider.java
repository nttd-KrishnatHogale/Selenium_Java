package datpeoviderdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;



public class dataprovider {

    WebDriver driver;
   @BeforeClass
    void  setUp(){
       driver = new ChromeDriver();
//       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    void testLogin()
    {

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
//        Thread.sleep(2000);
        boolean status=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed(); if(status==true)
    {
        driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space () = 'Logout']")).click();
        Assert.assertTrue(true);
    }
    else
    {
        Assert.fail();
    }

    }
@AfterClass
    void tearDown(){
       driver.close();

    }
    @DataProvider
    void LoginData()
    {

    }}
