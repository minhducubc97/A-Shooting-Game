package ca.ubc.cs.cpsc210.spaceinvaders.model;

import java.awt.event.KeyEvent;
import java.security.Key;

public class SuperiorSIGame extends SIGame {

    @Override
    // MODIFIES: this
    // EFFECTS: turns tank or increase the tank's speed in response to key code
    protected void tankControl(int keyCode) {
        if (keyCode == KeyEvent.VK_KP_LEFT || keyCode == KeyEvent.VK_LEFT)
            tank.faceLeft();
        else if (keyCode == KeyEvent.VK_KP_RIGHT || keyCode == KeyEvent.VK_RIGHT)
            tank.faceRight();
        else if (keyCode == KeyEvent.VK_KP_UP || keyCode == KeyEvent.VK_UP)
            tank.faceUp();
        else if (keyCode == KeyEvent.VK_KP_DOWN || keyCode == KeyEvent.VK_DOWN)
            tank.faceDown();
        else if (keyCode == KeyEvent.VK_I)
        {
            tank.tankSpeedIncrement();
        }
    }
}
