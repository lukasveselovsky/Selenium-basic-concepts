import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ElementsTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/tabulka.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(rows);
        for (WebElement row : rows) {
            Assert.assertFalse(row.findElement(By.xpath("./td[3]")).getText().isEmpty());
        }
    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
