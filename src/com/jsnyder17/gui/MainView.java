package com.jsnyder17.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import com.jsnyder17.burgercreators.BurgerCreator;
import com.jsnyder17.main.GameManager;

public class MainView extends JPanel implements ActionListener {
	private Timer burgerTimer;
	private Timer updateTimer;
	private JLabel label;
	private Image burgerImage;
	private JButton clickButton;
	private JTextArea statusArea;
	private GameManager gm;
	
	public MainView(GameManager gm) {
		burgerTimer = new Timer(1000, this);
		updateTimer = new Timer(5, this);
		this.gm = gm;
		
		this.setLayout(null);
		
		initializeImages();
		initializeButtons();
		initializeLabels();
		initializeTextArea();
	}
	
	private void initializeButtons() {
		clickButton = new JButton();
		clickButton.setBounds(430, 20, 128, 128);
		clickButton.setIcon(new ImageIcon(burgerImage));
		clickButton.addActionListener(this);
		clickButton.setOpaque(false);
		clickButton.setContentAreaFilled(false);
		clickButton.setBorderPainted(false);
		clickButton.setFocusPainted(false);
		this.add(clickButton);
	}
	
	private void initializeLabels() {
		label = new JLabel();
		label.setText("You've clicked more than 10 times. ");
		label.setLocation(100, 200);
	}
	private void initializeImages() {
		try {
			burgerImage = ImageIO.read(new File("resources/burger.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void initializeTextArea() {
		statusArea = new JTextArea();
		statusArea.setBounds(10, 200, 300, 400);
		
		this.add(statusArea);
	}
	
	// Inc each burger from all burger makers the player has 
	private void incBurgers() {
		for (BurgerCreator bc : gm.getBurgerCreators()) {
			gm.incMoney(2 * bc.getBurgersPerSecond());
			gm.incBurgers(bc.getBurgersPerSecond());
		}
	}
	
	private void clickBurger() {
		gm.incMoney(2);
		gm.incBurgers(1);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", 3, 40));
		g.drawString("Burgers sold: " + gm.getBurgers(), 50, 100);
		g.setFont(new Font("Arial", 1, 20));
		g.drawString("Cash: $" + gm.getMoney(), 400, 220);
		burgerTimer.start();
		updateTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clickButton) {
			clickBurger();
		}
		else if (e.getSource() == burgerTimer) {
			incBurgers();
		}
		else if (e.getSource() == updateTimer) {
			refresh();
		}
	}
	
	private void refresh() {
		statusArea.setText(gm.getStatusString());
		revalidate();
		repaint();
	}
}
