Feature: Checkout a product on SauceDemo

  Scenario Outline: Successful checkout with multiple products
    Given the user logs in with username "<username>" and password "<password>"
    When the user adds products "<product1>" and "<product2>" to the cart
    Then the user completes the purchase and sees the confirmation message "<confirmationMessage>"

    Examples:
      | username       | password     | product1             | product2             | confirmationMessage         |
      | standard_user  | secret_sauce | Sauce Labs Backpack  | Sauce Labs Bike Light | THANK YOU FOR YOUR ORDER    |
      | standard_user  | secret_sauce | Test.allTheThings()  | Sauce Labs Fleece Jacket | THANK YOU FOR YOUR ORDER    |
