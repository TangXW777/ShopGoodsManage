package com.tang.vo;

import java.util.Date;

/**
 * Goods vo¿‡
 * @author Administrator
 *
 */
public class Goods {
	private int goodsno;
	private String goodsname;
	private double goodsprice;
	private int categoryno;
	private Date goodsdate;
	private int goodswarranty;
	
	public int getGoodsno() {
		return goodsno;
	}
	public void setGoodsno(int goodsno) {
		this.goodsno = goodsno;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}
	public double getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(double goodsprice) {
		this.goodsprice = goodsprice;
	}
	public Date getGoodsdate() {
		return goodsdate;
	}
	public void setGoodsdate(Date goodsdate) {
		this.goodsdate = goodsdate;
	}
	public int getGoodswarranty() {
		return goodswarranty;
	}
	public void setGoodswarranty(int goodswarranty) {
		this.goodswarranty = goodswarranty;
	}
	
	
}
