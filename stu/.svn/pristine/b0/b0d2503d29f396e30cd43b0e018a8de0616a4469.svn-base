package seehope.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 */
	private void doService(HttpServletRequest req, HttpServletResponse resp) {
		String uri = req.getRequestURI();
		String[] args = uri.split("/");
		String methodName = args[args.length - 1].replace(".do", "");
		String className = args[args.length - 2];
		className = "seehope.controller." + className;
		try {
			Class clz = Class.forName(className);
			Method method = clz.getMethod(methodName,
					new Class[] { HttpServletRequest.class, HttpServletResponse.class });
			Object obj = clz.newInstance();
			method.invoke(obj, new Object[] { req, resp });
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
