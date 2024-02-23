import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/clickmebaby.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        Assert.assertEquals("Incialny pocet klikov","0",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1",driver.findElement(By.id("clicks")).getText());

    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
