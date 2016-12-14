package marioT;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.Window.Type;
import javax.swing.*;

public class Main {

    public static JFrame f = new JFrame("Mario");
    static MarioGraphics marioGraphics = new MarioGraphics();
    static GameLogic gameLogic = new GameLogic();
    static boolean exitPressed = false;
    static Timer timer = new Timer(50, e -> {
        gameLogic.update();
        marioGraphics.repaint();
    });

    public static void main(String[] args) {
        f.getContentPane().add(marioGraphics);
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        f.setSize(f.getToolkit().getScreenSize());

        // f.setSize(r.getSize());
        //  f.setType(Type.POPUP);
        //f.setState(JFrame.ICONIFIED);
        //f.setSize(800,600);
        //f.setBounds(0,0,getToolkit().getScreenConfigurationAccessor().getWidth(r),getToolkit().getScreenConfigurationAccessor().getHeight(r));
        //f.setState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marioGraphics.gameLogic = gameLogic;
        timer.start();
        f.addKeyListener(gameLogic.keyListener);
    }

    public static void exit() {
        if (exitPressed) {
            ((Window) f.getRootPane().getParent()).dispose();
        }
    }

}
