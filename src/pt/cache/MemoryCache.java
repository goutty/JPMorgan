package pt.cache;

import java.util.ArrayList;
import java.util.List;

import pt.vo.Product;

public class MemoryCache {
	// static variable single_instance of type Singleton
	private static MemoryCache memoryCache = null;

	// variable of type String
	public List<Product> products;

	// private constructor restricted to this class itself
	private MemoryCache() {
		products = new ArrayList<Product>();
	}

	// static method to create instance of Singleton class
	public static MemoryCache getInstance() {
		// To ensure only one instance is created
		if (memoryCache == null) {
			memoryCache = new MemoryCache();
		}
		return memoryCache;
	}
}
