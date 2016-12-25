package marioT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameLogic {
   // private State state = new State("Main Menu");
    ArrayList<Obstacle> obstacles = new ArrayList<>();
    ArrayList<GameObjects> gameObjects = new ArrayList<>();
    ArrayList<Clouds> clouds = new ArrayList<>();
    ArrayList<Runner> runners = new ArrayList<>();
    ArrayList<Coin> coins = new ArrayList<>();
    MainHero mainHero = new MainHero();
    int backPosition = 0;
    private boolean isSit = false;
    static GameLogic gameLogic;
    
    
public static GameLogic getCurrentGame() {
        if (gameLogic == null)
            gameLogic = new GameLogic();
        return gameLogic;
    }
public static void startNewGame() {
        gameLogic = new GameLogic();
    }
public static void exit(){
    Main.exitPressed = true;
            Main.exit();
}
    public GameLogic() {
        mainHero.position.setBounds(200, 260, 30, 50);
        
        
         String[] level1 = new String[] {
        "cc00cc0000000000000000000000000000000000000000000000000000000000000000c00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        "c00c000000ccc000cc0000c000c000000c000000c0000000000cc0ccccc00cc000000ccc0000000ccc000ccc00000000000cccc000000cc0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        "000000c0000cc00000ccc00000cccc00000c00cc00000cccc00cc0000000ccc0000ccccc00000000c00000cc000ccc00000000cc0000000c000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        "0000000000000000000000000000000000000000000000000000000000ccccc0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000030000",
        "0000000000000000000000?000000000000000000000000C00C00000000000000000000000000000?3333333000333?0000000000000030000000000033300003??30000000000000000000000000000000000000000000000000000000000000000000333000",
        "000000000000000000000000000000000000000000000C00C00000000000000000000000000000CC0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000bb00000000000003333300",
        "00000000000000000000000000000000000000000000CC00000CC000000000000C00000000000CCC000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000bbb00000000000033333330",
        "0000000000000000C0000C0C00000000000000000000 00000000 00000000000?0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000bbbb00000000000033333330",
        "0000000000000000?0003?3?300CCC00000000000000s0CCCCCC0s0000000000000000000000033300000000000000300000330000?00?00?0000030000000000330000000b00b0000000000bb00b00000000000033?30000000bbbbb00000000000033303330",
        "0000000000000000000000000000000000000d000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000bb00bb00000000bbb00bb000000000000000000000bbbbbb00000000000033303330",
        "0000000000000000000000000000t00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000bbb00bbb000000bbbb00bbb00000t0000000000t00bbbbbbb00000000F00033303330",
        "0002200200020002002022200000000200020 0220000002220000002022200000020000000220000002220 02002200222000220002200000000000000000000000000bbbb00bbbb0000bbbbb00bbbb00000000000000000bbbbbbbb00000000b00033303330",
        "1111111111111111111111111111111111111111111111111111111111111111111111GG1111111111111100011111111111111111111111111111111111111111111111111111111111111111t 1111111111111111111111111111111111111111111111111",
        "1111111111111111111111111111111111111111111111111111111111111111111111GG1111111111111100011111111111111111111111111111111111111111111111111111111111111111  1111111111111111111111111111111111111111111111111",
        "                                                          30003333333      3",
        "                                                          3000 CCCCCCCCCC  3",
        "                                                          3000 CCCCCCCCCC  3",
        "                                                          30000CCCCCCCCCC  3",
        "                                                          3000   CCCCCCC   3",
        "                                                          3000     CCCCC   3",
        "                                                          3000       CCC   3",
        "                                                          3000        CC   3",
        "                                                          30003333333  C   3",
        "                                                          30003333333      T",
        "                                                          30003333333       ",
        "                                                          11111111111111111",
        "                                                          11111111111111111",
        
    };

        
     
        
        for(int i = 0; i<level1.length;i++){
            String line = level1[i];
            for(int j = 0; j<line.length();j++){
                System.out.println(line.length());
                switch (line.substring(j, j+1)) {
                    
                    case "?" : obstacles.add(new Obstacle( j*30, i*30, 30, 30, 1)); break;
                    case "1" : obstacles.add(new Obstacle(j*30,i*30,30,30,2)); break;
                    case "b" : obstacles.add(new Obstacle( j*30, i*30, 30, 30, 3)); break;
                    case "3" : obstacles.add(new Obstacle(j*30,i*30, 30, 30, 4)); break;
                    case "t" : obstacles.add(new Obstacle( j*30, i*30, 60, 60, 5)); break;
                    case "d" : obstacles.add(new Obstacle( j*30, i*30, 60, 90, 5)); break;
                    case "s" : obstacles.add(new Obstacle( j*30, i*30, 60, 120,5)); break;
                    case "T" : obstacles.add(new Obstacle((j-1)*30-10, i*30, 160, 60, 9)); break;
                    case "G" : obstacles.add(new Obstacle( j*30, i*30, 30, 30,10)); break;
                    case "F" : obstacles.add(new Obstacle( j*30-5, (i-5)*30, 30, 180,11)); break;


                    case "c" : clouds.add(new Clouds( j*30, i*30, 30, 30, 6)); break;
                    case "2" : clouds.add(new Clouds( j*30, i*30, 30, 30, 7)); break;
                    case "C" : coins.add(new Coin( j*30+2, i*30, 26, 29, 8)); break;

                }
            }
            
        } 
               for (Obstacle obstacle : obstacles) {
            gameObjects.add(obstacle);
            mainHero.register(obstacle);
        }
       
       for (Coin coin : coins){
           if(coin.visible)
           gameObjects.add(coin);
       }
       for (Clouds cloud : clouds)
           gameObjects.add(cloud);
       
       gameObjects.add(mainHero);
    }
    public void update() {
            mainHero.update(obstacles, coins);
//            for(GameObjects gameObject : gameObjects) {
//                gameObject.update(this);
//            }
            if(mainHero.position.x + backPosition > 1000){
                backPosition = backPosition - (mainHero.position.x+backPosition-1000);
            }
            if(mainHero.position.x + backPosition < 100){
                backPosition = backPosition + (100 - (mainHero.position.x+backPosition));
            }
            
        }
    public KeyListener keyListener = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
             System.out.println("Key pressed: " + e.getKeyCode());

            if ((e.getKeyCode() == 38 || e.getKeyCode()==87 || e.getKeyCode()==32) && !mainHero.jumping) {
             int jump = -14;
             mainHero.dy = jump;
             Sounds.playSound("jump.mp3");
             System.out.println(mainHero.dy);
             mainHero.jumping = true;
            }
            
            if (e.getKeyCode() == 37 || e.getKeyCode()==65) {
                mainHero.stateGame.goingLeft = true;

               if(!mainHero.nitro) mainHero.dx = -8;
               else { 
                   int i;
                   for(i=0; i>-20;i--) {
                       mainHero.dx=i;
                   } i=0;
               }
            }
            if (e.getKeyCode()==16) mainHero.nitro = true;
            if (e.getKeyCode() == 39 || e.getKeyCode()==68) {
                mainHero.stateGame.goingRight = true;

                if(!mainHero.nitro) mainHero.dx = 15;
                else {
                    int i;
                   for(i=0; i<20;i++) {
                       mainHero.dx=i;
                   } i=0;
                }
            }  
            if((e.getKeyCode() == 40 || e.getKeyCode() == 83) && !isSit) {
                mainHero.position.height/=2;
                isSit = true;
                mainHero.stateGame.sitting = true;
            }
            if(e.getKeyCode()==82) {
                mainHero.position.setLocation(200, 260);
                for(Coin coin : coins) 
               coin.setVisibility(true);
               // startNewGame();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Key released: " + e.getKeyCode());
            if (e.getKeyCode() == 37 ||
                    e.getKeyCode() == 39 || 
                    e.getKeyCode()==65 ||
                    e.getKeyCode()==68) {
                mainHero.dx = 0;
                mainHero.stateGame.goingRight = false;
                mainHero.stateGame.goingLeft = false;

            }
            if (e.getKeyCode() == 16)
                mainHero.nitro = false;
            if((e.getKeyCode() == 40 || e.getKeyCode() == 83) && isSit){ 
                mainHero.position.height = mainHero.position.height*2;
                mainHero.position.y -=mainHero.position.height/2; 
                isSit = false;
                mainHero.stateGame.sitting = false;
                }
            
                
        }
           
        };
}

