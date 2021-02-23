package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchResultsPage extends BasePage {

    @FindBy(className = "product-count")
    WebElement productCounter;

    @FindBy(css = ".right-block .product-name")
    WebElement productName;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOf(productName));
        return productName.getText().trim();
    }

    @Override
    public boolean isElementDisplayed(WebElement webElement) {
        return super.isElementDisplayed(webElement);
    }
}


