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
public abstract class GameObjects implements ObjectAction {

    public boolean transparent = false; //for transparent obstacles: trees, clouds, turtles;

    public Rectangle position = new Rectangle(0,0,0,0);
    
    public boolean visible = true;
    
    public abstract Rectangle getPosition();

    public abstract int getImageNo();
    
    public void setVisibility(boolean isVisible) {
        visible = isVisible;
    }
}
