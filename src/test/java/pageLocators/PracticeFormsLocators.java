package pageLocators;

import org.openqa.selenium.By;

public class PracticeFormsLocators {
    public static final By firstNameElement = By.xpath("//input[@placeholder='First Name']");
    public static final By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
    public static final By emailElement = By.xpath("//input[@placeholder='name@example.com']");
    public static final By genderOptionsElement = By.xpath("//input[@name='gender']");
    public static final By mobilePhoneElement = By.xpath("//input[@placeholder='Mobile Number']");
    public static final By subjectsElement = By.id("subjectsInput");
    //public static final By hobbiesOptionList = By.xpath("//div[@id='hobbiesWrapper']//label");
    public static final By pictureElement = By.id("uploadPicture");
    public static final By currentAddressElement = By.id("currentAddress");
    public static final By stateElement = By.xpath("//div[text()='Select State']");
    public static final By stateInputElement = By.id("react-select-3-input");
    public static final By cityElement = By.xpath("//div[text()='Select City']");
    public static final By cityInputElement = By.id("react-select-4-input");
    public static final By submitElement = By.id("submit");
    public static final By thankYouElement = By.id("example-modal-sizes-title-lg");
    public static final By tableRowsListElement = By.xpath("//tbody/tr");

}
