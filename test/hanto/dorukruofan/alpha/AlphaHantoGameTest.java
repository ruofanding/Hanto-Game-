package hanto.dorukruofan.alpha;

import static org.junit.Assert.assertEquals;
import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPieceType;
import hanto.common.MoveResult;

import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>AlphaHantoGameTest</code> contains tests for the class
 * {@link <code>AlphaHantoGame</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 9/7/14 5:31 PM
 *
 * @author ruofan
 *
 * @version $Revision$
 */
public class AlphaHantoGameTest{
	
	HantoGame alphaGame;
	HantoPieceType butterfly;
	HantoCoordinate origin;
	HantoCoordinate point1, point2;
	boolean redNotFirst;
	
	@Before
	public void setUp() {
		alphaGame = new AlphaHantoGame();
		point1 = new HantoCoordinateGrid(0, 1);
		point2 = new HantoCoordinateGrid(1, 1);
		origin = new HantoCoordinateGrid(0, 0);
		redNotFirst = true;
		
	}
	
	@Test(expected = HantoException.class)
	public void coordinateCheck() throws HantoException{
		alphaGame.makeMove(butterfly, null, point1);
	}
	
	@Test
	public void blueFirst() throws HantoException {
		assertEquals(alphaGame.makeMove(butterfly, null, origin), MoveResult.OK);
		assertEquals(alphaGame.makeMove(butterfly, null, point1), MoveResult.DRAW);
	}
	
	@Test(expected = HantoException.class)
	public void twoPieceOnSameCoordinate() throws HantoException{
		alphaGame.makeMove(butterfly, null, origin);
		alphaGame.makeMove(butterfly, null, origin);
	}
	
	@Test(expected = HantoException.class)
	public void notAdjacentToOrigin() throws HantoException{
		alphaGame.makeMove(butterfly, null, origin);
		alphaGame.makeMove(butterfly, null, point2);
	}
}