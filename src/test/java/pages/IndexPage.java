package pages;

import helpMethods.ElementHelper;
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
    }
    public void enterOnAlertSubMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertsSubMenu);
    }
    public void enterOnBrowserWindowsSubmenu() {
        elementHelper.clickJSLocator(IndexLocators.browserWindowsSubMenu);
    }
    public void enterOnFrameSubmenu () {
        elementHelper.clickJSLocator(IndexLocators.frameSubMenu);
    }
}
