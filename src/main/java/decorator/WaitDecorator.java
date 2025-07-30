package decorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class WaitDecorator implements ElementAction {
    private final ElementAction wrapped;
    private final WebDriver driver;

    public WaitDecorator(ElementAction wrapped, WebDriver driver) {
        this.wrapped = wrapped;
        this.driver = driver;
    }

    @Override
    public void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element));
        wrapped.click(element);
    }

    @Override
    public void sendKeys(WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element));
        wrapped.sendKeys(element, text);
    }
}

