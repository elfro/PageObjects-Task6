package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class WelcomeBoardPage {
    private WebDriver driver;
    private Actions actions;

    @FindBy(xpath = "//a[contains(text(),'Drop me')]")
    private WebElement source;
    @FindBy(xpath = "//textarea[contains(text(),'Advanced')]")
    private WebElement target;
    @FindBy(xpath = "//textarea[contains(text(),'Basics')]")
    private WebElement targetBack;

    public WelcomeBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
}
