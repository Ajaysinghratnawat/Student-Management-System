package in.ajay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

import in.ajay.dto.Student;
import in.ajay.service.RStudentService;
import in.ajay.servicefactory.StudentServiceFactory;

public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init method called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String action = req.getParameter("action");
        RStudentService stdService = StudentServiceFactory.getStudentService();

        if (action == null) {
            out.println("<h2>No action provided.</h2>");
            return;
        }

        switch (action.toLowerCase()) {

	        case "add":
	            String name = req.getParameter("name");
	            Integer age = Integer.parseInt(req.getParameter("age"));
	            String address = req.getParameter("address");
	
	            out.println("<h2>" + stdService.addStudent(name, age, address) + "</h2>");
	            break;
	
	        case "search":
	            Integer id = Integer.parseInt(req.getParameter("id"));
	            Student s = stdService.searchStudent(id);
	
	            if (s != null) {
	                out.println("<h2>Student Found</h2>");
	                out.println("ID : " + s.getSid() + "<br>");
	                out.println("Name : " + s.getSname() + "<br>");
	                out.println("Age : " + s.getSage() + "<br>");
	                out.println("Address : " + s.getSaddress() + "<br>");
	            } else {
	                out.println("<h2>No student found with ID " + id + "</h2>");
	            }
	            break;
	
	        case "update":
	            Integer uid = Integer.parseInt(req.getParameter("id"));
	            String uname = req.getParameter("name");
	            Integer uage = Integer.parseInt(req.getParameter("age"));
	            String uaddress = req.getParameter("address");
	
	            out.println("<h2>" + stdService.updateStudent(uid, uname, uage, uaddress) + "</h2>");
	            break;
	
	        case "delete":
	            Integer did = Integer.parseInt(req.getParameter("id"));
	            out.println("<h2>" + stdService.deleteStudent(did) + "</h2>");
	            break;
	
	        default:
	            out.println("<h2>Invalid action!</h2>");
	        }
	
	        out.close();
    	}
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//
//		String action = req.getParameter("action");
//		RStudentService stdService = StudentServiceFactory.getStudentService();
//
//		// ========== ADD STUDENT ==========
//		if ("add".equalsIgnoreCase(action)) {
//			String name = req.getParameter("name");
//			Integer age = Integer.parseInt(req.getParameter("age"));
//			String address = req.getParameter("address");
//
//			String result = stdService.addStudent(name, age, address);
//			out.println("<h2>" + result + "</h2>");
//		}
//
//		// ========== SEARCH STUDENT ==========+
//		else if ("search".equalsIgnoreCase(action)) {
//			Integer id = Integer.parseInt(req.getParameter("id"));
//			Student s = stdService.searchStudent(id);
//
//			if (s != null) {
//				out.println("<h2>Student Found</h2>");
//				out.println("ID : " + s.getSid() + "<br>");
//				out.println("Name : " + s.getSname() + "<br>");
//				out.println("Age : " + s.getSage() + "<br>");
//				out.println("Address : " + s.getSaddress() + "<br>");
//			} else {
//				out.println("<h2>No student found with ID " + id + "</h2>");
//			}
//		}
//
//		// ========== UPDATE STUDENT ==========
//		else if ("update".equalsIgnoreCase(action)) {
//
//			Integer id = Integer.parseInt(req.getParameter("id"));
//			String name = req.getParameter("name");
//			Integer age = Integer.parseInt(req.getParameter("age"));
//			String address = req.getParameter("address");
//
//			String result = stdService.updateStudent(id, name, age, address);
//			out.println("<h2>" + result + "</h2>");
//		}
//
//		// ========== DELETE STUDENT ==========
//		else if ("delete".equalsIgnoreCase(action)) {
//			Integer id = Integer.parseInt(req.getParameter("id"));
//			String result = stdService.deleteStudent(id);
//			out.println("<h2>" + result + "</h2>");
//		}
//
//		else {
//			out.println("<h2>Invalid action!</h2>");
//		}
//	}
}