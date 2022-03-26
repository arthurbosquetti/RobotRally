

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setUp.Board;
import setUp.Card;
import setUp.Game;
import setUp.Level;
import setUp.Player;
import setUp.Robot;
import setUp.Tiles.Tile;
import setUp.Tiles.FlagTile;

public class StepsDefinition {


	Level level 	= new Level();
	Player player1 	= new Player();
	Player player2  = new Player();
	Game game		= new Game();
	Board board;
	Card[] availableCards;
	Card[] chosenCards;
	Tile tile;
	FlagTile flag1 = new FlagTile(1);
	FlagTile flag2 = new FlagTile(2);
	Robot robot = new Robot("test");

	
////// GAME START //////////

	//Scenario: Successful start of the game
	@Given("difficulty level is {int}")
	public void difficulty_level_is(Integer int1) {
	    level.setLevel(int1);
	    board = new Board(level.getLevel());
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
	@Given("{int} possible movement cards")
	public void possible_movement_cards(Integer int1) {
		availableCards=new Card[int1];
	}
	@Given("P1’s turn")
	public void p1_s_turn() {
	    player1.setTurn(true);
	}
	@When("P1 chooses {int} cards")
	public void p1_chooses_cards(Integer int1) {
	    chosenCards = new Card[int1];
		player1.setHand(chosenCards, player2);
	}
	@Then("P2’s turn")
	public void p2_s_turn() {
	    assertTrue(player2.getTurn());
	}

	//Scenario: Unsuccessful Turn
	@Then("Not P2’s turn")
	public void not_p2_s_turn() {
		assertFalse(player2.getTurn());
	}

////// FLAGS ////////// 
	

	//Scenario: Robot reaches flag first time
	@Given("the robot has not already reached the first flag")
	public void the_robot_has_not_already_reached_on_the_first_flag() {
		robot.setFlag1(false);
	}

	@When("the robot reaches the first flag")
	public void the_robot_reaches_the_first_flag() {
		robot.setFlag1(true);
	}

	@Then("the robot is marked with one flag")
	public void mark_flag1() {
		assertTrue(robot.getFlag1());
	}
	
	
	//Scenario: Robot reaches the second flag before the first
	@Given("the robot has already reached the first flag")
	public void the_robot_has_already_reached_the_first_flag() {
		robot.setFlag1(true);
	}

	@Then("no change")
	public void no_change() {
		assertTrue(robot.getFlag1());
	}
	
	//Scenario: Robot reaches the second flag before the first
	@Given("the robot has not already stepped on the first flag")
	public void the_robot_has_not_already_stepped_on_the_first_flag() {
		robot.setFlag1(false);
	}

	@When("the robot reaches the second flag")
	public void the_robot_reaches_the_second_flag() {
		robot.interact(flag2);
	}

	@Then("nothing happens")
	public void nothing_happens() {
		assertFalse(robot.getFlag2());
	}

	 //Scenario: Robot wins
	@When("the robot steps on the second flag")
	public void the_robot_steps_on_the_second_flag1() {
	    assertEquals(true,Tile.secondFlagReached());
	}
	@Then("the robot has won")
	public void the_robot_has_won() {
		assertEquals(false, game.getGameStatus());
	}
	
////// OBSTACLES //////////
	
	//Scenario: Robot hits a stopping obstacle
	@Given("a stopping obstacle on the board in front of the robot")
	public void a_stopping_obstacle_on_the_board_in_front_of_the_robot() {
		robot.setNext(stoppingTile); next move is based on current 
	}
	@When("the robot hits the obstacle")
	public void the_robot_hits_the_obstacle() {
	    robot.interact(stoppingTile);
		robot.move();
	}

	@Then("the robot cannot move into the obstacle")
	public void the_robot_cannot_move_into_the_obstacle() {
	    assertEquals(robot.previous(), robot.current());
	     doesn't move, idk how to implement that
	     assertFalse(robot.checkValid());
	}
	
	
	 //Scenario: Robot 1 hits a damaging obstacle and survives
	@Given("a damaging obstacle on the board in front of the robot")
	public void a_damaging_obstacle_on_the_board_in_front_of_the_robot() {
	    robot.setNext(damageTile);
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
	    assertEquals(robot.getTile(), startingTile1);
	}

	 //Scenario: Robot hits a damaging obstacle and dies!
    @Given("one life left")
    public void one_life_left() {
        robot.setLives(1);
    }
    @Then("is out of the game")
    public void is_out_of_the_game() {
        assertFalse(robot.alive());
    }
}
