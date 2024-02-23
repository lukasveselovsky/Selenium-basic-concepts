import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TitleTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        List<WebElement> pages = driver.findElements(By.xpath("//nav//ul/li/a"));
        List<String> pageUrls = new ArrayList<>();

        for (WebElement page : pages) {
            String url = page.getAttribute("href");
            pageUrls.add(url);
        }

        for (String pageUrl : pageUrls) {
            driver.get(pageUrl);
            System.out.println(driver.getTitle());
        }
    }
    @After
    public void tearDown(){
//        driver.quit();

    }

}
