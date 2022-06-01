package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import dao.OrganizadorDAO;
import dao.UsuarioDAO;
import modelos.Organizador;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyEvent;
import javax.swing.JProgressBar;


public class CreateSSpaceView extends JFrame implements ActionListener  {
	
	private JTextField textField_titulo;
	private JTextField textField_email;
	private JTextField textField_contrasena;
	private JTextField textField_URL;
	private JTextField textField_usuario;
	OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
	private JTextField textField_categoria;
	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(720, 399);		
	      setLocationRelativeTo(null);		
	      setVisible(true);   
	  }
	
	public CreateSSpaceView() {
		setUndecorated(true);
		setTitle("Nueva cuenta");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		int h = 100;
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 720, 399);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(165, 11, 424, 378);
		panel.add(panel_1);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(102, 102, 102));
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setBounds(144, 44, 135, 25);
		panel_1.add(lblTitulo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(102, 102, 102));
		lblEmail.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(144, 92, 136, 25);
		panel_1.add(lblEmail);
		
		
	
		JLabel lblNewLabel_2 = new JLabel("GUARDA TU CUENTA");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNewLabel_2.setBounds(132, 11, 159, 32);
		panel_1.add(lblNewLabel_2);
		
		textField_titulo = new JTextField();
		textField_titulo.setColumns(10);
		textField_titulo.setBounds(142, 66, 139, 17);
		panel_1.add(textField_titulo);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(97, 118, 229, 17);
		panel_1.add(textField_email);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setForeground(new Color(102, 102, 102));
		lblContrasena.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblContrasena.setBackground(Color.WHITE);
		lblContrasena.setBounds(144, 189, 136, 22);
		panel_1.add(lblContrasena);
		
		textField_contrasena = new JPasswordField();
		textField_contrasena.setColumns(10);
		textField_contrasena.setBounds(132, 212, 159, 17);
		panel_1.add(textField_contrasena);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrl.setForeground(new Color(102, 102, 102));
		lblUrl.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblUrl.setBackground(Color.WHITE);
		lblUrl.setBounds(143, 266, 136, 25);
		panel_1.add(lblUrl);
		
		textField_URL = new JTextField();
		textField_URL.setColumns(10);
		textField_URL.setBounds(121, 293, 181, 17);
		panel_1.add(textField_URL);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setBorder(null);
		btnGenerar.setForeground(Color.RED);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = String.copyValueOf(miOrganizadorDAO.generatePass());
				textField_contrasena.setText(password);
			}
		});
		btnGenerar.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnGenerar.setFocusPainted(false);
		btnGenerar.setContentAreaFilled(false);
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setForeground(Color.BLACK);    
		btnGenerar.setBounds(301, 212, 47, 32);
		panel_1.add(btnGenerar);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(102, 102, 102));
		lblUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(144, 140, 136, 25);
		panel_1.add(lblUsuario);
		
		textField_usuario = new JTextField();
		textField_usuario.setColumns(10);
		textField_usuario.setBounds(150, 161, 123, 17);
		panel_1.add(textField_usuario);
		
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setForeground(new Color(102, 102, 102));
		lblCategoria.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblCategoria.setBackground(Color.WHITE);
		lblCategoria.setBounds(144, 321, 136, 25);
		panel_1.add(lblCategoria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(16, 345, 189, 22);
		try {
			miOrganizadorDAO.llenarCombo(comboBox);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_1.add(comboBox);
		
		textField_categoria = new JTextField();
		textField_categoria.setColumns(10);
		textField_categoria.setBounds(215, 346, 123, 21);
		panel_1.add(textField_categoria);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(miOrganizadorDAO.crearCategoria(textField_categoria.getText())) {
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
		
		btnCrear.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnCrear.setFocusPainted(false);
		btnCrear.setContentAreaFilled(false);
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setBounds(356, 336, 58, 31);
		panel_1.add(btnCrear);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(133, 241, 158, 14);
		panel_1.add(progressBar);
		Timer t1=new Timer(10,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	if (textField_contrasena.getText().length()<1) {
        			progressBar.setValue(0);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_contrasena.getText().length()<2){
        			progressBar.setValue(5);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_contrasena.getText().length()<3){
        			progressBar.setValue(10);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_contrasena.getText().length()<4){
        			progressBar.setValue(15);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_contrasena.getText().length()<5){
        			progressBar.setValue(20);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_contrasena.getText().length()<6){
        			progressBar.setValue(25);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_contrasena.getText().length()<7){
        			progressBar.setValue(30);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_contrasena.getText().length()<8){
        			progressBar.setValue(35);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_contrasena.getText().length()<9){
        			progressBar.setValue(40);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_contrasena.getText().length()<10){
        			progressBar.setValue(45);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_contrasena.getText().length()<11){
        			progressBar.setValue(50);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_contrasena.getText().length()<12){
        			progressBar.setValue(55);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_contrasena.getText().length()<13){
        			progressBar.setValue(60);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_contrasena.getText().length()<14){
        			progressBar.setValue(66);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_contrasena.getText().length()<15){
        			progressBar.setValue(71);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_contrasena.getText().length()<16){
        			progressBar.setValue(80);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_contrasena.getText().length()<17){
        			progressBar.setValue(86);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_contrasena.getText().length()<18){
        			progressBar.setValue(94);
        			progressBar.setForeground(Color.green);
        			progressBar.setString("Segura");
        		}else if(textField_contrasena.getText().length()<19){
        			progressBar.setValue(100);
        			progressBar.setValue(94);
        			progressBar.setForeground(Color.green);
        			progressBar.setString("Segura");
        		}
            }
        });
        t1.start();
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
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
		btnAtras.setBounds(585, 11, 73, 35);
		panel.add(btnAtras);
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnAtras.setFocusPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorder(null);
		btnAtras.setBackground(Color.WHITE);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(33, 363, 95, 25);
		panel.add(btnGuardar);
		btnGuardar.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnGuardar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnGuardar.setFocusPainted(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBackground(Color.WHITE);
		
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
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CreateSSpaceView.class.getResource("/assets/Create22.PNG")));
		lblFondo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblFondo.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		lblFondo.setBounds(0, 0, 722, 400);
		panel.add(lblFondo);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
				Organizador miOrganizador = new Organizador();
				miOrganizador.setId(UsuarioDAO.iD);
				miOrganizador.setTitulo(textField_titulo.getText());
				miOrganizador.setCorreo(textField_email.getText());
				miOrganizador.setUsername(textField_usuario.getText());
				miOrganizador.setPassword(textField_contrasena.getText());
				miOrganizador.setSitioweb(textField_URL.getText());
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
		

		final Random r=new Random();
        Timer t=new Timer(3000,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
                btnGenerar.setForeground(c);
            }
        });
        t.start();
				
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