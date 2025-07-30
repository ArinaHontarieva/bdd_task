package pages;

import decorator.BasicElementAction;
import decorator.ElementAction;
import decorator.WaitDecorator;
import helpers.PropertiesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final String baseUrl;
    private final WebDriver driver;
    private final ElementAction actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.baseUrl = PropertiesHelper.getInstance().getBaseUrl();
        this.actions = new WaitDecorator(new BasicElementAction(), driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void click(WebElement element) {
        actions.click(element);
    }


    protected void click(By locator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        actions.sendKeys(element, text);
    }

    protected void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element));
    }
}