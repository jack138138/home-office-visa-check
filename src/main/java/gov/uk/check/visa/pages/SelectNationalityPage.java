package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {

    @CacheLookup
    @FindBy(id = "response")
    WebElement nationalityDropDownList;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    public void selectNationality(String nationality) {
        Reporter.log("Select Nationality " + nationalityDropDownList.toString());
        CustomListeners.test.log(Status.PASS, "Select Nationality " + nationalityDropDownList);
        selectByVisibleTextFromDropDown(nationalityDropDownList, nationality);
    }

    public void clickNextStepButton() {
        Reporter.log("Click on Next Step button  " + nextStepButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Next Step button  " + nextStepButton);
        clickOnElement(nextStepButton);
    }

}