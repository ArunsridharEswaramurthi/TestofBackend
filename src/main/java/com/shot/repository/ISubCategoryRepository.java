package com.shot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shot.model.Category;
import com.shot.model.SubCategory;

@Repository
public interface ISubCategoryRepository extends JpaRepository<SubCategory, Long> {

	List<SubCategory> findByName(String name);
}
