package webapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnection {
	
	public static List<Student> getStudents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection(
		    		"jdbc:mysql://localhost:3306/university?characterEncoding=latin1&useConfigs=maxPerformance",
		    		"root","SuryaTeja@9192");
		    CallableStatement stmt = con.prepareCall("{call getDetails()}");
		    ResultSet rs = stmt.executeQuery();
		    List<Student> studentsList = new ArrayList<Student>();
		    while(rs.next()) {
		    	studentsList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), 
		    			rs.getInt(5), rs.getDouble(4), rs.getString(6)));
		    }
		    return studentsList;
		} catch(Exception e) {
			System.out.println(e);
		}
		return new ArrayList<Student>();
	}
	
	public static int insertStudent(Student student) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection(
		    		"jdbc:mysql://localhost:3306/university?characterEncoding=latin1&useConfigs=maxPerformance",
		    		"root","SuryaTeja@9192");
		    CallableStatement ps = con.prepareCall("{call insertData(?, ?, ?, ?, ?, ?)}");
		    ps.setInt(1, student.getRegNo());
		    ps.setString(2, student.getFirstName());
		    ps.setString(3, student.getLastName());
		    ps.setDouble(4, student.getCgpa());
		    ps.setInt(5, student.getBacklogsNo());
		    ps.setString(6, student.getPhoneNo());
		    return ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static int getBGL(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
		    		"jdbc:mysql://localhost:3306/university?characterEncoding=latin1&useConfigs=maxPerformance",
		    		"root","SuryaTeja@9192");
		    CallableStatement ps = con.prepareCall("{call getBGL(?)}");
		    ps.registerOutParameter(1, java.sql.Types.INTEGER);
		    ps.setInt(1, id);
		    ps.executeUpdate();
		    return ps.getInt(1);
		} catch(Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public static int noOfStudents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection(
		    		"jdbc:mysql://localhost:3306/university?characterEncoding=latin1&useConfigs=maxPerformance",
		    		"root","SuryaTeja@9192");
		    CallableStatement ps = con.prepareCall("{call noofStud(?)}");
		    ps.registerOutParameter(1, java.sql.Types.INTEGER);
		    ps.executeUpdate();
		    return ps.getInt(1);
		} catch(Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public static Student search(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
		    		"jdbc:mysql://localhost:3306/university?characterEncoding=latin1&useConfigs=maxPerformance",
		    		"root","SuryaTeja@9192");
		    CallableStatement ps = con.prepareCall("{call search(?)}");
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next()) {
		    	return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getDouble(4), rs.getString(6));
		    }
		    return null;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
