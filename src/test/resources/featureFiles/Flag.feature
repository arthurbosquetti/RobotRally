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