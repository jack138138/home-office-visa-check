package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Jay Vaghani
 */
public class StartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Accept additional cookies']")
    WebElement acceptAllCookies;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Start now']")
    WebElement startButton;

    public void acceptAllCookies() {
        try {
            driver.findElement(By.xpath("//button[contains(text(),'Accept additional cookies')]")).click();
        } catch (StaleElementReferenceException e) {

        }

    }

    public void clickOnStartButton() {

        // clickOnElement(startButton);


        try {
            driver.findElement(By.xpath("//a[normalize-space()='Start now']")).click();
        } catch (StaleElementReferenceException e) {
            Reporter.log("Click On Start Now Button "+ startButton.toString());
            CustomListeners.test.log(Status.PASS,"Click On Start Now Button "+ startButton);
        }


    }
    }
