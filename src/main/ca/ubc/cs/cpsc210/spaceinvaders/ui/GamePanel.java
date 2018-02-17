package ca.ubc.cs.cpsc210.spaceinvaders.ui;

import java.awt.*;

import javax.swing.JPanel;

import ca.ubc.cs.cpsc210.spaceinvaders.model.*;

/*
 * The panel in which the game is rendered.
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private static final String OVER = "Game Over!";
	private static final String REPLAY = "R to replay";
	protected SIGame game;

	// EFFECTS:  sets size and background colour of panel,
	//           updates this with the game to be displayed
	public GamePanel(SIGame g) {
		setPreferredSize(new Dimension(SIGame.WIDTH, SIGame.HEIGHT));
		setBackground(Color.GRAY);
		this.game = g;
	}

	// EFFECTS: draw the game
	@Override
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		drawGame(g);
		
		if (game.isOver()) {
			gameOver(g);
		}
	}

	// MODIFIES: g
	// EFFECTS:  draws the game onto g
	protected void drawGame(Graphics g) {
		drawTank(g);
		drawInvaders(g);
		drawMissiles(g);
	}

    // MODIFIES: g
    // EFFECTS:  draws the tank onto g
    protected void drawTank(Graphics g) {
        SuperiorTank t = (SuperiorTank) game.getTank();
        Color savedCol = g.getColor();
        g.setColor(Tank.COLOR);
        g.fillRect(t.getX() - Tank.SIZE_X / 2, t.getY() - Tank.SIZE_Y / 2, Tank.SIZE_X, Tank.SIZE_Y);
        Polygon tankFront = createTankFront(t);
        g.fillPolygon(tankFront);
        g.setColor(savedCol);
    }

    // EFFECTS: returns a polygon that represents front of tank
    protected Polygon createTankFront(SuperiorTank t) {
        Polygon tankFront = new Polygon();

        if (t.isFacingRight()) {
            tankFront.addPoint(t.getX() + Tank.SIZE_X / 2, t.getY() + Tank.SIZE_Y / 2);
            tankFront.addPoint(t.getX() + Tank.SIZE_X, t.getY());
            tankFront.addPoint(t.getX() + Tank.SIZE_X / 2, t.getY() - Tank.SIZE_Y / 2);
        }
        else {
            tankFront.addPoint(t.getX() - Tank.SIZE_X / 2, t.getY() + Tank.SIZE_Y / 2);
            tankFront.addPoint(t.getX() - Tank.SIZE_X, t.getY());
            tankFront.addPoint(t.getX() - Tank.SIZE_X / 2, t.getY() - Tank.SIZE_Y / 2);
        }

        return tankFront;
    }

	// MODIFIES: g
	// EFFECTS:  draws the invaders onto g
	protected void drawInvaders(Graphics g) {
		for(Invader next : game.getInvaders()) {
			drawInvader(g, next);
		}
	}

	// MODIFIES: g
	// EFFECTS:  draws the invader i onto g
	protected void drawInvader(Graphics g, Invader i) {
		Color savedCol = g.getColor();
		g.setColor(Invader.COLOR);
		g.fillOval(i.getX() - Invader.SIZE_X / 2, i.getY() - Invader.SIZE_Y / 2, Invader.SIZE_X, Invader.SIZE_Y);
		g.setColor(savedCol);
	}

	// MODIFIES: g
	// EFFECTS:  draws the missiles onto g
	protected void drawMissiles(Graphics g) {
		for(Missile next : game.getMissiles()) {
			drawMissile(g, next);
		}
	}

	// MODIFIES: g
	// EFFECTS:  draws the missile m onto g
	protected void drawMissile(Graphics g, Missile m) {
		Color savedCol = g.getColor();
		g.setColor(Missile.COLOR);
		g.fillOval(m.getX() - Missile.SIZE_X / 2, m.getY() - Missile.SIZE_Y / 2, Missile.SIZE_X, Missile.SIZE_Y);
		g.setColor(savedCol);
	}

	// MODIFIES: g
	// EFFECTS:  draws "game over" and replay instructions onto g
	private void gameOver(Graphics g) {
		Color saved = g.getColor();
		g.setColor(new Color( 0, 0, 0));
		g.setFont(new Font("Arial", 20, 20));
		FontMetrics fm = g.getFontMetrics();
		centreString(OVER, g, fm, SIGame.HEIGHT / 2);
		centreString(REPLAY, g, fm, SIGame.HEIGHT / 2 + 50);
		g.setColor(saved);
	}

	// MODIFIES: g
	// EFFECTS:  centres the string str horizontally onto g at vertical position yPos
	private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
		int width = fm.stringWidth(str);
		g.drawString(str, (SIGame.WIDTH - width) / 2, yPos);
	}
}
