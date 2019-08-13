import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Helper {
    @FindBy(css = "input#username")
    private WebElement userNameInput;
    @FindBy(css = "input#password")
    private WebElement pwdInput;
    @FindBy(css = "input#Login")
    private WebElement loginBtn;

    public static WebDriver driver;
    public LoginPage(WebDriver webDriver) {
        driver= webDriver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUserName() {
        userNameInput.sendKeys(PropertiesReader.USER_NAME);
        return this;
    }

    public LoginPage enterPwd() {
        pwdInput.sendKeys(PropertiesReader.PASSWORD);
        return this;
    }

    public HomePage clickLoginBtn() {
        loginBtn.click();
        return new HomePage(driver);
    }
}
