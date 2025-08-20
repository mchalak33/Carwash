Feature: Validate search functionality on Justdial homepage
 
  Scenario Outline: Search with different inputs and verify system response
    Given the user launches a browser
    And navigates to the Justdial homepage
    When the user clicks "Maybe Later" if a popup appears
    And handles any additional permission or alert popups
    And the user enters "<searchInput>" in the search box
    And clicks the "Search" button
    Then the user should see "<expectedMessage>"

    Examples:
      | searchInput           | expectedMessage                                  |
      |                       | Please enter category / company name for search. |
      | @#$%^&*               | Please enter category / company name for search. |
      | Car Washing Services  | Listings for Car Washing Services shown          |

 