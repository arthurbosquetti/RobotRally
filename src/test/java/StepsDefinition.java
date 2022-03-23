import static org.junit.Assert.*;

import java.util.Random;

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
	Player player2	= new Player();
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
}
