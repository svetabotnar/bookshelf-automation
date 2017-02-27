@ready
Feature: Test login

  Scenario Outline: Login Success and Failure
    Given I navigate to login page
    When I login with username "<username>" and password "<password>"
    Then I should see that I logged in with status "<status>"
    And I do logout
  Examples:
    | username           | password             | status      |
    | sbotnar@lohika.com | password             |successful   |
    | ideabox-ldap       | xwPgV42Px9Af67LjJtr  |unsuccessful |
    | ideabox-admin      | w7kbqf%62xm          |unsuccessful |
    | ideabox-admin      | w7kbqf%62xm          |unsuccessful |
    |                    |                      |unsuccessful |


