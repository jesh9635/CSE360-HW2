package application;

public class Question{
	//Set public and private static variables
	private String title = "";
	private String description = "";
	private String user = "";
	//Set public and private static functions
	public Question(String title, String description, String user) {
		this.title = title;
		this.description = description;
		this.user = user;
	}
	public void update(String title, String description, String user) {
		this.title = title;
		this.description = description;
		this.user = user;	
	}
	public String[] read() {
		String[] stringArray = {title, description, user};
		return stringArray;
	}
}