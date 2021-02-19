package tests;

import com.github.javafaker.Faker;
import model.Address;
import model.PersonalInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.PageUtils;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        signInPage = new SignInPage(driver);

    }

    @Test
    public void shouldCreateNewAccount() {
        Faker faker = new Faker(new Locale("en-US"));

        topMenuPage.clickOnLoginButton();
        signInPage.inputEmailForCreateAccount(faker.internet().emailAddress());
        signInPage.clickOnCreateAccountButton();

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setGenderMr(personalInformation.getGenderMr());
        personalInformation.setFirstName(faker.address().firstName());
        personalInformation.setLastName(faker.address().lastName());
        personalInformation.setPassword(faker.internet().password());
        personalInformation.setDayOfBirth(PageUtils.DAY_OF_BIRTH);
        personalInformation.setMonthOfBirth(PageUtils.MONTH_OF_BIRTH);
        personalInformation.setYearOfBirth(PageUtils.YEAR_OF_BIRTH);
        createAccountPage.fillPersonalInformation(personalInformation);

        createAccountPage.clickNewsletterCheckBox();
        createAccountPage.clickSpecialOfferCheckBox();

        Address address = new Address();
        address.setFirstName(personalInformation.getFirstName());
        address.setLastName(personalInformation.getLastName());
        address.setCompanyName(faker.company().name());
        address.setAddressLine1(faker.address().streetName());
        address.setAddressLine2(faker.address().buildingNumber());
        address.setCity(faker.address().city());
        address.setState(PageUtils.STATE);
        address.setPostalCode(faker.address().zipCodeByState(PageUtils.STATE_ABBREVIATION));
        address.setCountry(PageUtils.COUNTRY);
        address.setAdditionalInfo(faker.address().secondaryAddress());
        address.setHomePhone(faker.phoneNumber().cellPhone());
        address.setMobilePhone(faker.phoneNumber().cellPhone());
        address.setAddressAlias(faker.name().username());
        createAccountPage.fillAddressInformation(address);

        createAccountPage.clickOnRegisterButton();

        assertThat(topMenuPage.getAccountName()).contains(personalInformation.getFirstName());
        assertThat(topMenuPage.getAccountName()).contains(personalInformation.getLastName());
        assertThat(createAccountPage.isInfoAccountDisplayed()).isTrue();
    }
}
