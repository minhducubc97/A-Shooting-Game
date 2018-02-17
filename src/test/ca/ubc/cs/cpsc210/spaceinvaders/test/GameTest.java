package ca.ubc.cs.cpsc210.spaceinvaders.test;


import ca.ubc.cs.cpsc210.spaceinvaders.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Game class.
 */
public class GameTest {

	private SIGame siGame;
	private Invader invader;
	
	@BeforeEach
	public void runBefore() {
		siGame = new SuperiorSIGame();
	}
	
	@Test
	public void testConstructor() {
		Tank t = siGame.getTank();
		assertEquals(SIGame.WIDTH / 2, t.getX());
		List<Invader> invaders = siGame.getInvaders();
		assertEquals(0, invaders.size());
		List<Missile> missiles = siGame.getMissiles();
		assertEquals(0, missiles.size());
		assertEquals(0, siGame.getNumMissiles());
		assertEquals(0, siGame.getNumInvadersDestroyed());
	}
	
	@Test
	public void testUpdate() {
		Tank t = siGame.getTank();
        siGame.keyPressed(KeyEvent.VK_RIGHT);
		assertEquals(SIGame.WIDTH / 2, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 + Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 + 2 * Tank.DX, t.getX());
		assertEquals(0, siGame.getMissiles().size());
	}
	
	@Test
	public void testNonKeyPadKeyEvent() {
		SuperiorTank t = (SuperiorTank) siGame.getTank();
		siGame.keyPressed(KeyEvent.VK_LEFT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		siGame.keyPressed(KeyEvent.VK_RIGHT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2, t.getX());
        siGame.keyPressed(KeyEvent.VK_UP);
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 - Tank.DX, t.getY());
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 - 2*Tank.DX, t.getY());
        siGame.keyPressed(KeyEvent.VK_DOWN);
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 - Tank.DX, t.getY());
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3, t.getY());
        siGame.keyPressed(KeyEvent.VK_I);
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 + 3, t.getY());
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 + 6, t.getY());
	}
	
	@Test
	public void testKeyPadKeyEvent() {
		SuperiorTank t = (SuperiorTank) siGame.getTank();
		siGame.keyPressed(KeyEvent.VK_KP_LEFT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		siGame.keyPressed(KeyEvent.VK_KP_RIGHT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2, t.getX());
        siGame.keyPressed(KeyEvent.VK_KP_UP);
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 - Tank.DX, t.getY());
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 - 2*Tank.DX, t.getY());
        siGame.keyPressed(KeyEvent.VK_KP_DOWN);
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3 - Tank.DX, t.getY());
        siGame.update();
        assertEquals(SIGame.HEIGHT*2/3, t.getY());
    }
	
	@Test
	public void testSpaceKeyEvent() {
		siGame.keyPressed(KeyEvent.VK_SPACE);
		assertEquals(1, siGame.getMissiles().size());
		siGame.keyPressed(KeyEvent.VK_SPACE);
		siGame.keyPressed(KeyEvent.VK_SPACE);
		assertEquals(3, siGame.getMissiles().size());
	}

	@Test
    public void testMoveMissile()
    {
        Missile missile = new Missile(0,2);
        Invader invader = new Invader(0,0);
        siGame.moveMissiles();
        assertEquals(0,missile.getY());
        siGame.moveInvaders();
        assertEquals(1, invader.getY());
    }
}
