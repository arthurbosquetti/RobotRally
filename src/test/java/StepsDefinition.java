import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setUp.Board;
import setUp.Game;
import setUp.Level;
import setUp.Player;

public class StepsDefinition {
	
	Level level = new Level();
	
	@Given("The difficulty to be set to level {int}")
	public void the_difficulty_to_be_set_to_level(Integer int1) {
	    level.setLevel(int1);
	}
	@Given("Player1 sets their name {string}")
	public void player1_sets_their_name(String string) {
	    Player player1 = new Player();
	    player1.setName(string);
	}
	@Given("Player2 sets their name {string}")
	public void player2_sets_their_name(String string) {
		Player player2 = new Player();
	    player2.setName(string);
	}
	@When("The game has started")
	public void the_game_has_started() {
		Game game = new Game();
		game.setGameStatus(true);	
	}
	@Then("the screen should display the easy level board and two players")
	public void the_screen_should_display_the_easy_level_board_and_two_players() {
	    Board board = new Board(level.getLevel());
	    board.printBoard();
	}
	
}
