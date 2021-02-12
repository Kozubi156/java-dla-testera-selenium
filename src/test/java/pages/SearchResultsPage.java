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


    public boolean isProductCounterDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(productCounter));
        boolean isDisplayed = false;
        try {
            isDisplayed = productCounter.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element");
        }

        return isDisplayed;
    }
}


