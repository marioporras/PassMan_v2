package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import conexion.Conexion;
import dao.OrganizadorDAO;
import dao.UsuarioDAO;
import modelos.Usuario;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JProgressBar;
import javax.swing.UIManager;


public class RegisterView extends JFrame implements ActionListener  {
	
	private JTextField textField_email;
	private JTextField textField_pass;
	private static final String EMAIL_PATTERN = 
		    "^[a-z0-9](\\.?[a-z0-9]){6,30}@gmail\\.com$";
	private JTextField textField_user;

	
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
		
		JLabel lblEmail = new JLabel("Enter email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(204, 204, 204));
		lblEmail.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(108, 54, 135, 25);
		panel_1.add(lblEmail);
		
		JLabel lblPass = new JLabel("Enter master password:");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setForeground(new Color(204, 204, 204));
		lblPass.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblPass.setBackground(Color.WHITE);
		lblPass.setBounds(70, 200, 210, 25);
		panel_1.add(lblPass);
		
		JButton btnRegistrar = new JButton("Register now");
		btnRegistrar.setForeground(new Color(204, 204, 204));
		btnRegistrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(127, 297, 89, 25);
		panel_1.add(btnRegistrar);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(78, 90, 195, 25);
		panel_1.add(textField_email);
		
		
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					UsuarioDAO miUsuarioDAO = new UsuarioDAO();
					Usuario miUsuario = new Usuario();
					String nombre=textField_email.getText();
					if (nombre.matches(EMAIL_PATTERN)) {
						miUsuarioDAO.registrarUsuario(textField_email.getText(), textField_pass.getText(), textField_user.getText());
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

	
		
		
		JLabel lblWelcome = new JLabel("WELCOME PASSMAN!");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblWelcome.setBounds(70, 11, 210, 25);
		panel_1.add(lblWelcome);
		
		
		
		
		textField_pass = new JPasswordField();
		textField_pass.setColumns(10);
		textField_pass.setBounds(108, 236, 135, 25);
		panel_1.add(textField_pass);
		
		JButton btnGenerar = new JButton("Generate");
		btnGenerar.setForeground(new Color(204, 204, 204));
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrganizadorDAO miOrganizadorDAO = new OrganizadorDAO();
				String password = String.copyValueOf(miOrganizadorDAO.generatePass());
				textField_pass.setText(password);
			}
		});
		btnGenerar.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnGenerar.setFocusPainted(false);
		btnGenerar.setContentAreaFilled(false);
		btnGenerar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setBounds(253, 236, 66, 25);
		panel_1.add(btnGenerar);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(102, 272, 146, 14);
		progressBar.setStringPainted(true);
		panel_1.add(progressBar);
		
		JLabel lblUser = new JLabel("Enter username:");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(new Color(204, 204, 204));
		lblUser.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblUser.setBackground(Color.WHITE);
		lblUser.setBounds(108, 127, 135, 25);
		panel_1.add(lblUser);
		
		textField_user = new JTextField();
		textField_user.setColumns(10);
		textField_user.setBounds(78, 163, 195, 25);
		panel_1.add(textField_user);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(new Color(255, 255, 255));
		lblFondo.setIcon(new ImageIcon(RegisterView.class.getResource("/assets/Fondo_Login_Register_View.PNG")));
		lblFondo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblFondo.setBounds(0, 0, 720, 399);
		panel.add(lblFondo);
		
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
		
		//Actualizamos nuestra progressbar
		Timer t=new Timer(100,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	if (textField_pass.getText().length()<1) {
        			progressBar.setValue(0);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_pass.getText().length()<2){
        			progressBar.setValue(5);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_pass.getText().length()<3){
        			progressBar.setValue(10);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_pass.getText().length()<4){
        			progressBar.setValue(15);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_pass.getText().length()<5){
        			progressBar.setValue(20);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_pass.getText().length()<6){
        			progressBar.setValue(25);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_pass.getText().length()<7){
        			progressBar.setValue(30);
        			progressBar.setForeground(Color.red);
        			progressBar.setString("Muy débil");
        		}else if(textField_pass.getText().length()<8){
        			progressBar.setValue(35);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_pass.getText().length()<9){
        			progressBar.setValue(40);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_pass.getText().length()<10){
        			progressBar.setValue(45);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_pass.getText().length()<11){
        			progressBar.setValue(50);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_pass.getText().length()<12){
        			progressBar.setValue(55);
        			progressBar.setForeground(Color.ORANGE);
        			progressBar.setString("Débil");
        		}else if(textField_pass.getText().length()<13){
        			progressBar.setValue(60);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_pass.getText().length()<14){
        			progressBar.setValue(66);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_pass.getText().length()<15){
        			progressBar.setValue(71);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_pass.getText().length()<16){
        			progressBar.setValue(80);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_pass.getText().length()<17){
        			progressBar.setValue(86);
        			progressBar.setForeground(Color.yellow);
        			progressBar.setString("Aceptable");
        		}else if(textField_pass.getText().length()<18){
        			progressBar.setValue(94);
        			progressBar.setForeground(Color.green);
        			progressBar.setString("Segura");
        		}else if(textField_pass.getText().length()<19){
        			progressBar.setForeground(Color.green);
        			progressBar.setValue(100);
        			progressBar.setString("Segura");
        			progressBar.setToolTipText("No deberías de estar viendo esto");
        			
        		}else if(textField_pass.getText().length()>18){
        			progressBar.setForeground(Color.darkGray);
        			progressBar.setValue(100);
        			progressBar.setString("18 caracteres max.");        			
        		}
            }
        });
        t.start();

						
				
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
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}