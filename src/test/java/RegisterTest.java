import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

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


    @After
    public void tearDown(){

        driver.close();
        driver.quit();

    }

}
