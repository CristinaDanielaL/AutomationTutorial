package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

import javax.swing.plaf.PanelUI;

public class AlertPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;


    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
    }
    public void interactWithAcceptAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        LoggerUtility.infoTest("The user clicks on Alert OK Button");
        alertHelper.acceptAlert();
        LoggerUtility.infoTest("The user accepts the Alert Display");
    }
    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.timeAlertElement);
        LoggerUtility.infoTest("The user clicks on Timer Alert OK Button");
        alertHelper.acceptAlert();
        LoggerUtility.infoTest("The user accepts the Alert Timer Display");
    }
    public void interactWithCancelAlert () {
        elementHelper.clickLocator(AlertLocators.confirmElement);
        LoggerUtility.infoTest("The user clicks on Cancel Alert Button");
        alertHelper.cancelAlert();
        LoggerUtility.infoTest("The user accepts the Cancel Alert Display");
    }
    public void interactWithPromptAlert (String value) {
        elementHelper.clickLocator(AlertLocators.promtElement);
        LoggerUtility.infoTest("The user clicks on Prompt Alert Button");
        alertHelper.fillAlert(value);
        LoggerUtility.infoTest("The user accepts the Prompt Alert Display");

    }
}
