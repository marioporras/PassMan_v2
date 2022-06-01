package tabla;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.Statement;

import conexion.Conexion;
import modelos.Organizador;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * Instancia un JFrame con un JDesktopPane y dentro de este
 * un JInternalFrame.
 *
 */
public class Tablero extends JFrame {

	/** Instancia esta clase */
	public static void main(String[] args) {
		new Tablero();
	}
	
	public void CentrarJFrame(){
	      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(720, 399);		

	      setLocationRelativeTo(null);		
	      setVisible(true);
	  }
	
	/**
	 * Crea el JFrame, el JDesktopPane, un JInternalFrame de
	 * muestra y lo visualiza.
	 */
	public Tablero()
	{
		// El JFrame con el JDesktopPane
		
		
		DefaultTableModel tm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (0 == column)
					return false;
				return super.isCellEditable(row, column);
			}
		};

		// Titulos para la cabecera superior. El primero es vacio,
		// puesto que corresponde
		tm.setColumnIdentifiers(new String[] { "Titulo", "Email", "Usuario", "Password", "sitioweb", " Categoria" });
		

		// JTable al que se le pasa el modelo recien creado y se
		// sobreescribe el metodo changeSelection para que no permita
		// seleccionar la primera columna.
		JTable t = new JTable(tm);
		t.setSelectionForeground(Color.BLACK);
		t.setSelectionBackground(Color.RED);
		t.setGridColor(Color.LIGHT_GRAY);
		t.setBackground(Color.BLACK);
		t.setForeground(Color.WHITE);
		
		
		Conexion miConexion = new Conexion();
		Connection conexion = miConexion.conectar(); 
		String sql = "SELECT titulo,correo,username,password,sitioweb,categoria FROM organizador";
		Statement st;
		
		Organizador miOrganizador = new Organizador();
		
		String dato[] = new String[6];
		try {
	
			
			st = (Statement) conexion.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			while (result.next()) {
				dato[0] = result.getString(1);
				dato[1] = result.getString(2);
				dato[2] = result.getString(3);
				dato[3] = result.getString(4);
				dato[4] = result.getString(5);
				dato[5] = result.getString(6);
				tm.addRow(dato);

			}

		}catch(SQLException ex) {
			ex.printStackTrace();
	}
		

		// Se pone a la primera columna el render del JTableHeader
		// superior.
		//t.getColumnModel().getColumn(0).setCellRenderer(
			//	t.getTableHeader().getDefaultRenderer());
		
		// Creación y visualización de la ventana completa.
		JFrame v = new JFrame("Prueba JInternalFrame");
		v.getContentPane().setBackground(Color.BLACK);
		v.setBackground(Color.BLACK);
		v.setUndecorated(true);

		//v.getContentPane().add(dp, BorderLayout.SOUTH);
		//v.getContentPane().setBounds(0,0,200,200);
		// Se construye el panel que ira dentro del JInternalFrame
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		v.getContentPane().setLayout(null);
		// Se visualiza todo.
		
		
		// Se visualiza el JInternalFrame 
		//p.add(t);
		JScrollPane scrollPane = new JScrollPane(t);
		scrollPane.setBounds(0, 81, 720, 231);
		scrollPane.getViewport().setBackground(Color.black);
		//scrollPane.setBounds(0, 0, 200, 200);
		scrollPane.setVisible(true);
		//getContentPane().add(scrollPane);
		v.getContentPane().add(scrollPane);
		
		//internal.getContentPane().add(scrollPane2);
		//internal.setVisible(true);
		v.getContentPane().validate();
		v.getContentPane().repaint();
		v.setSize(720,399);
		v.setVisible(true);
		v.setLocationRelativeTo(null);		

		  
		  t.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					doMouseClicked(me);
				}
					public void doMouseClicked(MouseEvent me) {
						int fila = t.rowAtPoint(me.getPoint());
						int columna = t.columnAtPoint(me.getPoint());
						//t.setSelectionBackground(Color.PINK);
						/*uso la columna para valiar si corresponde a la columna de perfil garantizando
						 * que solo se produzca algo si selecciono una fila de esa columna
						 */
						System.out.println("Columna"+ columna+",fila="+fila);
					}
					});
		    TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(tm);
		    t.setRowSorter(elQueOrdena);
			t.setModel(tm);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(102, 22, 89, 23);
			v.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Tablero.class.getResource("/assets/Fondo_CreateSpaceView.PNG")));
			lblNewLabel.setBounds(0, 0, 720, 399);
			v.getContentPane().add(lblNewLabel);
			//CentrarJFrame();

	
	}
}