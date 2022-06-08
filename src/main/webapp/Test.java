package webapp;

import java.util.Iterator;
import java.util.Scanner;

public class Test {
	private static final Scanner s = new Scanner(System.in);
	
	private static void displayMenu() {
		System.out.println("MENU");
		System.out.println("1. Get All Students Details");
		System.out.println("2. Search for Student by ID");
		System.out.println("3. Insert a Student record");
		System.out.println("4. Get the Number of records");
		System.out.println("5. Get backlogs of a student with ID");
	}
	
	private static int getChoice() {
		displayMenu();
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();
		return choice;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean isRunning = true;
		while(isRunning) {
			int id = 0;
			switch(getChoice()) { 
			case 1: 
				Iterator<Student> it = JDBCConnection.getStudents().iterator();
				System.out.println("Student Details: ");
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				System.out.println();
			break;
			case 2: 
				System.out.print("Enter the ID: ");
				id = s.nextInt();
				System.out.println(JDBCConnection.search(id));
			break;
			case 3:
				System.out.print("Enter ID: ");
				id = s.nextInt();
				System.out.print("Enter First Name: ");
				String firstName = s.next();
				System.out.print("Enter Last Name: ");
				String lastName = s.next();
				System.out.print("Enter CGPA: ");
				double cgpa = s.nextDouble();
				System.out.print("Enter Backlog Count: ");
				int backlogs = s.nextInt();
				System.out.print("Enter phone number: ");
				String phoneNo = s.next();
				int count = JDBCConnection.insertStudent(new Student(id, firstName, lastName, backlogs, cgpa, phoneNo));
				if(count == 1) {
					System.out.println("Insertion Successful");
				} else {
					System.out.println("Insertion failed");
				}
				break;
			case 4:
				System.out.println("No. of records: " + JDBCConnection.noOfStudents());
				break;
			case 5:
				System.out.println("Enter the ID to find the backlogs: ");
				id = s.nextInt();
				System.out.println("Backlog Count for " + id + ": " + JDBCConnection.getBGL(id));
				break;
			default:
				System.out.println("Stopped.");
				isRunning = true;
			}
		}
		s.close();
	}

}
