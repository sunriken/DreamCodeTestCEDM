package com.dreamcode.dreamcodetest.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Class that defines a product category
 * @author Carlos Diaz Maya
 */
public class ProductCategory {
	private String name;
	private Integer level;
	private List<String> keywords;
	private ProductCategory parent;
	private List<ProductCategory> subCategories;

	/**
	 * Default constructor for Product Category
	 */
	public ProductCategory() {
		keywords = new ArrayList<String>();
		subCategories = new ArrayList<ProductCategory>();
	}
	
	/**
	 * Gets the name of the category
	 * @return The name of the category
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the category
	 * @param name The name of the category to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the level number of the category
	 * @return The level number of the category
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * Sets the level number of the category
	 * @param level The level number of the category to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * Gets the keywords list associated to the category
	 * @return The keywords list associated to the category
	 */
	public List<String> getKeywords() {
		return keywords;
	}


	/**
	 * Gets the keywords list associated to the category
	 * @param keywords The keywords list to set
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	/**
	 * Gets the parent of the category. If the category is Root, the parent is null
	 * @return The parent of the category.
	 */
	public ProductCategory getParent() {
		return parent;
	}

	/**
	 * Sets the parent of the category. I
	 * @param parent The parent of the category to set.
	 */
	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}

	/**
	 * Gets the list of subcategories associated to the category
	 * @return The list of subcategories
	 */
	public List<ProductCategory> getSubCategories() {
		return subCategories;
	}
	
	/**
	 * Adds a subcategory for the category
	 * @param subCategory The subcategory element to add 
	 */
	public void addSubCategory(ProductCategory subCategory) {
		subCategory.setParent(this);
		this.subCategories.add(subCategory);
	}
}
