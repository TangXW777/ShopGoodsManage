package com.tang.goods.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tang.dbc.DBManager;
import com.tang.tools.DateChange;
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
	private ResultSet rs = null;
	
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
			// 将java.util.Date 转换为 java.sql.Date
			pstmt.setDate(5, DateChange.util2Sql(good.getGoodsdate()));
			pstmt.setInt(6, good.getGoodswarranty());
			if(pstmt.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	// 找到某个商品
	public Goods findGoods(int goodsNo) {
		Goods goods = null;
		String sql = "SELECT * FROM goods WHERE goodsno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				goods = new Goods();
				goods.setGoodsno(rs.getInt("goodsno"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getDouble("goodsprice"));
				goods.setCategoryno(rs.getInt("categoryno"));
				goods.setGoodsdate(DateChange.sql2Util(rs.getDate("goodsdate")));
				goods.setGoodswarranty(rs.getInt("goodswarranty"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return goods;
	}
	
	// 获取全部商品
	public List<Goods> getAllGoods() {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Goods goods;
			while(rs.next()){
				goods = new Goods();
				goods.setGoodsno(rs.getInt("goodsno"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getDouble("goodsprice"));
				goods.setCategoryno(rs.getInt("categoryno"));
				goods.setGoodsdate(DateChange.sql2Util(rs.getDate("goodsdate")));
				goods.setGoodswarranty(rs.getInt("goodswarranty"));
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	// 移除某个商品
	public boolean removeGoods(int goodsNo, List<Goods> list) {
		boolean flag = false;
		String sql = "SELECT * FROM goods WHERE goodsno = ?";
		Goods goods;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				goods = new Goods();
				goods.setGoodsno(rs.getInt("goodsno"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getDouble("goodsprice"));
				goods.setCategoryno(rs.getInt("categoryno"));
				goods.setGoodsdate(DateChange.sql2Util(rs.getDate("goodsdate")));
				goods.setGoodswarranty(rs.getInt("goodswarranty"));
				
				// 如果列表包含这个Goods，则移除
				if(list.contains(goods)){
					list.remove(goods);
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
