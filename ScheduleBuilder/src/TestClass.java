import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestClass {
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Subject> subjects = new ArrayList<Subject>(); //may delete later
	private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();	
	private static ArrayList<Class> classes = new ArrayList<Class>();	
	
	public static void main(String[] args) throws FileNotFoundException { //This is main method, must run in this class
		BufferedReader br = new BufferedReader(new FileReader("src\\StudentData"));
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
		br = new BufferedReader(new FileReader("src\\TeacherData"));
		
		while(t!=null)
		{
			try 
			{   //read each line into a String
				t= br.readLine();
				if(t!=null)  //add names to an ArrayList
					tdata.add(t);
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
		/*
		String c = "";
		ArrayList<String> cdata = new ArrayList<String>();
		br = new BufferedReader(new FileReader("src\\ClassData"));
		
		while(c!=null)
		{
			try 
			{   //read each line into a String
				c= br.readLine();
				if(c!=null)  //add names to an ArrayList
					cdata.add(c);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:cdata)
		{  
			makeClass(x);
		}
		*/
		
		// may delete later
		br = new BufferedReader(new FileReader("src\\SubjectData"));
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
		
		
		
		//run method from scheduler class
		
		Scheduler roster = new Scheduler(students, teachers);
		roster.schedule();
		roster.showSchedule();
		
		
		
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
		int secondComma = p.substring(p.indexOf(",") + 1).indexOf(",") + fn.length() + 1;
		String ln = p.substring(p.indexOf(",")+1, secondComma);

		int thirdComma = p.substring(secondComma + 1).indexOf(",") + secondComma + 1;
		String grade = p.substring(secondComma + 1, thirdComma);
		
		int fourthComma = p.substring(thirdComma+1).indexOf(",") + thirdComma + 1;
		String start = p.substring(thirdComma+1, fourthComma);
		
		int fifthComma = p.substring(fourthComma+1).indexOf(",") + fourthComma + 1;
		String stop = p.substring(fourthComma+1, fifthComma); 
		
		ArrayList <String> choices = new ArrayList<String>();
		for(int i = fifthComma;i<p.length();i++)
		{    //split the name at delimiter "," 
			if(p.charAt(i)==',')
			{ 
				int end = p.substring(i+1).indexOf(",") + i + 1;
				if (p.substring(i+1).indexOf(",")==-1)
					end = p.length();
				choices.add(p.substring(i+1, end));
			}
		}
		
		students.add(new Student(fn, ln, grade, choices, start, stop));
		
	}
	
	public static void makeTeacher(String p){
		
		String fn = p.substring(0,p.indexOf(","));
		int secondComma = p.substring(p.indexOf(",") + 1).indexOf(",") + fn.length() + 1;
		String ln = p.substring(p.indexOf(",")+1, secondComma);
		
		int thirdComma = p.substring(secondComma+1).indexOf(",") + secondComma + 1;
		String prep = p.substring(secondComma+1, thirdComma);
		
		int fourthComma = p.substring(thirdComma+1).indexOf(",") + thirdComma + 1;
		String min = p.substring(thirdComma+1, fourthComma);
		
		int fifthComma = p.substring(fourthComma+1).indexOf(",") + fourthComma + 1;
		String max = p.substring(fourthComma+1, fifthComma);
		
		ArrayList<String> classes= new ArrayList<String>();
		for(int i = fifthComma;i<p.length();i++)
		{    //split the name at delimiter "," 
			if(p.charAt(i)==',')
			{ 
				int end = p.substring(i+1).indexOf(",") + i + 1;
				if (p.substring(i+1).indexOf(",")==-1)
					end = p.length();
				classes.add(p.substring(i+1, end));
				
			}
			
		}
		
		teachers.add(new Teacher(fn, ln, classes, prep, min, max));
		
	}
	/*
	public static void makeClass(String p){
		
		String subject = p.substring(0,p.indexOf(","));
		int secondComma = p.substring(p.indexOf(",") + 1).indexOf(",") + subject.length() + 1;
		String period = p.substring(p.indexOf(",") + 1, secondComma);

		int thirdComma = p.substring(secondComma + 1).indexOf(",") + secondComma + 1;
		String min = p.substring(secondComma + 1, thirdComma);
		
		String max = p.substring(thirdComma+1);
	
		//int p = Integer.parseInt(period);
		//int minimum = Integer.parseInt(min);
		//int maximum = Integer.parseInt(max);
		
		classes.add(new Class(subject, period, minimum, maximum));
		
	}
	*/
	// may delete later
	public static void makeSubject(String p) {
		for (int i = 0; i < p.length(); i++) {
			String subject = p.substring(0,i);
			
		}
	}

	
	
	

}
