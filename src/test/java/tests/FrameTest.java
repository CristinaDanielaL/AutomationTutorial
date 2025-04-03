package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.FramePage;
import pages.IndexPage;
import sharedData.SharedData;

import java.time.Duration;

public class FrameTest extends SharedData {



    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnFrameSubmenu();

        FramePage framePage = new FramePage(driver);
        framePage.switchToSpecificTab();

        framePage.switchToParent();
    }
}
