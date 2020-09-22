Feature: User login on Rotten Tomatoes
  I as rotten tomatoes user
  Want to login on the movies web page
  To verify my account

  Scenario Outline: Login to Rotten Tomatoes
    Given The user enters the Rotten Tomatoes web page
    When The user logins with "<username>" and "<password>"
    Then The user should enter the account

    Examples: 
      | username                     | password    |
      | exercise1.10pearls@gmail.com | rottenpass1 |
      | test                         | rottenpass1 |
      | exercise1.10pearls@gmail.com | .           |
