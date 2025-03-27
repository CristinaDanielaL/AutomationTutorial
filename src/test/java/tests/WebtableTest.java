package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebtableTest extends SharedData {

    //public WebDriver driver;

    @Test
    public void metodaTest () {

        ElementHelper elementHelper = new ElementHelper(driver);
        //deschidem un browser
        //driver=new ChromeDriver();

        //accesam o pagina web
        //driver.get("https://demoqa.com/");


        By elementsMenu=By.xpath("//h5[text()='Elements']");
        elementHelper.clickJSLocator(elementsMenu);

        By webTableSubMenu=By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJSLocator(webTableSubMenu);

        //facem browserul in modul maximize
        //driver.manage().window().maximize();


     By tableRowsListElement = By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even'or@class='rt-tr -odd']");
     List<WebElement> tableRowsList = driver.findElements(tableRowsListElement);
                Assert.assertEquals(tableRowsList.size(),3, "Valoarea initiala a tabelului  nu este 3.");

        //identifica un element
        By addElement=By.id("addNewRecordButton");
        elementHelper.clickJSLocator(addElement);



        By firstNameElement=By.id("firstName");
        String firstNameValue="Lazar";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement=By.id("lastName");
        String lastNameValue="Cristina";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By userEmailElement=By.id("userEmail");
        String userEmailValue="user@gmail.com";
        elementHelper.fillLocator(userEmailElement, userEmailValue);

        By ageElement=By.id("age");
        String ageValue="29";
        elementHelper.fillLocator(ageElement, ageValue);

        By salaryElement=By.id("salary");
        String salaryValue="5000";
        elementHelper.fillLocator(salaryElement, salaryValue);

        By departmentElement=By.id("department");
        String departmentValue="qa";
        elementHelper.fillLocator(departmentElement, departmentValue);

        By submitElement=By.id("submit");
        elementHelper.clickLocator(submitElement);

        tableRowsList = driver.findElements(tableRowsListElement);
        Assert.assertEquals(tableRowsList.size(),4, "Valoarea actuala a tabelului  nu este 4.");

        elementHelper.validateTextContainsElement(tableRowsList.get(3), firstNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), lastNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), ageValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), userEmailValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), salaryValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), departmentValue);


        //edit functionality
        By editElement=By.id("edit-record-4");
        elementHelper.clickLocator(editElement);

        By editFirstNameElement = By.id("firstName");
        String editFirstNameValue = "Totolici";
        elementHelper.clearFilledLocator(editFirstNameElement, editFirstNameValue);

        By editLastNameElement= By.id("lastName");
        String editLastNameValue = "Dana";
        elementHelper.clearFilledLocator(editLastNameElement, editLastNameValue);


        By editUserEmailElement= By.id("userEmail");
        String editUserEmailValue="user@yahoo.com";
        elementHelper.clearFilledLocator(editUserEmailElement, editUserEmailValue);

       By editAgeElement= By.id("age");
       String editAgeValue="27";
       elementHelper.clearFilledLocator(editAgeElement, editAgeValue);

        By editSalaryElement= By.id("salary");
        String editSalaryValue="9000";
        elementHelper.clearFilledLocator(editSalaryElement, editSalaryValue);

        By editDepartmentElement= By.id("department");
        String editDepartmentValue="qatester";
        elementHelper.clearFilledLocator(editDepartmentElement, editDepartmentValue);

        By resubmitElement=By.id("submit");
        elementHelper.clickLocator(resubmitElement);

        //tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even'or@class='rt-tr -odd']"));
        //Assert.assertEquals(tableRowsList.size(),4, "Valoarea actuala a tabelului  nu este 4.");
        //expectedRow = tableRowsList.get(3).getText();
        //Assert.assertTrue(expectedRow.contains(editFirstNameValue));
        //Assert.assertTrue(expectedRow.contains(editLastNameValue));
        //Assert.assertTrue(expectedRow.contains(editAgeValue));
        //Assert.assertTrue(expectedRow.contains(editUserEmailValue));
        //Assert.assertTrue(expectedRow.contains(editSalaryValue));
        //Assert.assertTrue(expectedRow.contains(editDepartmentValue));

        By deleteElement=By.id("delete-record-4");
        elementHelper.clickLocator(deleteElement);

        tableRowsList = driver.findElements(tableRowsListElement);
        Assert.assertEquals(tableRowsList.size(),3, "Valoarea actuala a tabelului  nu este 3.");
    }
}
