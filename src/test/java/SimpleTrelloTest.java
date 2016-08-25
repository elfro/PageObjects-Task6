import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.LoginPage;
import pages.WelcomeBoardPage;

import java.io.IOException;

public class SimpleTrelloTest extends BaseTest {

    LoginPage loginPage;
    BoardsPage boardsPage;
    WelcomeBoardPage welcomeBoardPage;

    @FindBy (xpath = "//a[contains(text(),'Drop me')]/ancestor::div[@class='list js-list-content']//textarea")
    private WebElement targetElementColumn;

    @Test()
    public void dragAndDrop() throws IOException {

        String expectedResult = "Advanced";
        loginPage = new LoginPage(driver);
        boardsPage = new BoardsPage(driver);
        welcomeBoardPage = new WelcomeBoardPage(driver);
        PageFactory.initElements(driver, this);
        loginPage.openLoginPage().setEmailPassword("testtesttest@mail.com","12345678");
        loginPage.clickLoginBtn();
        boardsPage.openWelcomeBoard();
        welcomeBoardPage.dragAndDropCard();
        Assert.assertEquals(expectedResult,targetElementColumn.getText());
        welcomeBoardPage.dragAndDropBack();

    }

}
