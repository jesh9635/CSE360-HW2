package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Platform;
import databasePart1.*;

/**
 * The WelcomeLoginPage class displays a welcome screen for authenticated users.
 * It allows users to navigate to their respective pages based on their role or quit the application.
 */
public class WelcomeLoginPage {
	
	private final DatabaseHelper databaseHelper;

    public WelcomeLoginPage(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }
    public void show( Stage primaryStage, User user, QuestionList qList, AnswerList aList) {
    	
    	VBox layout = new VBox(5);
	    layout.setStyle("-fx-alignment: center; -fx-padding: 20;");
	    
	    Label welcomeLabel = new Label("Welcome to the discussion forum!\n What would you like to do");
	    welcomeLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
	    
	    // Button to navigate to the user's respective page based on their role
	    Button viewQuestions = new Button ("View Questions");
	    Button createQuestion = new Button ("Create Questions");
	    Button updateQuestion = new Button ("Update Question");
	    Button deleteQuestion = new Button ("Delete Question");
	    Button viewAnswers = new Button ("View Answers");
	    Button createAnswer = new Button ("Create Answer");
	    Button updateAnswer = new Button ("Update Answer");
	    Button deleteAnswer = new Button ("Delete Answer");


		/*
		 * Button continueButton = new Button("Continue to your Page");
		 * continueButton.setOnAction(a -> { String role =user.getRole();
		 * System.out.println(role);
		 * 
		 * if(role.equals("admin")) { new AdminHomePage().show(primaryStage); } else
		 * if(role.equals("user")) { new UserHomePage().show(primaryStage); } });
		 */
	    // Button to quit the application
	    Button quitButton = new Button("Quit");
	    quitButton.setOnAction(a -> {
	    	databaseHelper.closeConnection();
	    	Platform.exit(); // Exit the JavaFX application
	    });
	    viewQuestions.setOnAction (a -> {
	    	new viewQuestionsPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    createQuestion.setOnAction (a -> {
	    	new createQuestionsPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    updateQuestion.setOnAction (a -> {
	    	new updateQuestionPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    deleteQuestion.setOnAction (a -> {
	    	new deleteQuestionPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    viewAnswers.setOnAction (a -> {
			//Set actions to do on button click (Usually Validation of Data from Page using Other Class and/or Calling new page)
			//Any actions that deal with database need try-catch blocks
	    	new viewAnswersPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    createAnswer.setOnAction (a -> {
			//Set actions to do on button click (Usually Validation of Data from Page using Other Class and/or Calling new page)
			//Any actions that deal with database need try-catch blocks
	    	new createAnswersPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    updateAnswer.setOnAction (a -> {
			//Set actions to do on button click (Usually Validation of Data from Page using Other Class and/or Calling new page)
			//Any actions that deal with database need try-catch blocks
	    	new updateAnswerPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    deleteAnswer.setOnAction (a -> {
			//Set actions to do on button click (Usually Validation of Data from Page using Other Class and/or Calling new page)
			//Any actions that deal with database need try-catch blocks
	    	new deleteAnswerPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	    
	    // "Invite" button for admin to generate invitation codes
	    if ("admin".equals(user.getRole())) {
            Button inviteButton = new Button("Invite");
            inviteButton.setOnAction(a -> {
                new InvitationPage().show(databaseHelper, primaryStage);
            });
            layout.getChildren().add(inviteButton);
        }

	    layout.getChildren().addAll(welcomeLabel,viewQuestions,createQuestion,updateQuestion,deleteQuestion,viewAnswers, createAnswer,updateAnswer,deleteAnswer,quitButton);
	    Scene welcomeScene = new Scene(layout, 800, 400);

	    // Set the scene to primary stage
	    primaryStage.setScene(welcomeScene);
	    primaryStage.setTitle("Welcome Page");
    }
}