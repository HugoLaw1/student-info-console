package seehope.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seehope.service.impl.DataTableService;
import seehope.util.JsonTools;

public class DataTableController {



	public void getTableListForPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aoData = request.getParameter("aoData");
		String param = request.getParameter("param");
		String service = request.getParameter("service");
		String[] args = service.split("\\$");
		service = args[0];
		String method = args[1];
		Map value = new DataTableService().getData(service, method, aoData, param);
		response.getWriter().append(JsonTools.mapToJson(value)).flush();
	}

}
