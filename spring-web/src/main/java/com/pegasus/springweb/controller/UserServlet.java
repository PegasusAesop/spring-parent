package com.pegasus.springweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pegasus.springweb.domain.User;
import com.pegasus.springweb.service.IUserService;
import com.pegasus.springweb.utils.SpringBeanHolder;

@WebServlet("/login.do")
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private IUserService userService;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		userService=(IUserService) SpringBeanHolder.getBean("userService");
		
		User user = userService.login(username, password);
		
		if(null!=user) {
			
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/view/success.jsp").forward(request, response);
		}else {
			
			request.setAttribute("fail","登录失败！");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
	}

}
