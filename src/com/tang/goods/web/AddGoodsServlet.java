package com.tang.goods.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tang.category.service.CategoryDao;
import com.tang.category.service.CategoryDaoImpl;
import com.tang.vo.Category;

public class AddGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDao service = new CategoryDaoImpl();
		List<Category> list = service.getAllCategory();
		req.getSession().setAttribute("categoryList", list);
		req.getRequestDispatcher("../jsp/addgoods.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
