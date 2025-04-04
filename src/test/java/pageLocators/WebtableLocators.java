package pageLocators;

import org.openqa.selenium.By;

public class WebtableLocators {
    public static final By tableRowsListElement = By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even'or@class='rt-tr -odd']");
    public static final By addElement=By.id("addNewRecordButton");
    public static final By firstNameElement=By.id("firstName");
    public static final By lastNameElement=By.id("lastName");
    public static final By userEmailElement=By.id("userEmail");
    public static final By ageElement=By.id("age");
    public static final By salaryElement=By.id("salary");
    public static final By departmentElement=By.id("department");
    public static final By submitElement=By.id("submit");
    public static final By editElement=By.id("edit-record-4");
    public static final By deleteElement=By.id("delete-record-4");
}
