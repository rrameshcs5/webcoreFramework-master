import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Helper {

    private WebDriver driver = BrowserSetup.driver;
    private static WebDriverWait wait;
    public void waitUntilElementVisible(WebElement element){
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilElementDisappears(WebElement element){
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilElementVisible(WebElement element, int timeoutSeconds){
        wait = new WebDriverWait(driver,timeoutSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
