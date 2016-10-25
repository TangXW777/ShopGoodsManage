package com.tang.goods.service;

import java.util.List;

import com.tang.vo.Goods;

/**
 * Goods Dao
 * @author Administrator
 *
 */
public interface GoodsDao {
	
	// 取得全部商品
	public List<Goods> getAllGoods();
	
	// 获取某个商品
	public Goods findGoods(int goodsNo);
	
	// 添加商品
	public boolean addGoods(Goods good);
	
	// 移除某个商品
	public boolean removeGoods(int goodsNo, List<Goods> list);
}
