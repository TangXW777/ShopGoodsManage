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
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// ȡ��ȫ������
	public List<Category> getAllCategory() {
		conn = DBManager.getConnection();
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

}