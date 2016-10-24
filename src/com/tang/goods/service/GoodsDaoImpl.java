package com.tang.goods.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;

import com.tang.dbc.DBManager;
import com.tang.vo.Category;
import com.tang.vo.Goods;

/**
 * Goods Dao Impl
 * @author Administrator
 *
 */
public class GoodsDaoImpl implements GoodsDao{
	private List<Goods> list = new ArrayList<Goods>();
	private Connection conn = DBManager.getConnection();
	private PreparedStatement pstmt = null;
	private int rs = null;
	
	// 添加商品
	public boolean addGoods(Goods good) {
		boolean flag = false;
		String sql = "INSERT INTO goods (goodsno,goodsname,goodsprice,categoryno,goodsdate,goodswarranty) VALUES (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, good.getGoodsno());
			pstmt.setString(2, good.getGoodsname());
			pstmt.setDouble(3, good.getGoodsprice());
			pstmt.setInt(4, good.getCategoryno());
			pstmt.setDate(5, good.getGoodsdate());
			pstmt.setInt(6, good.getGoodswarranty());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	// 找到某个商品
	public Goods findGoods(int goodsId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 获取全部商品
	public List<Goods> getAllGoods() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 移除某个商品
	public boolean removeGoods(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
