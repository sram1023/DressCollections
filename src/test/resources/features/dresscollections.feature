Feature: Purchase T-shirt

  @Order
  Scenario: Verify the order confirmation in order history page
    Given I am on homepage
    When I sign in
    And I order a T-Shirt
    Then I should see my order in order history

  @UpdateInfo
  Scenario: update personal information
    Given I am on homepage
    When I sign in
    And I update my personal information
    Then my personal information is saved