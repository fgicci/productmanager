package org.gicci.uni.productmanager.service;

import java.util.List;

import org.gicci.uni.productmanager.model.Product;

public interface ProductService {

	public Product create(Product product) throws RuntimeException;
	public Product update(Product product) throws RuntimeException;
	public Product delete(String key) throws RuntimeException;
	public Product find(String name) throws RuntimeException;
	public List<Product> findAll();
	public double sell(String key, int quantity) throws RuntimeException;
}
