package in.ajay.daofactory;

import in.ajay.persistence.RStudentDao;
import in.ajay.persistence.StudentDaoImpl;

public class StudentDaoFactory {
	private StudentDaoFactory() {
		
	}
	
	private static RStudentDao studentDao = null;
	
	public static RStudentDao getstudentDao() {
		if(studentDao==null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
