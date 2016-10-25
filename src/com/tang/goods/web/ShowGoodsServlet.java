package com.tang.goods.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tang.goods.service.GoodsDao;
import com.tang.goods.service.GoodsDaoImpl;
import com.tang.vo.Goods;

public class ShowGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GoodsDao service = new GoodsDaoImpl();
		List<Goods> list = service.getAllGoods();
		req.getSession().setAttribute("goodsList", list);
		
		resp.sendRedirect(req.getContextPath() + "/servlet/GoodsUI");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
