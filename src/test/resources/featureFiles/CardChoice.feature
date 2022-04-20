@tag
Feature: Choosing 5 cards to be played
	@tag1
  	Scenario: Successful turn
		Given possible movement cards
		And P1s turn
		When P1 chooses 5 cards
		Then P2s turn
		And Hand is not empty
		
	@tag2 
	Scenario: Turning left
	Given difficulty level is "Easy"
	And P1 chooses card "L"
	And P1 chooses 5 cards
	When the card is executed
	Then Robot rotates left
	
	@tag3
	Scenario: Moving forward
	Given difficulty level is "Medium"
	When P1 chooses card "F1"
	And P1 chooses 5 cards
	Then the card is executed
	And Robot moves forward
	


