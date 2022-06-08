package webapp;

public class Student {
	private int regNo, backlogsNo;
	private String firstName, lastName, phoneNo;
	private double cgpa;
	
	public Student(int regNo, String firstName, String lastName, int backlogsNo, double cgpa, String phoneNo) {
		this.regNo = regNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.backlogsNo = backlogsNo;
		this.cgpa = cgpa;
		this.phoneNo = phoneNo;
	}
	
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	
	public int getRegNo() {
		return this.regNo;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setBacklagsNo(int backlogsNo) {
		this.backlogsNo = backlogsNo;
	}
	
	public int getBacklogsNo() {
		return this.backlogsNo;
	}
	
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	public double getCgpa() {
		return this.cgpa;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getPhoneNo() {
		return this.phoneNo;
	}
	
	public String toString() {
		return "RegNo: " + this.regNo + "\tFirst Name: " + this.firstName + "\tLast Name: " + this.lastName + "\tBacklogs No: " + this.backlogsNo + "\tCGPA: " + this.cgpa + "\tPhone No: " + this.phoneNo;
	}
}
