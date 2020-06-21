import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	private static ArrayList<Student> students = new ArrayList<Student>();
	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader("src\\StudentData.txt"));
		String s = "";
		ArrayList<String> names = new ArrayList<String>();
		
		while(s!=null)
		{
			try 
			{   //read each line into a String
				s= br.readLine();
				if(s!=null)  //add names to an ArrayList
					names.add(s);
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
		}
		for(String x:names)
		{  
			makeStudent(x);
		}
		
	}
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
	

}
