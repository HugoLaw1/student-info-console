package seehope.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seehope.model.ResultModel;
import seehope.service.impl.UserService;

public class RegisterController {
	
	
	public void register(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("sellerid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService =new UserService();
		
		ResultModel result = userService.getUserById(id);
		if(result.getCode().equals("001")){
			result.setMessage("id已注册");
			result.sendData(response);
		}
		
	}
}
