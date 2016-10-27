package com.tang.goods.web;

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
import com.tang.vo.Goods;

public class StartAddGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GoodsDao service = new GoodsDaoImpl();
		java.util.Date goodsdate = null;
		PrintWriter out = resp.getWriter();
		if(req.getParameter("goodsdate") != "" && req.getParameter("goodsno") != "" && req.getParameter("goodsname") != "" 
			&& req.getParameter("goodsprice") != "" && req.getParameter("categoryno") != "" && req.getParameter("goodswarranty") != ""){
			try {
				goodsdate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("goodsdate"));
				int goodsno = Integer.parseInt(req.getParameter("goodsno"));
				String goodsname = req.getParameter("goodsname");
				double goodsprice = Double.parseDouble(req.getParameter("goodsprice"));
				int categoryno = Integer.parseInt(req.getParameter("categoryno"));
				int goodswarranty = Integer.parseInt(req.getParameter("goodswarranty"));
		
				
				Goods good = new Goods();
				good.setCategoryno(goodsno);
				good.setGoodsname(goodsname);
				good.setGoodsprice(goodsprice);
				good.setCategoryno(categoryno);
				good.setGoodsdate(goodsdate);
				good.setGoodswarranty(goodswarranty);
		
				if(service.addGoods(good)){
					System.out.println("添加商品成功!");
					// 重新获取List
					out.print("success");
					//resp.sendRedirect(req.getContextPath() + "/servlet/ShowGoodsServlet");
				}else{
					out.print("failue");
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				out.print("errordate");
				System.out.println("日期格式错误");
			}
		}else{
			out.print("empty");
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
