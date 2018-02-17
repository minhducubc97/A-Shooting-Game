package ca.ubc.cs.cpsc210.spaceinvaders.ui;

import ca.ubc.cs.cpsc210.spaceinvaders.model.Invader;
import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cs.cpsc210.spaceinvaders.model.SuperiorTank;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SuperiorGamePanel extends GamePanel {

    public SuperiorGamePanel(SIGame g) {
        super(g);
    }

    // MODIFIES: g
    // EFFECTS:  draws the game onto g
    @Override
    protected void drawGame(Graphics g) {
        drawBackGround(g);
        drawTank(g);
        drawInvaders(g);
        drawMissiles(g);
    }

    @Override
    // MODIFIES: g
    // EFFECTS:  draws the tank onto g
    protected void drawTank(Graphics g) {

        SuperiorTank t = (SuperiorTank) game.getTank();

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("img/Zombie.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(image, t.getX() - Tank.SIZE_X / 2, t.getY() - Tank.SIZE_Y / 2, Tank.SIZE_X*5, Tank.SIZE_Y*5, this);
    }

    @Override
    // MODIFIES: g
    // EFFECTS:  draws the invader i onto g
    protected void drawInvader(Graphics g, Invader i) {

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("img/missile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(image, i.getX() - Invader.SIZE_X / 2, i.getY() - Invader.SIZE_Y / 2, Invader.SIZE_X*2, Invader.SIZE_Y*4, this);
    }

    // MODIFIES: g
    // EFFECTS:  draws the background onto g
    protected void drawBackGround(Graphics g)
    {
        BufferedImage image_bck = null;
        try {
            image_bck = ImageIO.read(new File("img/bck.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(image_bck, 0, 0, SIGame.WIDTH, SIGame.HEIGHT, this);
    }
}
