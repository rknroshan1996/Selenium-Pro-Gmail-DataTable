Feature: Compose
@tag
Scenario: validate mail sent
Given launch site using "chrome"
When enter "kumarnayakroshan305" as userid
And click uid next
And enter "xxxxxxxxxxxxxxx" as password
And click pwd next
Then validate compose operation
|            To                     |         Subject       |      Body      |
|     kumarnayakroshan305@gmail.com |         hiii          |      hloo bro  | 
|     xxxxxxxxxxxxxxxxxxxxxxxxxx    |         hlooopp       |      gud night |
When close site
