package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage {
    private static final String URL = "https://trello.com/login";

    @FindBy(id = "user")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.get(URL);
        return this;
    }

    @Step
    public LoginPage setEmailPassword(String user, String password) {
        this.user.sendKeys(user);
        this.password.sendKeys(password);
        return this;
    }

    @Step
    public BoardsPage clickLoginBtn() {
        loginBtn.click();
        return new BoardsPage(driver);
    }
}
