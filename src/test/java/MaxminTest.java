import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxminTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/clickmebaby.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){

        driver.manage().window().setSize(new Dimension(300,2500));
        driver.get(BASE_URL);
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1", driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("klik", driver.findElement(By.className("description")).getText());

    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
