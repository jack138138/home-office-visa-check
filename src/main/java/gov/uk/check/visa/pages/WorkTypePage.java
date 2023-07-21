package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='gem-c-radio govuk-radios__item']")
    List<WebElement> selectJobTypeList;

    public void selectJobType(String job) {

        for (WebElement jobType : selectJobTypeList) {
            if (jobType.getText().equalsIgnoreCase(job)) {
                clickOnElement(jobType);
                Reporter.log("Select Job Type " + job.toString());
                CustomListeners.test.log(Status.PASS, "Select Job Type " + job);
            }
        }

    }

    public void clickNextStepButton() {
        Reporter.log("Select Job type " + nextStepButton.toString());
        CustomListeners.test.log(Status.PASS, "Select Job type " + nextStepButton);
        clickOnElement(nextStepButton);

    }



}
