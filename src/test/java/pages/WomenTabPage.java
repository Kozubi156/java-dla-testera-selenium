package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class WomenTabPage {

    private WebDriverWait wait;


    @FindBy(className = "product-price")
    List<WebElement> productsPrice;


    public List<String> getProductsPrice()  {
        return productsPrice.stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());

    }

}
