Feature: Login
Scenario: validate title
Given launch site using "chrome"
Then title should be "Gmail"
When close site