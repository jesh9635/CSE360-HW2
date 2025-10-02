package application;

import java.util.ArrayList;

public class AnswerList{
	//Set public and private static variables
	private ArrayList<Answer> list = new ArrayList<Answer>();
	//Set public and private static functions
	public void add(Answer answer) {
		list.add(answer);
	}
	public void delete(String answerDescription) {
		int index = search(answerDescription);
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
    public ArrayList<Answer> getList() {
        return list;
    }
}