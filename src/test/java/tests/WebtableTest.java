package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebtableTest {

    public WebDriver driver;

    @Test
    public void metodaTest () {
        //deschidem un browser
        driver=new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement elementsMenu=driver.findElement(By.xpath("//h5[text()='Elements']"));
        executor.executeScript("arguments[0].click();", elementsMenu);

        WebElement webTableSubMenu=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        executor.executeScript("arguments[0].click();", webTableSubMenu);

        //facem browserul in modul maximize
        driver.manage().window().maximize();


        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even'or@class='rt-tr -odd']"));
                Assert.assertEquals(tableRowsList.size(),3, "Valoarea initiala a tabelului  nu este 3.");

        //identifica un element
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        executor.executeScript("arguments[0].click();", addElement);



        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        String firstNameValue="Lazar";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement=driver.findElement(By.id("lastName"));
        String lastNameValue="Cristina";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement=driver.findElement(By.id("userEmail"));
        String userEmailValue="user@gmail.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="29";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="5000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="qa";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement=driver.findElement(By.id("submit"));
        submitElement.click();

        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even'or@class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),4, "Valoarea actuala a tabelului  nu este 4.");
        String expectedRow = tableRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(firstNameValue));
        Assert.assertTrue(expectedRow.contains(lastNameValue));
        Assert.assertTrue(expectedRow.contains(ageValue));
        Assert.assertTrue(expectedRow.contains(userEmailValue));
        Assert.assertTrue(expectedRow.contains(salaryValue));
        Assert.assertTrue(expectedRow.contains(departmentValue));


        //edit functionality
        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editFirstNameElement= driver.findElement(By.id("firstName"));
        String editFirstNameValue="Totolici";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement= driver.findElement(By.id("lastName"));
        String editLastNameValue="Dana";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editUserEmailElement= driver.findElement(By.id("userEmail"));
        String editUserEmailValue="user@yahoo.com";
        editUserEmailElement.clear();
        editUserEmailElement.sendKeys(editUserEmailValue);

        WebElement editAgeElement= driver.findElement(By.id("age"));
        String editAgeValue="27";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement= driver.findElement(By.id("salary"));
        String editSalaryValue="9000";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement= driver.findElement(By.id("department"));
        String editDepartmentValue="qatester";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even'or@class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),4, "Valoarea actuala a tabelului  nu este 4.");
        expectedRow = tableRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(editFirstNameValue));
        Assert.assertTrue(expectedRow.contains(editLastNameValue));
        Assert.assertTrue(expectedRow.contains(editAgeValue));
        Assert.assertTrue(expectedRow.contains(editUserEmailValue));
        Assert.assertTrue(expectedRow.contains(editSalaryValue));
        Assert.assertTrue(expectedRow.contains(editDepartmentValue));

        WebElement editSubmitElement=driver.findElement(By.id("submit"));
        editSubmitElement.click();

        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even'or@class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(),3, "Valoarea actuala a tabelului  nu este 3.");
    }
}
