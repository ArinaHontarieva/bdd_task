package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@href='/register']")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickRedirectToRegistrationButton() {
        click(registerLink);
    }
}
