package ca.ubc.cs.cpsc210.spaceinvaders.model;

import java.awt.Color;

/**
 * Represents a tank
 */
public class Tank {
	
	public static final int SIZE_X = 30;
	public static final int SIZE_Y = 16;
	public static final int DX = 2;
	public static final int Y_POS = SIGame.HEIGHT *2/3;
	public static final Color COLOR = new Color(250, 128, 20);

	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	protected int direction;
    protected int x_coord;
    protected int y_coord;

	// EFFECTS: places tank at position (x, Y_POS) moving right.
	public Tank(int x) {
		x_coord = x;
		y_coord = Y_POS;
	}

	// EFFECTS: return the x coordinate of the tank
	public int getX() {
		return x_coord;
	}

    // EFFECTS: returns true if tank is facing right, false otherwise
    public boolean isFacingRight() {
        if (direction == RIGHT)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

	// MODIFIES: this
	// EFFECTS: tank is facing right
	public void faceRight() {
		direction = RIGHT;
	}

	// MODIFIES: this
	// EFFECTS: tank is facing left
	public void faceLeft() {
		direction = LEFT;
	}

    // MODIFIES: this
	// EFFECTS:  tank is moved DX units in whatever direction it is facing and is
	//           constrained to remain within horizontal bounds of game
    public void move() {
		if (direction == RIGHT)
        {
            x_coord += DX;
        }
        else
        {
            x_coord -= DX;
        }
        handleBoundary();
	}

	// MODIFIES: this
	// EFFECTS: tank is constrained to remain within horizontal bounds of game
    protected void handleBoundary() {
		if (x_coord > SIGame.WIDTH)
        {
            x_coord = 0;
        }
        else if (x_coord < 0)
        {
            x_coord = SIGame.WIDTH;
        }
	}
}
