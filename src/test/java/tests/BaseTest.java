package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.stqa.selenium.factory.WebDriverFactory;
import webDriver.Browser;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {
    protected Browser browser;
    protected WebDriver driver;
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional String browserName) {
        this.browser = new Browser();
        driver = this.browser.getDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30L, SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        WebDriverFactory.dismissAll();
    }
}
