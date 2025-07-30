package stepdefinitions;

import factory.DriverFactory;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.time.Duration;

public abstract class BaseSteps {

    protected final Logger LOG = LogManager.getLogger(this.getClass());

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected boolean isHeaderPresent(String tag, String text) {
        LOG.debug("Checking presence of element <{}> with text '{}'", tag, text);
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//" + tag + "[text()='" + text + "']")));
            LOG.info("Header found: <{}>{}</{}>", tag, text, tag);
            return true;
        } catch (TimeoutException e) {
            LOG.warn("Header not found: <{}>{}</{}>", tag, text, tag);
            return false;
        }
    }

    protected void openWelcomePage() {
        LOG.info("Opening welcome page");
        WelcomePage welcomePage = new WelcomePage(getDriver());
    }

    protected void clickLoginButton() {
        LOG.info("Clicking login button on Welcome Page");
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.clickLoginButton();
    }

    protected void redirectToRegisterPage() {
        LOG.info("Redirecting to Registration page");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickRedirectToRegistrationButton();
    }

    protected void fillRegistrationFormAndSubmit(User user) {
        LOG.info("Filling registration form for user: {}", user.getEmail());
        RegisterPage registerPage = new RegisterPage(getDriver());

        registerPage.fillName(user.getName());
        registerPage.fillLastName(user.getLastName());
        registerPage.fillEmail(user.getEmail());
        registerPage.fillPassword(user.getPassword());
        registerPage.fillConfirmPassword(user.getConfirmPassword());
        registerPage.fillBirthDate(user.getBirthDate());

        LOG.info("Submitting registration form");
        registerPage.clickRegisterButton();
    }

    protected void goToProfile() {
        LOG.info("Navigating to user profile");
        MainWishlistPage mainWishlistPage = new MainWishlistPage(getDriver());
        mainWishlistPage.clickProfileIcon();
    }

    protected void deleteUserAccount() {
        LOG.info("Deleting user account");
        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.clickDeleteButton();
    }

    protected void openCreateWishlistModal() {
        LOG.info("Opening create wishlist modal");
        MainWishlistPage mainPage = new MainWishlistPage(getDriver());
        mainPage.clickCreateWishlistButton();
    }

    protected void fillCreateWishlistForm(String wishlistName) {
        LOG.info("Filling create wishlist form with title: {}", wishlistName);
        CreateWishlistWindow window = new CreateWishlistWindow(getDriver());

        window.fillTitle(wishlistName);
        window.fillDate("01012055");
        window.fillDescription("This is a test wishlist");

        window.clickCreate();
        LOG.info("Wishlist created successfully");
    }

    protected boolean isWishlistWithTitlePresent(String title) {
        LOG.debug("Checking if wishlist with title '{}' is present", title);
        MainWishlistPage mainPage = new MainWishlistPage(getDriver());
        boolean result = mainPage.isWishlistWithTitlePresent(title);
        LOG.debug("Wishlist with title '{}' present: {}", title, result);
        return result;
    }

    protected void openWishlistByTitle(String title) {
        LOG.info("Opening wishlist with title: {}", title);
        MainWishlistPage mainPage = new MainWishlistPage(getDriver());
        mainPage.clickWishlistByTitle(title);
    }

    protected void openCreateWishModal() {
        LOG.info("Opening create wish modal");
        WishlistDetailsPage detailsPage = new WishlistDetailsPage(getDriver());
        detailsPage.openCreateWishModal();
    }

    protected void createWish(String title) {
        LOG.info("Creating wish with title: {}", title);
        CreateWishWindow wishWindow = new CreateWishWindow(getDriver());
        wishWindow.fillTitle(title);
        wishWindow.clickSave();
        LOG.info("Wish '{}' created", title);
    }
}
