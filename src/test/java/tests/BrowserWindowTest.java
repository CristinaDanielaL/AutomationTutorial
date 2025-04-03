package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTest extends SharedData {


    @Test
    public void metodaTest() {


        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();

        indexPage.enterOnBrowserWindowsSubmenu();

        BrowserWindowPage browserWindowPage = new BrowserWindowPage(driver);
        browserWindowPage.interactWithSpecificTab();
        browserWindowPage.interactWithSpecificWindow();

    }
}
