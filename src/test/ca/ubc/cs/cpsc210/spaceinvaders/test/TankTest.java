package ca.ubc.cs.cpsc210.spaceinvaders.test;

import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cs.cpsc210.spaceinvaders.model.SuperiorTank;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Tank class.
 */
public class TankTest {
	private static final int XLOC = SIGame.WIDTH / 2;
	private SuperiorTank tank;
	private SuperiorTank tank2;
	
	@BeforeEach
	public void runBefore() {
		tank = new SuperiorTank(XLOC);
		tank2 = new SuperiorTank(2*XLOC - 1);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(XLOC, tank.getX());
		assertEquals(SIGame.HEIGHT *2/3, tank.getY());
		assertEquals(Tank.LEFT, tank.getDirection());
		tank.move();
		assertEquals(XLOC - tank.getSpeed(), tank.getX());
		tank.faceRight();
		tank.move();
		assertEquals(XLOC, tank.getX());
		tank.faceUp();
		tank.move();
		assertEquals(SIGame.HEIGHT *2/3 - tank.getSpeed(), tank.getY());
		tank.faceDown();
		tank.move();
		assertEquals(SIGame.HEIGHT *2/3, tank.getY());
		int current_speed = tank.getSpeed();
		tank.tankSpeedIncrement();
		assertEquals(current_speed + 1, tank.getSpeed());
	}

	@Test
    public void testHandleBoundary()
    {
        tank2.faceRight();
        assertEquals(true, tank2.isFacingRight());
        tank2.move();
        assertEquals(0, tank2.getX());
        tank2.faceLeft();
        tank2.move();
        assertEquals(SIGame.WIDTH, tank2.getX());
        tank2.faceDown();
        for (int i = 0; i < 201; i++) {
            tank2.tankSpeedIncrement();
        }
        tank2.move();
        assertEquals(0, tank2.getY());
        tank2.faceUp();
        tank2.move();
        assertEquals(SIGame.HEIGHT, tank2.getY());
    }
}
