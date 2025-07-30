package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProfilePage extends BasePage{

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(css = "button.save-btn")
    private WebElement saveProfileButton;

    @FindBy(xpath = "//div[text()='Профіль змінено успішно']")
    private WebElement profileUpdatedMessage;

    @FindBy(css = "button.delete-account-btn")
    private WebElement deleteAccountButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void updateEmail(String newEmail) {
        sendKeys(emailInput, newEmail);
        click(saveProfileButton);
    }

    public boolean isProfileUpdatedMessageVisible() {
        try {
            waitForElementVisible(profileUpdatedMessage);
            return profileUpdatedMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDeleteButton() {
        click(deleteAccountButton);
    }
}
