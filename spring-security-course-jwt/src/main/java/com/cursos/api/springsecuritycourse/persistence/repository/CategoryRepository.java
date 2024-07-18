package com.cursos.api.springsecuritycourse.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.api.springsecuritycourse.persistence.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	

}
