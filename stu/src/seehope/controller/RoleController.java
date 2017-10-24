package seehope.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import seehope.model.ResultModel;
import seehope.model.RoleModel;
import seehope.model.UserModel;
import seehope.service.IRoleService;
import seehope.service.IUserService;
import seehope.service.impl.RoleService;
import seehope.service.impl.UserService;

public class RoleController {
	
	public void viewRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			// 如果id不为空，则查询数据库，获取ID对应的用户
			IRoleService roleService = new RoleService();
			request.setAttribute("role", roleService.getRoleById(id).getData());
			request.getRequestDispatcher("/module/role/role-view.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/module/role/role-add.jsp").forward(request, response);
		}
	}

	public void addOrEditRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			// 如果id不为空，则查询数据库，获取ID对应的用户
			IRoleService roleService = new RoleService();
			request.setAttribute("role", roleService.getRoleById(id).getData());
		}
		request.getRequestDispatcher("/module/role/role-add.jsp").forward(request, response);
	}

	public void addRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = request.getParameter("role");
//		System.out.println("role:"+role);
		Gson g = new Gson();
		RoleModel roleModel = g.fromJson(role, RoleModel.class);
		IRoleService roleService = new RoleService();
		ResultModel result = null;
		if (roleModel.getId() != null && !roleModel.getId().equals("")) {
			result = roleService.editRole(roleModel);
		} else {
			result = roleService.addRole(roleModel);
		}
		result.sendData(response);
	}

	public void deleteRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		IRoleService roleService = new RoleService();
		String[] idsArg = ids.split(",");
		ResultModel result = roleService.deleteRole(idsArg);
		result.sendData(response);
	}

	public void getAllRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson g = new Gson();
		IRoleService roleService = new RoleService();
		ResultModel result = roleService.getAllRole();
		result.sendData(response);
	}
}
