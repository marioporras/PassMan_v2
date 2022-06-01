package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import conexion.Conexion;
import dao.UsuarioDAO;
import tabla.CabeceraLateral;
import utils.AES;
import utils.JLabelLink;
import utils.Scrapping;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class TreeView extends JFrame{
	private java.sql.Connection cn;
	private ResultSet rs;
	private java.sql.Statement st;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private static final int color_OPAQUE=0;
	private String titulo;
	private JLabelLink link = new JLabelLink();
	private String correo;
	private String username; 
	private String password; 
	private String sitioweb;							
	private String cuenta;
	private int ver = 0;
	private Scrapping miScrap = new Scrapping();
	private int scrappingNumber = 2;
	
	public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(720, 399);		
	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public TreeView() throws SQLException {
		
		setUndecorated(true);
		getContentPane().setBackground(Color.white);
		getContentPane().setLayout(null);
		CentrarJFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 720, 399);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 722, 399);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		DefaultMutableTreeNode passman=new DefaultMutableTreeNode("PassMan");
		JTree jt=new JTree(passman);
		jt.setBorder(null);
		Rectangle r = new Rectangle(0, 0, 0, 0);
		jt.computeVisibleRect(r);
		jt.setShowsRootHandles(true);
		jt.setToggleClickCount(1);
		jt.setSize(new Dimension(4, 0));
		jt.setForeground(new Color(0, 0, 0));
		jt.setOpaque(false);
		jt.setBackground(Color.BLACK);
		jt.setSize(194, 218);
		jt.setLocation(158, 54);
		jt.setScrollsOnExpand(true);
		
		JScrollPane scroll = new JScrollPane(jt);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBounds(148, 54, 194, 198);
		scroll.setBackground(Color.black);
		/*
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = Color.BLACK;
			}
		});
		*/
		panel_1.add(scroll);
		

		TreeCellRenderer cr = jt.getCellRenderer();
		if (cr instanceof DefaultTreeCellRenderer) {
		  DefaultTreeCellRenderer dtcr =
		               (DefaultTreeCellRenderer)cr; 

		  dtcr.setBackgroundNonSelectionColor(null);
		  dtcr.setBackgroundSelectionColor(Color.gray);
		  dtcr.setTextSelectionColor(Color.red); 
		  dtcr.setTextNonSelectionColor(Color.white); 
		  //Icon closedIcon = new ImageIcon(Objects.requireNonNull(
	                //this.getClass().getResource("/assets/firstview.png")));
	        //Icon openIcon = new ImageIcon(Objects.requireNonNull(
	                //this.getClass().getResource("/images/lightbulb.png")));
	        //Icon leafIcon = new ImageIcon(Objects.requireNonNull(
	               // this.getClass().getResource("/images/lightning.png")));
		  //dtcr.setLeafIcon(closedIcon); 

		  jt.setBackground(Color.black); 
		} 
	
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(353, 53, 226, 218);
		panel_1.add(lblNewLabel_1);
		
		JButton btnCrear = new JButton("Guardar nueva cuenta/crear categoria");
		btnCrear.setForeground(Color.LIGHT_GRAY);
		btnCrear.setBounds(259, 283, 204, 51);
		panel_1.add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateSSpaceView menu = new CreateSSpaceView(); 
				menu.setLocationRelativeTo(null);
				dispose();
				menu.setVisible(true);
			}
		});
		btnCrear.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnCrear.setFocusPainted(false);
		btnCrear.setContentAreaFilled(false);
		btnCrear.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCrear.setBackground(Color.WHITE);
		
		JButton btnScrapper = new JButton("");
		btnScrapper.setToolTipText("notificar cambios en la pagina web por medio del correo de esta cuenta");
		btnScrapper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
					miScrap.scrap(correo,sitioweb,titulo);	
			}
		});
		btnScrapper.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnScrapper.setFocusPainted(false);
		btnScrapper.setContentAreaFilled(false);
		btnScrapper.setBounds(658, 212, 54, 35);
		panel_1.add(btnScrapper);
		
		JButton btnCopiarC = new JButton("");
		btnCopiarC.setToolTipText("copiar contrase\u00F1a");
		btnCopiarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String password_decrypt = AES.decrypt(password, "patrondelmal");
			Toolkit.getDefaultToolkit()
	        .getSystemClipboard()
	        .setContents(
	                (Transferable) new StringSelection(password_decrypt),
	                null
	        );
			CabeceraLateral cabecera = new CabeceraLateral();
			cabecera.main();
			}
			
		});
		btnCopiarC.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnCopiarC.setFocusPainted(false);
		btnCopiarC.setContentAreaFilled(false);
		btnCopiarC.setBounds(658, 168, 54, 43);
		panel_1.add(btnCopiarC);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(23, 365, 150, 23);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TreeView.class.getResource("/assets/Fondo_TreeView.PNG")));
		lblNewLabel.setBounds(0, 0, 719, 399);
		panel_1.add(lblNewLabel);
		
		panel_1.setVisible(true);
		;
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
		
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				doMouseClicked(me);
			}
				public void doMouseClicked(MouseEvent me) {
					TreePath tp = jt.getPathForLocation(me.getX(), me.getY());
					if(tp!=null) {
						if(tp.getPathCount() == 4) {
							
								try {
									ver = 0;
								    String sql = "SELECT titulo,correo,organizador.username,organizador.password,sitioweb FROM organizador, user WHERE user.iD = organizador.id AND organizador.titulo= + '" + tp.getLastPathComponent().toString() + "'";
								    st = cn.createStatement();
								    rs = st.executeQuery(sql); //run your query

								    while (rs.next()) //go through each row that your query returns
								    {
								    	
								    	lblNewLabel_1.remove(link);
								    	titulo = rs.getString("titulo"); //get the element in column "item_code"
								         correo= rs.getString("correo");
								         username= rs.getString("username"); 
								         password= rs.getString("password"); 
								        System.out.println(AES.decrypt(password, "patrondelmal"));
								         sitioweb = rs.getString("sitioweb");							
								        cuenta = "<html><p>Esta es tu cuenta de " + titulo + ":<p>" + 
								        				"	<p><strong>correo</strong>: "+ correo+"<p>"+
								        				"	<p><b>usuario: </b>"+ username + "<p>"+
								        				"	<p><b>contraseña: </b>"+ password + "<p>";
								        				//"	<p><b>url: <p>";

								        
								        link.setText(sitioweb);
								        link.setLink(sitioweb);  
								        link.setTextLink(sitioweb); 
								        link.setBounds(1, 168, 200, 40);
								        lblNewLabel_1.setText(cuenta);
								        lblNewLabel_1.add(link);
								    }
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
						}
					}else {
						System.out.println("nothing");
					}
				}
		});
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setToolTipText("Ver contrase\u00F1a");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ver == 0) {
					String password_decrypt = AES.decrypt(password, "patrondelmal");
					cuenta = "<html><p>Esta es tu cuenta de " + titulo + ":<p>" + 
	        				"	<p><strong>correo</strong>: "+ correo+"<p>"+
	        				"	<p><b>usuario: </b>"+ username + "<p>"+
	        				"	<p><b>contraseña: </b>"+ password_decrypt + "<p>";
	        				

	        
	        link.setText(sitioweb);
	        link.setLink(sitioweb);  
	        link.setTextLink(sitioweb); 
	        link.setBounds(1, 156, 200, 40);
	        lblNewLabel_1.setText(cuenta);
	        lblNewLabel_1.add(link);
	        ver = 1;
			
				}else {
					cuenta = "<html><p>Esta es tu cuenta de " + titulo + ":<p>" + 
	        				"	<p><strong>correo</strong>: "+ correo+"<p>"+
	        				"	<p><b>usuario: </b>"+ username + "<p>"+
	        				"	<p><b>contraseña: </b>"+ password + "<p>";
	        				

	        
	        link.setText(sitioweb);
	        link.setLink(sitioweb);  
	        link.setTextLink(sitioweb); 
	        link.setBounds(1, 156, 200, 40);
	        lblNewLabel_1.setText(cuenta);
	        lblNewLabel_1.add(link);
	        ver = 0;
			
				}
				
			}
		});
		btnDecrypt.setBounds(656, 136, 56, 30);
		btnDecrypt.setFocusPainted(false);
		btnDecrypt.setContentAreaFilled(false);
		btnDecrypt.setBorderPainted(false);
		btnDecrypt.setBorder(null);
		panel_1.add(btnDecrypt);
		
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
		btnCerrar.setBounds(658, 11, 54, 43);
		panel_1.add(btnCerrar);
		
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
		btnAtras.setBounds(598, 11, 54, 43);
		panel_1.add(btnAtras);
		

		
		DefaultMutableTreeNode a = new DefaultMutableTreeNode("Categoria");
		passman.add(a);
				
		try {
			Class.forName(Conexion.controlador);
			cn = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
			st=cn.createStatement();
			rs=st.executeQuery("SELECT organizador.titulo, organizador.categoria from organizador, user where user.iD = organizador.iD and user.id ='"+ UsuarioDAO.iD + "'order by organizador.categoria");
			lblNewLabel_2.setText(UsuarioDAO.user);
			
			
			ArrayList<Integer> listaIds = new ArrayList<Integer>();
			String categoriaActual = null;
			DefaultMutableTreeNode categoria = null;
			while(rs.next()) {
				if (categoriaActual == null) {
					categoriaActual = rs.getString(2);
					categoria = new DefaultMutableTreeNode(rs.getString(2));
					a.add(categoria);
					DefaultMutableTreeNode titulo = new DefaultMutableTreeNode(rs.getString(1));
					categoria.add(titulo);
				}else {
					if (!categoriaActual.equals(rs.getString(2))){
						categoria = new DefaultMutableTreeNode(rs.getString(2));
						a.add(categoria);
						categoriaActual = rs.getString(2);
						DefaultMutableTreeNode titulo = new DefaultMutableTreeNode(rs.getString(1));
						categoria.add(titulo);
					}else {
						DefaultMutableTreeNode titulo = new DefaultMutableTreeNode(rs.getString(1));
						categoria.add(titulo);
					}
				}
				
				
				
			}
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println(ex);
			
			}
				
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					TreeView frame = new TreeView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
