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

public class StepsDefinition {

	Level level 	= new Level();
	Player player1 	= new Player();
	Player player2 = new Player();
	Game game		= new Game();
	Board board;

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

	@Given("the robot steps on the second flag")
	public void the_robot_steps_on_the_second_flag() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("the robot has not already stepped on the first flag")
	public void the_robot_has_not_already_stepped_on_the_first_flag() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the robot reaches the second flag")
	public void the_robot_reaches_the_second_flag() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("nothing happens")
	public void nothing_happens() {
	    assertEquals(false, game.getGameStatus());
	}

////// OBSTACLES //////////

	@Given("a movement executed by a robot")
	public void a_movement_executed_by_a_robot() {
		throw new io.cucumber.java.PendingException();
	}
	@Given("a stopping obstacle on the board in front of the robot")
	public void a_stopping_obstacle_on_the_board_in_front_of_the_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the robot hits the obstacle")
	public void the_robot_hits_the_obstacle() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
