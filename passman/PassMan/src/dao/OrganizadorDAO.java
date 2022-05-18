package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;
import utils.JLabelLink;
import modelos.Organizador;
import utils.AES;

public class OrganizadorDAO extends AbstractDAO {

	Statement stm;
	ResultSet rs;
	Organizador miOrganizador;
	ArrayList<Organizador> organizadorList = new ArrayList<Organizador>();
	ArrayList<String> categoryList = new ArrayList<String>();
	
	public OrganizadorDAO() {
		super();
		stm = null;
		rs = null;
		miOrganizador = new Organizador();
	}
	
	/**
	 * Metodo que devuelve todos los datos de la tabla organizador
	 * @return
	 */
	public ArrayList<Organizador> mostrarDatos() {
		try {
			String sql = "SELECT titulo,correo,username,password,sitioweb FROM organizador";
			stm = (Statement) cn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Organizador miOrganizador = new Organizador();
					miOrganizador.setTitulo(rs.getString("titulo"));
					miOrganizador.setCorreo(rs.getString("correo"));
					miOrganizador.setUsername(rs.getString("username"));
					miOrganizador.setPassword(rs.getString("password"));
					miOrganizador.setSitioweb(rs.getString("sitioweb"));
			        organizadorList.add(miOrganizador);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return organizadorList;
	}
	
	public void populateJList(JLabel label) throws SQLException
	{
	    JLabel model = new JLabel(); //create a new list model
	    String sql = "SELECT * FROM organizador";
	    stm = cn.createStatement();
	    rs = stm.executeQuery(sql); //run your query

	    while (rs.next()) //go through each row that your query returns
	    {
	        String titulo = rs.getString("titulo"); //get the element in column "item_code"
	        String correo= rs.getString("correo");
	        String username= rs.getString("username"); 
	        String password= rs.getString("password"); 
	        String sitioweb = rs.getString("sitioweb");
	        String cuenta = "Esta es tu cuenta de " + titulo + ":\\N" +
	        				"correo: "+ correo+ "\\N"+
	        				"usuario: "+ username + "\\N"+
	        				"contraseña: "+ password + "\\N"+
	        				"url: "+ sitioweb;
	        model.setText(cuenta); //add each item to the model

	    }
	    
	    

	    rs.close();
	    stm.close();

	}
	
	
	
	public void cargarDatos(JLabelLink link, String selected) throws SQLException
	{
		
		String cuenta;
	    String sql = "SELECT titulo,correo,username,password,sitioweb FROM organizador WHERE titulo=+ '" + selected + "'";
	    stm = cn.createStatement();
	    rs = stm.executeQuery(sql); //run your query

	    while (rs.next()) //go through each row that your query returns
	    {
	    	String titulo = rs.getString("titulo"); //get the element in column "item_code"
	        String correo= rs.getString("correo");
	        String username= rs.getString("username"); 
	        String password= rs.getString("password"); 
	        String sitioweb = rs.getString("sitioweb");
	        cuenta = "<html><p>Esta es tu cuenta de " + titulo + ":<p>" + 
	        				"	<p><strong>correo</strong>: "+ correo+"<p>"+
	        				"	<p><b>usuario: </b>"+ username + "<p>"+
	        				"	<p><b>contraseña: </b>"+ password + "<p>"+
	        				"	<p><b>url: <dt>"+ sitioweb +"<p>";
	        //label.setText(cuenta);
	        
	        link.setTextLink( rs.getString("sitioweb"));
	        link.setLink( rs.getString("sitioweb"));
	    }

	    rs.close();
	    stm.close();

	}
	
	public boolean crearDatos(Organizador miOrganizador) {
		PreparedStatement pr;
		//Cliente miCLiente = new Cliente();
		try {
			pr = (PreparedStatement) super.cn.prepareStatement("insert into organizador" + "(iD,titulo,correo,username,password,sitioweb,categoria) values(?,?,?,?,?,?,?);");
			pr.setInt(1, miOrganizador.getId());
			pr.setString(2, miOrganizador.getTitulo());
			pr.setString(3, miOrganizador.getCorreo());
			pr.setString(4, miOrganizador.getUsername());
			pr.setString(5, AES.encrypt(miOrganizador.getPassword(), "patrondelmal"));
			pr.setString(6, miOrganizador.getSitioweb());
			pr.setString(7, miOrganizador.getCategoria());
			pr.executeUpdate();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public char[] generatePass() {
		int length = 18;
        String symbol = "-/.^&*_!@%=+>)"; 
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String small_letter = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 


        String finalString = cap_letter + small_letter + 
                numbers + symbol; 

        Random random = new Random(); 

        char[] password = new char[length]; 

        for (int i = 0; i < length; i++) 
        { 
            password[i] = 
                    finalString.charAt(random.nextInt(finalString.length())); 

        } 
        return password;
	}
	
	/**
	 * Comportamiento para llenar de datos un combobox
	 * @param miCombo
	 * @throws SQLException
	 */
	
	public void llenarCombo(JComboBox miCombo) throws SQLException {
		String sql = "SELECT * FROM categorias";
	    stm = cn.createStatement();
	    rs = stm.executeQuery(sql); //run your query

	    while (rs.next()) //go through each row that your query returns
	    {
	    	String categoria = rs.getString(2);
	    	miCombo.addItem (categoria);

	       
	    }
	    //label.setText(cuenta);

	    rs.close();
	    stm.close();

	}
	
	public boolean crearCategoria(String categoria) throws SQLException {
		PreparedStatement pr;
		Connection con = conectar();
		try {
			//String password = String.copyValueOf(generatePass());
			pr = (PreparedStatement) super.cn.prepareStatement("insert into categorias" + "(categoria) values(?);");
			pr.setString(1,categoria);	
			pr.executeUpdate();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	//
	public void magicTree(DefaultMutableTreeNode root) throws SQLException {
	    	String sql = "SELECT categoria FROM categorias";
	    	String sql_2 = "SELECT titulo, categoria FROM organizador";
		    stm = cn.createStatement();
		    stm.addBatch(sql);
		    stm.addBatch(sql_2);
	    while (rs.next()) {
	    	//DefaultMutableTreeNode a = new DefaultMutableTreeNode(rs.getString(1));
			//root.add(a);
			categoryList.add(rs.getString(1));
			//magicTree2(a);
	    }
	    rs.close();
	    stm.close();
	}
	
	public void arbolMagico(DefaultMutableTreeNode root) {
		for(int i = 0; i < categoryList.size(); i++) {
			//DefaultMutableTreeNode category = new DefaultMutableTreeNode(categoryList.get(i).toString());
			try {
				
				DefaultMutableTreeNode a = new DefaultMutableTreeNode(categoryList.get(i).toString());
				root.add(a);
				magicTree2(categoryList.get(i).toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void magicTree2(String categorias) throws SQLException {
	    try {
	    	String sql2 = "SELECT titulo, categoria FROM organizador";
		    stm = cn.createStatement();
		    rs = stm.executeQuery(sql2); //run your query
	    while (rs.next()) //go through each row that your query returns
	    {
	    	
	    	String ktg = rs.getString(2);
	    		if (categorias.equals(ktg)) {
	    			DefaultMutableTreeNode category = new DefaultMutableTreeNode(categorias);
					category.add(new DefaultMutableTreeNode(rs.getString(1)));
					System.out.println(categorias);
					//System.out.println(rs.getString(1));
	    	}else{
	    		//System.out.println("No jay");
	    	}
	    }
	    
	    }catch(SQLException e) {
	    	e.printStackTrace();

	    }rs.close();
	    stm.close();
	    
	}
	    
	
}

