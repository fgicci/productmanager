package org.gicci.uni.productmanager.service;

import java.util.HashMap;
import java.util.Map;

import org.gicci.uni.productmanager.model.Product;

public class ProductServiceManager implements ProductService {

	private static final String RECORD_EXIST = "Record already exists!";
	private static final String RECORD_NOT_FOUND = "Record not found!";
	private static final String RECORD_INVALID = "Record has constraints!";
	
	private Map<String, Product> products = new HashMap<String, Product>();
	
	@Override
	public Product create(Product product) throws RuntimeException {
		if (products.containsKey(product.getName())) throw new RuntimeException(RECORD_EXIST);
		if (!isValid(product)) throw new RuntimeException(RECORD_INVALID);
		return products.put(product.getName(), product);
	}

	@Override
	public Product update(Product product) throws RuntimeException {
		if (!products.containsKey(product.getName())) throw new RuntimeException(RECORD_NOT_FOUND);
		if (!isValid(product)) throw new RuntimeException(RECORD_INVALID);
		return products.put(product.getName(), product);
	}

	@Override
	public Product delete(String key) throws RuntimeException {
		if (!products.containsKey(key)) throw new RuntimeException(RECORD_NOT_FOUND);
		return products.remove(key);
	}

	@Override
	public Product find(String name) throws RuntimeException {
		if (!products.containsKey(name)) throw new RuntimeException(RECORD_NOT_FOUND);
		return products.get(name);
	}

	@Override
	public double sell(String key, int quantity) throws RuntimeException {
		Product product = find(key);
		if (product.getQuantity() < quantity) throw new RuntimeException("It is not possible to sell this quantity. This product does not contain items enought!");
		product.setQuantity(product.getQuantity() - quantity);
		return (product.getQuantity() * product.getPrice());
	}

	private boolean isValid(Product product) {
		return (!product.getName().equals("")
				&& product.getQuantity() > 0
				&& product.getPrice() > 0);
	}
}
