package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import utils.PageUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }

    @Test
    public void shouldSeePopularItemsOnHomePage() {
        List<String> productNames = popularItemsPage.getProductNames();

        List<String> productWithEmptyName = productNames.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());

        Assertions.assertThat(productWithEmptyName).isEmpty();

    }


}
