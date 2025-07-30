package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class WelcomePage extends BasePage {

    @FindBy(xpath = "//a[@class='header-btn']")
    private WebElement loginButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        click(loginButton);
    }
}
