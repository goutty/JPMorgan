package pt.cache;

import java.util.ArrayList;
import java.util.List;

import pt.vo.Product;

public class MemoryCache {
	private static MemoryCache memoryCache = null;

	public List<Product> products;

	private MemoryCache() {
		products = new ArrayList<Product>();
	}

	public static MemoryCache getInstance() {
		if (memoryCache == null) {
			memoryCache = new MemoryCache();
		}
		return memoryCache;
	}
}
