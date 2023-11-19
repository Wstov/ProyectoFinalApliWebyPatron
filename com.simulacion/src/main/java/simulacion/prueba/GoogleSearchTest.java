package simulacion.prueba;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperties("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGooglePage(){

        WebElement searchbox = driver.findElement(By.name("q"));

        searchbox.clear();

        searchbox.sendKeys("quality-stram Introducción a la automatizacion de Pruebas de Software");

        searchbox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         assertEquals("quality-stream Introduccion a la automatizacion de pruebas de software - Google Search", driver.getTitle());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
