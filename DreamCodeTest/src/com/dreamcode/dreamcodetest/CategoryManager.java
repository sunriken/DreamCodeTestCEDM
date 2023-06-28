package com.dreamcode.dreamcodetest;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Objects;

import com.dreamcode.dreamcodetest.model.ProductCategory;
import com.dreamcode.dreamcodetest.util.Utils;

/**
 * Class that manages the product categories
 * @author Carlos Diaz Maya
 *
 */
public class CategoryManager {
	/** Instance of root category */
	private ProductCategory rootCategory;
	
	/**
	 * Constructs a category manager
	 */
	public CategoryManager() {
		// Definition of Root category node
		rootCategory = new ProductCategory();
		rootCategory.setLevel(0);
		rootCategory.setName("Root");
		List<String> rootKeywords = new ArrayList<String>();
		rootKeywords.add("Article");
		rootKeywords.add("Product");
		rootCategory.setKeywords(rootKeywords);
	}
	
	/**
	 * Adds a category to the root category
	 * @param productCategory the product category object to add
	 */
	public void addCategory(ProductCategory productCategory) {
		rootCategory.addSubCategory(productCategory);
	}
	
	/**
	 * Gets a list of keywords associated to a category.
	 * If a category doesn't have keywords set, it returns the keywords associated to his parent category.
	 * @param categoryName The category name
	 * @return The keywords list
	 */
	public List<String> getKeywordsOfCategory(String categoryName) {
		if(Objects.isNull(categoryName)) return new ArrayList<String>();
		return Utils.getKeywordsOfNode(rootCategory, categoryName);
	}
	
	/**
	 * Gets a map with the corresponding product categories for each level
	 * The key corresponds to a level, and the value is the list of product categories that belong to the level
	 * @return The map with the corresponding product categories for each level
	 */
	public Map<Integer, List<ProductCategory>> getLevelsOfCategories() {
		Utils.buildLevelsOfCategories(rootCategory);
		return Utils.getLevelsOfNode(rootCategory);
	}	
}
