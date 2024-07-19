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
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTestCase {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void welcomemsg() {
        WebElement welcomeMsg = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        String expectedText = "Welcome to our store";
        Assert.assertEquals(welcomeMsg.getText(), expectedText);
    }

    @Test(priority = 2)
    public void searchbox() {
        WebElement searchBox = driver.findElement(By.xpath("(//input[@id='small-searchterms'])[1]"));
        searchBox.sendKeys("T-Shirt");
        searchBox.sendKeys(Keys.RETURN);

        WebElement productGrid = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product-grid")));
        String expectedProduct = "Oversized Women T-Shirt";
        Assert.assertTrue(productGrid.getText().contains(expectedProduct));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
