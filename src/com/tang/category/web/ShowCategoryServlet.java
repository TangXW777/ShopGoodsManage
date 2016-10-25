package com.tang.category.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tang.category.service.CategoryDao;
import com.tang.category.service.CategoryDaoImpl;
import com.tang.vo.Category;

public class ShowCategoryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 注意这里的实例化service必须写在方法里面
		// 如果定义在外面，则每次跳转到这个页面的时候，service没有重新被实例化
		// 所有servce的List会重复添加
		
		CategoryDao service = new CategoryDaoImpl();
		List<Category> categoryList = service.getAllCategory();
		req.getSession().removeAttribute("categoryList");
		// 放在session范围
		req.getSession().setAttribute("categoryList", categoryList);
		resp.sendRedirect(req.getContextPath() + "/servlet/CategoryUI");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
