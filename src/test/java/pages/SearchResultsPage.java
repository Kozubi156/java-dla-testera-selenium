package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchResultsPage extends BasePage  {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "product-count")
    WebElement productCounter;

    @FindBy (className = "product-name")
    WebElement productName;

//    public String  getProductName(){
//        return productName.getText().trim();
//    }
//
//    public void getProduct(){
//        productName.getText().trim();
//    }

    public boolean isProductCounterDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(productCounter));
        if (productCounter.isDisplayed()) return true;
        else return false;

    }
}
