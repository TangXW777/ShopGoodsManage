package com.tang.category.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tang.dbc.DBManager;
import com.tang.vo.Category;

/**
 * Category DaoImpl
 * @author Administrator
 *
 */
public class CategoryDaoImpl implements CategoryDao{
	private List<Category> list = new ArrayList<Category>();
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// 取得全部分类
	public List<Category> getAllCategory() {
		String sql = "SELECT * FROM category";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Category category;
			while(rs.next()){
				category = new Category();
				category.setCategoryno(rs.getInt("categoryno"));
				category.setCategoryname(rs.getString("categoryname"));
				list.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	// 添加分类
	public boolean addCategory(String categoryName){
		boolean flag = false;
		String sql = "INSERT INTO category (categoryname) VALUES (?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryName);
			if(pstmt.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
