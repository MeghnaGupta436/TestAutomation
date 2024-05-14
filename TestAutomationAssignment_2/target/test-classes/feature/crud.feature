Feature: To perform CRUD operations on an rest API

  Scenario: Retrieve information of all employees
    When Get request is hit
    Then All employees data is shown

#  Scenario: Retrieve information of a single employee
#    When Get request for single Employee
#    Then Single employee data is shown

  Scenario: To create a new employee
    When Post request is hit
    Then new employee is created successfully