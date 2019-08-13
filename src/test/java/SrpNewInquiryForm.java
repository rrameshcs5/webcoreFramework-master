import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.awt.windows.WBufferStrategy;

public class SrpNewInquiryForm extends Helper{
@FindBy(css = "h2.mainTitle")
private WebElement mainTitle;
@FindBy(id = "j_id0:theentireform:j_id27:j_id42:j_id43:opp__firstname")
private WebElement firstNameInput;
@FindBy (id = "j_id0:theentireform:j_id27:j_id42:j_id45:opp__lastname")
private WebElement lastNameInput;
@FindBy (id = "j_id0:theentireform:j_id27:j_id42:j_id47:campusPicklist")
private WebElement campusPick;
@FindBy (xpath = "//iframe[@title='accessibility title'][1]")
private WebElement iframe;
@FindBy (id = "j_id0:theentireform:j_id27:j_id38:j_id39:opp__retrainowner")
private WebElement retainOwnerCbox;
@FindBy (id = "j_id0:theentireform:j_id27:j_id42:j_id51:programPicklist")
private WebElement programeDropDown;
@FindBy (id = "j_id0:theentireform:j_id27:j_id42:j_id55:specPicklist")
private WebElement specializatioDropDown;
@FindBy (id = "j_id0:theentireform:j_id27:j_id42:j_id51:programStatus.start")
private WebElement loadingTextPrograme;
@FindBy (id="j_id0:theentireform:j_id27:j_id42:j_id55:specStatus.start")
private WebElement loadingTextSpec;
@FindBy (id = "j_id0:theentireform:j_id27:j_id42:j_id58:timeframe")
private WebElement timeFramDropDown;
@FindBy (id = "j_id0:theentireform:j_id27:j_id42:j_id61:gender")
private WebElement genderDropDown;
@FindBy (id = "j_id0:theentireform:j_id27:j_id64:j_id65:emailAdd")
private WebElement emailInput;
@FindBy (id = "j_id0:theentireform:j_id27:j_id64:j_id67:Home_Phone")
private WebElement homePhoneNumber;
@FindBy (id = "j_id0:theentireform:j_id27:j_id73:j_id80:Country")
private WebElement countryDropDown;
@FindBy (id = "j_id0:theentireform:j_id27:j_id86:j_id89:campaignList")
private WebElement campaignDropDown;
@FindBy (id = "j_id0:theentireform:j_id27:j_id28:subBtn")
private WebElement saveBtn;
@FindBy (xpath = "//a[text()='Go to Opportunity']")
private WebElement goToOpportunityBtn;
private String campusDropDownId="j_id0:theentireform:j_id27:j_id42:j_id47:campusPicklist";
private String programeDropDwonId ="j_id0:theentireform:j_id27:j_id42:j_id51:programPicklist";
private String specializationDropDownId ="j_id0:theentireform:j_id27:j_id42:j_id55:specPicklist";
private String timeFrameDropDownId="j_id0:theentireform:j_id27:j_id42:j_id58:timeframe";
private String genderDropDownId ="j_id0:theentireform:j_id27:j_id42:j_id61:gender";
private String countryDropDownId ="j_id0:theentireform:j_id27:j_id73:j_id80:Country";
private String campaignDropDownId="j_id0:theentireform:j_id27:j_id86:j_id89:campaignList";


WebDriver driver;
    public SrpNewInquiryForm(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
        driver.switchTo().frame(iframe);
        waitUntilElementVisible(mainTitle);
    }

    public SrpNewInquiryForm verifyFormTitle(){
        Assert.assertEquals("New Inquiry Form",mainTitle.getText());
        return this;
    }

    public SrpNewInquiryForm enterFirstName(String fName){
        firstNameInput.sendKeys(fName);
        return this;
    }

    public SrpNewInquiryForm enterSecondName(String sName){
        lastNameInput.sendKeys(sName);
        return this;
    }

    public SrpNewInquiryForm selectCampus(String campusName){
        waitUntilElementVisible(campusPick);
        campusPick.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(campusDropDownId));
        dropDownSelector.selectOption(campusName).click();
        campusPick.click();
        waitUntilElementDisappears(loadingTextPrograme);
        return this;
    }
    public SrpNewInquiryForm selectCampus(int index){
        waitUntilElementVisible(campusPick);
        campusPick.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(campusDropDownId));
        dropDownSelector.selectOption(index).click();
        campusPick.click();
        waitUntilElementVisible(loadingTextPrograme);
        waitUntilElementDisappears(loadingTextPrograme);

        //waitUntilElementDisappears(loadingTextPrograme);
       return this;
    }
    public SrpNewInquiryForm checkRetainowner(){
       if (!retainOwnerCbox.isSelected()){
           retainOwnerCbox.click();
       }
        return this;
    }

    public SrpNewInquiryForm unCheckRetainowner(){
        if (retainOwnerCbox.isSelected()){
            retainOwnerCbox.click();
        }
        return this;
    }

    public SrpNewInquiryForm selectPrograme(String programeName){
        waitUntilElementVisible(programeDropDown);
        programeDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(programeDropDwonId));
        dropDownSelector.selectOption(programeName).click();
        waitUntilElementDisappears(loadingTextSpec);
        return this;
    }
    public SrpNewInquiryForm selectPrograme(int index){
        waitUntilElementVisible(programeDropDown);
        programeDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(programeDropDwonId));
        dropDownSelector.selectOption(index).click();
        waitUntilElementVisible(loadingTextSpec);
        waitUntilElementDisappears(loadingTextSpec);
        return this;
    }

    public SrpNewInquiryForm selectSpecialization(String programeName){
        waitUntilElementVisible(specializatioDropDown);
        specializatioDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(programeDropDwonId));
        dropDownSelector.selectOption(programeName).click();
        programeDropDown.click();
        return this;
    }
    public SrpNewInquiryForm selectSpecialization(int index){
        waitUntilElementVisible(specializatioDropDown);
        specializatioDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(specializationDropDownId));
        dropDownSelector.selectOption(index).click();
        return this;
    }

    public SrpNewInquiryForm selectTimeFrame(String timeFrame){
        waitUntilElementVisible(timeFramDropDown);
        timeFramDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(timeFrameDropDownId));
        dropDownSelector.selectOption(timeFrame).click();
        timeFramDropDown.click();
        return this;
    }
    public SrpNewInquiryForm selectGender(String gender){
        waitUntilElementVisible(genderDropDown);
        genderDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(genderDropDownId));
        dropDownSelector.selectOption(gender).click();
        genderDropDown.click();
        return this;
    }

    public SrpNewInquiryForm enterEmail(String emailId){
        emailInput.sendKeys(emailId);
        return this;
    }
    public SrpNewInquiryForm homePhone(String phoneNum){
        homePhoneNumber.sendKeys(phoneNum);
        return this;
    }

    public SrpNewInquiryForm selectCountry(String countryName){
        countryDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(countryDropDownId));
        dropDownSelector.selectOption(countryName).click();

        return this;
    }
    public SrpNewInquiryForm selectCountry(int index){
        countryDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(countryDropDownId));
        dropDownSelector.selectOption(index).click();

        return this;
    }
    public SrpNewInquiryForm selectCampaign(int index){
        campaignDropDown.click();
        DropDownSelector dropDownSelector = new DropDownSelector(new ElementSelector.ById(campaignDropDownId));
        dropDownSelector.selectOption(index).click();
        campaignDropDown.click();
        return this;
    }

    public SrpNewInquiryForm clickSaveBtn(){
        saveBtn.click();
        waitUntilElementVisible(goToOpportunityBtn,30);
        return this;
    }

    public HomePage clickOpportunity(){
        goToOpportunityBtn.click();
        driver.switchTo().parentFrame();
        return new HomePage(driver);
    }
}
