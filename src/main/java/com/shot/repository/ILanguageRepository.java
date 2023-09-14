package com.shot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shot.model.Language;

@Repository
public interface ILanguageRepository extends JpaRepository<Language, Long> {

	List<Language> findByName(String movieLanguage);
}
