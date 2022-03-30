@tag
Feature: Choosing 5 cards to be played
	@tag1
  	Scenario: Successful turn
		Given 9 possible movement cards
		And P1’s turn
		When P1 chooses 5 cards
		Then P2’s turn

	@tag2
	Scenario: Unsuccessful Turn
		Given 9 possible movement cards
		And P1’s turn
		When P1 chooses 3 cards
		Then P1 hand empty
		Then P2’s turn