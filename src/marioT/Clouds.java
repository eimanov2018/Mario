/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioT;

import java.awt.Rectangle;

/**
 *
 * @author Emil
 */
public class Clouds extends GameObjects{
    public int type = 0; 
    
    public Clouds(int x, int y, int width, int height, int type) {
        position = new Rectangle(x,y, width, height);
        this.type = type;
        transparent = true;
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
