import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.beans.MethodDescriptor;
import java.lang.reflect.Method;

public class TestClass extends BrowserSetup {
    public Logger logger = Logger.getLogger(TestClass.class);

    @Test
    public void testCase1() {
        // Method method = M;
        logger.info("test case 1");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName().enterPwd().clickLoginBtn()
                .selectFromNavMenu("SRP New Inquiry Form")
                .verifyFormTitle()
                .unCheckRetainowner()
                .enterFirstName("Ramesh")
                .enterSecondName("Automation")
                .selectCampus(3)
                .selectPrograme(2)
                .selectSpecialization(2)
                .selectTimeFrame("12+ months")
                .selectGender("Female")
                .enterEmail("Test@nomail.com")
                .homePhone("93354125414")
                .selectCountry("AZERBAIJAN")
                .selectCampaign(3)
                .clickSaveBtn()
                .clickOpportunity()
                .clickOnCrossBtnofTab();
        logger.info("test case 1");
    }
}
