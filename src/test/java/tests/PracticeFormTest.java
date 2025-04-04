package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest  extends SharedData {


    @Test
    public void metodaTest () {


        //PageHelper pageHelper = new PageHelper(driver);

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnFormsMenu();
        indexPage.enterOnPracticeFormSubmenu();


        String firstNameValue = "Cristina";
        String lastNameValue = "Lazar";
        String emailValue = "username@gmail.com";
        String genderValue = "Female";
        String mobilePhoneValue = "0721345678";
        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");
        String pathValue = "src/test/resources/images.png";
        String currentAddressValue = "Iasi";
        String stateInputValue = "NCR";
        String cityInputValue = "Delhi";
        String expectedMessage = "Thanks for submitting the form";

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillFirstName(firstNameValue);
        practiceFormPage.fillLastName(lastNameValue);
        practiceFormPage.fillEmailValue(emailValue);
        practiceFormPage.fillGenderValue(genderValue);
        practiceFormPage.fillMobilePhoneValue(mobilePhoneValue);
        practiceFormPage.fillSubjects(subjects);
        practiceFormPage.fillHobbies(hobbies);
        practiceFormPage.pictureUpload(pathValue);
        practiceFormPage.fillCurrentAddress(currentAddressValue);
        practiceFormPage.fillState(stateInputValue);
        practiceFormPage.fillCity(cityInputValue);
        practiceFormPage.submitClick();
        practiceFormPage.validateThankYouMessage(expectedMessage);
        practiceFormPage.validateEntireTable (firstNameValue, lastNameValue, emailValue, genderValue,
                mobilePhoneValue, currentAddressValue, stateInputValue, cityInputValue);

    }
}
