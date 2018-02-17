package ca.ubc.cs.cpsc210.spaceinvaders.model;

public class SuperiorTank extends Tank {

    protected int speed = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;

    public SuperiorTank(int x) {
        super(x);
        direction = LEFT;
    }

    // MODIFIES: this
    // EFFECTS:  tank is moved speed units in whatever direction it is facing and is
    //           constrained to remain within boundaries of game
    @Override
    public void move() {
        if (direction == RIGHT) {
            x_coord += speed;
        }
        else if (direction == LEFT) {
            x_coord -= speed;
        }
        else if (direction == UP)
        {
            y_coord -= speed;
        }
        else
        {
            y_coord += speed;
        }
        handleBoundary();
    }

    // MODIFIES: this
    // EFFECTS: tank is constrained to remain within boundaries of game
    @Override
    protected void handleBoundary() {
        if (x_coord > SIGame.WIDTH)
        {
            x_coord = 0;
        }
        else if (x_coord < 0)
        {
            x_coord = SIGame.WIDTH;
        }
        if (y_coord > SIGame.HEIGHT)
        {
            y_coord = 0;
        }
        else if (y_coord < 0)
        {
            y_coord = SIGame.HEIGHT;
        }
    }

    // MODIFIES: this
    // EFFECTS: increment the speed of the tank
    public void tankSpeedIncrement()
    {
        speed = speed + 1;
    }

    // MODIFIES: this
    // EFFECTS: tank is facing left
    public void faceUp() {
        direction = UP;
    }

    // MODIFIES: this
    // EFFECTS: tank is facing left
    public void faceDown() {
        direction = DOWN;
    }

    // EFFECTS: return y coordinate of the tank
    public int getY() {
        return y_coord;
    }

    public int getDirection()
    {
        return direction;
    }

    public int getSpeed()
    {
        return speed;
    }

}
