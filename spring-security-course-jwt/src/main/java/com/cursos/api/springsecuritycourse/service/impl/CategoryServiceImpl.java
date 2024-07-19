package com.cursos.api.springsecuritycourse.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.cursos.api.springsecuritycourse.dto.SaveCategory;
import com.cursos.api.springsecuritycourse.exception.ObjectNotFoundException;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.persistence.repository.CategoryRepository;
import com.cursos.api.springsecuritycourse.service.CategoryService;

/*@Service: Indica que esta clase es un servicio de Spring, lo que significa que contiene 
 * la lógica de negocio y se puede inyectar en otras partes de la aplicación.*/
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Optional<Category> findOneById(Long productId) {
		return categoryRepository.findById(productId);
	}

	@Override
	public Category createOne(SaveCategory saveCategory) {
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
		return categoryRepository.save(categoryFromDB);
	}

	@Override
	public Category disableOneById(Long categoryId) {
		Category categoryFromDB = categoryRepository.findById(categoryId)
				.orElseThrow( ()-> new ObjectNotFoundException("product not found with"+categoryId)); //creamos exepcion propia
		
		categoryFromDB.setStatus(Category.categoryStatus.DISABLED);
		return categoryRepository.save(categoryFromDB);
	}

}
