package marioT;

import java.awt.Rectangle;
import java.util.ArrayList;

public class MainHero extends GameObjects implements Observable {

    public State stateGame = new State();
    int state;
    public int dx = 0;
    public int dy = 1;
    public int currentImage = 0;

    Obstacle onObstacle = null;
    Obstacle nearObstacle = null;
    public boolean nitro = false;
    public ArrayList<Observer> observers = new ArrayList<>();
    public boolean jumping = false;

    public void update(ArrayList<Obstacle> obstacles, ArrayList<Coin> coins) {
        dy++;

        if (dy > 10) {
            dy = 10;
        }
//        if (dx > 0) {
//            dx ++;
//            if (dx > 15)
//                dx = 15;
//        };
//        if (dx < 0) {
//            dx --;
//            if (dx < -15)
//                dx = -15;
//        }

        int lastX = position.x;
        int lastY = position.y;

        position.setBounds(
                position.x + dx, 
                position.y, 
                position.width, 
                position.height);
        boolean intersects = false;
        for (Coin coin : coins) {
            if (coin.position.intersects(position)) {
                coin.setVisibility(false);
            }
        }
        
        if(!intersects) jumping = true;
        for (Obstacle obstacle : obstacles) {
            if (obstacle.position.intersects(position)) {
                transparent = obstacle.transparent;
                intersects = true;
                nearObstacle = obstacle;
            }
        }

        if (intersects && !transparent) {
            position.setBounds(lastX, position.y, position.width, position.height);
            jumping = false;
        }

        position.setBounds(position.x, 
                position.y + dy, 
                position.width, 
                position.height);
        intersects = false;
        for (Obstacle obstacle : obstacles) {
            if (obstacle.position.intersects(position)) {
                transparent = obstacle.transparent;
                intersects = true;
                onObstacle = obstacle;
            }

        }
        
        if (intersects && !transparent) {
            position.setBounds(position.x, lastY, position.width, position.height);
            jumping = false;
        }
        notifyObservers();
    }

    @Override
    public Rectangle getPosition() {
        return position;
    }

    @Override
    public int getImageNo() {
        return 0;
    }

    @Override
    public void update(GameLogic gameLogic) {
        update(gameLogic.obstacles, gameLogic.coins);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.react(this);
        }
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        observers.remove(observer);
    }
    public void congrats(int type){
        Obstacle obstacle = null;
//        if(obstacle.type == 11) {
//            visible = false;
//            transparent = true;
//        }
        //obstacle.visible = true;
        System.out.println("Congratulations!!!");
    }

}
