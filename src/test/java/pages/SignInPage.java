package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement inputEmailFiled;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    public void inputEmailForCreateAccount(String email){
        wait.until(ExpectedConditions.visibilityOf(inputEmailFiled));
        inputEmailFiled.sendKeys(email);
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }

}
