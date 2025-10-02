package application;

public class Answer{
	//Set public and private static variables
	private String question = "";
	private String description = "";
	private String user = "";
	//Set public and private static functions
	public Answer(String question, String description, String user) {
		this.question = question;
		this.description = description;
		this.user = user;
	}
	public void update(String question, String description, String user) {
		this.question = question;
		this.description = description;
		this.user = user;	
	}
	public String[] read() {
		String[] stringArray = {question, description, user};
		return stringArray;
	}
}