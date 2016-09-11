package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class BoardsPage extends BasePage{
    @FindBy(xpath = "//span[@title='Welcome Board' and @class='board-tile-details-name']")
    private WebElement welcomeBoardTile;

    public BoardsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public WelcomeBoardPage openWelcomeBoard() {
        welcomeBoardTile.click();
        return new WelcomeBoardPage(driver);
    }
}
