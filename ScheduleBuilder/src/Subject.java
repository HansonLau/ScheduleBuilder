import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Subject {
	private String subject;
	private ArrayList<String> teachers = new ArrayList<String>();
	
	public Subject(String subject) {
		this.subject = subject;
		//createTeacherList();
	}

	/*
	private void createTeacherList(){
		BufferedReader br = new BufferedReader(new FileReader("src\\TeacherData.txt"));
		String s = "";
		ArrayList<String> lines = new ArrayList<String>();
		
		while(s!=null)
		{
			try 
			{   //read each line into a String
				s= br.readLine();
				if(s!=null)  //add names to an ArrayList
					lines.add(s);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:lines)
		{  
			createTeacher(x);
		}
	}
	*/
	
	
}
