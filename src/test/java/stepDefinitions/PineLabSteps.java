package stepDefinitions;

import Pages.PineLabsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.WebDriverUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PineLabSteps {
    PineLabsPage pineLabSteps = new PineLabsPage();




        @Given("user is on app selection page")
    public void user_is_on_app_selection_page() {
        // Write code here that turns the phrase above into concrete actions
       String title = pineLabSteps.setAppselection();
       System.out.println(title);
       Assert.assertEquals(title,"Tickets Status");

    }

    @Given("user navigates to the Pinelabs page")
    public void user_navigates_to_the_pinelabs_page() {
        // Write code here that turns the phrase above into concrete actions
        pineLabSteps.clickPineLabs();



    }

    @Then("user checks the heading of the page")
    public void user_checks_the_heading_of_the_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = pineLabSteps.checkTitle();
        Assert.assertEquals(title,"Pine Lab Issues");

    }

    @Given("user checks if the {string} button is visible")
    public void user_checks_if_the_button_is_visible(String string) {
        // Write code here that turns the phrase above into concrete actions
      boolean flag=  pineLabSteps.checkCreateIssue();
      Assert.assertEquals(flag,true);
    }

    @Then("verify the button is clickable")
    public void verify_the_button_is_clickable() {
        // Write code here that turns the phrase above into concrete actions
        boolean flag=  pineLabSteps.clickable();
        Assert.assertEquals(flag,true);


    }

    @Given("user clicks on the {string} button")
    public void user_clicks_on_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        String flag = pineLabSteps.checkclick();
        Assert.assertEquals(flag,"Create Pine Lab Complaints Registration");

    }

    @Given("user enters valid Pinelabs details")
    public void user_enters_valid_pinelabs_details() {
        // Write code here that turns the phrase above into concrete actions
        pineLabSteps.EnterDetails();
    }

    @Given("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        // Write code here that turns the phrase above into concrete actions
        pineLabSteps.clickSubmit();
    }

    @Then("user should see the {string} message")
    public void user_should_see_the_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        String
    }

    @Then("user should verify the status is {string}")
    public void user_should_verify_the_status_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user clicks on an existing Pinelabs entry")
    public void user_clicks_on_an_existing_pinelabs_entry() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user clicks on the edit button")
    public void user_clicks_on_the_edit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user updates the Pinelabs details")
    public void user_updates_the_pinelabs_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the status should remain {string}")
    public void the_status_should_remain(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user clicks on the delete button")
    public void user_clicks_on_the_delete_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the entry should no longer appear in the list")
    public void the_entry_should_no_longer_appear_in_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user clicks on the status update button for an entry")
    public void user_clicks_on_the_status_update_button_for_an_entry() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user provides the necessary details")
    public void user_provides_the_necessary_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user clicks on the confirm status update button")
    public void user_clicks_on_the_confirm_status_update_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the entry status should be {string}")
    public void the_entry_status_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user enters a valid search term in the Pinelabs search bar")
    public void user_enters_a_valid_search_term_in_the_pinelabs_search_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should see results matching the search term")
    public void user_should_see_results_matching_the_search_term() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user enters invalid Pinelabs details")
    public void user_enters_invalid_pinelabs_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should see an error message indicating invalid input")
    public void user_should_see_an_error_message_indicating_invalid_input() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user clicks on Actions for an entry that is not in {string} status")
    public void user_clicks_on_actions_for_an_entry_that_is_not_in_status(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("status update option should not be available")
    public void status_update_option_should_not_be_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("delete option should not be available for this entry")
    public void delete_option_should_not_be_available_for_this_entry() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
