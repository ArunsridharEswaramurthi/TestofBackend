package com.shot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shot.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByName(String name);
}
