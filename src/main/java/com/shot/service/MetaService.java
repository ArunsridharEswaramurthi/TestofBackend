package com.shot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shot.DTO.CountResponseDTO;
import com.shot.model.Category;
import com.shot.model.Language;
import com.shot.model.Movie;
import com.shot.model.SubCategory;
import com.shot.model.Tag;
import com.shot.repository.ICategoryRepository;
import com.shot.repository.ILanguageRepository;
import com.shot.repository.ILocationRepository;
import com.shot.repository.IMovieRepository;
import com.shot.repository.ISongsAndSceneRepository;
import com.shot.repository.ISubCategoryRepository;
import com.shot.repository.ITagRepository;

@Service
public class MetaService {

	@Autowired
	private ITagRepository tagRepository;

	@Autowired
	private ILanguageRepository languageRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private ISubCategoryRepository subCategoryRepository;

	@Autowired
	private IMovieRepository movieRepository;

	@Autowired
	private ILocationRepository locationRepositroy;

	@Autowired
	private ISongsAndSceneRepository songsAndScenesRepository;

	public Tag addTag(Tag tag) {
		return tagRepository.save(tag);
	}

	public List<Tag> getAllTags() {
		return tagRepository.findAll();
	}

	public List<Tag> getTagsByName(String name) {
		return tagRepository.findByNameContainingIgnoreCase(name);
	}

	public Tag getById(Long id) {
		return tagRepository.findById(id).get();
	}

	public Tag updateTag(Long id, Tag tag) {
		Tag tagObj = tagRepository.findById(id).get();

		tagObj.setName(tag.getName());
		tagObj.setDescription(tag.getDescription());
		return tagRepository.save(tagObj);
	}

	public String deleteTag(Long id) {
		tagRepository.deleteById(id);
		return "Deleted Successfully";
	}

	public Language addLanguage(Language language) {
		return languageRepository.save(language);
	}

	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	public List<Language> getLanguageByName(String name) {
		return languageRepository.findByName(name);
	}

	public Language updateMovieLanguage(Long id, Language language) {
		Language languageObj = languageRepository.findById(id).get();
		languageObj.setName(language.getName());
		return languageRepository.save(languageObj);
	}

	public String deleteLangauge(Long id) {
		languageRepository.deleteById(id);
		return "Deleted Successfully";
	}

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public List<Category> getCategoriesByName(String name) {
		return categoryRepository.findByName(name);
	}

	public Category updateCategory(Long id, Category category) {
		Category categoryObj = categoryRepository.findById(id).get();
		categoryObj.setName(category.getName());
		categoryObj.setDescription(category.getDescription());
		return categoryRepository.save(categoryObj);
	}

	public String deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return "Deleted Successfully";
	}

	public CountResponseDTO getCounts() {
		CountResponseDTO counts = new CountResponseDTO();
		counts.setMovieCount(movieRepository.count());
		counts.setLocationCount(locationRepositroy.count());
		counts.setSongsAndScenesCount(songsAndScenesRepository.count());
		return counts;
	}

	public SubCategory addSubCategory(SubCategory category) {
		return subCategoryRepository.save(category);
	}

	public List<SubCategory> getAllSubCategories() {
		return subCategoryRepository.findAll();
	}

	public List<SubCategory> getSubCategorieByName(String name) {
		return subCategoryRepository.findByName(name);
	}

	public SubCategory updateSubCategory(Long id, SubCategory category) {
		SubCategory categoryObj = subCategoryRepository.findById(id).get();
		categoryObj.setName(category.getName());
		categoryObj.setDescription(category.getDescription());
		categoryObj.setCategoryId(category.getCategoryId());
		return subCategoryRepository.save(categoryObj);
	}

	public String deleteSubCategory(Long id) {
		subCategoryRepository.deleteById(id);
		return "Deleted Successfully";
	}
}
