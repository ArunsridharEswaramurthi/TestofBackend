package com.shot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shot.model.Tag;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {
	List<Tag> findByNameContainingIgnoreCase(String name);

	Tag findByName(String tagName);
}
