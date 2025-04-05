package pages;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.FrameLocators;

public class FramePage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private TabWindowHelper tabWindowHelper;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        tabWindowHelper = new TabWindowHelper(driver);
    }

    public void switchToSpecificTab () {
        driver.switchTo().frame("frame1");
        LoggerUtility.infoTest("The user switches the focus on second tab");
        WebElement textElement = driver.findElement(FrameLocators.textElement);
        System.out.println(textElement.getText());
    }

    public void switchToParent () {
        driver.switchTo().parentFrame();
        LoggerUtility.infoTest("The user switches the focus on parent frame");
        driver.switchTo().frame("frame2");
        LoggerUtility.infoTest("The user switches the focus on second frame");
        WebElement textElement2 = driver.findElement(FrameLocators.textElement);
        System.out.println(textElement2.getText());
    }

}
