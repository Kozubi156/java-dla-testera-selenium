package tests;

import com.github.javafaker.Faker;
import model.PersonalInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        signInPage = new SignInPage(driver);

    }

    @Test
    public void shouldBeAbleToCreateAccount(){
        Faker faker = new Faker();

        topMenuPage.clickOnLoginButton();
        signInPage.inputEmailForCreateAccount(faker.internet().emailAddress());
        signInPage.clickOnCreateAccountButton();

        PersonalInformation personalInformation = new PersonalInformation();

        personalInformation.setGenderMr(personalInformation.getGenderMr());
        personalInformation.setFirstName(faker.address().firstName());
        personalInformation.setLastName(faker.address().lastName());
        personalInformation.setEmail(faker.internet().emailAddress());
        personalInformation.setPassword(faker.internet().password());

        createAccountPage.sendCreateAccountForm(personalInformation);
        assertThat(personalInformation.getFirstName()).isNotEmpty();


    }
}
