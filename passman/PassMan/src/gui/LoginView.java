package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import dao.UsuarioDAO;
import modelos.Usuario;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class LoginView extends JFrame implements ActionListener  {
	private JTextField textField_email;
	private JPasswordField passwordField;
	
	 public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(720, 399);		
	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public LoginView() {
		setUndecorated(true);
		setTitle("Login");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		int h = 100;
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 720, 399);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(214, 62, 292, 284);
		panel.add(panel_1);
		
		JLabel lblEmail = new JLabel("Enter email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(85, 29, 135, 25);
		panel_1.add(lblEmail);
		
		JLabel lblPass = new JLabel("Enter password:");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblPass.setBackground(Color.WHITE);
		lblPass.setBounds(85, 117, 136, 25);
		panel_1.add(lblPass);
		
		JButton btnRegistrar = new JButton("Register now");
		btnRegistrar.setForeground(Color.LIGHT_GRAY);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterView frame = new RegisterView();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnRegistrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(108, 234, 89, 25);
		panel_1.add(btnRegistrar);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.setForeground(Color.LIGHT_GRAY);
		btnLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(108, 198, 89, 25);
		panel_1.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Usuario miUsuario = new Usuario();
				UsuarioDAO miUsuarioDAO = new UsuarioDAO();
				String contra = new String(passwordField.getPassword());
				
				if(!passwordField.getPassword().toString().contentEquals("") && !contra.contentEquals("")) {
					miUsuario.setEmail(textField_email.getText());
					miUsuario.setPassword(contra);
					
					try {
						if(miUsuarioDAO.pruebaLogin(miUsuario)) {
							try {
								System.out.println(UsuarioDAO.user);
								JOptionPane.showMessageDialog(null, "Logeado correctamente");
								TreeView menu = new TreeView(); 
								menu.setLocationRelativeTo(null);
								dispose();
								menu.setVisible(true);
							}catch(Exception ex) {
								
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrectamente");

						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else { 					
						JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrectamente");

						
					};
				
				};
				
		});
		
		textField_email = new JTextField();
		textField_email.setBackground(new Color(255, 255, 204));
		textField_email.setColumns(10);
		textField_email.setBounds(51, 65, 204, 25);
		panel_1.add(textField_email);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 153, 135, 25);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/assets/Fondo_Login_Register_View.PNG")));
		lblNewLabel.setBounds(0, 0, 720, 398);
		panel.add(lblNewLabel);
		
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
				FirstView frame;
				frame = new FirstView();
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
		
		
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
				
				
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}