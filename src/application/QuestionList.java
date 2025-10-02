package application;

import java.util.ArrayList;

public class QuestionList{
	//Set public and private static variables
	private ArrayList<Question> list = new ArrayList<Question>();
	//Set public and private static functions
	public void add(Question question) {
		list.add(question);
	}
	public void delete(String questionTitle) {
		int index = search(questionTitle);
		if (index != -1) {
			list.remove(index);
		}
	}
	public void delete(int index) {
		if (index >= 0) {
			list.remove(index);
		}
	}
	private int search(String questionTitle) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).read()[0] == questionTitle) {
				return i;
			}
		}
		return -1;
	}
    public ArrayList<Question> getList() {
        return list;
    }
}