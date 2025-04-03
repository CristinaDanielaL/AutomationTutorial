package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.time.Duration;

public class AlertTest extends SharedData {


    @Test
    public void metodaTest () {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnAlertSubMenu();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.interactWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithPromptAlert("1");
    }
}


