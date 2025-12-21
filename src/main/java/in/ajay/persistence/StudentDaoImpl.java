package in.ajay.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.ajay.dto.Student;

public class StudentDaoImpl implements RStudentDao {
	private static final String DBURL = "jdbc:mysql://localhost:3306/studentmanagement";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "Ajay@9977";
	private static final String INSERTDATA = "insert into student_data(sname, sage, saddress) values(?,?,?)";
	private static final String DELETEDATA = "delete from student_data where sid = ?";
	private static final String READDATA = "select * from student_data where sid = ?";
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		String res = "fail";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			PreparedStatement pstmt = con.prepareStatement(INSERTDATA);
			pstmt.setString(1, sname);
			pstmt.setInt(2, sage);
			pstmt.setString(3, saddress);
			pstmt.executeUpdate();
			res = "success";
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return res;
	}

	@Override
	public Student searchStudent(Integer sid) {
		Student student =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			PreparedStatement pstmt = con.prepareStatement(READDATA);
			pstmt.setInt(1, sid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
		        student.setSage(rs.getInt("sage"));
		        student.setSaddress(rs.getString("saddress"));
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return student;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		String res= "fail";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			//
			PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM student_data WHERE sid = ?");
	        checkStmt.setInt(1, sid);
	        ResultSet rs = checkStmt.executeQuery();
	       
	        if (!rs.next()) {
	            con.close();
	            return "not_found";   // ← Very important
	        }
	        //
	        int count=0;
			if (!sname.equals("")) {
	            PreparedStatement pstmt = con.prepareStatement("UPDATE student_data SET sname = ? WHERE sid = ?");
	            pstmt.setString(1, sname);
	            pstmt.setInt(2, sid);
	            count += pstmt.executeUpdate();
	        }
			if (sage > 0) {
	            PreparedStatement pstmt = con.prepareStatement("UPDATE student_data SET sage = ? WHERE sid = ?");
	            pstmt.setInt(1, sage);
	            pstmt.setInt(2, sid);
	            count += pstmt.executeUpdate();
	        }
			if (!saddress.equals("")) {
	            PreparedStatement pstmt = con.prepareStatement("UPDATE student_data SET saddress = ? WHERE sid = ?");
	            pstmt.setString(1, saddress);
	            pstmt.setInt(2, sid);
	            count += pstmt.executeUpdate();
	        }
			con.close();
			if(count>0) {
				res = "success";
			}
			else {
				res="not_found";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return res;
	}

	@Override
	public String deleteStudent(Integer sid) {
		String res = "fail";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			PreparedStatement pstmt = con.prepareStatement(DELETEDATA);
			pstmt.setInt(1, sid);
			int rowaffected = pstmt.executeUpdate();
			con.close();
			if(rowaffected>0) {
				res = "success";
			}
			else {
				res = "not_found";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return res;
	}
}