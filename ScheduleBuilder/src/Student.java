import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Student {

	
	
	public Student() throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader("src\\StudentData.txt"));
		Scanner s = new Scanner(System.in);
		
		while(s.hasNextLine()) {
			
			
			
		}
		
		
	}

}
