/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Emil
 */
public class Menu extends JFrame {

    private JTextField play;
    private JTextField restart;
    private JTextField exit;
    
    public Menu() {

        setSize(getToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(new JLabel(new ImageIcon("images/MainMenu.png")));
        play = new JTextField("Play");

        restart = new JTextField("Restart Game");
        restart.setEnabled(false);

        exit = new JTextField("Exit");
        
        play.setLocation(100, 100);
        exit.setLocation(200, 300);
        play.setEditable(false);
        exit.setEditable(false);
        restart.setEditable(false);
        

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.

                System.exit(0);
            }
        });

        play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                Main main = new Main();
                main.f.setVisible(true);
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.

                System.exit(0);
            }
        });
        setLayout(new FlowLayout());
        add(play);
        add(exit);
        add(restart);
    }

    public static void main(String[] args) {
        Menu main = new Menu();
        main.setVisible(true);
    }

}
