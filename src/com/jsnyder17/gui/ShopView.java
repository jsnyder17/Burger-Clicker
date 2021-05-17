package com.jsnyder17.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jsnyder17.burgercreators.BurgerCreator;
import com.jsnyder17.main.GameManager;

public class ShopView extends JPanel implements ActionListener {
	private GameManager gm;
	private JLabel title;
	private JLabel purchaseStatus;
	private JButton burgerStandButton;
	private JButton burgerBlockButton;
	private BoxLayout layout;
	
	public ShopView(GameManager gm) {
		this.gm = gm;
		
		this.layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		
		this.setLayout(layout);
		
		initializeComponents();
	}
	private void initializeComponents() {
		title = new JLabel("The Store");
		title.setAlignmentX(CENTER_ALIGNMENT);
		this.add(title);
		
		burgerStandButton = new JButton("Burger Stand - $200");
		burgerStandButton.setText("Burger Stand - $200");
		burgerStandButton.setAlignmentX(CENTER_ALIGNMENT);
		burgerStandButton.addActionListener(this);
		this.add(burgerStandButton);
		
		burgerBlockButton = new JButton();
		burgerBlockButton.setText("Burger Block - $1000");
		burgerBlockButton.setAlignmentX(CENTER_ALIGNMENT);
		burgerBlockButton.addActionListener(this);
		this.add(burgerBlockButton);
		
		purchaseStatus = new JLabel();
		purchaseStatus.setAlignmentX(CENTER_ALIGNMENT);
		this.add(purchaseStatus);
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
