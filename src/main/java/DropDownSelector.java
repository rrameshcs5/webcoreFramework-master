import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownSelector {
    private String tag="select";
    private WebElement selector;
    private WebElement option;
    WebDriver driver = BrowserSetup.driver;
    public DropDownSelector(ElementSelector.ById id){
        selector = driver.findElement(By.xpath(id.xpathCreator(tag,"")));
    }

    public WebElement selectOption(String optionToselect){
        if (selector.findElements(By.xpath("./option")).size()==1){
            optionToselect="-None-";
        }
        option = selector.findElement(By.xpath("//option[text()='"+optionToselect+"']"));
        return option;
    }
    public WebElement selectOption(int index){
        if (selector.findElements(By.xpath("./option")).size()==1){
            index=1;
        }
        option = selector.findElement(By.xpath("./option[position()="+index+"]"));
        return option;
    }
}

