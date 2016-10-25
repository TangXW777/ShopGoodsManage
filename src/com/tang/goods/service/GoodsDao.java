package com.tang.goods.service;

import java.util.List;

import com.tang.vo.Goods;

/**
 * Goods Dao
 * @author Administrator
 *
 */
public interface GoodsDao {
	
	// ȡ��ȫ����Ʒ
	public List<Goods> getAllGoods();
	
	// ��ȡĳ����Ʒ
	public Goods findGoods(int goodsNo);
	
	// �����Ʒ
	public boolean addGoods(Goods good);
	
	// �Ƴ�ĳ����Ʒ
	public boolean removeGoods(int goodsNo, List<Goods> list);
}
