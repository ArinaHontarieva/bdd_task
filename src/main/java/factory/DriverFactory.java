package factory;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static DriverFactory instance;

    private final Map<String, WebDriverCreator> creators = new HashMap<>();

    private DriverFactory() {
        creators.put("chrome", new ChromeDriverCreator());
        creators.put("firefox", new FirefoxDriverCreator());
        creators.put("edge", new EdgeDriverCreator());
    }

    public static synchronized DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver initializeDriver(String browser) {
        WebDriverCreator creator = creators.get(browser.toLowerCase());
        if (creator == null) {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        tlDriver.set(creator.createDriver());

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        System.out.println(browser + " WebDriver initialized successfully.");
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public void closeDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
