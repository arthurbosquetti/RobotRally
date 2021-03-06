@tag
Feature: Flags

    @tag1
    Scenario: Robot reaches flag first time
		Given the first flag on the board in front of the robot
		And the robot has not already reached the first flag
		When a movement is executed by a robot
		Then the robot collects the first flag

    @tag2
    Scenario: Robot reaches the first flag again
		Given the first flag on the board in front of the robot
		And the robot has already reached the first flag
		When a movement is executed by a robot
		Then robot does not collect the first flag

		@tag3
		Scenario: Robot reaches the second flag before the first
			Given the second flag on the board in front of the robot
			And the robot has not already reached the first flag
			When a movement is executed by a robot
			Then robot does not collect the second flag
					
		@tag4
		Scenario: Robot wins
			Given the second flag on the board in front of the robot
			And the robot has already reached the first flag
			When a movement is executed by a robot
			Then the robot has won
			And the game ends