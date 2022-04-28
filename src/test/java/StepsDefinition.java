import controller.Game;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.*;
import model.tiles.FlagTile;
import model.tiles.GlueTile;
import model.tiles.PitTile;
import model.tiles.TallTile;

import static org.junit.Assert.*;

public class StepsDefinition {
	
	Game game		 = new Game();
	Player player1 	 = new Player("test1", 9);
	Player player2   = new Player("test2", 9);
	Board board      = new Board();
	Deck deck      	 = new Deck();
	FlagTile flag1 	 = new FlagTile(1);
	FlagTile flag2   = new FlagTile(2);
	Robot robot		 = new Robot("test", 9, game);
	Level level;
	Card[] availableCards;
	Card[] chosenCards;
	Card card1;

	
////// GAME START //////////

	//Scenario: Successful start of the game
	@Given("difficulty level is {string}")
	public void difficulty_level_is(String str) {
		this.level = new Level(str, board);
	}

	@Given("players set their names to {string} and {string}")
	public void players_set_name(String name1, String name2) {
	    player1.setName(name1);
	    player2.setName(name2);
	}
	@When("game is started")
	public void game_is_started() {
	    game.setGameStatus(true);
	}
	@Then("board is initialized")
	public void board_is_initialized() {
		assertNotNull(board);
	}

////// CARD CHOICE //////////
	
	//Scenario: Successful Turn
	@Given("possible movement cards")
	public void possible_movement_cards() {
		deck.newHand();
	}
	@Given("P1s turn")
	public void p1_s_turn() {
	    player1.setTurn(true);
	}
	@When("P1 chooses {int} cards")
	public void p1_chooses_cards(Integer int1) {
	    chosenCards = new Card[int1];
		player1.checkHand(chosenCards, player2);
	}
	@And("Hand is not empty")
	public void hand_is_not_empty() {
		assertNotNull(robot.getDeck().getHand());
		player2.setTurn(true);
	}
	@Then("P2s turn")
	public void p2_s_turn() {
	    assertTrue(player2.getTurn());
	}

	//Scenario: Moving forward
	@Given("P1 chooses card {string}")
	public void p1_chooses_card(String action) {
		this.card1 = new Card(action);
	}
	@When("the card is executed")
	public void the_card_is_executed() {
	    card1.executeAction(robot, board);
	}
	@Then("Robot moves forward")
	public void robot_moves_forward() {
	    assertEquals(1, card1.get_MovingCard().get_MovedForward());
	}

	//Scenario: Turning left
	@And("Robot is facing north")
	public void robotIsFacingNorth() {
		robot.setDir(new Direction(0));
	}
	@Then("Robot rotates left")
	public void robot_rotates_left() {
		robot.getDir().turnLeft();
	}
	@Then("Robot is facing west")
	public void robotIsFacingWest() {
	    assertTrue(robot.getDir().getRotatedLeft());
	}

	//Scenario: Turning right
	@Then("Robot rotates right")
	public void robotRotatesRight() {
		robot.getDir().turnRight();
	}
	@Then("Robot is facing east")
	public void robotIsFacingEast() {
		assertTrue(robot.getDir().getRotatedRight());
	}

	//Scenario: Successful jump
	@And("the tile in front is not a Tall tile")
	public void theTileInFrontIsNotATallTile() {
		board.setTile(3, 3, new GlueTile());
	}
	@Then("Robot jumps")
	public void robotJumps() {
		robot.setX(3);
		robot.setY(2);
		board.makeMove(robot,true,2,true);
	}
	@Then("Robot lands 2 tiles away")
	public void robotLands2TilesAway() {
		assertNotNull(board.getTile(3,0).getRobotOn());
	}


////OBSTACLES //////////

	//Scenario: Robot hits a stopping obstacle
	@Given("a stopping obstacle on the board in front of the robot")
	public void a_stopping_obstacle_on_the_board_in_front_of_the_robot() {
		board.setTile(2, 2, new TallTile());
		robot.setX(2);
		robot.setY(3);
	}

	@When("the robot hits the obstacle")
	public void the_robot_hits_the_obstacle() {
		board.makeMove(robot, true, 1, false);
	}

	@Then("the robot cannot move into the obstacle")
	public void the_robot_cannot_move_into_the_obstacle() {
	    assertFalse(board.makeMove(robot, true, 1, false));
	}

	 //Scenario: Robot 1 hits a damaging obstacle and survives
	@Given("a damaging obstacle on the board in front of the robot")
	public void a_damaging_obstacle_on_the_board_in_front_of_the_robot() {
		board.setTile(2, 2, new PitTile());
		robot.setX(2);
		robot.setY(3);
	}

	@Given("two or more lives left")
	public void two_or_more_lives_left() {
	    robot.setLives(4);
	}

	@Then("the robot loses a life")
	public void the_robot_loses_a_life() {
	    assertEquals(robot.getLives(), 3);
	}
	@Then("the robot is moved to the starting position")
	public void the_robot_is_moved_to_the_starting_position() {
	    int[] spawnPoint = robot.getSpawn();
		assertEquals(robot.getX(), spawnPoint[0]);
		assertEquals(robot.getY(), spawnPoint[1]);
	}

	 //Scenario: Robot hits a damaging obstacle and dies!
   @Given("one life left")
   public void one_life_left() {
       robot.setLives(1);
   }

	@Then("the robot has no lives")
	public void robot_has_no_lives() {
		assertEquals(robot.getLives(), 0);
	}

   @Then("is out of the game")
   public void is_out_of_the_game() {
       assertFalse(robot.isAlive());
   }

	//Scenario: Unsuccessful jump
	@And("the tile in front is a Tall tile")
	public void theTileInFrontIsATallTile() {
		board.setTile(3,3, new TallTile());
	}
	@Then("Robot does not jump")
	public void robotDoesNotJump() {
		assertFalse(board.makeMove(robot,true,2,true));
	}



////// FLAGS //////////
	//Scenario: Robot reaches flag first time
	@Given("the first flag on the board in front of the robot")
	public void theFirstFlagOnTheBoardInFrontOfTheRobot() {
		robot.nextTile(flag1);
	}

	@And("the robot has not already reached the first flag")
	public void the_robot_has_not_already_reached_the_first_flag() {
		robot.setFlag1(false);
	}

	@When("a movement is executed by a robot")
	public void aMovementExecutedByARobot() {
		robot.move();
	}

	@Then("the robot collects the first flag")
	public void mark_flag1() {
		assertTrue(robot.getFlag1());
	}


	//Scenario: Robot reaches the first flag again
	@And("the second flag on the board in front of the robot")
	public void theSecondFlagOnTheBoardInFrontOfTheRobot() {
		robot.nextTile(flag2);
	}
	@Given("the robot has already reached the first flag")
	public void the_robot_has_already_reached_the_first_flag() {
		robot.setFlag1(true);
	}

	@Then("robot does not collect the first flag")
	public void robot_does_not_collect_first_flag() {
		assertTrue(robot.getFlag1());
	}


	//Scenario: Robot reaches the second flag before the first
	@Then("robot does not collect the second flag")
	public void robot_does_not_collect_second_flag() {
		assertFalse(robot.getFlag2());
	}

	 //Scenario: Robot wins
	@Then("the robot has won")
	public void the_robot_has_won() {
		assertFalse(game.getGameStatus());
	}
}


