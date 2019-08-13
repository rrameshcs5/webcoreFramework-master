import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MenuDropDown {

    private String DROP_DOWN_LIST_CLASS = "slds-popover__body";
    private String LIST_ITEM_CSS ="li.slds-listbox__item";
    private WebElement dropDown;
    private WebElement dropDownElement;
    WebDriver driver = BrowserSetup.driver;
    Actions actions;
    public MenuDropDown(ElementSelector.ById id){
        dropDown= driver.findElement(By.xpath(id.xpathCreator("div",DROP_DOWN_LIST_CLASS)));
    }

    public List<WebElement> getListItems(){
       return dropDown.findElements(By.cssSelector(LIST_ITEM_CSS));
    }

    public WebElement selectItemFromList(String itemName){
        dropDownElement = dropDown.findElement(By.cssSelector("li a[title='"+itemName+"']"));
        actions = new Actions(driver);
        actions.moveToElement(dropDownElement);
       return dropDownElement;
    }
    public WebElement selectItemFromList(int index){
        dropDownElement = dropDown.findElement(By.cssSelector("li:nth-child("+index+")"));
        actions = new Actions(driver);
        actions.moveToElement(dropDownElement);
        return dropDownElement;
    }


}
