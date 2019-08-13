import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {
    public Logger logger = Logger.getLogger(BrowserSetup.class);
    public static WebDriver driver;
    {
        PropertiesReader prop = new PropertiesReader();
        prop.loadProperties();
    }

    @BeforeMethod
    public void setupBrowser(){
        logger.info("setupBrowser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(PropertiesReader.BASE_URL);
    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}
