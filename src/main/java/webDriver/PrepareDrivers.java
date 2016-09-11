package webDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Map;

public class PrepareDrivers {
    public static DesiredCapabilities capabilities;

    public static DesiredCapabilities prepareFirefox() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver64.exe");
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", false);
        return capabilities;
    }

    public static DesiredCapabilities prepareChrome() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.setBinary("C:\\Users\\Owner\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }
}

