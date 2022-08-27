Feature: parameterization in cucumber
Scenario: parameterization of numbers
    Given I have two numbers 5 and 6
    When I add them
    Then Print the result
    
# we can not parameterize char and boolean in cucumber

 Scenario: parameterization of strings
 Given I have a fruite "apple"
 Then Display its "red"
 
 Scenario: parameterization of lists
 Given I have following <states>
 |Maharashtra   |33|MH|
 |Gujrat        |31|GJ|
 |Andhrapradesh |28|AP|
 |Telangna      |29|TL|
 |Tamil Nadu    |30|TN|
 Then Display all states