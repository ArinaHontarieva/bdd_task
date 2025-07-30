package pages;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class MainWishlistPage extends BasePage {

    @FindBy(css = "a[href='/profile']")
    private WebElement profileLink;

    @FindBy(css = "button.add-text-btn")
    private WebElement createWishlistButton;

    public MainWishlistPage(WebDriver driver) {
        super(driver);
    }

    public void clickProfileIcon() {
        click(profileLink);
    }

    public void clickCreateWishlistButton() {
        click(createWishlistButton);
    }

    public boolean isWishlistWithTitlePresent(String title) {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@class, 'title') and text()='" + title + "']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickWishlistByTitle(String title) {
        By wishlistLink = By.xpath("//a[contains(@class, 'title') and text()='" + title + "']");
        click(wishlistLink);
    }

}
