
@tag
Feature: Starting the game

	@tag1
	Scenario: Successful start of the game
		Given difficulty level is 2
		And players set their names to "player1" and "player2"
		When game is started
		Then board is initialized



