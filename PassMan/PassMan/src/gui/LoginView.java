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

public class LoginView extends JFrame implements ActionListener  {
	private JTextField textField;
	private JPasswordField passwordField;
	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(644, 384);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public LoginView() {
		setTitle("Login");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		int h = 100;
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 642, 473);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/assets/beak-g3edd93948_640_preview_rev_1.png")));
		lblNewLabel.setBounds(24, 0, 624, 372);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(203, 22, 307, 293);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter email:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(85, 54, 135, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter password:");
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
		btnNo_1.setBounds(108, 245, 89, 25);
		panel_1.add(btnNo_1);
		
		JButton btnNo_2 = new JButton("Log in");
		btnNo_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		//btnNo_2.setFocusPainted(false);
		//btnNo_2.setContentAreaFilled(false);
		//btnNo_2.setBorderPainted(false);
		btnNo_2.setBorder(null);
		btnNo_2.setBackground(Color.WHITE);
		btnNo_2.setBounds(108, 198, 89, 25);
		panel_1.add(btnNo_2);
		btnNo_2.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Usuario miUsuario = new Usuario();
				UsuarioDAO miUsuarioDAO = new UsuarioDAO();
				String contra = new String(passwordField.getPassword());
				
				if(!passwordField.getPassword().toString().contentEquals("") && !contra.contentEquals("")) {
					miUsuario.setEmail(textField.getText());
					miUsuario.setPassword(contra);
					
					if(miUsuarioDAO.pruebaLogin(miUsuario)) {
						
						JOptionPane.showMessageDialog(null, "Logeado correctamente");
						PanelView menu = new PanelView(); 
						menu.setLocationRelativeTo(null);
						dispose();
						menu.setVisible(true);
						//menu.setExtendedState(JFrame.MAXIMIZED_BOTH); 
						//LoginJefeMecanico.this.setVisible(false);

						
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrectamente");

					}
					}else { 					
						JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrectamente");

						
					};
				
				};
				
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("ARE YOU SURE YO WANT TO PASS?");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_2.setBounds(2, 0, 302, 17);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(51, 90, 204, 25);
		panel_1.add(textField);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(86, 162, 135, 25);
		panel_1.add(passwordField);
		
		
		
		
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
		//Tomo el tamaño de la pantalla
				
				
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//launch(args);
					
					LoginView frame = new LoginView();
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