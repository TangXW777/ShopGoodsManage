package com.tang.category.service;

import java.util.List;

import com.tang.vo.Category;

/**
 * Category Dao
 * @author Administrator
 *
 */
public interface CategoryDao {
	
	// ȡ��ȫ������
	public List<Category> getAllCategory();
	
	// ��ӷ���
	public boolean addCategory(String categoryName);
}
