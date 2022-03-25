@tag
Feature: Flags

    @tag1
    Scenario: Robot reaches flag first time
        Given a movement executed by a robot
        And the first flag on the board in front of the robot
        And the robot has not already reached the first flag
        When the robot reaches the first flag
        Then the robot is marked with one flag

    @tag2
    Scenario: Robot reaches the first flag again
        Given a movement executed by a robot
        And the first flag on the board in front of the robot
        And the robot has already reached the first flag
        When the robot reaches the first flag
        Then nothing happens


	 @tag3
	 Scenario: Robot reaches the second flag before the first
				Given a movement executed by a robot
				And the robot steps on the second flag 
				And the robot has not already stepped on the first flag
				When the robot reaches the second flag
				Then nothing happens
				
	@tag4
	Scenario: Robot wins
				Given a movement executed by a robot
				And the robot steps on the second flag
				And the robot has already reached the first flag
				When the robot reaches the second flag
				Then the robot has won 
	 

