import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/clickmebaby.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        WebElement clicksElement = driver.findElement(By.id("clicks"));

        // Assert the initial number of clicks
        Assert.assertEquals("Initial number of clicks", "0", clicksElement.getText());

        for (int i = 1; i < 11; i++) {
            // Click on the "clickMe" element
            driver.findElement(By.id("clickMe")).click();

            // Assert the number of clicks after each click
            Assert.assertEquals("Incorrect number of clicks after click #" + i, String.valueOf(i), clicksElement.getText());
        }
    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
