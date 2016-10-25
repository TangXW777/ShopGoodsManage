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
	
	// �����Ʒ
	public boolean addGoods(Goods good) {
		boolean flag = false;
		String sql = "INSERT INTO goods (goodsno,goodsname,goodsprice,categoryno,goodsdate,goodswarranty) VALUES (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, good.getGoodsno());
			pstmt.setString(2, good.getGoodsname());
			pstmt.setDouble(3, good.getGoodsprice());
			pstmt.setInt(4, good.getCategoryno());
			// ��java.util.Date ת��Ϊ java.sql.Date
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

	// �ҵ�ĳ����Ʒ
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
	
	// ��ȡȫ����Ʒ
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
	
	// �Ƴ�ĳ����Ʒ
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
				
				// ����б�������Goods�����Ƴ�
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
