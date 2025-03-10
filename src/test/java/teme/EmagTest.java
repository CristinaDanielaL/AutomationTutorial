package teme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EmagTest {

    public WebDriver driver;

    @Test
    public void metodaTest () {

        driver=new ChromeDriver();

        driver.get("https://www.emag.ro/");

        driver.manage().window().maximize();
    }
}
