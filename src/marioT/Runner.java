/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioT;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Emil
 */
public class Runner {

    public Rectangle position = new Rectangle(0, 0, 0, 0);
    int state = 0;
    public int dx = 0;
    public int dy = 1;
    public boolean nitro = false;
    public boolean jumping = false;

    public Runner(int state) {
        this.state = state;
    }

}
