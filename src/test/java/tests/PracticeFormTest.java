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

        By mobilePhoneElement = By.xpath("//input[@placeholder='Mobile Number']");
        String mobilePhoneValue = "0721345678";
        elementHelper.fillLocator(mobilePhoneElement, mobilePhoneValue);

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
        for (int index=0; index<hobbies.size(); index++){
            String currentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(currentText)){
                elementHelper.clickJSLocator(hobbiesOptionList.get(index));

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

        By thankYouElement = By.id("example-modal-sizes-title-lg");
        String expectedMessage = "Thanks for submitting the form";
        elementHelper.validateTextLocator(thankYouElement, expectedMessage);

        //String actualMessage = thankYouElement.getText();
        //Assert.assertEquals(actualMessage, expectedMessage);
        //System.out.println("Testul a fost validat");

        By rowsListElement = By.xpath("//tbody/tr");
        List<WebElement>rowsList = driver.findElements(rowsListElement);
        elementHelper.validateTextContainsElement(rowsList.get(0), "StudentName");
        elementHelper.validateTextContainsElement(rowsList.get(0), firstNameValue);
        elementHelper.validateTextContainsElement(rowsList.get(0), lastNameValue);


        elementHelper.validateTextContainsElement(rowsList.get(1), "Student Email");
        elementHelper.validateTextContainsElement(rowsList.get(1), emailValue);

        elementHelper.validateTextContainsElement(rowsList.get(2), "Gender");
        elementHelper.validateTextContainsElement(rowsList.get(2), genderValue);

        elementHelper.validateTextContainsElement(rowsList.get(3), "Mobile");
        elementHelper.validateTextContainsElement(rowsList.get(3), mobilePhoneValue);

        elementHelper.validateTextContainsElement(rowsList.get(5), "Subjects");
        elementHelper.validateTextContainsElement(rowsList.get(5), "Maths");
        elementHelper.validateTextContainsElement(rowsList.get(5), "Arts");
        elementHelper.validateTextContainsElement(rowsList.get(5), "Biology");

        elementHelper.validateTextContainsElement(rowsList.get(6), "Hobbies");
        elementHelper.validateTextContainsElement(rowsList.get(6), "Sports");
        elementHelper.validateTextContainsElement(rowsList.get(6), "Music");

        elementHelper.validateTextContainsElement(rowsList.get(7), "Picture");
        elementHelper.validateTextContainsElement(rowsList.get(7), "images.png");

        elementHelper.validateTextContainsElement(rowsList.get(8), "Address");
        elementHelper.validateTextContainsElement(rowsList.get(8), currentAddressValue);

        elementHelper.validateTextContainsElement(rowsList.get(9), "State and City");
        elementHelper.validateTextContainsElement(rowsList.get(9), stateValue);
        elementHelper.validateTextContainsElement(rowsList.get(9), cityValue);

    }
}
