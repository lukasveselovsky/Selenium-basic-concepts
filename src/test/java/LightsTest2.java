import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LightsTest2 {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/semafor.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        String expectedGreen = "rgba(10, 129, 0, 1)";
        String expectedRed = "rgba(205, 58, 63, 1)";
        String expectedOrange = "rgba(191, 111, 7, 1)";

        driver.get(BASE_URL);
        WebElement trafficLight = driver.findElement(By.className("light"));
        String actualRedColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedRed, actualRedColor);

        Actions actions = new Actions(driver);
        actions.moveToElement(trafficLight).build().perform();

        String actualGreenColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedGreen,actualGreenColor);

        actions.clickAndHold(trafficLight).build().perform();
        String actualOrange = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedOrange, actualOrange);
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
