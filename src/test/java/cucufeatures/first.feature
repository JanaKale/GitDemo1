Feature: myntra site tests

Background:
Given url लाँच करा      

Scenario: verify Polo Search Result
When enter polo in search box
And press enter
Then resulting products should contain polo brand

Scenario: verify category list
And read expected category list from excel
And mouse over on men menu
When click on topwear link
And get list of all the categories present in topwear link
Then Expected and actual list should be same

Scenario: verify If SearchBy Popularity Yields Proper result
And mouse over on men menu
When user click on Tshirt
And click on sort by filter
And click on popularity filter