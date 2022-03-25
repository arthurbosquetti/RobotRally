

@tag
Feature: Choosing 5 cards to be played

	@tag1
	Scenario: Successful turn

		Given 9 possible movement cards
		And P1’s turn
#		When P1 chooses 5 cards
		And P1’s hand is saved
		Then P2’s turn

