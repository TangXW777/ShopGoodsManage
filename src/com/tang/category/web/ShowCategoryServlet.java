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
		// ע�������ʵ����service����д�ڷ�������
		// ������������棬��ÿ����ת�����ҳ���ʱ��serviceû�����±�ʵ����
		// ����servce��List���ظ����
		
		CategoryDao service = new CategoryDaoImpl();
		List<Category> categoryList = service.getAllCategory();
		req.getSession().removeAttribute("categoryList");
		// ����session��Χ
		req.getSession().setAttribute("categoryList", categoryList);
		resp.sendRedirect(req.getContextPath() + "/servlet/CategoryUI");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
