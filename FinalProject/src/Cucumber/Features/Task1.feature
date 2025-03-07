Feature: Adding new address after login

  Scenario: User adds a new address after logging in
    Given I am logged in as a user with the email "jkowalski@gmail.com" and password "aaAA123!@"
    When I click on the "Addresses" link
    And I click on the "Create new address" button
    And I fill in the new address form with the following details
      | alias  | address        | city     | zip    | country  | phone        |
      | Home   | 123 Main St    | London   | 12345  | UK       | 1234567890   |
    Then The program checks if the data are correct, create a new address and reload to the addresses page