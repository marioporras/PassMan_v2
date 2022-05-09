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
import java.util.Random;

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
import modelos.Organizador;
import modelos.Usuario;
import utils.AES;

import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.KeyEvent;
import javax.swing.JProgressBar;


public class CreateSSpaceView extends JFrame implements ActionListener  {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
	private JTextField textField_5;
	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(670, 478);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	      
	      
	  }
	
	public CreateSSpaceView() {
		setTitle("Nueva cuenta");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		int h = 100;
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 654, 473);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		//lblNewLabel.setIcon(new ImageIcon(CreateSSpaceView.class.getResource("/assets/beak-g3edd93948_640_preview_rev_1.png")));
		lblNewLabel.setBounds(10, 135, 180, 338);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(165, 11, 424, 390);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(144, 44, 135, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(144, 92, 136, 25);
		panel_1.add(lblNewLabel_1_1);
		
		
	
		JLabel lblNewLabel_2 = new JLabel("GUARDA TU CUENTA");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNewLabel_2.setBounds(132, 0, 159, 43);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField.setColumns(10);
		textField.setBounds(142, 66, 139, 30);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 118, 229, 17);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(144, 189, 136, 22);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 212, 159, 17);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("URL");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(143, 266, 136, 25);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 293, 181, 17);
		panel_1.add(textField_3);
		
		JButton btnNo_1_1 = new JButton("Generar");
		btnNo_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNo_1_1.setForeground(Color.RED);
		btnNo_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = String.copyValueOf(miOrganizadorDAO.generatePass());
				textField_2.setText(password);
			}
		});
		btnNo_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1.setFocusPainted(false);
		btnNo_1_1.setContentAreaFilled(false);
		btnNo_1_1.setBackground(Color.WHITE);
		btnNo_1_1.setForeground(Color.BLACK);
		
		final Random r=new Random();
        Timer t=new Timer(3000,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
                btnNo_1_1.setForeground(c);
            }
        });
        t.start();
        
		btnNo_1_1.setBounds(301, 208, 73, 25);
		panel_1.add(btnNo_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Usuario");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(144, 140, 136, 25);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(150, 161, 123, 17);
		panel_1.add(textField_4);
		
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Categoria");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_2_1.setBounds(143, 331, 136, 25);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 357, 189, 22);
		try {
			miOrganizadorDAO.llenarCombo(comboBox);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_1.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(215, 358, 123, 21);
		panel_1.add(textField_5);
		
		JButton btnNo_1_1_1 = new JButton("Crear");
		btnNo_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNo_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(miOrganizadorDAO.crearCategoria(textField_5.getText())) {
						JOptionPane.showMessageDialog(null, "Categoria creada correctamente");
						comboBox.removeAllItems();
						miOrganizadorDAO.llenarCombo(comboBox);
					}else {
						JOptionPane.showMessageDialog(null, "Categoria existente");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Categoria existente");
				}
			}
		});
		
		btnNo_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_1.setFocusPainted(false);
		btnNo_1_1_1.setContentAreaFilled(false);
		btnNo_1_1_1.setBackground(Color.WHITE);
		btnNo_1_1_1.setBounds(355, 355, 59, 25);
		panel_1.add(btnNo_1_1_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(133, 241, 158, 14);
		panel_1.add(progressBar);
		Timer t1=new Timer(10,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	if (textField_2.getText().length()<1) {
        			progressBar.setValue(0);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_2.getText().length()<2){
        			progressBar.setValue(5);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_2.getText().length()<3){
        			progressBar.setValue(10);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_2.getText().length()<4){
        			progressBar.setValue(15);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_2.getText().length()<5){
        			progressBar.setValue(20);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_2.getText().length()<6){
        			progressBar.setValue(25);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_2.getText().length()<7){
        			progressBar.setValue(30);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_2.getText().length()<8){
        			progressBar.setValue(35);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_2.getText().length()<9){
        			progressBar.setValue(40);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_2.getText().length()<10){
        			progressBar.setValue(45);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_2.getText().length()<11){
        			progressBar.setValue(50);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_2.getText().length()<12){
        			progressBar.setValue(55);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_2.getText().length()<13){
        			progressBar.setValue(60);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_2.getText().length()<14){
        			progressBar.setValue(66);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_2.getText().length()<15){
        			progressBar.setValue(71);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_2.getText().length()<16){
        			progressBar.setValue(80);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_2.getText().length()<17){
        			progressBar.setValue(86);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_2.getText().length()<18){
        			progressBar.setValue(94);
        			progressBar.setForeground(Color.green);
        			progressBar.setString("Segura");
        		}else if(textField_2.getText().length()<19){
        			progressBar.setValue(100);
        			progressBar.setValue(94);
        			progressBar.setForeground(Color.green);
        			progressBar.setString("Segura");
        		}
            }
        });
        t1.start();
		
		JButton btnNo_1_1_2 = new JButton("\u21E6 Atr\u00E1s");
		btnNo_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TreeView frame;
				try {
					frame = new TreeView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNo_1_1_2.setBounds(10, 11, 73, 25);
		panel.add(btnNo_1_1_2);
		btnNo_1_1_2.setForeground(SystemColor.desktop);
		btnNo_1_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_2.setFocusPainted(false);
		btnNo_1_1_2.setContentAreaFilled(false);
		btnNo_1_1_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNo_1_1_2.setBackground(Color.WHITE);
		
		JButton btnNo_1 = new JButton("Guardar");
		btnNo_1.setBounds(342, 412, 73, 25);
		panel.add(btnNo_1);
		btnNo_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNo_1.setFocusPainted(false);
		btnNo_1.setContentAreaFilled(false);
		btnNo_1.setBackground(Color.WHITE);
		btnNo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
				Organizador miOrganizador = new Organizador();
				miOrganizador.setId(UsuarioDAO.iD);
				miOrganizador.setTitulo(textField.getText());
				miOrganizador.setCorreo(textField_1.getText());
				miOrganizador.setUsername(textField_4.getText());
				miOrganizador.setPassword(textField_2.getText());
				miOrganizador.setSitioweb(textField_3.getText());
				miOrganizador.setCategoria(comboBox.getSelectedItem().toString());
				if (miOrganizadorDAO.crearDatos(miOrganizador)) 
				{
					JOptionPane.showMessageDialog(null, "Registrado correctamente");
					
				}else {
					SQLException a = null;
					JOptionPane.showMessageDialog(null, a);
				}
			}	
		});
		
		
		
		
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
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}