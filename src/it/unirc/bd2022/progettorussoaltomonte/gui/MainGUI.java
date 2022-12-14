package it.unirc.bd2022.progettorussoaltomonte.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import it.unirc.bd2022.progettorussoaltomonte.gui.cliente.NuovoCliente;


import java.awt.SystemColor;
import javax.swing.JTextPane;

public class MainGUI {

	private JFrame frmParamountHotelTimesSquare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmParamountHotelTimesSquare.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmParamountHotelTimesSquare = new JFrame();
		frmParamountHotelTimesSquare.setTitle("\u201CParamount Hotel Times Square\u201D ");
		frmParamountHotelTimesSquare.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/it/unirc/bd2022/progettorussoaltomonte/img/photo_5821382305334279250_x.jpg")));
		frmParamountHotelTimesSquare.getContentPane().setBackground(Color.WHITE);
		frmParamountHotelTimesSquare.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JLabel lblmagine = new JLabel("\u201CParamount Hotel Times Square\u201D \r\n                                               \r\n                                                          By Altomonte,Russo");
		lblmagine.setForeground(new Color(0, 0, 128));
		lblmagine.setFont(new Font("Vladimir Script", Font.PLAIN, 58));
		lblmagine.setIcon(new ImageIcon(MainGUI.class.getResource("/it/unirc/bd2022/progettorussoaltomonte/img/photo_5821382305334279250_x.jpg")));
	
		frmParamountHotelTimesSquare.getContentPane().add(lblmagine, BorderLayout.WEST);
		frmParamountHotelTimesSquare.setBounds(100, 100, 450, 300);
		frmParamountHotelTimesSquare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Gestione");
		frmParamountHotelTimesSquare.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(new Color(0, 0, 255));
		mnFile.setForeground(new Color(0, 0, 0));
		menuBar.add(mnFile);
		
		JMenuItem mntmEsci = new JMenuItem("Esci");
		mntmEsci.setBackground(SystemColor.menu);
		mntmEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmEsci);
		
		JMenu mnGestione = new JMenu("Gestione");
		mnGestione.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnGestione);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnGestione.add(mnCliente);
		
		JMenuItem mntmNuovoCliente = new JMenuItem("Nuovo Cliente");
		mntmNuovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuovoCliente nuovocliente=new NuovoCliente();
				nuovocliente.setVisible(true);

			}
		});
		mnCliente.add(mntmNuovoCliente);
		
	}
	

	
	

}
