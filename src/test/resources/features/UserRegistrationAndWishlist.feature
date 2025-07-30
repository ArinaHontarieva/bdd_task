Feature: User registration and wishlist management

  Background:
    Given User is on the welcome page
    When User clicks login
    And User navigates to the registration page

  Scenario Outline: Register user and create wishlist with multiple wishes
    When User registers with data: "<firstName>", "<lastName>", "<email>", "<password>", "<confirmPassword>", "<birthDay>"
    Then Main page should be visible

    When User creates a wishlist named "<wishlistName>"
    Then Created wishlist should be visible
    When User opens created wishlist

    When User adds the following wishes to the wishlist "<wishlistName>":
      | <wishName1>     |
      | <wishName2>     |
    Then the following wishes should be visible in "<wishlistName>":
      | <wishName1>     |
      | <wishName2>     |

    When User navigates to profile and deletes account
    Then Welcome page should be visible

    Examples:
      | firstName | lastName   | email              | password    | confirmPassword | birthDay | wishlistName    | wishName1   | wishName2 |
      | Aryna     | Hontarieva | aryna@test.com     | GoodPass123 | GoodPass123     | 01012000 | Test Wishlist   | Item 1      | Item 2    |
      | Test      | Testik     | test@test.com      | qweqwe123   | qweqwe123       | 11112011 | Test Wishlist   | Item 1      | Item 2    |
