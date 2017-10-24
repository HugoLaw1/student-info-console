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

import seehope.dao.SubjectDao;
import seehope.model.ResultModel;
import seehope.model.SubjectModel;
import seehope.model.UserModel;
import seehope.security.SecurityContext;
import seehope.service.ISubjectService;
import seehope.service.IUserService;
import seehope.service.impl.SubjectService;
import seehope.service.impl.UserService;

public class SubjectController {


	public void addOrEditSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("subcontroller+id:" + id);
		if (id != null && !id.equals("")) {
			ISubjectService subjectService = new SubjectService();
			System.out.println("adoreditsubject:"+subjectService.getSubjectById(id).getData());
			request.setAttribute("subject", subjectService.getSubjectById(id).getData());
			request.getRequestDispatcher("/module/subject/subject-update.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/module/subject/subject-add.jsp").forward(request, response);
		}
	}

	public void addSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subject = request.getParameter("subject");
		Gson g = new Gson();
		SubjectModel subjectModel = g.fromJson(subject, SubjectModel.class);
		ISubjectService subjectService = new SubjectService();
		ResultModel result = null;
		if (SubjectDao.hasSubject(subjectModel.getSub_id())) {
			result = new ResultModel("002", "此学科编号已存在");
		}else if(SubjectDao.hasSubjectByName(subjectModel.getSub_name())){
			result = new ResultModel("003","此学科名称已存在");
		}else {
			result = subjectService.addSubject(subjectModel);
		}
		result.sendData(response);
	}

	public void updateSubject(HttpServletRequest request, HttpServletResponse response) {
		
		String subject = request.getParameter("subject");
		Gson g = new Gson();
		SubjectModel subjectModel = g.fromJson(subject, SubjectModel.class);
		ISubjectService subjectService = new SubjectService();
		ResultModel result = null;
		if (SubjectDao.hasSubject(subjectModel.getSub_id())) {
			result = subjectService.editSubject(subjectModel);
		} else {
			result = new ResultModel("002", "更新失败");
		}
		result.sendData(response);
	}

	public void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		ISubjectService subjectService = new SubjectService();
		String[] idsArg = ids.split(",");
		ResultModel result = subjectService.deleteSubject(idsArg);
		result.sendData(response);
	}

}
