/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.Window;
import marioT.*;

/**
 *
 * @author Emil
 */
public class MainMenu extends Menu
{
    public MainMenu(GameLogic gameLogic)
    {
        super(gameLogic);
    }

    public void execute()
    {
        switch(selectedItem)
        {
            case 1:
                gameLogic.startNewGame();
                break;
            case 2:
                gameLogic.exit();
                break;
        }
    }
}