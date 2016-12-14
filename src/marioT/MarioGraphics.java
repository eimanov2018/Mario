package marioT;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MarioGraphics extends JPanel {

    public GameLogic gameLogic;

    Image[] gameObjectImage;
    Image characterImage, sprite;
    Image[] coins;
    Image[] runnerImage;
    Image[] obstacleImages;
    Image mainMenuImage;

    public MarioGraphics() {
        gameObjectImage = new Image[11];
        coins = new Image[1];
        obstacleImages = new Image[11];
        runnerImage = new Image[12];
        try {
            sprite = ImageIO.read(new File("images/sprite.png"));
            mainMenuImage = ImageIO.read(new File("images/MainMenu.png"));
            runnerImage[0] = ImageIO.read(new File("images/1.png"));
            runnerImage[1] = ImageIO.read(new File("images/2.png"));
            runnerImage[2] = ImageIO.read(new File("images/3.png"));
            runnerImage[3] = ImageIO.read(new File("images/4.png"));
            runnerImage[4] = ImageIO.read(new File("images/5.png"));
            runnerImage[5] = ImageIO.read(new File("images/6.png"));
            runnerImage[6] = ImageIO.read(new File("images/7.png"));
            runnerImage[7] = ImageIO.read(new File("images/8.png"));
            runnerImage[8] = ImageIO.read(new File("images/9.png"));
            runnerImage[9] = ImageIO.read(new File("images/10.png"));
            runnerImage[10] = ImageIO.read(new File("images/11.png"));
            runnerImage[11] = ImageIO.read(new File("images/12.png"));

            obstacleImages[1] = ImageIO.read(new File("images/Question_Block_Art_-_New_Super_Mario_Bros.png"));
            obstacleImages[2] = ImageIO.read(new File("images/Ground_Block.png"));
            obstacleImages[3] = ImageIO.read(new File("images/mario_box.png"));
            obstacleImages[4] = ImageIO.read(new File("images/Brick_Block.png"));
            obstacleImages[5] = ImageIO.read(new File("images/tunnel.png"));
            obstacleImages[6] = ImageIO.read(new File("images/Clouds.png"));
            obstacleImages[7] = ImageIO.read(new File("images/Marixuana.png"));
            obstacleImages[8] = ImageIO.read(new File("images/Coin.png"));
            obstacleImages[9] = ImageIO.read(new File("images/tunnel2.png"));
            obstacleImages[10] = ImageIO.read(new File("images/GreenGrass.jpg"));
            characterImage = ImageIO.read(new File("images/__Pink-Ranger.png"));

        } catch (IOException e) {
            System.out.println("problems loading images" + e.getMessage());
            System.exit(1);
        }
    }

    int offsetY = 60;

    public void paint(Graphics g) {
        super.paint(g);

        if (gameLogic.mainHero.position.x == 200) {
            g.drawImage(mainMenuImage,
                    0, 0, g.getClipBounds().width, g.getClipBounds().height,
                    0, 0, mainMenuImage.getWidth(null), mainMenuImage.getHeight(null), null);
        } else {
            g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
            int fromX = 0;
            int toX = 0;
            int imX1=0, imY1=0, imX2=0, imY2=0;

            for (GameObjects gameObject : gameLogic.gameObjects) {
                Image toDraw1;
                if (!gameObject.visible) {
                    continue;
                }
                if (gameObject.getImageNo() == 0) {
                    //toDraw1 = sprite;
                    toDraw1 = characterImage;
                        imX1 = 0;
                        imY1 = 0;
                        imX2 = toDraw1.getWidth(null);
                        imY2 = toDraw1.getHeight(null); 
                    if (gameLogic.mainHero.dx != 0) {
                        gameLogic.mainHero.currentImage = (gameLogic.mainHero.currentImage + 1) % runnerImage.length;
                        //toDraw1 = runnerImage[gameLogic.mainHero.currentImage];
                        
                        toDraw1 = sprite;
                        imX1 = 3*toDraw1.getWidth(null)/8;
                        imY1 = toDraw1.getHeight(null)/2;
                        imX2 = imX1 + toDraw1.getWidth(null)/8;
                        imY2 = imY1 + toDraw1.getHeight(null)/8;
                        
                    }
                    fromX = gameLogic.mainHero.position.x + gameLogic.backPosition;
                    toX = gameLogic.mainHero.position.x + gameLogic.mainHero.position.width + gameLogic.backPosition;

//                    if (gameLogic.mainHero.dx < 0) {
//                        int k = fromX;
//                        fromX = toX;
//                        toX = k;
//                    }
                } else {

                    toDraw1 = obstacleImages[gameObject.getImageNo()];
                    fromX = gameObject.position.x + +(int) (gameLogic.backPosition * ((gameObject.getImageNo() == 6) ? 0.3 : 1));
                    toX = gameObject.position.x + gameObject.position.width + (int) (gameLogic.backPosition * ((gameObject.getImageNo() == 6) ? 0.3 : 1));
                        imX1 = 0;
                        imY1 = 0;
                        imX2 = toDraw1.getWidth(null);
                        imY2 = toDraw1.getHeight(null); 
                }

                g.drawImage(toDraw1,
                        fromX,
                        gameObject.position.y + offsetY,
                        toX,
                        gameObject.position.y + offsetY + gameObject.position.height,
                        imX1,imY1,imX2,imY2,  
                        null
                );
            }
        }

    }
}
