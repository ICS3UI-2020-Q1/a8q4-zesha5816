import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

	JTextField inputText;
	JTextField outputText;

	JLabel nLabel;
	JLabel fLabel;

	JButton calcButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Factorial Calculator");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
		//initialize the main Jpanel
	  mainPanel = new JPanel();
	  //disable any layout helpers 
	  mainPanel.setLayout(null);
    
		//Create side labels 
    nLabel = new JLabel("n"); 
    fLabel = new JLabel("factorial(n)");

		//set the location and size of the labels
		nLabel.setBounds(100,100,100,25);
		fLabel.setBounds(250,100,100,25);

		//create text boxs for user input 
    inputText = new JTextField(); 
    outputText = new JTextField(); 

    //set location for the text boxes 
    inputText.setBounds(125,100,100,25); 
    outputText.setBounds(350,100,100,25);

		//add the button
		calcButton = new JButton("CALC");
		//set the size and location of this
		calcButton.setBounds(475,100,100,25);
		//Add an action listener to this 
		calcButton.addActionListener(this);
		//set the action commands to the button
		calcButton.setActionCommand("calc");

		//make it so that the user cant input in the output box
		outputText.setEnabled(false);

		//add it to the mainPanel
		mainPanel.add(nLabel);
		mainPanel.add(fLabel);
		mainPanel.add(inputText);
		mainPanel.add(outputText);
		mainPanel.add(calcButton);
		//add the panel to the frame
		frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
		// get the number from the user and make a string
    String userNumber = inputText.getText();
    // conver the string into integer
    int userNum =  Integer.parseInt(userNumber);
    // the accumulator
    int total = 0;
    // the factorial of the number 
    int factorial = 1;
    // for loop to find the factorial of the number
    for(int i = 1; i <= userNum; i = i+ 1 ){
      // add the numbers as it goes on
      total = total + i;
      // the factorial formula to find the factorial 
      factorial = i * factorial;
    }
    // put the factorial in the result text area 
    outputText.setText("" + factorial);
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
