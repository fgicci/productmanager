package org.gicci.uni.productmanager.gui;

import javax.swing.table.AbstractTableModel;

import org.gicci.uni.productmanager.model.Product;
import org.gicci.uni.productmanager.service.ProductService;
import org.gicci.uni.productmanager.service.ProductServiceManager;

public class ProductTableModel extends AbstractTableModel {

	private String[] columnNames = {"Name", "Quantity", "Price £"};
	private ProductService productService;
	
	public ProductTableModel() {
		productService = new ProductServiceManager();
	}
	
	public ProductTableModel(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return productService.findAll().size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		Product product = productService.findAll().get(row);
		switch (col) {
			case 0:
				return product.getName();
			case 1:
				return product.getQuantity();
			case 2:
				return product.getPrice();
			default:
				return null;
		}
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
}
