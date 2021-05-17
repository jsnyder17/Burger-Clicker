package com.jsnyder17.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jsnyder17.burgercreators.BurgerCreator;
import com.jsnyder17.main.GameManager;

public class ShopView extends JPanel implements ActionListener {
	private GameManager gm;
	private JLabel title;
	private JLabel purchaseStatus;
	private JButton burgerStandButton;
	private JButton burgerBlockButton;
	
	public ShopView(GameManager gm) {
		this.gm = gm;
		
		this.setLayout(new FlowLayout());
		
		initializeLabels();
		initializeButtons();
	}
	
	private void initializeLabels() {
		title = new JLabel();
		title.setText("The Store");
		//title.setSize(150, 10);
		title.setLocation(200, 10);
		this.add(title);
		
		purchaseStatus = new JLabel();
		purchaseStatus.setLocation(200, 300);
		this.add(purchaseStatus);
	}
	private void initializeButtons() {
		burgerStandButton = new JButton();
		burgerStandButton.setText("Burger Stand - $200");
		burgerStandButton.setSize(200, 20);
		burgerStandButton.setLocation(200, 50);
		burgerStandButton.addActionListener(this);
		this.add(burgerStandButton);
		
		burgerBlockButton = new JButton();
		burgerBlockButton.setText("Burger Block - $1000");
		burgerBlockButton.setSize(200, 20);
		burgerBlockButton.setLocation(200, 80);
		burgerBlockButton.addActionListener(this);
		this.add(burgerBlockButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BurgerCreator bc = null;
		
		// Handle buttons 
		if (e.getSource() == burgerStandButton) {
			bc = new BurgerCreator("Burger Stand", 2, 200);
		}
		else if (e.getSource() == burgerBlockButton) {
			bc = new BurgerCreator("Burger Block", 4, 1000);
		}
		
		transaction(bc);

		revalidate();
		repaint();
	}

	private void transaction(BurgerCreator bc) {
		String resultString = "";
		boolean success = false;
		
		// Do transaction 
		if (gm.getMoney() >= bc.getPrice()) {
			gm.incMoney(-bc.getPrice());
			gm.addBurgerCreator(bc);
			success = true;
		}
		
		// Evaluate output 
		if (!success) {
			resultString = "You do not have enough cash to purchase a '" + bc.getName() + "!'";
		}
		else {
			resultString = "You purchased a '" + bc.getName() + "!'";
		}
		
		purchaseStatus.setText(resultString);
	}
}
