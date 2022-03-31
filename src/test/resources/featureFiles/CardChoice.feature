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
	Given P1 chooses card "L"
	And P1 chooses 5 cards
	When the card is executed
	And Robot rotates left

