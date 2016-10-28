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

public class CheckGoodsNo extends HttpServlet{
	GoodsDao service = new GoodsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String goodsno = req.getParameter("goodsno");
		PrintWriter out = resp.getWriter();
		if(goodsno != ""){
			if(service.findGoods(Integer.parseInt(goodsno)) == null){
				out.print("true");
			}else{
				out.print("false");
			}

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