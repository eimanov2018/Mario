/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioT;

/**
 *
 * @author Emil
 */
public class State {
    public boolean falling = false;
    public boolean jumping = false;
    public boolean goingLeft = false;
    public boolean goingRight = false;
    public boolean sitting = false;
    public void compute(MainHero mainHero) {
       goingLeft =  mainHero.dx < 0;
       goingRight = mainHero.dx > 0;
       jumping = mainHero.jumping;
    }
}
