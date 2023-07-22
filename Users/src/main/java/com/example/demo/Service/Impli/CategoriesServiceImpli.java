package com.example.demo.Service.Impli;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ExeceptionHandling.ResourceNotFoundException;
import com.example.demo.Models.Category;
import com.example.demo.Payloads.CategoryDao;
import com.example.demo.Repositorry.CategoryRepository;
import com.example.demo.Service.CategoryService;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class CategoriesServiceImpli implements CategoryService {

	
	@Autowired
	
	CategoryRepository repo;
	
	
	@Autowired
	
	ModelMapper modelmapper;
	
	@Override
	public CategoryDao AddCategory(CategoryDao categorydao) {
		
		Category category = this.dtotocategory(categorydao);
		
		Category savedCategory = this.repo.save(category);
		
		return this.categorytodto(savedCategory);
	}

	@Override
	public CategoryDao UpdateCategory(CategoryDao categorydao, int categoryid) {
		
		Category category = this.repo.findById(categoryid).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryid",categoryid));
		
		category.setCategoryTitle(categorydao.getCategoryTitle());
		
		category.setCategoryDescription(categorydao.getCategoryDescription());
		
		Category category1 =this.repo.save(category);
		
		CategoryDao categoryDao2 = this.categorytodto(category1);
		
		
		return categoryDao2;
	}

	@Override
	public void DeleteCategory(int categoryid) {
		
		Category category = this.repo.findById(categoryid).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryid", categoryid));
		
		 this.repo.delete(category);
	}

	@Override
	public List<CategoryDao> getAllCategory() {

        List<Category> category = this.repo.findAll();
        
        List<CategoryDao> categorydto = category.stream().map(categor -> this.categorytodto(categor)).collect(Collectors.toList());
        
		return categorydto;
	}

	@Override
	public CategoryDao getById(int categoryid) {
	
		Category category =this.repo.findById(categoryid).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryid));
		
		return this.categorytodto(category);
	}

	public Category dtotocategory(CategoryDao categorydao) {
		
	Category category = this.modelmapper.map(categorydao, Category.class);
	
	return category;
	}
	
	public CategoryDao categorytodto(Category category) {
		
		CategoryDao categorydao = this.modelmapper.map(category, CategoryDao.class);
		
		return categorydao;
	}
}
