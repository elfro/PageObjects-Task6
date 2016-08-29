package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.LoginPage;
import pages.WelcomeBoardPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.io.IOException;

@Listeners(value = AllureTestListener.class)
public class SimpleTrelloTest extends BaseTest {
    LoginPage loginPage;
    BoardsPage boardsPage;
    WelcomeBoardPage welcomeBoardPage;

    @FindBy(xpath = "//a[contains(text(),'Drop me')]/ancestor::div[@class='list js-list-content']//textarea")
    private WebElement targetElementColumn;

    @TestCaseId("1")
    @Features("dragAndDrop")
    @Stories("dragAndDrop")
    @Test()
    public void dragAndDrop() throws IOException {
        String expectedResult = "Advanced";
        loginPage = new LoginPage(driver);
        boardsPage = new BoardsPage(driver);
        welcomeBoardPage = new WelcomeBoardPage(driver);
        PageFactory.initElements(driver, this);
        loginPage.openLoginPage().setEmailPassword("testtesttest@mail.com", "12345678");
        loginPage.clickLoginBtn();
        boardsPage.openWelcomeBoard();
        welcomeBoardPage.dragAndDropCard();
        Assert.assertEquals(expectedResult, targetElementColumn.getText());
        welcomeBoardPage.dragAndDropBack();
    }
}
