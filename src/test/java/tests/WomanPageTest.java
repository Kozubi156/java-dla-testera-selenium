package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import pages.WomenTabPage;
import utils.PageUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WomanPageTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private WomenTabPage womenTabPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        womenTabPage = new WomenTabPage(driver);

    }

    @Test
    public void shouldOpenWomanTabPage(){
        topMenuPage.clickOnWomenTab();
        boolean isDisplayedCategoryName = womenTabPage.getCategoryName().equals("Women");
        assertThat(isDisplayedCategoryName).isTrue();
    }


    @Test
    public void shouldSeeProductsPriceGreaterThanZero()  {
        topMenuPage.clickOnWomenTab();
        List<Double> productWithPriceZeroOrLess = womenTabPage.getProductsPriceValueWithoutCurrency()
                .stream()
                .filter(price -> price <= 0.00)
                .collect(Collectors.toList());

        assertThat(productWithPriceZeroOrLess).isEmpty();


    }
}
