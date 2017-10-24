package seehope.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seehope.db.DBUtil;
import seehope.model.GradeModel;
import seehope.model.ResultModel;
import seehope.service.IGradeService;
import seehope.service.IMarkService;
import seehope.service.impl.GradeService;
import seehope.service.impl.MarkService;
import seehope.util.JsonTools;

public class MarkController {
	
	public void getSubjectByGrade(HttpServletRequest request,HttpServletResponse response){
		String grade = request.getParameter("grade");
		IGradeService gradeService = new GradeService();
		ResultModel result = gradeService.getSubjectByGrade(Integer.parseInt(grade));
		result.sendData(response);
	}
	
	public void editMarkJSP(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String id =request.getParameter("id");
		IMarkService markService = new MarkService();
		request.setAttribute("mark", markService.getMarkById(id).getData());
		request.getRequestDispatcher("/module/mark/mark-edit.jsp").forward(request, response);
	}
	
	public void updateMark(HttpServletRequest request,HttpServletResponse response){
		String mark = request.getParameter("mark");
//		System.out.println("updateMark:"+mark);
		Map map = JsonTools.parseJSON2Map(mark);
		IMarkService markService = new MarkService();
		
		ResultModel result = markService.updateMark(map);
		result.sendData(response);
	}
	
}
