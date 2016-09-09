package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    private LoginPage loginPage;
    private BoardsPage boardsPage;
    private WelcomeBoardPage welcomeBoardPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        boardsPage = new BoardsPage(driver);
        welcomeBoardPage = new WelcomeBoardPage(driver);
    }

    @TestCaseId("1")
    @Features("dragAndDrop")
    @Stories("dragAndDrop")
    @Test()
    public void dragAndDrop() throws IOException {
        String expectedResult = "Advanced";
        loginPage.openLoginPage().setEmailPassword("testtesttest@mail.com", "12345678").clickLoginBtn();
        boardsPage.openWelcomeBoard();
        welcomeBoardPage.dragAndDropCard();
        Assert.assertEquals(expectedResult, welcomeBoardPage.getColumnName());
        welcomeBoardPage.dragAndDropBack().logOut();
    }
}