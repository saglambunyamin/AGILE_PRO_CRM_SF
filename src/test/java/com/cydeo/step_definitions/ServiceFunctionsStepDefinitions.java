package com.cydeo.step_definitions;

import com.cydeo.pages.ServiceFunctionsPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.cydeo.utilities.ConfigurationReader;

public class ServiceFunctionsStepDefinitions {

    ServiceFunctionsPage serviceFunctionsPage = new ServiceFunctionsPage();

    Faker faker = new Faker();


    @When("User goes to url")
    public void user_goes_to_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web_url"));
    }
    @When("User enters valid username")
    public void user_enters_valid_username() {
        serviceFunctionsPage.inputUsername.sendKeys(ConfigurationReader.getProperty("username"));
    }
    @When("User enters valid password")
    public void user_enters_valid_password() {
        serviceFunctionsPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @When("User clicks to Login Button and goes to Home page")
    public void user_clicks_to_login_button_and_goes_to_home_page() {
        serviceFunctionsPage.loginButton.click();
    }
    @When("User goes to Services page")
    public void user_goes_to_services_page() {
        serviceFunctionsPage.servicesButton.click();
    }
    @When("User clicks to Training tab")
    public void user_clicks_to_training_tab() {
        serviceFunctionsPage.trainingButton.click();
    }

    @When("User clicks to My Courses tab")
    public void user_clicks_to_my_courses_tab() {
        serviceFunctionsPage.myCoursesButton.click();
    }
    @Then("User can display the courses")
    public void userCanDisplayTheCourses() {
        Assert.assertEquals("Course report", serviceFunctionsPage.coursePageTitle.getText());
    }

    @And("User clicks to Grade Book tab")
    public void userClicksToGradeBookTab() {
        serviceFunctionsPage.gradeBookButton.click();
    }


    @Then("User can display the grades")
    public void userCanDisplayTheGrades() {
        Assert.assertEquals("Test results", serviceFunctionsPage.testResultPageTitle.getText());
    }


    @And("User clicks to Profile tab")
    public void userClicksToProfileTab() {
        serviceFunctionsPage.profileButton.click();
    }

    @Then("User can edit personal data under Profile")
    public void userCanEditPersonalDataUnderProfile() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + "_" + lastName.toLowerCase() + "@cybertekschool.com";
        String webSite = firstName.toLowerCase() + "-" + lastName.toLowerCase() + ".com";
        String icq = faker.numerify("########");

        serviceFunctionsPage.inputFirstName.clear();
        serviceFunctionsPage.inputFirstName.sendKeys(firstName);

        serviceFunctionsPage.inputLastName.clear();
        serviceFunctionsPage.inputLastName.sendKeys(lastName);

        serviceFunctionsPage.inputEMail.clear();
        serviceFunctionsPage.inputEMail.sendKeys(email);

        serviceFunctionsPage.inputWebSite.clear();
        serviceFunctionsPage.inputWebSite.sendKeys(webSite);

        serviceFunctionsPage.inputIcq.clear();
        serviceFunctionsPage.inputIcq.sendKeys(icq);

        BrowserUtilities.sleep(3);
        serviceFunctionsPage.saveButton.click();
        BrowserUtilities.sleep(3);

        Assert.assertEquals(firstName, serviceFunctionsPage.inputFirstName.getText());
        Assert.assertEquals(lastName, serviceFunctionsPage.inputLastName.getText());
        Assert.assertEquals(email, serviceFunctionsPage.inputEMail.getText());
        Assert.assertEquals(webSite, serviceFunctionsPage.inputWebSite.getText());
        Assert.assertEquals(icq, serviceFunctionsPage.inputIcq.getText());


    }
}