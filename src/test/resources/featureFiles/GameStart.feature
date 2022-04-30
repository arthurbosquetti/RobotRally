
@tag
Feature: Starting the game

	@tag1
	Scenario: Successful start of the game
		Given difficulty level is "Easy"
		And players set their names to "Water" and "Fire"
		When game is started
		Then board is initialized	 
	
	@tag2
	Scenario: Successful start of the game
		Given difficulty level is "Medium"
		And players set their names to "Water" and "Fire"
		When game is started
		Then board is initialized
		
	@tag3
	Scenario: Successful start of the AI game
		Given difficulty level is "Hard"
		And players set their names to "Water" and "Fire"
		And players are both AI
		When game is started
		Then board is initialized



