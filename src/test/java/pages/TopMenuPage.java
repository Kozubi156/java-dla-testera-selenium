package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage extends BasePage{

    private WebDriverWait wait;

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Women")
    WebElement womenTab;

    public void clickOnContactUsLink(){
        contactUsLink.click();
    }

    public void clickOnWomenTab(){
        womenTab.click();
    }


}
