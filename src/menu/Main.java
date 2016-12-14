/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;
import javax.swing.JFrame;

/**
 *
 * @author Emil
 * 
 */
public class Main extends JFrame
{
    public Main(boolean debugger)
    {
        setIgnoreRepaint(true);
        setUndecorated(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Awesome Mario Remake");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args)
    {
        boolean debugger = false;
        if(args != null && args.length > 0 && args[0].equals("true"))
        {
            debugger = true;
        }
        Main main = new Main(debugger);
        main.setVisible(true);
    }
}