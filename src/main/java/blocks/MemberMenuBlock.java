package blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberMenuBlock {
    private WebDriver driver;

    @FindBy(xpath = ".//*[@id='header']/div[4]/a[2]/span[1]/span[1]")
    private WebElement memberMenu;
    @FindBy(css = ".js-logout")
    private WebElement logout;

    public MemberMenuBlock(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        memberMenu.click();
        logout.click();
    }
}
