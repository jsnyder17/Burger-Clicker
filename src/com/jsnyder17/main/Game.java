package com.jsnyder17.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.jsnyder17.burgercreators.BurgerCreator;
import com.jsnyder17.gui.MainView;
import com.jsnyder17.gui.ShopView;

public class Game {
	private JFrame frame;
	private MainView mainView;
	private ShopView shopView;
	private CardLayout cardLayout;
	private JPanel containerPanel;
	private JPanel navigationPanel;
	
	private GameManager gm;

	public Game() {
		gm = new GameManager();
		
		frame = new JFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		mainView = new MainView(gm);
		shopView = new ShopView(gm);
		
		initializeContainerPanel();
		initializeNavPanel();
		
		frame.add(containerPanel, BorderLayout.CENTER);
		frame.add(navigationPanel, BorderLayout.SOUTH);
	}
	
	private void initializeContainerPanel() {
		cardLayout = new CardLayout();
		containerPanel = new JPanel(cardLayout);
		
		containerPanel.add(mainView, "main");
		containerPanel.add(shopView, "shop");
	}
	
	private void initializeNavPanel() {
		navigationPanel = new JPanel();
		
		JButton mainButton = new JButton();
		mainButton.setText("Main");
		mainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(containerPanel, "main");
			}
		});
		navigationPanel.add(mainButton);
		
		JButton storeButton = new JButton();
		storeButton.setText("Store");
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(containerPanel, "shop");
			}
		});
		navigationPanel.add(storeButton);
	}
	
	public void start() {
		frame.setVisible(true);
	}
}
