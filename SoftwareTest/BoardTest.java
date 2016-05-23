package SoftwareTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;
	@Before
	public void initialize(){
		board = new Board();
	}
	
	@Test
	public void leeresBoard_keinGewinner() {
		//board.hasWinner();
		assertFalse(board.hasWinner());
	}
	
	@Test
	public void gueltigeMarkierung_keinGewinner() throws Throwable{
		board.setMark("X", 0, 0);
		assertFalse(board.hasWinner());
	}
	
	@Test
	public void gueltigeMarkierung_mitGewinner() throws Throwable{
		board.setMark("X", 0, 0);
		board.setMark("X", 0, 1);
		board.setMark("X", 0, 2);
		assertTrue(board.hasWinner());
	}
	
	@Test (expected = Exception.class)
	public void ungueltigeMarkierung() throws Throwable{
		board.setMark("X", 0, 3);
	}

}
