package com.dreamcode.dreamcodetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.dreamcode.dreamcodetest.model.ProductCategory;

class CategoryManagerTest {
	private static CategoryManager cat = null;
	

	@BeforeAll
	static void setUpBeforeClass()  {
		cat = new CategoryManager();	
	}

	@Test
	@Order(1)
	void testCreateDataStructure() {
		assertDoesNotThrow(() -> {
			createBaseData();
		});
	}
	
	@Test
	void testGetKeywordsOfCategory() {
		assertTrue(cat.getKeywordsOfCategory(null).isEmpty());
		assertTrue(cat.getKeywordsOfCategory("Root").contains("Article"));
		assertTrue(cat.getKeywordsOfCategory("Furniture").contains("Furniture"));
		assertTrue(cat.getKeywordsOfCategory("Electronics").contains("Product"));
		assertFalse(cat.getKeywordsOfCategory("Furnitures").contains("Furniture"));
		assertFalse(cat.getKeywordsOfCategory("Furnitures").contains("Furnitures"));
	}
	
	@Test
	void testGetLevels() {
		//Level 0
		Map<Integer, List<ProductCategory>> levels = cat.getLevelsOfCategories();
		assertEquals(levels.get(0).get(0).getLevel(), 0);
		assertEquals(levels.get(0).get(0).getName(), "Root");
		
		
		//Level 1
		boolean containsElectronics = false;
		for(ProductCategory pc: levels.get(1)) {
			assertEquals(pc.getLevel(), 1);
			if(pc.getName().equals("Electronics")) containsElectronics = true;
		};
		
		//Level 2
		boolean containsMinorAppliances = false;
		for(ProductCategory pc: levels.get(2)) {
			assertEquals(pc.getLevel(), 2);
			if(pc.getName().equals("Minor Appliances")) containsMinorAppliances = true;
		}
		assertTrue(containsMinorAppliances);
		
		//Level 3
		boolean containsKitchenAppliances = false;
		for(ProductCategory pc: levels.get(3)) {
			assertEquals(pc.getLevel(), 3);
			if(pc.getName().equals("Kitchen Appliances")) containsKitchenAppliances = true;
		}
		assertTrue(containsKitchenAppliances);
	}
	
 	void createBaseData() throws Exception {
 		ProductCategory pc1 = new ProductCategory();
 		pc1.setName("Furniture");
 		List<String> keywordsPc1 = new ArrayList<String>();
 		keywordsPc1.add("Furniture");
 		pc1.setKeywords(keywordsPc1);
 		
 		ProductCategory pc2 = new ProductCategory();
 		pc2.setName("Electronics");
 		
 		ProductCategory pc3 = new ProductCategory();
 		pc3.setName("Home Appliances");
 		List<String> keywordsPc3 = new ArrayList<String>();
 		keywordsPc1.add("Home");
 		keywordsPc1.add("Appliances");
 		pc3.setKeywords(keywordsPc3);
 		
 		ProductCategory subCategory1Pc3 = new ProductCategory();
 		subCategory1Pc3.setName("Major Appliances");
 		ProductCategory subCategory1SubCategory1Pc3 = new ProductCategory();
 		subCategory1SubCategory1Pc3.setName("Kitchen Appliances");
 		ProductCategory subCategory2SubCategory1Pc3 = new ProductCategory();
 		subCategory2SubCategory1Pc3.setName("General Appliances");
 		subCategory1Pc3.addSubCategory(subCategory1SubCategory1Pc3);
 		subCategory1Pc3.addSubCategory(subCategory2SubCategory1Pc3);
 		
 		ProductCategory subCategory2Pc3 = new ProductCategory();
 		subCategory2Pc3.setName("Minor Appliances"); 		
 		
 		ProductCategory subCategory3Pc3 = new ProductCategory();
 		subCategory3Pc3.setName("Lawn & Garden"); 	
 		List<String> keywordsSubCategory3Pc3 = new ArrayList<String>();
 		keywordsSubCategory3Pc3.add("Lawn");
 		keywordsSubCategory3Pc3.add("Garden");
 		keywordsSubCategory3Pc3.add("GardeningTools");
 		subCategory3Pc3.setKeywords(keywordsSubCategory3Pc3);
 		 		
 		pc3.addSubCategory(subCategory1Pc3);
 		pc3.addSubCategory(subCategory2Pc3);
 		pc3.addSubCategory(subCategory3Pc3);
 		
 		cat.addCategory(pc1);
 		cat.addCategory(pc2);
 		cat.addCategory(pc3);
 	}
 	
 	

}
