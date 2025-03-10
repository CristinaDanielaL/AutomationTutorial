package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void metodaTest () {
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement formsMenu=driver.findElement(By.xpath("//h5[text()='Forms']"));
        executor.executeScript("arguments[0].click();", formsMenu);

        WebElement practiceFormSubMenu=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        executor.executeScript("arguments[0].click();", practiceFormSubMenu);

        WebElement firstNameElement=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue="Cristina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue="Lazar";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement=driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        String emailValue="username@gmail.com";
        emailElement.sendKeys(emailValue);


    }
}
