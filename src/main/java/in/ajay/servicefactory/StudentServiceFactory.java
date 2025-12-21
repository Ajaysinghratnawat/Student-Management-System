package in.ajay.servicefactory;

import in.ajay.service.RStudentService;
import in.ajay.service.StudentServiceImpl;

//Connection con = DriverManager.getconnection(url,username,password);
public class StudentServiceFactory {
	//singleton class
	//Make Constructor private to avoid object creation
	private StudentServiceFactory(){
		
	}
	private static RStudentService studentService = null;
	
	public static RStudentService getStudentService() {
		if(studentService==null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}
