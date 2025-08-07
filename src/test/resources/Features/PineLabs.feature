@PinelabsFeature
Feature: PineLabs Functionality

  @Smoke @Regression
  Scenario: Navigate to Pinelabs page
    Given user is on app selection page
    And user navigates to the Pinelabs page
    Then user checks the heading of the page

  @Smoke @Regression
  Scenario: Verify 'Create New Pinelabs' button visibility and clickability
    Given user checks if the "Create New Pinelabs" button is visible
    Then verify the button is clickable

  @Smoke
  Scenario: Create a new Pinelabs entry
    Given user clicks on the "Create New Pinelabs" button
    And user enters valid Pinelabs details
    And user clicks on the save button
    Then user should see the "Pinelabs created successfully" message
    And user should verify the status is "New"

  @Smoke
  Scenario: Edit an existing Pinelabs entry
    Given user clicks on an existing Pinelabs entry
    And user clicks on the edit button
    And user updates the Pinelabs details
    Then user should see the "Pinelabs updated successfully" message
    And the status should remain "New"

  @Smoke
  Scenario: Delete a Pinelabs entry
    Given user clicks on an existing Pinelabs entry
    And user clicks on the delete button
    Then user should see the "Pinelabs deleted successfully" message
    And the entry should no longer appear in the list

  @Smoke
  Scenario: Update Pinelabs status to Closed
    Given user clicks on the status update button for an entry
    And user provides the necessary details
    And user clicks on the confirm status update button
    Then user should see the "Pinelabs status updated successfully" message
    And the entry status should be "Closed"

  @Smoke
  Scenario: Verify the search functionality for Pinelabs
    Given user enters a valid search term in the Pinelabs search bar
    And user clicks on the search button
    Then user should see results matching the search term

  @smoke
  Scenario: Show error for invalid Pinelabs details
    Given user clicks on the "Create New Pinelabs" button
    And user enters invalid Pinelabs details
    Then user should see an error message indicating invalid input

  @smoke
  Scenario: Prevent status update if Pinelabs is not in 'New' state
    Given user clicks on Actions for an entry that is not in "New" status
    Then status update option should not be available
    And delete option should not be available for this entry


