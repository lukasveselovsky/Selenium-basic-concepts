import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class NavTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test() throws InterruptedException {
        String expectedClass = "active";

        List<String> pages = new ArrayList<>();
        pages.add("vybersi.php");
        pages.add("tabulka.php");
        pages.add("zjavenie.php");

        for (String page : pages) {
            driver.get(BASE_URL + "/" + page);
            Assert.assertTrue(driver.findElement(By.xpath("//li[@href='" + page + "']"))
                    .getAttribute("class").contains(expectedClass));
        }

    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
