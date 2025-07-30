package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CreateWishWindow extends BasePage{

    @FindBy(xpath = "//h2[text()='Нове бажання']")
    private WebElement newWishHeader;

    @FindBy(id = "wishTitle")
    private WebElement wishTitleInput;

    @FindBy(css = "button.btn-ok")
    private WebElement saveWishButton;

    public CreateWishWindow(WebDriver driver) {
        super(driver);
    }

    public void fillTitle(String title) {
        sendKeys(wishTitleInput, title);
    }

    public void clickSave() {
        waitForElementClickable(saveWishButton);
        click(saveWishButton);
    }
}
