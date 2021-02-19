package model;
import lombok.Data;
import org.openqa.selenium.WebElement;

@Data
public class PersonalInformation {

    private WebElement genderMr;
    private WebElement genderMrs;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;

}