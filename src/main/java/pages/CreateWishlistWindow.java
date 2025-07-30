package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CreateWishlistWindow extends BasePage{
    @FindBy(id = "createForm")
    private WebElement createForm;

    @FindBy(id = "wishlistTitle")
    private WebElement titleInput;

    @FindBy(id = "wishlistDate")
    private WebElement dateInput;

    @FindBy(id = "wishlistDesc")
    private WebElement descriptionInput;

    @FindBy(css = "button.btn-ok")
    private WebElement createButton;

    public CreateWishlistWindow(WebDriver driver) {
        super(driver);
    }

    public void fillTitle(String title) {
        titleInput.clear();
        titleInput.sendKeys(title);
    }

    public void fillDate(String date) {
        dateInput.clear();
        dateInput.sendKeys(date);
    }

    public void fillDescription(String desc) {
        descriptionInput.clear();
        descriptionInput.sendKeys(desc);
    }

    public void clickCreate() {
        createButton.click();
    }
}
