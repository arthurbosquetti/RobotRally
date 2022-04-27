@tag
Feature: Choosing 5 cards to be played
	@tag1
  	Scenario: Successful turn
		Given possible movement cards
		And P1s turn
		When P1 chooses 5 cards
		And Hand is not empty
		Then P2s turn

	@tag2
	Scenario: Moving forward
		Given difficulty level is "Medium"
		And P1 chooses card "F1"
		And P1 chooses 5 cards
		When the card is executed
		Then Robot moves forward

	@tag3
	Scenario: Turning left
		Given difficulty level is "Easy"
		And P1 chooses card "L"
		And P1 chooses 5 cards
		When the card is executed
		And Robot is facing north
		And Robot rotates left
		Then Robot is facing west

	@tag4
	Scenario: Turning right
		Given difficulty level is "Easy"
		And P1 chooses card "R"
		And P1 chooses 5 cards
		When the card is executed
		And Robot is facing north
		And Robot rotates right
		Then Robot is facing east

	@tag5
	Scenario: Successful jump
		Given difficulty level is "Easy"
		And P1 chooses card "J"
		And P1 chooses 5 cards
		When the card is executed
		And Robot is facing north
		And the tile in front is not a Tall tile
		And Robot jumps
		Then Robot lands in front of Tall tile

	@tag6
	Scenario: Unsuccessful jump
		Given difficulty level is "Easy"
		And P1 chooses card "J"
		And P1 chooses 5 cards
		When the card is executed
		And the tile in front is a Tall tile
		Then Robot does not jump