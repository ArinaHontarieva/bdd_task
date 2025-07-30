package decorator;

import org.openqa.selenium.WebElement;

public class BasicElementAction implements ElementAction {

    @Override
    public void click(WebElement element) {
        element.click();
    }

    @Override
    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}