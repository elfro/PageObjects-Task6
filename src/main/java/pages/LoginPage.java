package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    private static final String URL = "https://trello.com/login";

    @FindBy(id = "user")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginPage() {
        driver.get(URL);
        return this;
    }

    public LoginPage setEmailPassword(String user, String password) {
        this.user.sendKeys(user);
        this.password.sendKeys(password);
        return this;
    }

    public BoardsPage clickLoginBtn() {
        loginBtn.click();
        return new BoardsPage(driver);
    }
}
