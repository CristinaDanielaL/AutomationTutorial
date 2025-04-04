package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebtablePage;
import sharedData.SharedData;

import java.util.List;

public class WebtableTest extends SharedData {

    //public WebDriver driver;

    @Test
    public void metodaTest () {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnElementMenu();
        indexPage.enterOnWebtableSubMenu();

        WebtablePage webtablePage = new WebtablePage(driver);
        webtablePage.verifyTableContent(3);

        webtablePage.addNewRecordButtonClick();

        String firstNameValue="Lazar";
        String lastNameValue="Cristina";
        String userEmailValue="user@gmail.com";
        String ageValue="29";
        String salaryValue="5000";
        String departmentValue="qa";
        int expectedSize = 4;

        webtablePage.fillFirstName(firstNameValue);
        webtablePage.fillLastName(lastNameValue);
        webtablePage.fillEmail(userEmailValue);
        webtablePage.fillAge(ageValue);
        webtablePage.fillSalary(salaryValue);
        webtablePage.fillDepartment(departmentValue);
        webtablePage.submitClick();

        webtablePage.verifyTableContent(expectedSize, firstNameValue,lastNameValue, ageValue, userEmailValue, salaryValue, departmentValue);

        webtablePage.editClick();

        String firstNameValueEdit="Totolici";
        String lastNameValueEdit="Dana";
        String userEmailValueEdit="toto@gmail.com";
        String ageValueEdit="30";
        String salaryValueEdit="9000";
        String departmentValueEdit="it";
        int expectedSizeEdit = 4;

        webtablePage.verifyTableContent(expectedSizeEdit);

        webtablePage.fillFirstName(firstNameValueEdit);
        webtablePage.fillLastName(lastNameValueEdit);
        webtablePage.fillEmail(userEmailValueEdit);
        webtablePage.fillAge(ageValueEdit);
        webtablePage.fillSalary(salaryValueEdit);
        webtablePage.fillDepartment(departmentValueEdit);
        webtablePage.submitClick();

        webtablePage.deleteRecords();
        webtablePage.verifyTableContent(3);


    }
}
