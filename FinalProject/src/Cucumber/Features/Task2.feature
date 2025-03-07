Feature: Reviewing the complete process of ordering an item

  Scenario: User completes process of ordering an item
    Given I am logged in as a user with the email "jkowalski@gmail.com" and password "aaAA123!@"
    When I click on the search bar and look for "Hummingbird Printed Sweater"
    And I click on the Hummingbird Printed Sweater' item
    And I select a M size
    And I select quantity value of 5
    And I add the selected item to cart
    And Proceed to checkout
    And I click proceed to checkout on the next page
    And I click continue
    And I click continue to payment
    And I select a payment method
    And I agree to terms
    Then Place an order