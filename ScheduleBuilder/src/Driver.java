import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Subject> subjects = new ArrayList<Subject>();
	private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();	
	
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("src\\StudentData.txt"));
		String s = "";
		ArrayList<String> sdata = new ArrayList<String>();
		
		while(s!=null)
		{
			try 
			{   //read each line into a String
				s= br.readLine();
				if(s!=null)  //add names to an ArrayList
					sdata.add(s);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:sdata)
		{  
			makeStudent(x);
		}
		
		String t = "";
		ArrayList<String> tdata = new ArrayList<String>();
		br = new BufferedReader(new FileReader("src\\TeacherData.txt"));
		
		while(t!=null)
		{
			try 
			{   //read each line into a String
				t= br.readLine();
				if(s!=null)  //add names to an ArrayList
					tdata.add(s);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:tdata)
		{  
			makeTeacher(x);
		}
/*
		BufferedReader br = new BufferedReader(new FileReader("src\\StudentData.txt"));
		String s = "";
		ArrayList<String> sdata = new ArrayList<String>();
		
		while(s!=null)
		{
			try 
			{   //read each line into a String
				s= br.readLine();
				if(s!=null)  //add names to an ArrayList
					sdata.add(s);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:sdata)
		{  
			makeStudent(x);
		}
		
		br = new BufferedReader(new FileReader("src\\TeacherData.txt"));
		s = "";
		ArrayList<String> tdata = new ArrayList<String>();
		
		while(s!=null)
		{
			try 
			{   //read each line into a String
				s= br.readLine();
				if(s!=null)  //add names to an ArrayList
					tdata.add(s);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:tdata)
		{  
			makeTeacher(x);
		}
		*/
		br = new BufferedReader(new FileReader("src\\SubjectData.txt"));
		ArrayList<String> subjectNames = new ArrayList<String>();
		s = "";
		
		while(s!=null)
		{
			try 
			{   //read each line into a String
				s= br.readLine();
				if(s!=null)  //add names to an ArrayList
					subjectNames.add(s);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:subjectNames)
		{  
			subjects.add(new Subject(s));
		}
		
	}
	
	/*
	public static void makeStudent(String p) 
	{
		for(int i = 0;i<p.length();i++)
		{    //split the name at , or space delimeter , 
			if(p.charAt(i)==' '||p.charAt(i)==',')
			{ 
				String fn = p.substring(0,i);
				int secondComma = p.substring(i + 1).indexOf(",");
				String ln = p.substring(i+1, secondComma);
				
				String grade = p.substring(secondComma + 1);
				students.add(new Student(fn, ln, grade));
			}
		}
		
	}
	
	public static void makeTeacher(String p) 
	{
		ArrayList<String> courses= new ArrayList<String>();
		for(int i = 0;i<p.length();i++)
		{    //split the name at , or space delimeter , 
			if(p.charAt(i)==',')
			{ 
				String fn = p.substring(0,i);
				int secondComma = p.substring(i + 1).indexOf(",");
				String ln = p.substring(p.indexOf(","), secondComma);
				
				
				courses.add(p.substring(i+1, p.substring(secondComma).indexOf(",")));
				
			}
			
			
			teachers.add(new Teacher(fn, ln, grade));
		}
		
	}
*/
	public static void makeStudent(String p){
		
		String fn = p.substring(0,p.indexOf(","));
		int secondComma = p.substring(p.indexOf(",") + 1).indexOf(",");
		String ln = p.substring(p.indexOf(","), secondComma);

		String grade = p.substring(secondComma + 1);
		int thirdComma = p.substring(secondComma + 1).indexOf(",");
		
		ArrayList <String> choices = new ArrayList<String>();
		for(int i = thirdComma;i<p.length();i++)
		{    //split the name at , or space delimeter , 
			if(p.charAt(i)==',')
			{ 
				int end = p.substring(i+1, p.length()).indexOf(",");
				if (end==-1)
					end = p.length();
				choices.add(p.substring(i+1, end));
			}
		}
		
		students.add(new Student(fn, ln, grade, choices));
		
	}
	
	public static void makeTeacher(String p){
		
		String fn = p.substring(0,p.indexOf(","));
		int secondComma = p.substring(p.indexOf(",") + 1).indexOf(",");
		String ln = p.substring(p.indexOf(","), secondComma);
		
		ArrayList<String> classes= new ArrayList<String>();
		for(int i = secondComma;i<p.length();i++)
		{    //split the name at , or space delimeter , 
			if(p.charAt(i)==',')
			{ 
				int end = p.substring(i+1, p.length()).indexOf(",");
				if (end==-1)
					end = p.length();
				classes.add(p.substring(i+1, end));
				
			}
			
			
			teachers.add(new Teacher(fn, ln, classes));
		}
		
	}

	public static void makeSubject(String p) {
		for (int i = 0; i < p.length(); i++) {
			String subject = p.substring(0,i);
			
			
		}
	}
	

}
