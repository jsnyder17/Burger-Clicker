package com.jsnyder17.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

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
	private JPanel mainPanel;
	private JPanel shopPanel;
	
	private GameManager gm;

	public Game() {
		gm = new GameManager();
		
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		initializePanels();
	}
	
	private void initializePanels() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		mainPanel = new MainView(gm);
		mainPanel.setBorder(border);
		mainPanel.setSize(new Dimension(frame.getWidth() / 2, frame.getHeight()));
		frame.add(mainPanel, BorderLayout.CENTER);
		
		shopPanel = new ShopView(gm);
		shopPanel.setBorder(border);
		shopPanel.setSize(new Dimension(frame.getWidth() / 3, frame.getHeight()));
		frame.add(shopPanel, BorderLayout.EAST);
	}
	
	public void start() {
		frame.setVisible(true);
	}
}
