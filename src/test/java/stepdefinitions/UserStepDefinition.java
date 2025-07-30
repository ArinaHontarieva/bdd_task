package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import models.User;
import org.testng.asserts.SoftAssert;
import io.cucumber.datatable.DataTable;
import java.util.List;

public class UserStepDefinition extends BaseSteps {

    private final SoftAssert softAssert = new SoftAssert();
    private final TestContext context = new TestContext();

    @Given("User is on the welcome page")
    public void userIsOnWelcomePage() {
        openWelcomePage();
    }

    @When("User clicks login")
    public void userClicksLogin() {
        clickLoginButton();
    }

    @And("User navigates to the registration page")
    public void userNavigatesToRegistrationPage() {
        redirectToRegisterPage();
    }

    @When("User registers with data: {string}, {string}, {string}, {string}, {string}, {string}")
    public void userRegistersWithData(String firstName, String lastName, String email, String password,
                                      String confirmPassword, String birthDay) {
        User user = new User(firstName, lastName, email, password, confirmPassword, birthDay);
        context.setEmail(email);
        fillRegistrationFormAndSubmit(user);
    }

    @Then("Main page should be visible")
    public void mainPageShouldBeVisible() {
        softAssert.assertTrue(isHeaderPresent("h1", "Мої вішлісти"), "Main page header is not displayed");
        softAssert.assertAll();
    }

    @When("User creates a wishlist named {string}")
    public void userCreatesWishlist(String wishlistName) {
        context.setWishlistName(wishlistName);
        openCreateWishlistModal();
        fillCreateWishlistForm(wishlistName);
    }

    @Then("Created wishlist should be visible")
    public void wishlistShouldBeVisible() {
        String wishlistName = context.getWishlistName();
        softAssert.assertTrue(isWishlistWithTitlePresent(wishlistName),
            "Wishlist with title '" + wishlistName + "' is not visible");
        softAssert.assertAll();
    }

    @When("User opens created wishlist")
    public void userOpensCreatedWishlist() {
        String wishlistName = context.getWishlistName();
        openWishlistByTitle(wishlistName);
    }

    @When("User adds a wish {string} to the wishlist {string}")
    public void userAddsWishToWishlist(String wishName, String wishlistName) {
        context.setWishName(wishName);
        openCreateWishModal();
        createWish(wishName);
    }

    @When("User navigates to profile and deletes account")
    public void userDeletesAccount() {
        goToProfile();
        deleteUserAccount();
    }

    @Then("Welcome page should be visible")
    public void welcomePageShouldBeVisible() {
        softAssert.assertTrue(isHeaderPresent("h1", "Створи вішліст "),
            "Expected welcome page not visible after deletion");
        softAssert.assertAll();
    }

    @When("User adds the following wishes to the wishlist {string}:")
    public void userAddsMultipleWishesToWishlist(String wishlistName, DataTable dataTable) {
        List<String> wishNames = dataTable.asList();
        for (String wishName : wishNames) {
            openCreateWishModal();
            createWish(wishName);
        }
    }

    @Then("the following wishes should be visible in {string}:")
    public void wishesShouldBeVisible(String wishlistName, DataTable dataTable) {
        List<String> wishNames = dataTable.asList();
        for (String wishName : wishNames) {
            boolean isVisible = isHeaderPresent("*", wishName);
            softAssert.assertTrue(isVisible, "Wish '" + wishName + "' is not visible in wishlist '" + wishlistName + "'");
        }
        softAssert.assertAll();
    }
}
