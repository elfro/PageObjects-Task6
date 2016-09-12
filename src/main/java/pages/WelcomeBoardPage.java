package pages;

import blocks.MemberMenuBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class WelcomeBoardPage extends BasePage {
    private MemberMenuBlock memberMenuBlock;
    private Actions actions;

    @FindBy(xpath = "//a[contains(text(),'Drop me')]")
    private WebElement source;
    @FindBy(xpath = "//textarea[contains(text(),'Advanced')]")
    private WebElement target;
    @FindBy(xpath = "//textarea[contains(text(),'Basics')]")
    private WebElement targetBack;
    @FindBy(xpath = "//a[contains(text(),'Drop me')]/ancestor::div[@class='list js-list-content']//textarea")
    private WebElement targetElementColumn;

    public WelcomeBoardPage(WebDriver driver) {
        super(driver);
        memberMenuBlock = PageFactory.initElements(driver, MemberMenuBlock.class);
    }

    public WelcomeBoardPage dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        return this;
    }

    @Step
    public WelcomeBoardPage dragAndDropCard() {
        dragAndDrop(source, target);
        return this;
    }

    @Step
    public WelcomeBoardPage dragAndDropBack() {
        dragAndDrop(source, targetBack);
        return this;
    }

    public String getColumnName() {
        return targetElementColumn.getText();
    }

    @Step
    public void logOut() {
        memberMenuBlock.logout();
    }
}
