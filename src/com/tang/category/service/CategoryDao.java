package com.tang.category.service;

import java.util.List;

import com.tang.vo.Category;

/**
 * Category Dao
 * @author Administrator
 *
 */
public interface CategoryDao {
	
	// 取得全部分类
	public List<Category> getAllCategory();
	
	// 添加分类
	public boolean addCategory(String categoryName);
}
