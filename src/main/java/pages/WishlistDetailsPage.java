package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class WishlistDetailsPage extends BasePage {

    @FindBy(xpath = "//h1/span")
    private WebElement wishlistTitleHeader;

    @FindBy(css = "button.add-btn")
    private WebElement addWishButton;


    public WishlistDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getWishlistTitle() {
        waitForElementVisible(wishlistTitleHeader);
        return wishlistTitleHeader.getText();
    }

    public void openCreateWishModal() {
        click(addWishButton);
    }
}
