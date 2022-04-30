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
        Given difficulty level is "Medium"
        And a damaging obstacle on the board in front of the robot
        And two or more lives left
        When the robot hits the obstacle
        Then the robot loses a life
        And the robot is moved to the starting position

    @tag3
    Scenario: Robot hits a damaging obstacle and dies!
        Given difficulty level is "Hard"
        And a damaging obstacle on the board in front of the robot
        And one life left
        When the robot hits the obstacle
        Then the robot has no lives
        And is out of the game

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
    Scenario: Robot hits a conveyor obstacle
        Given difficulty level is "Easy"
        And a conveyor obstacle on the board in front of the robot
        When the robot hits the obstacle
        Then the robot is moved in the right direction
        