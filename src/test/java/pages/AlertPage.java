package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
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
        alertHelper.acceptAlert();
    }
    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.timeAlertElement);
        alertHelper.acceptAlert();
    }
    public void interactWithCancelAlert () {
        elementHelper.clickLocator(AlertLocators.confirmElement);
        alertHelper.cancelAlert();
    }
    public void interactWithPromptAlert (String value) {
        elementHelper.clickLocator(AlertLocators.promtElement);
       alertHelper.fillAlert(value);

    }
}
