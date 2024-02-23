import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/redalert.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);

//        driver.findElement(By.id("alert1")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        driver.findElement(By.id("alert2")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Second alert!", alert.getText());
        alert.dismiss();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());



    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
