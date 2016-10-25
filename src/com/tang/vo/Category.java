package com.tang.vo;

import java.io.Serializable;

/**
 * Category vo¿‡
 * @author Administrator
 *
 */
public class Category implements Serializable{
	private int categoryno;
	private String categoryname;
	public int getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
}
