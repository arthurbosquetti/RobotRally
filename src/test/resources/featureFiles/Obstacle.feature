@tag
Feature: Obstaclewar
    
    @tag1
    Scenario: Robot hits a stopping obstacle
        Given difficulty level is "Easy"
        And a stopping obstacle on the board in front of the robot
        When the robot hits the obstacle
        Then the robot cannot move into the obstacle

    @tag2
    Scenario: Robot hits a damaging obstacle and survives
        Given difficulty level is "Easy"
        And a damaging obstacle on the board in front of the robot
        And two or more lives left
        When the robot hits the obstacle
        Then the robot loses a life
        And the robot is moved to the starting position

    @tag3
    Scenario: Robot hits a damaging obstacle and dies!
        Given difficulty level is "Easy"
        And a damaging obstacle on the board in front of the robot
        And one life left
        When the robot hits the obstacle
        Then the robot has no lives
        And the robot dies

    @tag4
    Scenario: Robot attempts to jump over a Tall obstacle
        Given difficulty level is "Easy"
        And P1 chooses card "J"
        And P1 chooses 5 cards
        And a stopping obstacle on the board in front of the robot
        When the card is executed
        And the tile in front is a Tall tile
        Then Robot does not jump
        
    @tag5
    Scenario: Robot hits a conveyor obsticle
        Given difficulty level is "Easy"
        And a conveyor obstacle on the board in front of the robot
        When the robot hits the obstacle
        Then the robot is moved in the right direction
        
     @tag6   
     Scenario: Robot steps on a a glue obstacle
     			Given difficulty level is "Easy"
					And a glue obstacle on the board in front of the robot
					When the robot hits the obstacle
					Then the robot cannot move for the rest of the turn

		@tag7
			Scenario: Robot steps on a teleport obstacle
					Given difficulty level is "Easy"
					And a teleport obstacle on the board in front of the robot
					And another teleport obstacle on the board
					When the robot hits the obstacle
					Then the robot is moved to the other teleport tile
					
					
		@tag8
			Scenario: Robot hits a mine obstacle and both die!
					Given difficulty level is "Easy"
					And a mine obstacle on the board in front of the robot
					And robot2 is in the area of the mine
					And both robots have one life left
					When the robot hits the obstacle
					Then both robots die
		        
        