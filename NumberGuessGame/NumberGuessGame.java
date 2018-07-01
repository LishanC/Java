/** Guess Hi-Lo 
  * The program randomly picks a number from 1-100.
  * The user enters their guess into a text field and either presses "enter" or clicks a 
  * button to submit the guess (you can decide).
  * Display a message about whether the guess was too low, too high, or correct.
  * Allow the user to continue guessing until they get it.
  * allow the user to play again once they have guessed correctly.
*
* @author Lishan Chan
*/

package week4;

import java.util.Random;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class NumberGuessGame extends Application{
	
	    private Text numberFieldLabel;
	    private Button guessButton, clearButton;
	    private TextField inputField;
	    private Text resultText;
	    private int targetnumber= new Random().nextInt(100) + 1;
	       
	    
	    public void start(Stage primaryStage) {
		
	    //set up a GridPane
		GridPane gridPane=new GridPane();
		gridPane.setStyle("-fx-background-color: beige");
		gridPane.setVgap(20);
		gridPane.setAlignment(Pos.CENTER);
		
		numberFieldLabel=new Text("Enter a number between 1 to 100: ");
		numberFieldLabel.setFont(Font.font("Times New Roman", 16));
		numberFieldLabel.setFill(Color.BLUE);
		inputField=new TextField();
		
		//set up a TilePane and add to GridPane
		TilePane numberPane = new TilePane(numberFieldLabel, inputField);
		gridPane.add(numberPane, 0, 0);
		
		//set up another TilePane and add to GridPane
		guessButton=new Button("Submit");
		guessButton.setOnAction(this::handleGuessButton);  //when click submit will call method handleGuessButton
		clearButton=new Button("Play again");
		clearButton.setOnAction(this::handleClearButton);// when click play again will call method handleClearButton
		TilePane buttonPane=new TilePane(guessButton, clearButton);
		gridPane.add(buttonPane,0,1);
		
		resultText=new Text("");
		gridPane.add(resultText, 0, 2);
		
		//view the layout pane
		Scene scene=new Scene(gridPane, 400, 200);
		primaryStage.setTitle("This is Guess Number Game");
		primaryStage.setScene(scene);
		primaryStage.show();

	    }
	    
	    //when press play again, it will clear all the input and result and allow user to input number
	    private void handleClearButton(ActionEvent event) {
	    	
	    	targetnumber = new Random().nextInt(100) + 1;
	  		 resultText.setText("");
	  		 inputField.setText("");
	    }
	    
	  //when press submit ,a message whether the guess is too high or too low or right number
		private void handleGuessButton(ActionEvent event) {
			try {
			    resultText.setText("guess number ");
			    int inputNumber = Integer.parseInt(inputField.getText());
			      String str="";
		        	
				    if(inputNumber> targetnumber) {
					   str=  inputNumber + " is too high ";		
				    }
				    else if(inputNumber <targetnumber) {
					   str=   inputNumber + " is too low ";			          
				    }
				    else if(inputNumber == targetnumber) {				    	
					   str= inputNumber + " Congratulation, you guess the right number" ;
				    }
				    resultText.setText(str);
				    resultText.setFont(Font.font("Times New Roman", 20));
					resultText.setFill(Color.BLACK);
			  }	catch (NumberFormatException ex) {
					resultText.setText("Error: not a number!");
					resultText.setFill(Color.RED);
				} 
		}

	
	public static void main(String[] args) {
		launch(args);

	}
}
