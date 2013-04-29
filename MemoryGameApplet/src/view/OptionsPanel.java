package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.SimonSaysController;

import model.Player;

public class OptionsPanel extends JFrame implements ActionListener
{
    
    //Store selections
    final ArrayList<String> selectedColors = new ArrayList<String>();
    final ArrayList<String> selectedShapes = new ArrayList<String>();
    JButton play = new JButton("Play!");
    
    public OptionsPanel(Player player, final SimonSaysController sscgame){
        super("Options");
        

        
        // create main frame
        JPanel opt = new JPanel(new FlowLayout(FlowLayout.CENTER,100,50));
        JPanel shapes = new JPanel(new GridLayout(3,2));
        JPanel colors = new JPanel(new GridLayout(3,2));
        JPanel layout = new JPanel(new GridLayout(2,2));
       
       // create option frames 
        JLabel userName = new JLabel("UserName: " + player.getName());
        
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //go to home login screen
                LoginPanel login = new LoginPanel(sscgame);
                setVisible(false);
            }
        });
        
        
                 
        opt.add(userName);
        opt.add(logout);
        logout.setBackground(Color.orange);
        opt.add(play);
        play.setBackground(Color.orange);
        // disable play button until critera is met
        play.setEnabled(false);
        
        // panel 2
        JLabel lblnumObjects = new JLabel("Number of Objects: ");
        final JComboBox numObjects = new JComboBox(new Object[]
                {"4", "5","6","7","8","9","10","11","12","13","14","15","16","17","18",
                "19","20","21","22","23","24","25"});
        opt.add(lblnumObjects);
        opt.add(numObjects);
       
        // panel 3
        JLabel lblshapes = new JLabel("Shapes");
        opt.add(lblshapes);
        
        final JCheckBox sqr;
        final JCheckBox tri;
        final JCheckBox cir;
        shapes.add(sqr = new JCheckBox("Sqaure"));
        shapes.add(tri = new JCheckBox("Triangle"));
        shapes.add(cir = new JCheckBox("Circle"));
        opt.add(shapes);
        
        //Panel 4
        JLabel lblcolors;
        opt.add(lblcolors = new JLabel("Colors"));
        
        final JCheckBox red;
        final JCheckBox blue;
        final JCheckBox green;
        final JCheckBox purple;
        final JCheckBox orange;
        final JCheckBox yellow;
        colors.add(red = new JCheckBox("Red"));
        colors.add(blue = new JCheckBox("Blue"));
        colors.add(green = new JCheckBox("Green"));
        colors.add(purple = new JCheckBox("Purple"));
        colors.add(orange = new JCheckBox("Orange"));
        colors.add(yellow = new JCheckBox("Yellow"));
        opt.add(colors);
        
        // Panel 5
        JLabel lblLayout;
        opt.add(lblLayout = new JLabel("Layout"));
        final JRadioButton grid;
        JRadioButton diamond;
        layout.add(grid = new JRadioButton("Grid"));
        layout.add(diamond = new JRadioButton("Diamond"));
       
        grid.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(grid);
        group.add(diamond);
        
        opt.add(layout);
        
        //object size
        JLabel lblSize;
        opt.add(lblSize = new JLabel("Object Size: "));
        
        final JComboBox size;
        opt.add(size = new JComboBox( new Object[]
        {"Small", "Medium", "Large"}));
      
        
        opt.setBackground(Color.lightGray);
        
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // get info create game and launch game UI
                int selectedNumObjects = numObjects.getSelectedIndex() + 4;
                String layout;
                if(grid.isSelected())
                    layout = "grid";
                else
                    layout = "diamond";
                int selectedSize = size.getSelectedIndex();
                
                /* test code
                System.out.println("Object size");
                System.out.println(selectedSize);
                System.out.println("Layout");
                System.out.println(layout);
                System.out.println("Num Objects");
                System.out.println(selectedNumObjects);
                System.out.println("Selected shapes");
                for(String s: selectedShapes){
                    System.out.println(s);
                }
                System.out.println("Selected Colors");
                for(String s: selectedColors){
                    System.out.println(s);
                }
                */
                
                setVisible(false);
            }
        });
        
        // Shapes Listener
        sqr.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               if(sqr.isSelected()){
                   if(selectedShapes.indexOf("square") == -1)
                       selectedShapes.add("square");
               }
               else{
                   selectedShapes.remove("square");
               }
               enablePlay();
           }
        });
        
        tri.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               if(tri.isSelected()){
                   if(selectedShapes.indexOf("triangle") == -1)
                       selectedShapes.add("triangle");
               }
               else{
                   selectedShapes.remove("triangle");
               }
               enablePlay();
           }
        });
        
        cir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(cir.isSelected()){
                    if(selectedShapes.indexOf("circle") == -1)
                        selectedShapes.add("circle");
                }
                else{
                    selectedShapes.remove("circle");
                }
                enablePlay();
            }
        });
        
        // Color Listeners
        red.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(red.isSelected()){
                    if(selectedColors.indexOf("red") == -1)
                        selectedColors.add("red");
                }
                else{
                    selectedColors.remove("red");
                }
                enablePlay();
            }
        });
        
        yellow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(yellow.isSelected()){
                    if(selectedColors.indexOf("yellow") == -1)
                        selectedColors.add("yellow");
                }
                else{
                    selectedColors.remove("yellow");
                }
                enablePlay();
            }
        });
        
        blue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(blue.isSelected()){
                    if(selectedColors.indexOf("blue") == -1)
                        selectedColors.add("blue");
                }
                else{
                    selectedColors.remove("blue");
                }
                enablePlay();
            }
        });
        
        green.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(green.isSelected()){
                    if(selectedColors.indexOf("green") == -1)
                        selectedColors.add("green");
                }
                else{
                    selectedColors.remove("green");
                }
                enablePlay();
            }
        });
        
        purple.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(purple.isSelected()){
                    if(selectedColors.indexOf("purple") == -1)
                        selectedColors.add("purple");
                }
                else{
                    selectedColors.remove("purple");
                }
                enablePlay();
            }
        });
        
        orange.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(orange.isSelected()){
                    if(selectedColors.indexOf("orange") == -1)
                        selectedColors.add("orange");
                }
                else{
                    selectedColors.remove("orange");
                }
                enablePlay();
            }
        });
        
        
        add(opt);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }
    
    private void enablePlay(){
        if(selectedShapes.size() != 0 && selectedColors.size() != 0)
            play.setEnabled(true);
        else
            play.setEnabled(false);
    }

}
