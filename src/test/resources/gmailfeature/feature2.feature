Feature: Login
Scenario Outline: validate uid field
Given launch site using "<bn>"
When enter "<u>" as userid
And click uid next
Then validate output for "<uc>" as uid criteria
When close site
Examples: 
|     bn     |             u              |       uc      |
|   Chrome   |      kumarnayakroshan305   |     valid     |
|   Chrome   |      kumarnayakroshan323f  |    invalid    |
|   Chrome   |                            |     blank     |

Scenario Outline: validate pwd field
Given launch site using "<bn>"
When enter "kumarnayakroshan305" as userid
And click uid next
And enter "<p>" as password
And click pwd next
Then validate output for "<pc>" as pwd criteria
When close site
Examples: 
|    bn      |            p               |       pc      |
|   Chrome   |      rknroshan@123#1996    |     valid     |
|   Chrome   |      rknawf34              |    invalid    |
|   Chrome   |                            |     blank     |
