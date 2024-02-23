import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/kalkulacka.php" ;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    public void testSum(){
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("7",driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("3");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("8",driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("1");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("3",driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("6",driver.findElement(By.id("result")).getText());

    }

    @Test
    public void testDeduct(){
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals("3",driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("3");
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals("2",driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("3");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals("1",driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals("2",driver.findElement(By.id("result")).getText());

    }

    @Test
    public void testReset(){
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("4");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();

        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());


    }

    @Test
    public void testInvalidInputs(){
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("hovadina");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("estevacsia");
        driver.findElement(By.id("count")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]")).getAttribute("class").contains("has-error"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='secondInput']]")).getAttribute("class").contains("has-error"));
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
