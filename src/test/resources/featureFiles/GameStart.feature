
@tag
Feature: Starting the game

	@tag1
	Scenario: Successful start of the game

		Given difficulty level is 2
		And players set their names to "Water" and "Fire"
		When game is started
		Then board is initialized	 
	
	@tag2
	Scenario: Unsuccessful start of the game

		Given difficulty level is 4
		And players set their names to "Water" and "Fire"
		When game is started
		Then board is not initialized	 




