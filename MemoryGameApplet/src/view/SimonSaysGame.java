
package view;

import java.awt.*;
import java.awt.event.*;
import model.GameObject;
import model.Player;
import model.SimonSays;

import javax.swing.*;

public class SimonSaysGame extends JApplet 
{
 //*****************login Menu***************************
	// **for login*** 
			private JButton Jbt, Jbt2, Jbt3;
			private JLabel sSays, entr, Hscr, JlName;
			private JTextField	Jtx;
			private JTextArea	JArea;
			
			//******for CreateUser Window********
			private JLabel jlName;
			private JTextField jtName;
			private JButton jbUser;
			
//*******************for options**************************
		    private JLabel userName, user;
			private JButton play, logout;
			// for panel 1
			private JLabel gOptions, NObjects;
			private JComboBox numObj;
			// for panel 2
			private JLabel shapes;
			private JCheckBox Sqr, Tri, Cir;
			
			// for panel 3
			private  JLabel Colors;
			private JCheckBox Red, Blue, Green, Purple, Orange, Yellow;
			
			// panel 4
			private JLabel layout;
			private JRadioButton grid, diamond;
			// panel 5
			private JLabel ObSize;
			private JComboBox size;
// ************** for game frame ***********************
			private  JButton quit;
			
// Class Variables
			private  int numberOfObjects = 4;
			private String NUsr;
			private  String Usr;
			/* holds array of shapes and colors selected by user to search 
			 * to filter size, shape, and colors to load to the object list. 
			*/
			private String [] Shape = new String[3];
			private String [] Clr = new String[6];
			//counters to enable play button 
			private int count1 = 0;
			private int count2 = 0;
			
			private String Sz;
			private String layOuts;
				
			
			public void init()
			{
				try
				{
					SimonSaysGame();
			
				}
				catch(Exception e)
				{
					System.err.println("Unable to start Game");
				}// end try/catch 
			}// end init
			
			
			private void SimonSaysGame()
			{
				//create frame for login
				
				final JPanel lg = new JPanel(new BorderLayout());
				JPanel labl = new JPanel(new FlowLayout());
				JPanel sel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 50));
				
				// ***createUser Frame***
				final JFrame cUser = new JFrame();
				cUser.setTitle("Create User");
				cUser.setSize(400,200);
				JPanel cUser1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,50));
				cUser1.add(jlName = new JLabel("Enter New Username:"));
				cUser1.add(jtName= new JTextField(15));
				cUser1.add(jbUser = new JButton("Create"));
				cUser1.setBackground(Color.lightGray);
				jbUser.setBackground(Color.ORANGE);
				// add to JFrame 
				cUser.add(cUser1);
				
				
				//***Settings and panels for login frame***
				setSize(400,500);
				labl.setBackground(Color.white);
				sel.setBackground(Color.lightGray);
				
				// labels and buttons
				labl.add(sSays = new JLabel("Simon Says"),BorderLayout.PAGE_START);
						sSays.setFont(new Font("SansSerif",Font.PLAIN, 30));
				sel.add(entr = new JLabel("Please Enter Username to begin:"));
				sel.add(Jtx = new JTextField(15));
				sel.add(Jbt = new JButton("Login"));
				sel.add(Jbt2 = new JButton("Create New User"));
				sel.add(Hscr = new JLabel("High Scores"));
				sel.add(JArea = new JTextArea("                               <<Scores go in this JTextArea>>", 600,50),BorderLayout.PAGE_END);
				
				JArea.setBackground(Color.gray);
				Jbt.setBackground(Color.ORANGE);
				Jbt2.setBackground(Color.ORANGE);
				lg.add(labl,BorderLayout.PAGE_START);
				lg.add(sel,BorderLayout.CENTER);
				
				add(lg);
				
			
	//************************options Menu************************************************
	
					
				
			// create main frame 
			   final JPanel opt = new JPanel(new FlowLayout(FlowLayout.CENTER,100,50));
			   JPanel label = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
			   JPanel sp = new JPanel(new GridLayout(3,2));
			   JPanel col = new JPanel(new GridLayout(3,2));
			   JPanel lay = new JPanel(new GridLayout(2,2));
			  
			  // create option frames 
			  
			  label.add(sSays = new JLabel(" Simon Says"));
			  sSays.setFont(new Font("SansSerif",Font.PLAIN, 30));
			  label.setBackground(Color.white);
			  gOptions = new JLabel("Game Options");
			  gOptions.setFont(new Font( "SansSerif",Font.PLAIN, 20));
	
			  		    
			   opt.add(label);
			   opt.add(userName = new JLabel("UserName: "));
			   opt.add(user = new JLabel());
			   opt.add(logout = new JButton("Logout"));
			   logout.setBackground(Color.orange);
			   opt.add(play = new JButton("Play! "));
			   play.setBackground(Color.orange);
			   // disable play button until critera is met
			   play.setEnabled(false);
			   opt.add(gOptions);
			   // panel 2
			   opt.add(NObjects = new JLabel("Number of Objects: "));
			   opt.add(numObj = new JComboBox(new Object[]
					   {"4", "5","6","7","8","9","10","11","12","13","14","15","16","17","18",
					   "19","20","21","22","23","24","25"}));
			   // add to main jpanel 
			  
			   // panel 3
			   opt.add(shapes = new JLabel ("Shapes"));
			   sp.add(Sqr = new JCheckBox("Sqaure"));
			   sp.add(Tri = new JCheckBox("Triangle"));
			   sp.add(Cir = new JCheckBox("Circle"));
			   // add check boxes to panel
			   opt.add(sp);
			   
			   //Panel 4
			   opt.add(Colors = new JLabel("Colors"));
			   col.add(Red = new JCheckBox("Red"));
			   col.add(Blue = new JCheckBox("Blue"));
			   col.add(Green = new JCheckBox("Green"));
			   col.add(Purple = new JCheckBox("Purple"));
			   col.add(Orange = new JCheckBox("Orange"));
			   col.add(Yellow = new JCheckBox("Yellow"));
			   // add to panel
			   opt.add(col);
			   
			   // Panel 5
			   opt.add(layout = new JLabel("Layout"));
			   lay.add(grid = new JRadioButton("Grid"));
			   lay.add(diamond = new JRadioButton("Diamond"));
			   grid.setSelected(true);
			   ButtonGroup group = new ButtonGroup();
			   group.add(grid);
			   group.add(diamond);
			   //add to panel
			   opt.add(lay);
			   
			   //object size
			   opt.add(ObSize = new JLabel("Object Size: "));
			   opt.add(size = new JComboBox( new Object[]
			   {"Small", "Medium", "Large"}));
			 
			   
			   opt.setBackground(Color.lightGray);
	
			   
			   //*********************Game GUI******************************************
			   final JPanel main = new JPanel(new BorderLayout());
			   JPanel gamePane = new JPanel();
	           //ImageIcon img = new ImageIcon("resources/Cir_Blue_Lg.png");
	           //gamePane.add(new JLabel(img),BorderLayout.CENTER);
			   main.add(quit = new JButton("quit"),BorderLayout.PAGE_START);
			   main.add(gamePane,BorderLayout.CENTER);		
			   		
			   
			   
			   //******************Action Listeners and events******************************
			
				//***** Login / create User menu's******
				//CreateUser action Event
				Jbt2.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e)
							{
								cUser.setVisible(true);
				                
							}
					
						});
					// create user button 
					jbUser.addActionListener(new ActionListener()
					 {
							public void actionPerformed(ActionEvent e)
					      {
						     NUsr= jtName.getText();
						     cUser.setVisible(false);
					      }
					});
				
			   
				// Login Action event 
				Jbt.addActionListener(new ActionListener()
				{
				
					public void actionPerformed(ActionEvent e)
					{
						//user and goes to options menu
					    user.setText(Jtx.getText());
						add(opt);
						setSize(400,900);
						lg.setVisible(false);
						opt.setVisible(true);
						
					
						
					}
				});
				
				//********Options Menu***********
				logout.addActionListener(new ActionListener()
				{
				
					public void actionPerformed(ActionEvent e)
					{
						// returns to login screen
			
						setSize(400,500);
						lg.setVisible(true);
						opt.setVisible(false);
					}

					
				});
				
				play.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						add(main);
						setSize(1000,900);
						opt.setVisible(false);
						main.setVisible(true);
						main.setLocation(700, 500);
					}
					
				});
				
				//Number of Objects ComboBox Listener
				 numObj.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						int numRounds = numObj.getSelectedIndex();
						
						
					}
					
				});
				 
				 // Shapes Listener
				 Sqr.addActionListener(new ActionListener()
				 {
					public void actionPerformed(ActionEvent e)
					{
						   if(Sqr.isSelected() == false)
						   {  
							 Shape[0] = "";
						   	 count1--;
						   }
						   else
						   {	   
							Shape[0] = "Sq";
						    count1++;
						   }
						   enablePlay();
					
					}
					 
				 });
				 Tri.addActionListener(new ActionListener()
				 {
					public void actionPerformed(ActionEvent e)
					{
						if(Tri.isSelected() == false)
						{
						   Shape[1] = "";
						   count1 --;
						}
						else	
						{
						   Shape[1] = "Tri";
						   count1++;
						}
						
						enablePlay();
					
						
					}
				 });
				 
				 Cir.addActionListener(new ActionListener()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						
						 if(Cir.isSelected() == false)
						 {
							   Shape[2] = "";
							   count1 --;
						 }
							else	
							{
							   Shape[2] = "Cir";
							   count1++;
							}
						 enablePlay();
						 
					 }
					 
				 });
				// Colors Check Box Listeners
				 Red.addActionListener(new ActionListener()
				 {
					 public void actionPerformed(ActionEvent e)
					 {

						 if(Red.isSelected() == false)
						 {
							   Clr[0] = "";
							   count2 --;
						 }
							else	
							{
							   Clr[0] = "Red";
							   count2++;
							}
						 enablePlay();
						 
					 }
				 });
				
				 Blue.addActionListener(new ActionListener()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						
						 if(Blue.isSelected() == false)
						 {
							   Clr[1] = "";
							   count2--;
						 }
							else	
							{
							   Clr[1] = "Blue";
							   count2++;
							}
						 enablePlay();
						 
					 }
				 });
				 
				 Green.addActionListener(new ActionListener()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						 
						 if(Green.isSelected() == false)
						 {
							   Clr[2] = "";
							   count2--;
						 }
							else	
							{
							   Clr[2] = "Green";
							   count2++;
							}
						enablePlay();
						 
					 }
				 });
				 
				 Purple.addActionListener(new ActionListener()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						 if(Purple.isSelected() == false)
						 {
							   Clr[3] = "";
							   count2--;
						 }
							else	
							{
							   Clr[3] = "Purple";
							   count2++;
							}
							enablePlay();
						 
					 }
				 });
				 
				 Orange.addActionListener(new ActionListener()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						 
						 if(Orange.isSelected() == false)
						 {
							   Clr[4] = "";
							   count2--;
						 }
							else	
							{
							   Clr[4] = "Orange";	
							   count2++;
							}
						 enablePlay();
						 
					 }
				 });
				 
				 Yellow.addActionListener(new ActionListener()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						 
						 if(Yellow.isSelected() == false)
						 {
							   Clr[5] = "";
							   count2--;
						 }
							else	
							{
							   Clr[5] = "Yellow";
							   count2++;
							}
						 enablePlay();
					 }
				 });
				
				//******** Object Size **********************
				 size.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent e)
						{
						  
							Sz = size.getSelectedItem().toString();
						}
						
					});
				 
				 //********layout******************
				 
				 grid.addActionListener(new ActionListener ()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						 layOuts = "grid";
					 }
					 
				 });
				 
				 diamond.addActionListener(new ActionListener ()
				 {
					 public void actionPerformed(ActionEvent e)
					 {
						 layOuts = "diamond";
					 }
					 
				 });
			
				
				//***************  Game *********************************
				
				quit.addActionListener(new ActionListener()
				{
					public void  actionPerformed (ActionEvent e)
					{
						
						setSize(400,900);
						main.setVisible(false);
						opt.setVisible(true);
					}
				});
				 
				
				
			   
		}// end of GUI's 	
			
			private void enablePlay()
			{
				if(count1 != 0 && count2 != 0)
					play.setEnabled(true);
				else 
					play.setEnabled(false);
				
			}
}// end class
