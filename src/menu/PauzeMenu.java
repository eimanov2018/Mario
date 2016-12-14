/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import marioT.*;

/**
 *
 * @author Emil
 */
public class PauzeMenu extends Menu
{
    public PauzeMenu(GameLogic gameLogic)
    {
        super(gameLogic, "/images/PauseMenu.png");
    }

    public void execute()
    {
       switch(selectedItem)
       {
            case 1:
               // gameLogic.GameLogic;
            break;
            case 2:
                
                gameLogic.startNewGame();
                break;
           case 3:
              // PauzeMenu(gameLogic);
                
                break;
        }
    }
}