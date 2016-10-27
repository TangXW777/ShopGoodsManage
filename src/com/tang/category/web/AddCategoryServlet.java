package com.tang.category.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.tang.category.service.CategoryDao;
import com.tang.category.service.CategoryDaoImpl;

public class AddCategoryServlet extends HttpServlet{
	CategoryDao service = new CategoryDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String sort = req.getParameter("sort");
		if(service.addCategory(sort)){
			System.out.println("添加分类成功!");
			out.print("true");
			// resp.sendRedirect(req.getContextPath() + "/servlet/ShowCategoryServlet");
		}else{
			out.print("false");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
