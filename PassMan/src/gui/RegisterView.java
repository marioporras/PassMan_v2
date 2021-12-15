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

import conexion.Conexion;
import dao.UsuarioDAO;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.SetSplitState;
import modelos.Usuario;

import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;


public class RegisterView extends JFrame implements ActionListener  {
	private JTextField textField;
	private JTextField textField_1;
	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(644, 384);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public RegisterView() {
		setTitle("Login");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		int h = 100;
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 642, 473);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon(RegisterView.class.getResource("/assets/barthomesmall_preview_rev_1.png")));
		lblNewLabel.setBounds(0, 0, 638, 346);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(238, 42, 306, 256);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter username:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(85, 54, 135, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter email:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(85, 126, 136, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNo_1 = new JButton("Register now");
		btnNo_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1.setFocusPainted(false);
		btnNo_1.setContentAreaFilled(false);
		btnNo_1.setBorderPainted(false);
		btnNo_1.setBorder(null);
		btnNo_1.setBackground(Color.WHITE);
		btnNo_1.setBounds(108, 208, 89, 25);
		panel_1.add(btnNo_1);
		
		btnNo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					UsuarioDAO miUsuarioDAO = new UsuarioDAO();
					Usuario miUsuario = new Usuario();
					
					if (miUsuarioDAO.registrarUsuario(textField.getText(), textField_1.getText())) 
					{
						JOptionPane.showMessageDialog(null, "Correct registration! Your password has been sent to your mail");
						FirstView frame = new FirstView();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						Conexion miConexion = new Conexion();
						miConexion.cierraConexion();
						miConexion.conectar();
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect registration");

					}
				}
			
		});

	
		
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME PASSMAN!");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_2.setBounds(62, 0, 182, 17);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(110, 90, 86, 25);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 162, 86, 25);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(RegisterView.class.getResource("/assets/LOGOBART.png")));
		lblNewLabel_3.setBounds(532, 0, 100, 115);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Your password has been sent you to your email. Take care! It may be in spam.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_4.setBounds(235, 301, 330, 59);
		
		
		
		
		
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
		//Tomo el tamaño de la pantalla
				
				
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//launch(args);
					
					RegisterView frame = new RegisterView();
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