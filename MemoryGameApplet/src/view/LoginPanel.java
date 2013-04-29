package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.SimonSaysController;

import model.Player;

public class LoginPanel extends JFrame implements ActionListener
{
    Player play;
    public LoginPanel(final SimonSaysController sscgame){
        super("Simon Says");
        
        JPanel lg = new JPanel(new BorderLayout());
        JPanel labl = new JPanel(new FlowLayout());
        JPanel sel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 50));
        
        
        
        JLabel lblName = new JLabel("Please Enter Username to begin:");
        final JTextField txtName = new JTextField(15);
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // check if login is valid
                // if valid go to options screen
                // if not say not valid login
                
                String input = txtName.getText();
                play = sscgame.login(input);
                if(play != null){
                    OptionsPanel op = new OptionsPanel(play, sscgame);
                    setVisible(false);
                }
                else{
                    //say username does not exist
                }
            }
        });
        
        JButton createButton = new JButton("Create New User");
        createButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // bring up create new user gui
                NewUserPanel newUser = new NewUserPanel(sscgame);
                setVisible(false);
            }
        });
        
        
        JLabel lblHighScores = new JLabel("High Scores");
        JTextArea highScores = new JTextArea("                               <<Scores go in this JTextArea>>", 600,50);
        
        //***Settings and panels for login frame***
        setSize(400,500);
        labl.setBackground(Color.white);
        sel.setBackground(Color.lightGray);
        
        // labels and buttons
        sel.add(lblName);
        sel.add(txtName);
        sel.add(loginButton);
        sel.add(createButton);
        sel.add(lblHighScores);
        sel.add(highScores, BorderLayout.PAGE_END);
        
        highScores.setBackground(Color.gray);
        loginButton.setBackground(Color.ORANGE);
        createButton.setBackground(Color.ORANGE);
        lg.add(labl,BorderLayout.PAGE_START);
        lg.add(sel,BorderLayout.CENTER);
        
        add(lg);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }

}
