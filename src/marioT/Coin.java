package marioT;

import java.awt.Rectangle;

public class Coin extends GameObjects{

    int type = 0;
    public Coin(int x, int y, int width, int height, int type) {
       position = new Rectangle(x, y, width, height);
       this.type=type;
    }

    @Override
    public Rectangle getPosition() {
        return position;
    }

    @Override
    public int getImageNo() {
        return type;
    }

    @Override
    public void update(GameLogic gameLogic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
