Feature: To perform CRUD operations on an rest API

  Scenario: Retrieve information of all users
    When Get request is hit
    Then All users list is shown

  Scenario: Retrieve information of a single user
    When Get request for single user
    Then Single user data is shown

  Scenario: create a new user
    When Post request is hit
    Then new user is created successfully

  Scenario:Update a user data
      When Put request for update
      Then record updated successfully

  Scenario: Delete an user data
    When Delete request for deletion
    Then record deleted successfully

