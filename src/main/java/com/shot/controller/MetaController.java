package com.shot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shot.DTO.CountResponseDTO;
import com.shot.model.Category;
import com.shot.model.Language;
import com.shot.model.SubCategory;
import com.shot.model.Tag;
import com.shot.service.MetaService;

@RestController
@RequestMapping("/meta")
@CrossOrigin
public class MetaController {

	@Autowired
	private MetaService metaService;

	@PostMapping("/tag/add")
	public Tag addTag(@RequestBody Tag tag) {
		return metaService.addTag(tag);
	}

	@GetMapping("/tag/get")
	public List<Tag> getTags() {
		return metaService.getAllTags();
	}
	
	@GetMapping("/tag/get/{id}")
	public Tag getTags(@PathVariable Long id) {
		return metaService.getById(id);
	}

	@GetMapping("/tag/search")
	public ResponseEntity<List<Tag>> getAllTag(@RequestParam String name) {
		List<Tag> tag = metaService.getTagsByName(name);
		return ResponseEntity.ok(tag);
	}

	@PutMapping("/tagupdate/{id}")
	public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tag) {
		Tag tagObj = metaService.updateTag(id, tag);

		if (tagObj != null) {
			return new ResponseEntity<>(tagObj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // You can handle this case differently based on your
																// application's logic
		}
	}

	@DeleteMapping("/tagDelete/{id}")
	public String deleteTag(@PathVariable Long id) {
		return metaService.deleteTag(id);
	}

	@PostMapping("/movielanguage/add")
	public Language addLanguage(@RequestBody Language language) {
		return metaService.addLanguage(language);
	}

	@GetMapping("/moviecategory/get")
	public List<Language> getLanguages() {
		return metaService.getAllLanguages();
	}

	
	@GetMapping("/moviecategory/search")
	public ResponseEntity<List<Language>> getlanguageByName(@RequestParam String name) {
		List<Language> language = metaService.getLanguageByName(name);
		return ResponseEntity.ok(language);
	}

	@PutMapping("/movielanguage/edit/{id}")
	public ResponseEntity<Language> updateLanguage(@PathVariable Long id,
			@RequestBody Language language) {
		Language languageObj = metaService.updateMovieLanguage(id, language);

		if (languageObj != null) {
			return new ResponseEntity<>(languageObj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/movielanguage/delete/{id}")
	public String deleteLangauge(@PathVariable Long id) {
		return metaService.deleteLangauge(id);
	}

	/**
	 * Adding movie category
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("/locationcategory/add")
	public Category addCategory(@RequestBody Category category) {
		return metaService.addCategory(category);
	}

	@GetMapping("/locationcategory/get")
	public List<Category> getAllCategories() {
		return metaService.getAllCategories();
	}

	@GetMapping("/locationcategory/search")
	public ResponseEntity<List<Category>> getByCategoryByName(@RequestParam String name) {
		List<Category> category = metaService.getCategoriesByName(name);
		return ResponseEntity.ok(category);
	}

	@PutMapping("/locationcategory/update/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id,
			@RequestBody Category category) {
		Category categoryObj = metaService.updateCategory(id, category);

		if (categoryObj != null) {
			return new ResponseEntity<>(categoryObj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/locationcategoryDelete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		return metaService.deleteCategory(id);
	}

	@GetMapping("/count")
	public CountResponseDTO getCounts() {
		return metaService.getCounts();
	}
	
	/**
	 * Adding sub category
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("/category/sub/add")
	public SubCategory addSubCategory(@RequestBody SubCategory category) {
		return metaService.addSubCategory(category);
	}

	@GetMapping("/category/sub/get")
	public List<SubCategory> getAllSubCategories() {
		return metaService.getAllSubCategories();
	}
	
	@PutMapping("/category/sub/update/{id}")
	public ResponseEntity<SubCategory> updateSubCategory(@PathVariable Long id,
			@RequestBody SubCategory category) {
		SubCategory categoryObj = metaService.updateSubCategory(id, category);

		if (categoryObj != null) {
			return new ResponseEntity<>(categoryObj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/category/sub/{id}")
	public String deleteSubCategory (@PathVariable Long id) {
		return metaService.deleteSubCategory(id);
	}
	
	@GetMapping("/category/sub/search")
	public ResponseEntity<List<SubCategory>> getBySubCategoryByName(@RequestParam String name) {
		List<SubCategory> category = metaService.getSubCategorieByName(name);
		return ResponseEntity.ok(category);
	}
}
