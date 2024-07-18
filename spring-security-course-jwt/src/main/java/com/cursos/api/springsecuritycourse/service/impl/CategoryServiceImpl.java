package com.cursos.api.springsecuritycourse.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cursos.api.springsecuritycourse.dto.SaveCategory;
import com.cursos.api.springsecuritycourse.exception.ObjectNotFoundException;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.persistence.entity.Product;
import com.cursos.api.springsecuritycourse.persistence.repository.CategoryRepository;
import com.cursos.api.springsecuritycourse.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Page<Category> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Optional<Category> findOneById(Long productId) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(productId);
	}

	@Override
	public Category createOne(SaveCategory saveCategory) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setName(saveCategory.getName());
		category.setStatus(Category.categoryStatus.ENABLED);
		return categoryRepository.save(category);
	}

	@Override
	public Category updateOneById(Long categoryId, SaveCategory saveCategory) {
		Category categoryFromDB = categoryRepository.findById(categoryId)
				.orElseThrow( ()-> new ObjectNotFoundException("category not found with"+categoryId)); //creamos exepcion propia
		
		categoryFromDB.setName(saveCategory.getName());
	//	categoryFromDB.setStatus(Category.categoryStatus.ENABLED);
		
		return categoryRepository.save(categoryFromDB);
	}

	@Override
	public Category disableOneById(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
