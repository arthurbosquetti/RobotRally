
@tag
Feature: Starting the game

	@tag1
	Scenario: Successful start of the game
		Given The difficulty to be set to level 1
		And Player1 sets their name "A"
		And Player2 sets their name "B"
		When The game has started
		Then the screen should display the easy level board and two players 
