package application;

import databasePart1.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class viewAnswersPage {
	private final DatabaseHelper databaseHelper; //Initialize the databaseHelper
	
	public viewAnswersPage(DatabaseHelper databaseHelper){ //Constructor for setting database
		this.databaseHelper = databaseHelper;
	}
	
	public void show (Stage primaryStage, User user, QuestionList qList, AnswerList aList){ //Main Method
		//Set the objects (Labels, Fields, Button)
		Label instructions = new Label("View Answers Below");
	    Label answer1 = new Label("");
	    Label answer2 = new Label("");
	    Label answer3 = new Label("");
        int index = 0;
        int size = aList.getList().size();
        if (!aList.getList().isEmpty()){
            if (index >= 0 && index < size) {
    		    if (aList.getList().get(index) != null) {
    		    	String[] answerData = aList.getList().get(index).read();
    		    	String text  = String.format("A%d.%nQuestion being Answered: %s%nAnswer: %s%nWritten by: %s%n", index+1, answerData[0], answerData[1], answerData[2]);
    		    	answer1.setText(text);
    		    } else {
    		    	answer1.setText("");
    		    }	
            }
    	    if (index+1 >= 0 && index+1 < size) {
    		    if (aList.getList().get(index+1) != null) {
    		    	String[] answerData = aList.getList().get(index+1).read();
    		    	String text  = String.format("A%d.%nQuestion being Answered: %s%nAnswer: %s%nWritten by: %s%n", index+2, answerData[0], answerData[1], answerData[2]);
    		    	answer2.setText(text);
    		    } else {
    		    	answer2.setText("");
    		    }
            }
    	    if (index+2 >= 0 && index+2 < size) {
    		    if (aList.getList().get(index+2) != null) {
    		    	String[] answerData = aList.getList().get(index+2).read();
    		    	String text  = String.format("A%d.%nQuestion being Answered: %s%nAnswer: %s%nWritten by: %s%n", index+3, answerData[0], answerData[1], answerData[2]);
    		    	answer3.setText(text);
    		    } else {
    		    	answer3.setText("");
    		    }
    	    }	
        }


//        Button next = new Button("Next");
//	    next.setOnAction (a -> {
//	    	index = index + 3;
//	    	
//		});
//        Button previous = new Button("Previous");
//	    previous.setOnAction (a -> {
//	    	index = index - 3;
//		});
//	
        Button back = new Button("Return to Menu");
	    back.setOnAction (a -> {
	    	new WelcomeLoginPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	

		//Set the layout
	    VBox layout = new VBox(5); // Set Vertical Layout for children with int spacing
	    layout.setStyle("-fx-padding: 20; -fx-alignment: center;"); //Style the Layout
        layout.getChildren().addAll(instructions, answer1, answer2, answer3, back); //Place all objects (Labels, Fields, Button) in Layout	
	    Scene currScene = new Scene(layout, 800, 400); //Set window dimensions
	    
	    // Set the scene to primary stage
	    primaryStage.setScene(currScene);
	    primaryStage.setTitle("Create Answer");
	}
}