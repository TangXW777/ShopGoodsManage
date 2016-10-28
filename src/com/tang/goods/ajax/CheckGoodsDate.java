package com.tang.goods.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tang.goods.service.GoodsDao;
import com.tang.goods.service.GoodsDaoImpl;

public class CheckGoodsDate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String goodsdate = req.getParameter("goodsdate");
		PrintWriter out = resp.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {   // 如果日期格式正确
			sdf.parse(goodsdate);
			out.print("true");
		} catch (ParseException e) {
			// 如果不正确
			out.print("false");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
