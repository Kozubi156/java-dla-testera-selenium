package pages;

import model.Address;
import model.PersonalInformation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "days")
    WebElement dayOfBirthField;

    @FindBy(id = "months")
    WebElement monthOfBirthField;

    @FindBy(id = "years")
    WebElement yearOfBirthField;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    WebElement specialOfferCheckBox;

    @FindBy(id = "firstname")
    WebElement firstNameAddressField;

    @FindBy(id = "lastname")
    WebElement lastNameAddressField;

    @FindBy(id = "company")
    WebElement companyNameField;

    @FindBy(id = "address1")
    WebElement address1Field;

    @FindBy(id = "address2")
    WebElement address2Field;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "id_state")
    WebElement stateFiled;

    @FindBy(id = "postcode")
    WebElement postcodeField;

    @FindBy(id = "id_country")
    WebElement countryField;

    @FindBy(id = "other")
    WebElement additionalInfoField;

    @FindBy(id = "phone")
    WebElement homePhoneField;

    @FindBy(id = "phone_mobile")
    WebElement phoneMobileField;

    @FindBy(id = "submitAccount")
    WebElement submitAccountButton;

    @FindBy(id = "alias")
    WebElement aliasField;

    @FindBy(className = "info-account")
    WebElement infoAccount;

    public void clickSpecialOfferCheckBox(){
        specialOfferCheckBox.click();
    }

    public void clickNewsletterCheckBox(){
        newsletterCheckBox.click();
    }

    public void fillPersonalInformation (PersonalInformation personalInformation){
        wait.until(ExpectedConditions.visibilityOf(genderMrRadioBox));
        genderMrRadioBox.click();
        firstNameField.sendKeys(personalInformation.getFirstName());
        lastNameField.sendKeys(personalInformation.getLastName());
        passwordFiled.sendKeys(personalInformation.getPassword());
        Select dayOfBirthDropDownList = new Select(dayOfBirthField);
        dayOfBirthDropDownList.selectByValue(personalInformation.getDayOfBirth());

        Select monthOfBirthDropDownList = new Select(monthOfBirthField);
        monthOfBirthDropDownList.selectByValue(personalInformation.getMonthOfBirth());

        Select yearOfBirthDropDownList = new Select(yearOfBirthField);
        yearOfBirthDropDownList.selectByValue(personalInformation.getYearOfBirth());
    }

    public void fillAddressInformation(Address address){
        firstNameAddressField.sendKeys(address.getFirstName());
        lastNameAddressField.sendKeys(address.getLastName());
        companyNameField.sendKeys(address.getCompanyName());
        address1Field.sendKeys(address.getAddressLine1());
        address2Field.sendKeys(address.getAddressLine2());
        cityField.sendKeys(address.getCity());

        Select stateFiledDropDownList = new Select(stateFiled);
        stateFiledDropDownList.selectByVisibleText(address.getState());

        postcodeField.sendKeys(address.getPostalCode());

        Select countryFieldDropDownList = new Select(countryField);
        countryFieldDropDownList.selectByVisibleText(address.getCountry());

        additionalInfoField.sendKeys(address.getAdditionalInfo());
        homePhoneField.sendKeys(address.getHomePhone());
        phoneMobileField.sendKeys(address.getMobilePhone());
        aliasField.sendKeys(address.getAddressAlias());
    }

    public void clickOnRegisterButton(){
        submitAccountButton.click();
    }

    public boolean isElementDisplayed() {
        return super.isElementDisplayed(infoAccount);
    }
}
