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
public class MarioData {
    private boolean big;
    private int coins, lives, level;
    private static MarioData marioData = new MarioData();
    private MarioData(){
        coins = 0;
        lives = 3;
        level = 1;
        
    }
     public int getCoins()
    {
        return coins;
    }

    public void setCoins(int coins)
    {
        this.coins = coins;
    }

    public int getLives()
    {
        return lives;
    }

    public void setLives(int lives)
    {
        this.lives = lives;
    }
    public static MarioData getMarioData()
    {
        return marioData;
    }

}
