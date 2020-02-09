//*******************************************************************
//	ITC 115 - Assignment 5 - calcGPA class/printGPA method
//  a method named printGPA that calculates a student's grade point average.
//	The user will type a line of input containing the student's name,
//	then a number of scores, followed by that many integer scores.
//	Here are two example dialogues:
//	
//	Enter a student record: Maria 5 72 91 84 89 78
//	Maria's grade is 82.8
//	Enter a student record: Jordan 4 86 71 62 90
//	Jordan's grade is 77.25
//	For example, Maria's grade is 82.80 because her average of
//	(72 + 91 + 84 + 89 + 78) / 5 equals 82.8. Use a Scanner for user input.
//
//	By: Mike Gilson
//	Date: 2/6/2020
//*******************************************************************



import java.util.Scanner;
public class calcGPA {

	public static void main(String[] args) {
		
// 	I created three "dummy" Scanners for Test Case purposes.
//	Through random experimenting, I discovered you can replace
// 	"System.in" with a String, and it actually works.  Surprised me!

		Scanner test1 = new Scanner("Maria 5 72 91 84 89 78");
		printGPA(test1); // produces expected 82.80 percentage and 3.14 GPA
		
		Scanner test2 = new Scanner("Jordan 4 86 71 62 90");
		printGPA(test2); // produces expected 77.25 percentage and 2.86 GPA

//	This Test Case ensures additional test scores beyond those determined by
//	the first int are ignored. only the [100, 93, 86] scores should be used.
		
		Scanner test3 = new Scanner("Sarah 3 100 93 86 52 30 10");
		printGPA(test3);  // produces expected 93.00 percentage and 3.65 GPA
		
		
//	This one takes in actual user input:
		Scanner console = new Scanner(System.in);
		System.out.print("\nEnter a student record, number of tests, and their scores: ");
		printGPA(console);
		
	} // End of main
	
// 	creates the printGPA method, with a Scanner object as a parameter
	public static void printGPA(Scanner console) {
		
// 	A happy accident revealed that by having two Scanner objects back-to-back, one 
//	for next string (which automatically grabs the first token, up to the space),
//	and the next token gets picked up by nextInt, avoiding having to cut up a String
//	into substrings that need to be converted into ints.
//  The first gets the "name", the second creates the int for the number of test scores.
		
	    String name = console.next();
	    int numTest = console.nextInt();
	    
//	Create variable as type double for adding up all test numbers.
//	A for loop to iterate through a number of times equal to numTest. By putting the
//	grade Scanner in the for loop, it will automatically take in each test score after
//	the numTest int and add them together as "total".
	    
	    double total = 0.0;
	    for (int i = 1; i <= numTest; i++) {
	    	int grade = console.nextInt();  
	        total += grade;
	        
	    } //End for loop

//	Create an average variable of type double that will take the sum total of the grades
//	and divide them by the total number of tests to get the percentile average.
	    
	    double average = total / numTest;
	    
//	I used printf to limit the average number to 2 decimal places, and opted to include
//	the GPA conversion based on a formula found online. I then used printf a second time
//	to add enough character width to have the percentage and GPA versions line up, also
//	limiting the decimal places to 2.
	    
	    System.out.println();
	    System.out.printf(name + "'s grade is: %.2f\n", average);
	    double gpa = (average/20) - 1;
	    System.out.printf(name + "'s GPA is: %7.2f", gpa);
	    
	}  // End of printGPA method
	
} // End of calcGPA class
