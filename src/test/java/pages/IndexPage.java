package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void enterOnAlertFrameWindowMenu () {
        elementHelper.clickJSLocator(IndexLocators.alertFrameWindowsMenu);
        LoggerUtility.infoTest("The user clicks on Alert Frame Window Menu");
    }

    public void enterOnAlertSubMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertsSubMenu);
        LoggerUtility.infoTest("The user clicks on Alert Frame SubMenu");
    }

    public void enterOnBrowserWindowsSubmenu() {
        elementHelper.clickJSLocator(IndexLocators.browserWindowsSubMenu);
        LoggerUtility.infoTest("The user clicks on Browser Windows Submenu");
    }

    public void enterOnFrameSubmenu () {
        elementHelper.clickJSLocator(IndexLocators.frameSubMenu);
        LoggerUtility.infoTest("The user clicks on Frame Submenu");
    }

    public void enterOnFormsMenu () {
        elementHelper.clickJSLocator(IndexLocators.formsMenu);
        LoggerUtility.infoTest("The user clicks on Form Menu");
    }

    public void enterOnPracticeFormSubmenu () {
        elementHelper.clickJSLocator(IndexLocators.practiceFormSubMenu);
        LoggerUtility.infoTest("The user clicks on Practice Form Submenu");
    }

    public void enterOnElementMenu () {
        elementHelper.clickJSLocator(IndexLocators.elementsMenu);
        LoggerUtility.infoTest("The user clicks on Element Menu");
    }

    public void enterOnWebtableSubMenu () {
        elementHelper.clickJSLocator(IndexLocators.webTableSubMenu);
        LoggerUtility.infoTest("The user clicks on Webtable SubMenu");
    }

}
