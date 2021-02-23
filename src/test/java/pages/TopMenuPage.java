package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage{

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Women")
    WebElement womenTab;

    @FindBy(id = "search_query_top")
    WebElement searchFieldTop;

    @FindBy(className = "button-search")
    WebElement submitSearchButton;

    @FindBy(className = "login")
    WebElement signInButton;

    @FindBy(className = "account")
    WebElement accountName;

    public void inputSearchQuery(String queryText){
        searchFieldTop.sendKeys(queryText);
    }

    public void clickOnSubmitSearchButton(){
        submitSearchButton.click();
    }

    public void clickOnContactUsLink(){
        contactUsLink.click();
    }

    public void clickOnWomenTab(){
        womenTab.click();
    }

    public void clickOnLoginButton(){
        signInButton.click();
    }

    public String getAccountName(){
        return accountName.getText();
    }


}
