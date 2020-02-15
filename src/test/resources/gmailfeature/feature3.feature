Feature: Compose
@tag
Scenario: validate mail sent
Given launch site using "chrome"
When enter "kumarnayakroshan305" as userid
And click uid next
And enter "rknroshan@123#1996" as password
And click pwd next
Then validate compose operation
|            To                     |         Subject       |      Body      |
|     kumarnayakroshan305@gmail.com |         hiii          |      hloo bro  | 
|     bikashdjmajhi185@gmail.com    |         hlooopp       |      gud night |
When close site