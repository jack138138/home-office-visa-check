package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You will not need a visa to come to the UK')]")
    WebElement resultMessageTourism;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
    WebElement resultMessageHealthAndCare;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You’ll need a visa to join your family or partner ')]")
    WebElement resultMessageJoinPartnerOrFamily;

    public String getResultMessageTourism() {
        Reporter.log("Get Result message " + resultMessageTourism.toString());
        CustomListeners.test.log(Status.PASS, "Get Result message " + resultMessageTourism);
        String result =getTextFromElement(resultMessageTourism);
        return result;
    }

    public void confirmResultMessageTourism(String expectedMessage) {

        Assert.assertTrue(expectedMessage.equalsIgnoreCase(getResultMessageTourism()));
    }

    public String getResultMessageHealthAndCare() {
        Reporter.log("Get Result message " + resultMessageHealthAndCare.toString());
        CustomListeners.test.log(Status.PASS, "Get Result message " + resultMessageHealthAndCare);

        return getTextFromElement(resultMessageHealthAndCare);
    }

    public void confirmResultMessageHealthAndCare(String expectedMessage) {

        Assert.assertTrue(expectedMessage.equalsIgnoreCase(getResultMessageHealthAndCare()));
    }

    //        if (getResultMessage().equalsIgnoreCase(expectedMessage)) {
//            Assert.assertTrue(true);
//        } else {
//            Assert.fail();
////        }
//        Reporter.log("Confirm Result Message " + expectedMessage.toString());
//        CustomListeners.test.log(Status.PASS, "Confirm Result Message " + expectedMessage);
    public String getResultMessageJoinPartnerOrFamily() {
        return getTextFromElement(resultMessageJoinPartnerOrFamily);
    }

    public void confirmResultMessageJoinPartnerOrFamily(String expectedMessage) {
        Assert.assertTrue(expectedMessage.equalsIgnoreCase(getResultMessageJoinPartnerOrFamily()));
    }
}