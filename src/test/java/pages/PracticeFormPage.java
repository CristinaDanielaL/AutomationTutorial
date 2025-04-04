package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static pageLocators.PracticeFormsLocators.*;

public class PracticeFormPage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);

    }
    public void fillFirstName (String firstNameValue) {
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }
    public void fillLastName (String lastNameValue) {
        elementHelper.fillLocator(lastNameElement, lastNameValue);
    }
    public void fillEmailValue (String emailValue) {
        elementHelper.fillLocator(emailElement,emailValue);
    }

    public void fillGenderValue (String genderValue) {
        List<WebElement> genderOptionsList = driver.findElements(genderOptionsElement);
        if (genderValue.equals("Male")){
            elementHelper.clickJSLocator(genderOptionsList.get(0));
        }
        if (genderValue.equals("Female")){
            elementHelper.clickJSLocator(genderOptionsList.get(1));
        }
        if (genderValue.equals("Others")){
            elementHelper.clickJSLocator(genderOptionsList.get(2));
        }
    }

    public void fillMobilePhoneValue (String mobilePhoneValue) {
        elementHelper.fillLocator(mobilePhoneElement, mobilePhoneValue);

    }
    public void fillSubjects (List<String> subjects) {
        elementHelper.clickJSLocator(subjectsElement);

        for (int index = 0; index < subjects.size(); index++) {

            elementHelper.fillPressLocator(subjectsElement, subjects.get(index), Keys.ENTER);

        }
    }
    public void fillHobbies (List<String> hobbies) {
        List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index=0; index<hobbies.size(); index++) {
            String currentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(currentText)) {
                elementHelper.clickJSLocator(hobbiesOptionList.get(index));

            }
        }
    }
    public void pictureUpload (String path) {
        File file = new File(path);
        elementHelper.fillLocator(pictureElement, file.getAbsolutePath());
    }
    public void fillCurrentAddress (String currentAddressValue) {
        elementHelper.fillLocator(currentAddressElement, currentAddressValue);
    }

    public void fillState (String stateInputValue) {
        elementHelper.clickJSLocator(stateElement);
        elementHelper.fillPressLocator(stateInputElement, stateInputValue, Keys.ENTER);
    }

    public void fillCity (String cityInputValue) {
        elementHelper.clickJSLocator(cityInputElement);
        elementHelper.fillPressLocator(cityInputElement, cityInputValue, Keys.ENTER);
    }

    public void submitClick () {
        elementHelper.clickLocator(submitElement);
    }

    public void validateThankYouMessage (String expectedMessage) {
        elementHelper.validateTextLocator(thankYouElement, expectedMessage);
        System.out.println("Testul a fost validat");
    }

    public void validateEntireTable (String firstNameValue, String lastNameValue,
                                     String emailValue, String genderValue, String mobilePhoneValue,
                                     String currentAddressValue, String stateInputValue, String cityInputValue) {

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
        elementHelper.validateTextContainsElement(rowsList.get(9), stateInputValue);
        elementHelper.validateTextContainsElement(rowsList.get(9), cityInputValue);

    }

}

