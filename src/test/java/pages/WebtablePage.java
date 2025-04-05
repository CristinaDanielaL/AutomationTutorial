package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static pageLocators.PracticeFormsLocators.tableRowsListElement;
import static pageLocators.WebtableLocators.*;

public class WebtablePage {

    private WebDriver driver;
    private ElementHelper elementHelper;


    public WebtablePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void verifyTableContent(int expectedTableRowsListElement) {
        elementHelper.waitForElementsVisible(tableRowsListElement);
        List<WebElement> tableRowsList = driver.findElements(tableRowsListElement);
        Assert.assertEquals(tableRowsList.size(), expectedTableRowsListElement, "Valoarea initiala a tabelului  nu este 3.");
    }

    public void addNewRecordButtonClick() {
        elementHelper.clickJSLocator(addElement);
    }

    public void fillFirstName(String firstNameValue) {
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        elementHelper.fillLocator(lastNameElement, lastNameValue);
    }

    public void fillEmail(String userEmailValue) {
        elementHelper.fillLocator(userEmailElement, userEmailValue);
    }

    public void fillAge(String ageValue) {
        elementHelper.fillLocator(ageElement, ageValue);
    }

    public void fillSalary(String salaryValue) {
        elementHelper.fillLocator(salaryElement, salaryValue);
    }

    public void fillDepartment (String departmentValue) {
        elementHelper.fillLocator(departmentElement,departmentValue);
    }

    public void submitClick () {
        elementHelper.clickJSLocator(submitElement);
    }

    public void verifyTableContent (int expectedSize, String firstNameValue, String lastNameValue,String userEmailValue,
                                    String ageValue, String salaryValue, String departmentValue) {
        List<WebElement>tableRowsList = driver.findElements(tableRowsListElement);
        Assert.assertEquals(tableRowsList.size(), expectedSize, "Valoarea actuala a tabelului  nu este 4.");
        elementHelper.validateTextContainsElement(tableRowsList.get(3), firstNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), lastNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), userEmailValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), ageValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), salaryValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), departmentValue);
    }

    public void deleteRecords () {
        elementHelper.clickJSLocator(deleteElement);
    }
    public void editClick () {
        elementHelper.clickJSLocator(editElement);
    }


}
