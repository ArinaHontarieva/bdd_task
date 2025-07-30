package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage extends BasePage {

    @FindBy(id = "fname")
    private WebElement nameField;

    @FindBy(id = "lname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "birthDate")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//button[@class='btn' and @type='submit']")
    private WebElement registerButton;

    @FindBy(id = "emptyFname")
    private WebElement emptyFnameError;

    @FindBy(id = "emptyLname")
    private WebElement emptyLnameError;

    @FindBy(id = "emailError")
    private WebElement emailError;

    @FindBy(id = "passwordError")
    private WebElement passwordError;

    @FindBy(id = "matchError")
    private WebElement emptyConfirmPasswordError;

    @FindBy(id = "ageError")
    private WebElement ageError;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillName(String name) {
        sendKeys(nameField, name);
    }

    public void fillLastName(String lastName) {
        sendKeys(lastNameField, lastName);
    }

    public void fillEmail(String email) {
        sendKeys(emailField, email);
    }

    public void fillPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        sendKeys(confirmPasswordField, confirmPassword);
    }

    public void fillBirthDate(String birthDate) {
        sendKeys(dateOfBirthField, birthDate);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }
}
