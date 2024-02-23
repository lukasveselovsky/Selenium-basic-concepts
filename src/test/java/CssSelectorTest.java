import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/kalkulacka.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("button#count")).click(); //ID
        driver.findElement(By.cssSelector("button.btn-success")).click(); //trieda

    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
