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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
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
import modelos.Usuario;

import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;


public class RegisterView extends JFrame implements ActionListener  {
	private JTextField textField;
	private JTextField textField_1;
	private static final String EMAIL_PATTERN = 
		    "^[a-z0-9](\\.?[a-z0-9]){6,30}@gmail\\.com$";
	private JTextField textField_2;

	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(720, 399);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public RegisterView() {
		setUndecorated(true);
		setTitle("Login");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		int h = 100;
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 720, 399);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(184, 51, 351, 322);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter email:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(108, 54, 135, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter master password:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(70, 200, 210, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNo_1 = new JButton("Register now");
		btnNo_1.setForeground(new Color(204, 204, 204));
		btnNo_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1.setFocusPainted(false);
		btnNo_1.setContentAreaFilled(false);
		btnNo_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNo_1.setBackground(Color.WHITE);
		btnNo_1.setBounds(127, 297, 89, 25);
		panel_1.add(btnNo_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(78, 90, 195, 25);
		panel_1.add(textField);
		
		
		
		btnNo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					UsuarioDAO miUsuarioDAO = new UsuarioDAO();
					Usuario miUsuario = new Usuario();
					String nombre=textField.getText();
					if (nombre.matches(EMAIL_PATTERN)) {
						miUsuarioDAO.registrarUsuario(textField.getText(), textField_1.getText(), textField_2.getText());
						JOptionPane.showMessageDialog(null, "Correct registration! Now you can use PassMan");
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
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(70, 11, 210, 25);
		panel_1.add(lblNewLabel_2);
		
		
		
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 236, 135, 25);
		panel_1.add(textField_1);
		
		JButton btnNo_1_1 = new JButton("Generate");
		btnNo_1_1.setForeground(new Color(204, 204, 204));
		btnNo_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
				String password = String.copyValueOf(miOrganizadorDAO.generatePass());
				textField_1.setText(password);
			}
		});
		btnNo_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1.setFocusPainted(false);
		btnNo_1_1.setContentAreaFilled(false);
		btnNo_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNo_1_1.setBackground(Color.WHITE);
		btnNo_1_1.setBounds(253, 236, 66, 25);
		panel_1.add(btnNo_1_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(102, 272, 146, 14);
		progressBar.setStringPainted(true);
		panel_1.add(progressBar);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter username:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(108, 127, 135, 25);
		panel_1.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 163, 195, 25);
		panel_1.add(textField_2);
		
		
		
		JButton btnNo_1_1_2_1 = new JButton("");
		btnNo_1_1_2_1.setBounds(479, 11, 48, 25);
		panel.add(btnNo_1_1_2_1);

		btnNo_1_1_2_1.setActionCommand("");
		
		btnNo_1_1_2_1.setForeground(Color.BLACK);
		btnNo_1_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_2_1.setFocusPainted(false);
		btnNo_1_1_2_1.setContentAreaFilled(false);
		btnNo_1_1_2_1.setBorder(null);
		btnNo_1_1_2_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setIcon(new ImageIcon(RegisterView.class.getResource("/assets/Fondo_Login_Register_View.PNG")));
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_5.setBounds(0, 0, 720, 399);
		panel.add(lblNewLabel_5);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCerrar.setToolTipText("cerrar");
		btnCerrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnCerrar.setFocusPainted(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBounds(656, 11, 54, 43);
		panel.add(btnCerrar);
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginView frame;
				frame = new LoginView();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnAtras.setToolTipText("atras");
		btnAtras.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnAtras.setFocusPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBounds(592, 11, 54, 43);
		panel.add(btnAtras);
		
		
		
		Timer t=new Timer(100,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	if (textField_1.getText().length()<1) {
        			progressBar.setValue(0);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_1.getText().length()<2){
        			progressBar.setValue(5);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_1.getText().length()<3){
        			progressBar.setValue(10);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_1.getText().length()<4){
        			progressBar.setValue(15);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_1.getText().length()<5){
        			progressBar.setValue(20);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_1.getText().length()<6){
        			progressBar.setValue(25);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_1.getText().length()<7){
        			progressBar.setValue(30);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_1.getText().length()<8){
        			progressBar.setValue(35);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_1.getText().length()<9){
        			progressBar.setValue(40);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_1.getText().length()<10){
        			progressBar.setValue(45);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_1.getText().length()<11){
        			progressBar.setValue(50);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_1.getText().length()<12){
        			progressBar.setValue(55);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_1.getText().length()<13){
        			progressBar.setValue(60);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_1.getText().length()<14){
        			progressBar.setValue(66);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_1.getText().length()<15){
        			progressBar.setValue(71);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_1.getText().length()<16){
        			progressBar.setValue(80);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_1.getText().length()<17){
        			progressBar.setValue(86);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_1.getText().length()<18){
        			progressBar.setValue(94);
        			progressBar.setForeground(Color.green);
        			progressBar.setString("Segura");
        		}else if(textField_1.getText().length()<19){
        			progressBar.setForeground(Color.green);
        			progressBar.setValue(100);
        			progressBar.setString("Segura");
        			progressBar.setToolTipText("No deberías de estar viendo esto");
        			
        		}else if(textField_1.getText().length()>18){
        			progressBar.setForeground(Color.darkGray);
        			progressBar.setValue(100);
        			progressBar.setString("18 caracteres max.");        			
        		}
            }
        });
        t.start();
		
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