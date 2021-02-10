package tests;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TopMenuPage;
import pages.WomenTabPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WomanPageTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private WomenTabPage womenTabPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        womenTabPage = new WomenTabPage(driver);

    }

    @Test
    public void shouldOpenWomanTabPage(){
        topMenuPage.clickOnWomenTab();
        boolean isDisplayedCategoryName = womenTabPage.getCategoryName().equals("Women");
        Assertions.assertThat(isDisplayedCategoryName).isTrue();
    }


    @Test
    public void shouldSeeProductsPriceGreaterThanZero()  {
        topMenuPage.clickOnWomenTab();
        List<Double> productWithPriceZeroOrLess = womenTabPage.getProductsPriceValueWithoutCurrency()
                .stream()
                .filter(price -> price <= 0.00)
                .collect(Collectors.toList());

        Assertions.assertThat(productWithPriceZeroOrLess).isEmpty();


    }
}
