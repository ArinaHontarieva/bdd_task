package decorator;

import org.openqa.selenium.WebElement;

public interface ElementAction {
    void click(WebElement element);
    void sendKeys(WebElement element, String text);
}