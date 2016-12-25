package marioT;

import java.awt.Rectangle;

public class Obstacle extends GameObjects implements Observer {

    public int type = 0;
    public boolean shrinked = false;
        
    public Obstacle(int x, int y, int width, int height, int type) {
        if(type == 11) {
            visible = true;
            transparent = true;
        }
        position = new Rectangle(x, y, width, height);
        this.type = type;
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

    @Override
    public void react(Observable subject) {
        MainHero mainHero = (MainHero) subject;
        if (mainHero.onObstacle == this && mainHero.stateGame.sitting && type == 10) {
            shrinked = true;
            position.setBounds(position.x + position.width / 4, position.y, position.width / 2, position.height);
        }
        if (mainHero.nitro && mainHero.nearObstacle == this && mainHero.stateGame.goingRight && type == 9) {
            System.out.println("TUT");
            
           // visible = true;
            mainHero.position.setBounds(4650, 240, mainHero.position.width, mainHero.position.height);
            mainHero.congrats(type); 
        }
    }
}
