package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import pages.WomenTabPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class WomanPageTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private WomenTabPage womenTabPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        womenTabPage = new WomenTabPage();

    }

    @Test
    public void shouldSeeProductsPriceGreaterThanZero()  {
        topMenuPage.clickOnWomenTab();
        womenTabPage.getProductsPrice();

    }
}
