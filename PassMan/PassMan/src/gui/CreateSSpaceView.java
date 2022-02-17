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
import java.sql.SQLException;

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
import dao.OrganizadorDAO;
import dao.UsuarioDAO;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.SetSplitState;
import modelos.Organizador;
import modelos.Usuario;

import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;


public class CreateSSpaceView extends JFrame implements ActionListener  {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(644, 384);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public CreateSSpaceView() {
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
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel.setIcon(new ImageIcon(CreateSSpaceView.class.getResource("/assets/beak-g3edd93948_640_preview_rev_1.png")));
		lblNewLabel.setBounds(27, 0, 611, 373);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(224, 11, 323, 314);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(94, 44, 135, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(93, 92, 136, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNo_1 = new JButton("Guardar");
		btnNo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
				Organizador miOrganizador = new Organizador();
				
				miOrganizador.setTitulo(textField.getText());
				miOrganizador.setCorreo(textField_1.getText());
				miOrganizador.setUsername(textField_4.getText());
				miOrganizador.setPassword(textField_2.getText());
				miOrganizador.setSitioweb(textField_3.getText());
				
				if (miOrganizadorDAO.crearDatos(miOrganizador)) 
				{
					JOptionPane.showMessageDialog(null, "Registrado correctamente");
					
				}else {
					SQLException a = null;
					JOptionPane.showMessageDialog(null, a);
				}
			}	
		});
		
		btnNo_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1.setFocusPainted(false);
		btnNo_1.setContentAreaFilled(false);
		btnNo_1.setBorderPainted(false);
		btnNo_1.setBorder(null);
		btnNo_1.setBackground(Color.WHITE);
		btnNo_1.setBounds(89, 289, 73, 25);
		panel_1.add(btnNo_1);
	
		JLabel lblNewLabel_2 = new JLabel("GUARDA TU CUENTA");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNewLabel_2.setBounds(78, 0, 167, 43);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 66, 111, 17);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 118, 132, 17);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(93, 189, 136, 22);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 212, 111, 17);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("URL");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(93, 232, 136, 25);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 260, 134, 17);
		panel_1.add(textField_3);
		
		JButton btnNo_1_1 = new JButton("Generar");
		btnNo_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
				String password = String.copyValueOf(miOrganizadorDAO.generatePass());
				textField_2.setText(password);
			}
		});
		btnNo_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1.setFocusPainted(false);
		btnNo_1_1.setContentAreaFilled(false);
		btnNo_1_1.setBorderPainted(false);
		btnNo_1_1.setBorder(null);
		btnNo_1_1.setBackground(Color.WHITE);
		btnNo_1_1.setBounds(227, 212, 86, 17);
		panel_1.add(btnNo_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Usuario");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(93, 140, 136, 25);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(106, 161, 111, 17);
		panel_1.add(textField_4);
		
		JButton btnNo_1_1_1 = new JButton("Atras");
		btnNo_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelView menu = new PanelView(); 
				menu.setLocationRelativeTo(null);
				dispose();
				menu.setVisible(true);
			}
		});
		
		btnNo_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_1.setFocusPainted(false);
		btnNo_1_1_1.setContentAreaFilled(false);
		btnNo_1_1_1.setBorderPainted(false);
		btnNo_1_1_1.setBorder(null);
		btnNo_1_1_1.setBackground(Color.WHITE);
		btnNo_1_1_1.setBounds(159, 291, 73, 23);
		panel_1.add(btnNo_1_1_1);
		
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
					
					CreateSSpaceView frame = new CreateSSpaceView();
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