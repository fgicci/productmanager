package org.gicci.uni.productmanager.application;

import javax.swing.UIManager;

import org.gicci.uni.productmanager.gui.ProductManagerFrame;

public class ProductManager {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new ProductManagerFrame().setVisible(true);
            }
        });
	}

}
