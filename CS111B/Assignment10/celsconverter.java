package celsconverter;

import javax.swing.*;      //needed for Swing classes
import java.awt.event.*;   //needed for ActionListener Interface

public class CelsConverter extends JFrame
{
    private JPanel panel;      //to reference a panel
    private JTextField celsTextField;  //to reference a text field
    private JButton calcButton;        //to reference a button
    private JLabel f_label;            //to reference a label
    private JLabel label;              //to reference a label
    private final int WINDOW_WIDTH=250;  //window width
    private final int WINDOW_HEIGHT=100; //window height

    //constructor
    public CelsConverter()
    {
       //set the window title
       setTitle("Celcius Converter");  
       //set the size of the window
       setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       //specify when the close button is clicked the window will be closed
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       //build the panel and add it to the frame
       buildPanel();
       add(panel);
       
       //display the window
       setVisible(true);
    }

    //the buildPanel method adds a text field, button and panel
    private void buildPanel()
    {
    	//create text field 10 characters wide
       celsTextField =new JTextField(10);
       //create button with the caption "Convert"
       calcButton =new JButton("Convert");
       //create label and set visible to false
       f_label=new JLabel("Farenheit: ");
       f_label.setVisible(false);
       label=new JLabel();
       label.setVisible(false);

       //add an action listener to the button
       calcButton.addActionListener(new CalcButtonListener());
 
       //create a JPanel object and let the panel field reference it
       panel = new JPanel();
       
       //add the text field, button and label components to the panels
       panel.add(celsTextField);
       panel.add(calcButton);
       panel.add(f_label);
       panel.add(label);
    }

    //CalcButtonListener is an action listener class for the Convert button
    private class CalcButtonListener implements ActionListener
    {

       //the actionPerformed method executes when the user clicks on the convert button
       public void actionPerformed(ActionEvent e)
       {
           String input;    //to hold the user input
           int temperture;  //to hold the convert farenheit 
           
           input=celsTextField.getText();
  
           //Celius convert to farenheit
           temperture=(int) (Integer.parseInt(input) * 1.8 + 32);  
    
           //display label
           String labelText=temperture + " degrees";
   		   label.setText(labelText);
           f_label.setVisible(true);
           label.setVisible(true);
       }
    }
}
