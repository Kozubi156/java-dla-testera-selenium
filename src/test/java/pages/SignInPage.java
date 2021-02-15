package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement inputEmailFiled;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    public void inputEmailForCreateAccount(){
        inputEmailFiled.sendKeys("testsdsdsssdssdsd@kozubi.com");
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }

}
