package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest  extends SharedData {


    @Test
    public void metodaTest () {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        By formsMenu=By.xpath("//h5[text()='Forms']");
        elementHelper.clickJSLocator(formsMenu);

        By practiceFormSubMenu=By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJSLocator(practiceFormSubMenu);

        By firstNameElement=By.xpath("//input[@placeholder='First Name']");
        String firstNameValue="Cristina";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement=By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue="Lazar";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement=By.xpath("//input[@placeholder='name@example.com']");
        String emailValue="username@gmail.com";
        elementHelper.fillLocator(emailElement,emailValue);

        String genderValue = "Female";
       By genderOptionElement =By.xpath("//input[@name='gender']");
        List<WebElement> genderOptionsList = driver.findElements(genderOptionElement);
        if (genderValue.equals("Male")){
            elementHelper.clickJSLocator(genderOptionsList.get(0));
        }
        if (genderValue.equals("Female")){
            elementHelper.clickJSLocator(genderOptionsList.get(1));
        }
        if (genderValue.equals("Others")){
            elementHelper.clickJSLocator(genderOptionsList.get(2));
        }

        WebElement mobilePhoneElement = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        String mobilePhoneValue = "0721345678";
        mobilePhoneElement.sendKeys(mobilePhoneValue);

        pageHelper.scrollByPixel(0,500);

        By subjectsElement = By.id("subjectsInput");
        elementHelper.clickJSLocator(subjectsElement);


        //String subjectsValue = "Maths";
        //subjectsElement.sendKeys(subjectsValue);
       // subjectsElement.sendKeys(Keys.ENTER);
       // String subjectsValue2 = "Art";
        //subjectsElement.sendKeys(subjectsValue2);
       // subjectsElement.sendKeys(Keys.ENTER);

        //lISTA DE STRINGURI SI SA ADAUG ELEMENTELE PE CERE VREAU SA LE SELECTEZ
        // TREBUIE SA PARCURG LISTA PE CARE AM FACUT-O CU UN FOR
        //IN INTERIORUL FORULUI TREBUIE SA COMPLETEZ PE RAND FIECARE VALOARE IN subjectsElement si apoi sa apas un enter

        List<String> subjects=new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");


        for (int index=0; index<subjects.size(); index++){
            //subjectsElement.sendKeys(subjects.get(index));
            //subjectsElement.sendKeys(Keys.ENTER);
            elementHelper.fillPressLocator(subjectsElement, subjects.get(index),Keys.ENTER);
        }

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");

        List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index=0; index<hobbiesOptionList.size(); index++){
            String currentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(currentText)){
                hobbiesOptionList.get(index).click();
            }
        }

        By pictureElement = By.id("uploadPicture");
        File file = new File("src/test/resources/images.png");
        elementHelper.fillLocator(pictureElement, file.getAbsolutePath());

        By currentAddressElement = By.id("currentAddress");
        String currentAddressValue = "Iasi, jud. Iasi";
        elementHelper.fillLocator(currentAddressElement, currentAddressValue);

        By stateElement = By.xpath("//div[text()='Select State']");
        elementHelper.clickJSLocator(stateElement);

        By stateInputElement = By.id("react-select-3-input");
        String stateValue = "NCR";
        elementHelper.fillPressLocator(stateInputElement, stateValue, Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJSLocator(cityElement);


        By cityInputElement = By.id("react-select-4-input");
        String cityValue = "Delhi";
        elementHelper.fillPressLocator(cityInputElement, cityValue, Keys.ENTER);

        By submitElement=By.id("submit");
        elementHelper.clickLocator(submitElement);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = thankYouElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);


        List<WebElement>rowsList = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(rowsList.get(0).getText().contains("StudentName"));
        Assert.assertTrue(rowsList.get(0).getText().contains(firstNameValue));
        Assert.assertTrue(rowsList.get(0).getText().contains(lastNameValue));


        Assert.assertTrue(rowsList.get(1).getText().contains("Student Email"));
        Assert.assertTrue(rowsList.get(1).getText().contains(emailValue));

        Assert.assertTrue(rowsList.get(2).getText().contains("Gender"));
        Assert.assertTrue(rowsList.get(2).getText().contains(genderValue));

        Assert.assertTrue(rowsList.get(3).getText().contains("Mobile"));
        Assert.assertTrue(rowsList.get(3).getText().contains(mobilePhoneValue));


        String subjectStringValue = String.join(", ", subjects);
        Assert.assertTrue(rowsList.get(5).getText().contains("Subjects"));
        System.out.println(rowsList.get(5));
        System.out.println(subjectStringValue);
        Assert.assertTrue(rowsList.get(5).getText().contains(subjectStringValue));

        String hobbiesStringValue = String.join(", ", hobbies);
        Assert.assertTrue(rowsList.get(6).getText().contains("Hobbies"));
        Assert.assertTrue(rowsList.get(6).getText().contains(hobbiesStringValue));

        Assert.assertTrue(rowsList.get(7).getText().contains("Picture"));
        Assert.assertTrue(rowsList.get(7).getText().contains("images.png"));

        Assert.assertTrue(rowsList.get(8).getText().contains("Address"));
        Assert.assertTrue(rowsList.get(8).getText().contains(currentAddressValue));

        Assert.assertTrue(rowsList.get(9).getText().contains("State and City"));
        Assert.assertTrue(rowsList.get(9).getText().contains(stateValue));
        Assert.assertTrue(rowsList.get(9).getText().contains(cityValue));




    }
}
