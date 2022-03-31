
@tag
Feature: Starting the game

	@tag1
	Scenario: Successful start of the game

		Given difficulty level is "Easy"
		And players set their names to "Water" and "Fire"
		When game is started
		Then board is initialized	 
	




