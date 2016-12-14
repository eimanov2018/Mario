/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import marioT.*;
/**
 *
 * @author Emil
 */
public abstract class Menu
{
    protected String[] menuItems;
    protected int menuItemsCount;
    protected int selectedItem = 1;
    protected GameLogic gameLogic;
    protected String image;

    public Menu(GameLogic gameLogic, String image)
    {
        this.gameLogic = gameLogic;
        this.menuItems = menuItems;
        this.menuItemsCount = menuItems.length;
        this.image = image;
    }

    public void draw(Graphics graphics)
    {
        int y = 1000 / 3;
        int i = 1;
        for (String menuItem : menuItems)
        {
            if (i == selectedItem)
            {
                graphics.setColor(Color.red);
                graphics.fillRect(310, y + (i * 37) + 5 , 15, 2);
            }
            i++;
        }
    }

    public void menuDown()
    {
        selectedItem++;
        if (selectedItem > menuItemsCount)
        {
            selectedItem = 1;
        }
    }

    public void menuUp()
    {
        selectedItem--;
        if (selectedItem < 1)
        {
            selectedItem = menuItemsCount;
        }
    }

    abstract public void execute();

    public void handlePressedKeys(ArrayList<KeyButtons> keyPressed)
    {
        if (keyPressed.contains(KeyButtons.DOWN))
        {
            menuDown();
        }
        if (keyPressed.contains(KeyButtons.UP))
        {
            menuUp();
        }
        if (keyPressed.contains(KeyButtons.CONFIRM))
        {
            execute();
        }
    }

    public void doLoopAction()
    {
    }
}