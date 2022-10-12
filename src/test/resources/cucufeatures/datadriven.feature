Feature: Data driven testing in cucumber

 Scenario Outline: data driven testing
 Given I have two numbers <num1> and <num2>
 When I add them 
 Then print if there addition is prime
 
 Examples:
   |num1|num2|
   |11|12|
   |5|6|
   |23|9|
   |13|7|
   
 Scenario Outline: data driven testing read data from excel
 Given I have <rownum>
 When I add them 
 Then print if there addition is prime
 
 Examples:
 |rownum|
 |1|
 |2|
 |3|
 |4|
 |5|
 
