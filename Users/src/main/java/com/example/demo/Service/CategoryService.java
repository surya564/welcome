package com.example.demo.Service;

import java.util.List;


import com.example.demo.Payloads.CategoryDao;

public interface CategoryService {

	CategoryDao AddCategory(CategoryDao category);
	
	CategoryDao UpdateCategory( CategoryDao categorydao, int categoryid);
	
	void DeleteCategory(int id);
	
	List<CategoryDao> getAllCategory();
	
	CategoryDao getById(int id);
}
