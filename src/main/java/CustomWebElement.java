import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CustomWebElement implements WebElement {
    public  CustomWebElement shouldBeVisible(){
        WebDriverWait wait = new WebDriverWait(BrowserSetup.driver,10);
        wait.until(ExpectedConditions.visibilityOf(this));
        return this;
    }
}
