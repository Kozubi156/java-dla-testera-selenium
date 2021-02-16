package pages;

import model.PersonalInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement genderMrRadioBox;

    @FindBy(id = "uniform-id_gender2")
    WebElement genderMrsRadioBox;

    @FindBy(id = "customer_firstname")
    WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordFiled;

    public void sendCreateAccountForm(PersonalInformation personalInformation){
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(personalInformation.getFirstName());
        lastNameField.sendKeys(personalInformation.getLastName());
        emailField.sendKeys(personalInformation.getEmail());
        passwordFiled.sendKeys(personalInformation.getPassword());
    }


}
