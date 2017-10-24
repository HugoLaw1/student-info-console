package seehope.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import seehope.dao.StudentDao;
import seehope.model.ResultModel;
import seehope.model.StudentModel;
import seehope.model.UserModel;
import seehope.security.SecurityContext;
import seehope.service.IStudentService;
import seehope.service.IUserService;
import seehope.service.impl.StudentService;
import seehope.service.impl.UserService;

public class StudentController {

	public void addOrEditStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("addoreditsutdent:id:" + id);
		if (id != null && !id.equals("")) {
			IStudentService studentService = new StudentService();
			System.out.println("addoreditstudent："+studentService.getStudentById(id).getData());
			request.setAttribute("student", studentService.getStudentById(id).getData());
			request.getRequestDispatcher("/module/student/student-update.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/module/student/student-add.jsp").forward(request, response);
		}
	}

	public void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student = request.getParameter("student");
		System.out.println("addstudent:"+student);
		Gson g = new Gson(); 
		StudentModel studentModel = g.fromJson(student, StudentModel.class);
		IStudentService studentService = new StudentService();
		ResultModel result = null;
		if (StudentDao.hasStudent(studentModel.getId())) {
			result = new ResultModel("002", "此学生已存在");
		} else {
			result = studentService.addStudent(studentModel);
		}
		result.sendData(response);
	}

	public void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		
		String student = request.getParameter("student");
		System.out.println("updatestudent:"+student);
		Gson g = new Gson();
		StudentModel studentModel = g.fromJson(student, StudentModel.class);
		IStudentService studentService = new StudentService();
		ResultModel result = null;
		if (StudentDao.hasStudent(studentModel.getId())) {
			result = studentService.editStudent(studentModel);
		} else {
			result = new ResultModel("002", "没有此学生");
		}
		result.sendData(response);
	}

	public void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		IStudentService studentService = new StudentService();
		String[] idsArg = ids.split(",");
		ResultModel result = studentService.deleteStudent(idsArg);
		result.sendData(response);
	}

}
