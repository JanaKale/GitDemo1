Feature: myntra site test

Background:
Given url लाँच करा
#@smoke
Scenario: verify Polo Search Result
When enter polo in search box
And press enter
Then resulting products should contain polo brand

 