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

import seehope.model.ResultModel;
import seehope.model.UserModel;
import seehope.security.SecurityContext;
import seehope.service.IUserService;
import seehope.service.impl.UserService;

public class UserController {

	public void viewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			// 如果id不为空，则查询数据库，获取ID对应的用户
			IUserService userService = new UserService();
			request.setAttribute("user", userService.getUserById(id).getData());
			request.getRequestDispatcher("/module/user/user-view.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/module/user/user-add.jsp").forward(request, response);
		}
	}

	public void addOrEditUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			// 如果id不为空，则查询数据库，获取ID对应的用户
			IUserService userService = new UserService();
			request.setAttribute("user", userService.getUserById(id).getData());
		}
		request.getRequestDispatcher("/module/user/user-add.jsp").forward(request, response);
	}

	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		Gson g = new Gson();
		UserModel userModel = g.fromJson(user, UserModel.class);
		IUserService userService = new UserService();
		ResultModel result = null;
		if (userModel.getId() != null && !userModel.getId().equals("")) {
			result = userService.editUser(userModel);
		} else {
			result = userService.addUser(userModel);
		}
		result.sendData(response);
	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		IUserService userService = new UserService();
		String[] idsArg = ids.split(",");
		ResultModel result = userService.deleteUser(idsArg);
		result.sendData(response);
	}

	public void getAllUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson g = new Gson();
		IUserService userService = new UserService();
		ResultModel result = userService.getAllUser();
		result.sendData(response);
	}
	
	public void setRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String role = request.getParameter("role");
		IUserService userService = new UserService();
		ResultModel result = userService.setRole(id,role);
		result.sendData(response);
	}
	
	public void setStatusJSP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			// 如果id不为空，则查询数据库，获取ID对应的用户
			IUserService userService = new UserService();
			request.setAttribute("user", userService.getUserById(id).getData());
		}
		request.getRequestDispatcher("/module/user/user-setStatus.jsp").forward(request, response);
	}
	
	public void setStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		IUserService userService = new UserService();
		ResultModel result = userService.setStatus(id,status);
		result.sendData(response);
	}
	
	public void setPasswordJSP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			// 如果id不为空，则查询数据库，获取ID对应的用户
			IUserService userService = new UserService();
			request.setAttribute("user", userService.getUserById(id).getData());
		}
		request.getRequestDispatcher("/module/user/user-setPassword.jsp").forward(request, response);
	}
	
	public void setPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldp = request.getParameter("oldp");
		String newp = request.getParameter("newp");
		String id = request.getParameter("id");
		IUserService userService = new UserService();
		ResultModel result = userService.setPassword(id,oldp,newp);
		result.sendData(response);
	}
	
	public void checkOp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String oldp = request.getParameter("oldp");
		IUserService userService = new UserService();
		UserModel user = (UserModel) userService.getUserById(id).getData();
		ResultModel result = null;
		oldp = SecurityContext.encryptPassword(oldp);
		if (oldp.equals(user.getPassword())) {
			result = new ResultModel("001", "验证旧密码正确");
		} else {
			result = new ResultModel("002", "验证旧密码错误");
		}
		result.sendData(response);
	}
}
