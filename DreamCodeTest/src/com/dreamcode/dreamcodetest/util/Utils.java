package com.dreamcode.dreamcodetest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import com.dreamcode.dreamcodetest.model.ProductCategory;

/**
 * Utility class for operations related to Product Categories
 * @author Carlos Diaz Maya
 *
 */
public class Utils {
	/**
	 * Gets the keywords for a given product category name that's part of the product category node
	 * @param node The product category node
	 * @param categoryName the product category name
	 * @return The list of keywords
	 */
	public static List<String> getKeywordsOfNode(ProductCategory node, String categoryName){
		if(categoryName.equals(node.getName())) {
			if(node.getKeywords().isEmpty() && node.getParent()!=null) {
			 return node.getParent().getKeywords();
			} else {
				return node.getKeywords();
			}
		} else if(node.getSubCategories().isEmpty()) {
			return new ArrayList<String>();
		} else {
			ArrayList<String> categories = new ArrayList<String>();
			node.getSubCategories().forEach(sc -> {
				categories.addAll(getKeywordsOfNode(sc, categoryName));
			});
			return categories;
		}
	}
	
	/**
	 * Marks the level attribute for the product category node and his subcategories
	 * @param node The product category node to mark the level attribute
	 */
	public static void buildLevelsOfCategories(ProductCategory node) {
		if(Objects.isNull(node.getLevel())) {
			node.setLevel(node.getParent().getLevel()+1);
		}
		node.getSubCategories().forEach(sc -> {
			buildLevelsOfCategories(sc);
		});
	}

	/**
	 * Gets the levels of the given product category node
	 * @param node The product category node
	 * @return The levels of the given product category node
	 */
	public static Map<Integer, List<ProductCategory>> getLevelsOfNode(ProductCategory node) {
		Map<Integer, List<ProductCategory>> ret = new HashMap<>();
		List<ProductCategory> list = new ArrayList<>();
		list.add(node);
		ret.put(node.getLevel(), list);
		node.getSubCategories().forEach(sc -> {
			Map<Integer, List<ProductCategory>> levelsSc = getLevelsOfNode(sc);
			levelsSc.keySet().forEach(k -> {
				if(ret.containsKey(k)) {
					ret.get(k).addAll(levelsSc.get(k));
				} else {
					ret.put(k,levelsSc.get(k));
				}
			});
		});		
		return ret;
	}
}
