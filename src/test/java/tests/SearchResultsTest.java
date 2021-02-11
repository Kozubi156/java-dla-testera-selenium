package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import pages.SearchResultsPage;
import pages.TopMenuPage;
import pages.WomenTabPage;
import utils.PageTitleUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private SearchResultsPage searchResultsPage;
    private WomenTabPage womenTabPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        womenTabPage = new WomenTabPage(driver);
    }

    @Test
    public void shouldBySearchAndSeeFoundedProduct(){
        topMenuPage.inputSearchQuery(PageTitleUtils.SEARCH_PRODUCT_NAME);
        topMenuPage.clickOnSubmitSearchButton();

        System.out.println(searchResultsPage.getProduct());

//        boolean isFoundedProductNameEqualToSearchQuery =
//                searchResultsPage.getProductName().equals(PageTitleUtils.SEARCH_PRODUCT_NAME);
//
//        List<String> productsPrice = womenTabPage.getProductsPrice();
//
//        System.out.println(searchResultsPage.getProductName());
//
//        Assertions.assertThat(isFoundedProductNameEqualToSearchQuery).isTrue();
//        Assertions.assertThat(productsPrice).isNotEmpty();


    }
}
