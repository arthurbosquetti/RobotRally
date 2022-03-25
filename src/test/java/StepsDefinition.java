import static org.junit.Assert.*;

import java.util.Random;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setUp.Board;
import setUp.Card;
import setUp.Deck;
import setUp.Game;
import setUp.Level;
import setUp.Player;
import setUp.Tiles.Tile;

public class StepsDefinition {


	Level level 	= new Level();
	Player player1 	= new Player();
	Player player2  = new Player();
	Game game		= new Game();
	Board board;
	Card[] availableCards;
	Card[] chosenCards;
	Tile tile;

	
	/////////////////////////////////////////////////////////////////////////////
	/*
	 * USER STORY: As a player I want to start the game so that I can play
	 */
	
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
	
	
	/////////////////////////////////////////////////////////////////////////////
	/*
	 * USER STORY: As a player I want to choose my cards so that I can play the game
	 */
	
	//Scenario: Successful Turn
	@Given("{int} possible movement cards")
	public void possible_movement_cards(Integer int1) {
		availableCards=new Card[int1];
	}
	@Given("P's turn")
	public void p1_s_turn() {
	    player1.setTurn(true);
	}
	@When("P1 chooses {int} cards")
	public void p1_chooses_cards(Integer int1) {
	    chosenCards = new Card[int1];
		player1.setHand(chosenCards);
	}
	@When("P1's hand is saved")
	public void p1_s_hand_is_saved() {
		player1.setTurn(false);
	    player2.setTurn(true);
	}
	@Then("P2's turn")
	public void p2_s_turn() {
		assertFalse(player1.getTurn());
	    assertTrue(player2.getTurn());
	}
	
	
	
	
	
	
	// Margret: We somehow need to relate flags to players
	// Maybe we keep trach of the flags for the players
	// booleans setFlag1, getFlag1 in the Player class
	
	
//////FLAGS //////////
	
//Tag 1	
	
	
	@Given("the robot has not already reached the first flag")
	public void the_robot_has_not_already_reached_on_the_first_flag() {
		player1.setFlag1(false);
	}
	@When("the robot reaches the first flag")
	public void the_robot_reaches_the_first_flag() {
		assertEquals(true,Tile.firstFlagReached());
	}
	@Then("the robot is marked with one flag")
	public void mark_flag1() {
		assertTrue(player1.getFlag1());
	}
	
//Tag 2	
	
	@Given("the robot has already reached the first flag")
	public void the_robot_has_already_reached_on_the_first_flag() {
		player1.setFlag1(true);
	}
	@When("the robot reaches the first flag")
	public void the_robot_reaches_the_first_flag1() {
		assertEquals(true,Tile.firstFlagReached());
	}
	@Then("no change")
	public void no_change() {
		assertTrue(player1.getFlag1());
	}
	
//Tag 3

	@Given("the robot has not already stepped on the first flag")
	public void the_robot_has_not_already_stepped_on_the_first_flag() {
		// Margret: player1.setFlag1(false); don't know if this way makes sens but we'll figure it out
		assertEquals(false,Tile.firstFlagReached());
	}
	@When("the robot reaches the second flag")
	public void the_robot_reaches_the_second_flag() {
		assertEquals(true,Tile.secondFlagReached());
	}
	@Then("nothing happens")
	public void nothing_happens() {
		assertFalse(player1.getFlag2());
	}

// Tag 4
	@Given("the robot has already reached the first flag")
	public void the_robot_has_already_reached_the_first_flag() {
		assertEquals(true,Tile.firstFlagReached()); 
		// Margret: player1.setFlag1(true);
	}
	@When("the robot steps on the second flag")
	public void the_robot_steps_on_the_second_flag1() {
	    assertEquals(true,Tile.secondFlagReached());
	}
	@Then("the robot has won")
	public void the_robot_has_won() {
	    // Margret: false? since the game is now over
		assertEquals(true, game.getGameStatus());
	}
	
////// OBSTACLES //////////
	
//Tag 1

	@Given("a stopping obstacle on the board in front of the robot")
	public void a_stopping_obstacle_on_the_board_in_front_of_the_robot() {
	    tile.obstacleType("Stop");
	}
	@When("the robot hits the obstacle")
	public void the_robot_hits_the_obstacle() {
	    
	}
	@Then("the robot cannot move into the obstacle")
	public void the_robot_cannot_move_into_the_obstacle() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	@Given("a damaging obstacle on the board in front of the robot")
	public void a_damaging_obstacle_on_the_board_in_front_of_the_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("two or more lives left")
	public void two_or_more_lives_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot loses a life")
	public void the_robot_loses_a_life() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot is moved to the starting position")
	public void the_robot_is_moved_to_the_starting_position() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
