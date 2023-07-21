package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {


        @CacheLookup
        @FindBy(xpath = "//button[normalize-space()='Continue']")
        WebElement nextStepButton;
        @CacheLookup
        @FindBy(xpath = "//input[@value='yes']")
        WebElement yes;
        @CacheLookup
        @FindBy(xpath = "//input[@value='no']")
        WebElement no;

        public void selectImmigrationStatus(String status) {
            switch (status) {
                case "Yes":
                    Reporter.log("Select Immigration status " + status.toString());
                    CustomListeners.test.log(Status.PASS, "Select Immigration status " + status);
                    clickOnElement(yes);
                    break;
                case "No":
                    Reporter.log("Select Immigration status " + status.toString());
                    CustomListeners.test.log(Status.PASS, "Select Immigration status " + status);
                    clickOnElement(no);
                    break;
            }
        }

        public void clickNextStepButton() {
            Reporter.log("Click on Next Step button " + nextStepButton.toString());
            CustomListeners.test.log(Status.PASS, "Click on Next Step button " + nextStepButton);
            clickOnElement(nextStepButton);

        }


    }


