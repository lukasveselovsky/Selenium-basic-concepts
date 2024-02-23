import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Register2Test {

    private WebDriver driver;
    private final String BASE_URL = "http:/localhost/playground/registracia.php" ;
    private String validEmail = "lukas@gmail.com";
    private String validName = "lukas";
    private String validSurname = "veselovsky";

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

    }
    @Test
    public void test(){

        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());
    }

    @Test
    public void testMissingPasswords(){

        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());
    }

    @Test
    public void testMismatchedPasswords(){

        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("bezpecneheslo");
        driver.findElement(By.name("password-repeat")).sendKeys("bezpecneheslo");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());
    }

    @Test
    public void testMissingRobotCheckbox(){

        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("bezpecneheslo");
        driver.findElement(By.name("password-repeat")).sendKeys("bezpecneheslo");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());
    }

    @Test
    public void testSuccessfullRegistration(){

        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("bezpecneheslo");
        driver.findElement(By.name("password-repeat")).sendKeys("bezpecneheslo");

        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]")).isDisplayed());

    }

    @Test
    public void testInputErrorBorder(){
        String expectedClass = "has-error";
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        List<WebElement> formDivs = driver.findElements(By.xpath("//div[input]"));

        for (WebElement formDiv : formDivs){
            Assert.assertTrue(formDiv.getAttribute("class").contains(expectedClass));
        }

        Assert.assertTrue(driver.findElement(By.xpath("//div[label[input[@id='checkbox']]]")).getAttribute("class").contains(expectedClass));

    }


    @After
    public void tearDown(){

        driver.close();
        driver.quit();

    }

}
