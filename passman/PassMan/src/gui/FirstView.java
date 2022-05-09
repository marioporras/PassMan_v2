package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.border.LineBorder;

import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.border.TitledBorder;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.SetSplitState;

import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;

public class FirstView extends JFrame implements ActionListener  {
	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(670, 384);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public FirstView() {
		//setTitle("Login");
		setUndecorated(true);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 670, 384);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(null);
		logo.setBounds(10, 312, 33, 61);
		panel.add(logo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FirstView.class.getResource("/assets/firstView.png")));
		lblNewLabel.setBounds(0, 0, 670, 383);
		panel.add(lblNewLabel);
		
		JButton btnNo_1_1 = new JButton("");
		btnNo_1_1.setForeground(new Color(245, 245, 245));
		btnNo_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView frame = new LoginView();
				frame.setLocationRelativeTo(null);
				dispose();
				frame.setVisible(true);
				
			}
		});
		btnNo_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNo_1_1.setFocusPainted(false);
		btnNo_1_1.setContentAreaFilled(false);
		btnNo_1_1.setBorderPainted(false);
		btnNo_1_1.setBorder(null);
		btnNo_1_1.setBackground(Color.WHITE);
		btnNo_1_1.setBounds(0, 0, 630, 345);
		panel.add(btnNo_1_1);
		;
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
		//Tomo el tama�o de la pantalla
				
				
	}
	
	
   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//launch(args);
					
					FirstView frame = new FirstView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	public void abrir(ActionEvent e) {
		String acceso = new String(psdfContrasena.getPassword());		
		VentaVentana ventaVentana;
		miUsuario = miUsuarioDao.pruebaLogin(txtfUsuario.getText(), acceso);	
	}
*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}