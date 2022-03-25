Feature: Obstacle

    @tag1
        Scenario: Robot hits a stopping obstacle
        Given a movement executed by a robot
        And a stopping obstacle on the board in front of the robot
        When the robot hits the obstacle
        Then the robot cannot move into the obstacle

    @tag2
        Scenario: Robot hits a damaging obstacle and survives
        Given a movement executed by a robot
        And a damaging obstacle on the board in front of the robot
        And two or more lives left
        When the robot hits the obstacle
        Then the robot loses a life
        And the robot is moved to the starting position

    @tag3
        Scenario: Robot hits a damaging obstacle and dies!
        Given a movement executed by a robot
        And a damaging obstacle on the board in front of the robot
        And one life left
        When the robot hits the obstacle
        Then the robot loses a life
        And is out of the game