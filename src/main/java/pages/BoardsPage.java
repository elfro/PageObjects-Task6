package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class BoardsPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@title='Welcome Board' and @class='board-tile-details-name']")
    private WebElement welcomeBoardTile;

    public BoardsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step
    public WelcomeBoardPage openWelcomeBoard() {
        welcomeBoardTile.click();
        return new WelcomeBoardPage(driver);
    }
}
