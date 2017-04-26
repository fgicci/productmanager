package org.gicci.uni.productmanager.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ProductManagerFrame extends JFrame {

	private JLabel lblName, lblQuantity, lblPrice;
	private JTextField txtName, txtQuantity, txtPrice;
	private JButton btnSave, btnDelete, btnSell, btnExit;
	private JTable tblProducts;
	private JScrollPane tblProductsPane;
	private String[] columnNames = {"Name", "Quantity", "Price £"};
	private Object[][] data = {{"P1", 1, 10.0}, 
							   {"P2", 4, 15.67},
							   {"P3", 9, 7.50}};
	
	public ProductManagerFrame() {
		initialize();
		defineLayout();
		setTitle("Product Manager - #");
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private void initialize() {
		lblName = new JLabel("Name: ");
		lblQuantity = new JLabel("Quantity: ");
		lblPrice = new JLabel("Price £: ");
		
		txtName = new JTextField();
		txtQuantity = new JTextField();
		txtPrice = new JTextField();
		
		btnSave = new JButton("Save");
		
		btnDelete = new JButton("Save");
		
		btnSell = new JButton("Sell");
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				exitFrame();
			}
		});
		
		tblProducts = new JTable(data, columnNames);
		tblProductsPane = new JScrollPane(tblProducts);
	}
	
	private void defineLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)	
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblQuantity)
						.addComponent(lblPrice)
					)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(txtName)
						.addComponent(txtQuantity)
						.addComponent(txtPrice)
					)
				)
				.addComponent(tblProductsPane)
			)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(btnSave)
				.addComponent(btnSell)
				.addComponent(btnDelete)
				.addComponent(btnExit)
			)
		);

        layout.linkSize(SwingConstants.HORIZONTAL, btnSave, btnSell, btnDelete, btnExit);
        
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblName)
				.addComponent(txtName)
				.addComponent(btnSave)
			)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblQuantity)
				.addComponent(txtQuantity)
				.addComponent(btnSell)
			)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblPrice)
				.addComponent(txtPrice)
				.addComponent(btnDelete)
			)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(tblProductsPane)
				.addComponent(btnExit)
			)	
		);

        createBufferStrategy(1);
	}
	
	private void exitFrame() {
		System.exit(JFrame.EXIT_ON_CLOSE);
	}
}
