package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class WomenTabPage extends BasePage {

    @FindBy(css = ".right-block .product-price")
    List<WebElement> productsPrice;

    @FindBy(className = "category-name")
    WebElement womenCategoryBanner;

    public WomenTabPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryName(){
       return womenCategoryBanner.getText();
    }

    public List<String> getProductsPrice() {
        return productsPrice.stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());
    }

    public List<Double> getProductsPriceValueWithoutCurrency() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productsPrice));
        return productsPrice.stream()
                .map(price -> price.getText().replace("$","").trim())
                .map(price -> Double.parseDouble(price))
                .collect(Collectors.toList());
    }

}
