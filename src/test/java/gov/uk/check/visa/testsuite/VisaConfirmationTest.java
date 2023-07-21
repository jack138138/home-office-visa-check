package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {


        StartPage startPage;
        SelectNationalityPage selectNationalityPage;
        ReasonForTravelPage reasonForTravelPage;
        ResultPage resultPage;
        DurationOfStayPage durationOfStayPage;
        WorkTypePage workTypePage;
        FamilyImmigrationStatusPage familyImmigrationStatusPage;


        @BeforeMethod(alwaysRun = true)
        public void inIt() {
            startPage = new StartPage();
            selectNationalityPage = new SelectNationalityPage();
            reasonForTravelPage = new ReasonForTravelPage();
            resultPage = new ResultPage();
            durationOfStayPage = new DurationOfStayPage();
            workTypePage = new WorkTypePage();
            familyImmigrationStatusPage = new FamilyImmigrationStatusPage();

        }

        @Test(groups = {"smoke","sanity","regression"})
        public void verifyAnAustralianComingToUkForTourism() {
            startPage.clickOnStartButton();
            selectNationalityPage.selectNationality("Australia");
            selectNationalityPage.clickNextStepButton();
            reasonForTravelPage.selectReasonForVisit("Tourism");
            reasonForTravelPage.clickNextStepButton();
            //resultPage.confirmResultMessageTourism("You will not need a visa to come to the UK");
        }

        @Test(groups = {"regression"})
        public void verifyAChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
            startPage.clickOnStartButton();
            selectNationalityPage.selectNationality("Chile");
            selectNationalityPage.clickNextStepButton();
            reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
            reasonForTravelPage.clickNextStepButton();
            durationOfStayPage.selectLengthOfStay("longer than 6 months");
            durationOfStayPage.clickNextStepButton();
            workTypePage.selectJobType("Health and care professional");
            workTypePage.clickNextStepButton();
            // resultPage.confirmResultMessageHealthAndCare("You need a visa to work in health and care");

        }

        @Test(groups = {"sanity","regression"})
        public void verifyAColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
            // Click on start button
            startPage.clickOnStartButton();
            //	Select a Nationality 'Congo'
            selectNationalityPage.selectNationality("Congo");
            //	Click on Continue button
            selectNationalityPage.clickNextStepButton();
            //	Select reason 'Join partner or family for a long stay'
            reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
            //	Click on Continue button
            reasonForTravelPage.clickNextStepButton();
            //	Select state My partner of family member have uk immigration status 'yes'
            familyImmigrationStatusPage.selectImmigrationStatus("Yes");
            //	Click on Continue button
            familyImmigrationStatusPage.clickNextStepButton();
            //	verify result 'You’ll need a visa to join your family or partner in the UK'
            resultPage.confirmResultMessageJoinPartnerOrFamily("You’ll need a visa to join your family or partner in the UK");


        }
    }