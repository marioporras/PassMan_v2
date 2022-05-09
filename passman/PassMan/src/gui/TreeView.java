package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexion.Conexion;
import dao.OrganizadorDAO;
import dao.UsuarioDAO;
import utils.AES;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

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
	private int ver;
	
	public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(670, 384);		
	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	public TreeView() throws SQLException {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 669, 383);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		DefaultMutableTreeNode passman=new DefaultMutableTreeNode("PassMan");
		JTree jt=new JTree(passman);
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
		panel_1.add(jt);
		
		// Get the tree's cell renderer. If it is a default
		// cell renderer, customize it.
		TreeCellRenderer cr = jt.getCellRenderer();
		if (cr instanceof DefaultTreeCellRenderer) {
		  DefaultTreeCellRenderer dtcr =
		               (DefaultTreeCellRenderer)cr; 

		  // Set the various colors
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

		  // Finally, set the tree's background color 
		  jt.setBackground(Color.black); 
		} 
	
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(353, 53, 226, 218);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNo_1_1_1 = new JButton("Guardar nueva cuenta/crear categoria");
		btnNo_1_1_1.setBounds(213, 283, 204, 51);
		panel_1.add(btnNo_1_1_1);
		btnNo_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateSSpaceView menu = new CreateSSpaceView(); 
				menu.setLocationRelativeTo(null);
				dispose();
				menu.setVisible(true);
			}
		});
		btnNo_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNo_1_1_1.setFocusPainted(false);
		btnNo_1_1_1.setContentAreaFilled(false);
		btnNo_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNo_1_1_1.setBackground(Color.WHITE);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(77, 352, 158, 20);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TreeView.class.getResource("/assets/fondo_pers.png")));
		lblNewLabel.setBounds(0, 0, 669, 383);
		panel_1.add(lblNewLabel);
		
		panel_1.setVisible(true);
		;
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension tamano = (pantallaTamano);
		
		//Tomo el tamaño de la pantalla
		
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
								        link.setBounds(1, 156, 200, 40);
								        lblNewLabel_1.setText(cuenta);
								        lblNewLabel_1.add(link);
								    }
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
						}
					}else {
						System.out.println("else");
					}
				}
		});
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(605, 127, 64, 23);
		panel_1.add(btnNewButton);
		

		
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
					//launch(args);
					
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
