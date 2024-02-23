import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/registracia.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        String email = "lukas@email.com<? echo $email ?>";
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();

        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        Assert.assertEquals(email,driver.findElement(By.name("email")).getAttribute("value"));

        driver.navigate().forward();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='conchita.jpg']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='conchita.jpg']")).isDisplayed());
    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
