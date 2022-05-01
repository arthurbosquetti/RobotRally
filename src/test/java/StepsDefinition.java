import controller.Game;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.*;
import model.tiles.*;
import model.tiles.ConveyorTile;
import model.tiles.FlagTile;
import model.tiles.GlueTile;
import model.tiles.MineTile;
import model.tiles.PitTile;
import model.tiles.TallTile;
import model.tiles.TeleportTile;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class StepsDefinition {
	
	Game game		 = new Game();
	Board board      = new Board();
	Movement mov	 = new Movement(board);
	Deck deck      	 = new Deck();
	FlagTile flag1 	 = new FlagTile(1);
	FlagTile flag2   = new FlagTile(2);
	Robot robot		 = new Robot("test", 9, game, board);
	Robot robot2	 = new Robot("test2", 9, game, board);
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
	    robot.setName(name1);
	    robot2.setName(name2);
	}
	@When("game is started")
	public void game_is_started() {
	    //game.setGameStatus(true);
		game.gameStart(level.getLevel(), robot.getName(), robot2.getName());
	}
	@Then("board is initialized")
	public void board_is_initialized() {
		assertNotNull(board);
	}
	
	//Scenario: Successful start of the AI game
	@And ("players are both AI")
	public void player_are_both_AI() {
		game.setP1AI(true);
		game.setP2AI(true);
	}

////// CARD CHOICE //////////
	
	//Scenario: Successful Turn
	@Given("possible movement cards")
	public void possible_movement_cards() {
		deck.newHand();
	}
	@Given("P1s turn")
	public void p1_s_turn() {
	    deck.newHand();
	}
	@When("P1 chooses {int} cards")
	public void p1_chooses_cards(Integer int1) {
		ArrayList<Card> hand = deck.getHand();
	    deck.setChoosenCards(hand);
	}
	@And("Hand is not empty")
	public void hand_is_not_empty() {
		assertNotNull(deck.getHand());
	}
	@And("there are 5 cards chosen")
	public void five_cards_in_hand() {
		assertNotNull(deck.getChoosen());
	}
	@Then("P1 is done choosing")
	public void p1_done_choosing() {
	    assertFalse(deck.canChoose());
	}

	//Scenario: Moving forward
	@And("Robot spawned")
	public void robotSpawned() {
		robot.setX(3);
		robot.setY(3);
	}
	@And("the tiles in front are empty tiles")
	public void theTilesInFrontAreEmptyTiles() {
		board.setTile(3,2,new EmptyTile());
		board.setTile(3,1,new EmptyTile());
		board.setTile(3,0,new EmptyTile());
	}
	@Given("P1 chooses card {string}")
	public void p1_chooses_card(String action) {
		this.card1 = new Card(action);
	}
	@When("the card is executed")
	public void the_card_is_executed() {
	    card1.executeAction(robot, mov);
	}
	@Then("Robot moves forward {int} tiles")
	public void robotMovesForwardCells(int arg0) {
	    assertEquals(arg0, card1.get_MovingCard().get_MovedForward());
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
	    assertEquals("west",robot.getDir().getDirection());
	}

	//Scenario: Turning right
	@And("Robot is facing east")
	public void robotIsFacingEast() {
		robot.setDir(new Direction(90));
	}
	
	@Then("Robot rotates right")
	public void robotRotatesRight() {
		robot.getDir().turnRight();
	}
	@Then("Robot is facing south")
	public void robotIsFacingSouth() {
		assertEquals("south",robot.getDir().getDirection());
	}

	//Scenario: Successful jump
	@And("the tile in front is not a Tall tile")
	public void theTileInFrontIsNotATallTile() {
		board.setTile(3, 2, new GlueTile());
	}
	@Then("Robot jumps")
	public void robotLands2TilesAway() {
		assertEquals(2,card1.get_MovingCard().get_MovedForward());
	}


////OBSTACLES //////////

	//Scenario: Robot hits a stopping obstacle
	@Given("a stopping obstacle on the board in front of the robot")
	public void a_stopping_obstacle_on_the_board_in_front_of_the_robot() {
		board.setTile(2, 2, new TallTile());
		robot.setDir(new Direction(0));
		robot.setX(2);
		robot.setY(3);
	}

	@When("the robot hits the obstacle")
	public void the_robot_hits_the_obstacle() {
		mov.makeMove(robot, true, 1, false);
	}

	@Then("the robot cannot move into the obstacle")
	public void the_robot_cannot_move_into_the_obstacle() {
	    assertFalse(mov.makeMove(robot, true, 1, false));
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

   @Then("the robot dies")
   public void the_robot_dies() {
       assertFalse(robot.isAlive());
   }

	//Scenario: Unsuccessful jump
	@And("the tile in front is a Tall tile")
	public void theTileInFrontIsATallTile() {
		board.setTile(3,3, new TallTile());
	}
	@Then("Robot does not jump")
	public void robotDoesNotJump() {
		assertFalse(mov.makeMove(robot,true,2,true));
	}

	//Scenario: Robot hits a conveyor obstacle
	@Given("a conveyor obstacle on the board in front of the robot")
	public void a_conveyor_obstacle_on_the_board_in_front_of_the_robot() {
		board.setTile(2, 2, new ConveyorTile(new Direction(90)));
		robot.setX(2);
		robot.setY(3);
	}
	@Then("the robot is moved in the right direction")
	public void the_robot_is_moved_in_the_right_direction() {
	    assertEquals(90, robot.getDir().getDirectionInt());
	    assertEquals(3, robot.getX());
	    assertEquals(2, robot.getY());
	}

	//Scenario: Robot steps on a a glue obstacle
	@Given("a glue obstacle on the board in front of the robot")
	public void a_glue_obstacle_on_the_board_in_front_of_the_robot() {
		board.setTile(2, 2, new GlueTile());
		robot.setX(2);
		robot.setY(3);
	}
		
	@Then("the robot cannot move for the rest of the turn")
	public void the_robot_cannot_move_for_the_rest_of_the_turn() {
		assertFalse(robot.canMove());
	}
	
	
	//Scenario: Robot steps on a a teleport obstacle
	@Given("a teleport obstacle on the board in front of the robot")
	public void a_teleport_obstacle_on_the_board_in_front_of_the_robot() {
		board.setTile(2, 2, new TeleportTile());
		robot.setX(2);
		robot.setY(3);
	}
		
	@And("another teleport obstacle on the board")
	public void another_teleport_obstacle_on_the_board() {
		board.setTile(4, 4, new TeleportTile());
	}
	
	@Then("the robot is moved to the other teleport tile")
	public void the_robot_is_moved_to_the_other_teleport_tile() {
		assertEquals(4, robot.getX());
		assertEquals(4, robot.getY());
	}
	
	//Scenario: Robot hits a mine obstacle and both die!
		@Given("a mine obstacle on the board in front of the robot")
		public void a_mine_obstacle_on_the_board_in_front_of_the_robot() {
			board.setTile(2, 2, new MineTile());
			robot.setX(2);
			robot.setY(3);
		}
		
		@And("robot2 is in the area of the mine")
		public void robot2_is_in_the_area_of_the_mine() {
			robot2.setX(3);
			robot2.setY(3);
		}
	
		@And("both robots have one life left")
		public void both_robots_have_one_life_left() {
			robot.setLives(1);
			robot2.setLives(1);
		}
		
		@Then("both robots die")
		public void both_robots_die() {
			System.out.println(robot.getLives());
			assertFalse(robot.isAlive());
			assertFalse(robot2.isAlive());
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
		assertTrue(robot.getWinner());
	}

	@And("the game ends")
	public void the_game_ends() {
		assertFalse(game.getGameStatus());
	}

}


