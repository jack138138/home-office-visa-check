package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(xpath = "//input[@value='six_months_or_less']")
    WebElement lessThanSixMonths;
    @CacheLookup
    @FindBy(xpath = "//input[@value='longer_than_six_months']")
    WebElement moreThanSixMonths;

    public void selectLengthOfStay(String moreOrLess) {

        switch (moreOrLess) {
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                Reporter.log("Select Length of stay " + moreOrLess.toString());
                CustomListeners.test.log(Status.PASS, "Select Length of stay " + moreOrLess);
                break;
            case "longer than 6 months":
                clickOnElement(moreThanSixMonths);
                Reporter.log("Select Length of stay " + moreOrLess.toString());
                CustomListeners.test.log(Status.PASS, "Select Length of stay " + moreOrLess);
                break;
        }
    }

    public void clickNextStepButton() {
        clickOnElement(nextStepButton);
    }

}