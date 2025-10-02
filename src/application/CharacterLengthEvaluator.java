package application;

public class CharacterLengthEvaluator{
	public static boolean evaluate(String input, String textType) {
		if (textType.equals("title")) {
			if (input.length() <= 30) {
				return true;
			} else {
				return false;
			}
		} else if (textType.equals("description")) {
			if (input.length() <= 350) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;	
		}
	}
}
