import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdwnTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/vybersi.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        new Select(driver.findElement(By.className("form-control"))).selectByIndex(1);
        new Select(driver.findElement(By.className("form-control"))).selectByValue("02");
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Geodude");




    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
