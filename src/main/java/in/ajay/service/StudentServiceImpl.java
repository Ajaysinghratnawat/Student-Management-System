package in.ajay.service;

import in.ajay.daofactory.StudentDaoFactory;
import in.ajay.dto.Student;
import in.ajay.persistence.RStudentDao;

public class StudentServiceImpl implements RStudentService {

//	RStudentService stdService;
//	public String addStudent(String sname, Integer sage, String saddress) {
//		stdService=StudentServiceFactory.getStudentService();
//		return stdService.addStudent(sname, sage, saddress);
//	}
	RStudentDao stdService;
	public String addStudent(String sname, Integer sage, String saddress) {
		stdService= StudentDaoFactory.getstudentDao();
		return stdService.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
	    stdService = StudentDaoFactory.getstudentDao();
	    return stdService.searchStudent(sid);
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
	    stdService = StudentDaoFactory.getstudentDao();
	    return stdService.updateStudent(sid, sname, sage, saddress);
	}

	@Override
	public String deleteStudent(Integer sid) {
	    stdService = StudentDaoFactory.getstudentDao();
	    return stdService.deleteStudent(sid);
	}

}
