import java.io.*;
import java.util.*;

public class GradeStudents {

    private static int[] rg;;

    static int[] gradingStudents(int[] grades) {
    	
    	for (int i=0; i<grades.length; i++) {
    		if (grades[i] < 38) {
    			//don't round it's a failing grade
    			grades[i] = grades[i];
    		}
    		else {
    			int r = grades[i] % 5;
    			if (r >=3) {
    				//Round up number and insert
    				grades[i] = (grades[i] + 4) / 5 * 5;   
    			}
    			else {
    				grades[i] = grades[i];
    			}
    		}
    	}
   	
     	return grades;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
   //     BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
        

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);
        for (int i=0; i<grades.length; i++ ) {
        	System.out.println(result[i]);
        }



    }
}