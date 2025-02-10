package com.cursos.api.springsecuritycourse.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cursos.api.springsecuritycourse.dto.SaveProduct;
import com.cursos.api.springsecuritycourse.exception.ObjectNotFoundException;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.persistence.entity.Product;
import com.cursos.api.springsecuritycourse.persistence.entity.Product.ProductStatus;
import com.cursos.api.springsecuritycourse.persistence.repository.ProductRepository;
import com.cursos.api.springsecuritycourse.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findAll(pageable);
	}

	@Override
	public Optional<Product> findOneById(Long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Override
	public Product createOne(SaveProduct saveProduct) {
		//creamos propiedad producto
		Product productFromDB = new Product();
		//setear valores del dto
		productFromDB.setName(saveProduct.getName());
		productFromDB.setPrice(saveProduct.getPrice());
		productFromDB.setStatus(ProductStatus.ENABLED);
		
		Category category = new Category();
		category.setId(saveProduct.getCategoryId());
		productFromDB.setCategory(category);
		return productRepository.save(productFromDB);
	}

	@Override
	public Product updateOneById(Long productId, SaveProduct saveProduct) {
		// TODO Auto-generated method stub
		Product productoFromDB = productRepository.findById(productId)
				.orElseThrow( ()-> new ObjectNotFoundException("product not found with"+productId)); //creamos exepcion propia
		
		productoFromDB.setName(saveProduct.getName());
		productoFromDB.setPrice(saveProduct.getPrice());
		
		Category category = new Category();
		category.setId(saveProduct.getCategoryId());
		productoFromDB.setCategory(category);
		return productRepository.save(productoFromDB);
	}

	@Override
	public Product disableOneById(Long productId) {
		Product productoFromDB = productRepository.findById(productId)
				.orElseThrow( ()-> new ObjectNotFoundException("product not found with"+productId)); //creamos exepcion propia
		productoFromDB.setStatus(ProductStatus.DISABLED);
		return productRepository.save(productoFromDB);
	}
	

}
