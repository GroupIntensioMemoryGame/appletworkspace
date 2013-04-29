package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Player;
import controller.SimonSaysController;

public class PlayPanel extends JFrame implements ActionListener
{
    public PlayPanel(Player player, int numObjects, String layout, int size, ArrayList<String> colors, ArrayList<String> shapes){
        super("Simon Says");
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }

}
