@ready
Feature: Add Book


 Scenario: Add Book using ISBN number
   When I click on BookContent button
   Then Add Book form page is displayed
   And Add Book button is "disabled"
   When I search book with "9780130935380" number
   And Add Book button is "enabled"
   When I click on Add Book button
   Then Message "Book was successfully added" is displayed
   And I close message window



  Scenario: Add Book using wrong ISBN
    When I click on BookContent button
    Then Add Book form page is displayed
    And Add Book button is "disabled"
    When I search book with "97877735380" number
    Then Message "Nothing found for ISBN: 97877735380" is displayed
    And Add Book button is "disabled"

  Scenario: Add Book using ISBN, Title, Authors, Pages, Language, Categories
    When I click on BookContent button
    Then Add Book form page is displayed
    And Add Book button is "disabled"
    When I enter Title "Sveta_Test"
    Then Add Book button is "disabled"
    When I select "Foster Provost" Authors
    Then Add Book button is "disabled"
#    When I enter "453" number of pages
#    Then Add Book button is "disabled"
#    When I select Language
##    Then Add Book button is "disabled"
    When I select "Business & Economics / Marketing / General" Category
    Then Add Book button is "disabled"
#    When I search book with "97877735380" number
#    Then Message "Nothing found for ISBN: 97877735380" is displayed
#    And Add Book button is "disabled"

