package application;

import databasePart1.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class viewQuestionsPage {
	private final DatabaseHelper databaseHelper; //Initialize the databaseHelper
	
	public viewQuestionsPage(DatabaseHelper databaseHelper){ //Constructor for setting database
		this.databaseHelper = databaseHelper;
	}
	
	public void show (Stage primaryStage, User user, QuestionList qList, AnswerList aList){ //Main Method
		//Set the objects (Labels, Fields, Button)
		Label instructions = new Label("View Questions Below");
	    Label question1 = new Label("");
	    Label question2 = new Label("");
	    Label question3 = new Label("");
        int index = 0;
        int size = qList.getList().size();
        if (!qList.getList().isEmpty()){
            if (index >= 0 && index < size) {
    		    if (qList.getList().get(index) != null) {
    		    	String[] questionData = qList.getList().get(index).read();
    		    	String text  = String.format("Q%d.%nQuestion: %s%nWritten By: %s%nDescription: %s%n", index+1, questionData[0], questionData[2], questionData[1]);
    		    	question1.setText(text);
    		    } else {
    		    	question1.setText("");
    		    }	
            }
    	    if (index+1 >= 0 && index+1 < size) {
    		    if (qList.getList().get(index+1) != null) {
    		    	String[] questionData = qList.getList().get(index+1).read();
    		    	String text  = String.format("Q%d.%nQuestion: %s%nWritten By: %s%nDescription: %s%n", index+2, questionData[0], questionData[2], questionData[1]);
    		    	question2.setText(text);
    		    } else {
    		    	question2.setText("");
    		    }
            }
    	    if (index+2 >= 0 && index+2 < size) {
    		    if (qList.getList().get(index+2) != null) {
    		    	String[] questionData = qList.getList().get(index+2).read();
    		    	String text  = String.format("Q%d.%nQuestion: %s%nWritten By: %s%nDescription: %s%n", index+3, questionData[0], questionData[2], questionData[1]);
    		    	question3.setText(text);
    		    } else {
    		    	question3.setText("");
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
        layout.getChildren().addAll(instructions, question1, question2, question3, back); //Place all objects (Labels, Fields, Button) in Layout	
	    Scene currScene = new Scene(layout, 800, 400); //Set window dimensions
	    
	    // Set the scene to primary stage
	    primaryStage.setScene(currScene);
	    primaryStage.setTitle("Create Question");
	}
}