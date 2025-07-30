package hooks;

import factory.DriverFactory;
import helpers.PropertiesHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    @Before
    public void setup() {
        PropertiesHelper config = PropertiesHelper.getInstance();
        String browser = config.getBrowser();
        DriverFactory.getInstance().initializeDriver(browser);
        getDriver().manage().window().maximize();
        getDriver().get(config.getBaseUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        DriverFactory.getInstance().closeDriver();
    }
}
