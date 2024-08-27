Feature: Checkout a product on SauceDemo

  Scenario: Successful checkout
    Given the user is on the login page
    When the user logs in with valid credentials
    And the user adds two products to the cart
    And the user views the cart
    And the user completes the checkout process
    Then the user should see the confirmation message "THANK YOU FOR YOUR ORDER"
