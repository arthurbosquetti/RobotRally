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
		And Robot spawned
		And the tiles in front are empty tiles
		And P1 chooses card "F1"
		And P1 chooses 5 cards
		When the card is executed
		Then Robot moves forward 1 tiles

	@tag6
	Scenario: Moving forward
		Given difficulty level is "Medium"
		And Robot spawned
		And the tiles in front are empty tiles
		And P1 chooses card "F2"
		And P1 chooses 5 cards
		When the card is executed
		Then Robot moves forward 2 tiles

	@tag7
	Scenario: Moving forward
		Given difficulty level is "Medium"
		And Robot spawned
		And the tiles in front are empty tiles
		And P1 chooses card "F3"
		And P1 chooses 5 cards
		When the card is executed
		Then Robot moves forward 3 tiles

	@tag8
	Scenario: Moving forward
		Given difficulty level is "Medium"
		And Robot spawned
		And P1 chooses card "B"
		And P1 chooses 5 cards
		When the card is executed
		Then Robot moves forward -1 tiles

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
		And Robot is facing east
		And Robot rotates right
		Then Robot is facing south

	@tag5
	Scenario: Successful jump
		Given difficulty level is "Hard"
		And Robot spawned
		And Robot is facing north
		And the tile in front is not a Tall tile
		And P1 chooses card "J"
		And P1 chooses 5 cards
		When the card is executed
		Then Robot jumps
