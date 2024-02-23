import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssertTrueTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/vybersi.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Geodude");
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        Assert.assertTrue("Geodude sa v texte nenachadza",driver.findElement(By.xpath("//div/h3")).getText().contains("Geodudet"));



    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
