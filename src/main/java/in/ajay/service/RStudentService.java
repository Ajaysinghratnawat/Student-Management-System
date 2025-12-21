package in.ajay.service;

import in.ajay.dto.Student;

public interface RStudentService {
	//operations to be implemented
	
	public String addStudent(String sname,Integer sage,String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Integer sid,String sname,Integer sage,String saddress);
	
	public String deleteStudent(Integer sid);
}
