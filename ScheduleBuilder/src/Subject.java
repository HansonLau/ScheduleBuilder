import java.util.*;

//may delete later

public class Subject {
	private String subject;
	private ArrayList<String> teachers = new ArrayList<String>();
	
	public Subject(String subject) {
		this.subject = subject;
		createTeacherList();
	}

	private void createTeacherList(){
	}
}
