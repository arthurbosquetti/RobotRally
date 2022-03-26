@tag
Feature: Flags

    @tag1
    Scenario: Robot reaches flag first time
		Given the first flag on the board in front of the robot
		And the robot has not already reached the first flag
		When a movement is executed by a robot
		Then the robot is marked with one flag

    @tag2
    Scenario: Robot reaches the first flag again
		Given the first flag on the board in front of the robot
		And the robot has already reached the first flag
		When a movement is executed by a robot
		Then nothing happens


	 @tag3
	 Scenario: Robot reaches the second flag before the first
		Given the second flag on the board in front of the robot
		And the robot has not already reached the first flag
		When a movement is executed by a robot
		Then nothing happens
				
	@tag4
	Scenario: Robot wins
		Given the second flag on the board in front of the robot
		And the robot has already reached the first flag
		When a movement is executed by a robot
		Then the robot has won