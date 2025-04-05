package pages;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageLocators.BrowserWindowLocators.newTabClick;
import static pageLocators.BrowserWindowLocators.newWindowClick;

public class BrowserWindowPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private TabWindowHelper tabWindowHelper;

    public BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        tabWindowHelper = new TabWindowHelper(driver);

    }
    public void interactWithSpecificTab () {

        elementHelper.clickLocator(newTabClick);
        LoggerUtility.infoTest("The user clicks on Tab Button");

        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.switchToSpecificTabWindow(1);
        LoggerUtility.infoTest("The user switches the focus on second Tab");

        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.closeCurrentTabWindow();
        LoggerUtility.infoTest("The user closes tab");

    }
    public void interactWithSpecificWindow() {
        tabWindowHelper.switchToSpecificTabWindow(0);
        LoggerUtility.infoTest("The user switches the focus on second Window");
        elementHelper.clickLocator(newWindowClick);
        LoggerUtility.infoTest("The user clicks on Window Button");
        tabWindowHelper.switchToSpecificTabWindow(1);
        LoggerUtility.infoTest("The user closes second Window");

    }
}
