package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import modelos.Organizador;
import modelos.Usuario;

public class OrganizadorDAO extends AbstractDAO {

	Statement stm;
	ResultSet rs;
	Organizador miOrganizador;
	ArrayList<Organizador> organizadorList = new ArrayList<Organizador>();
	
	public OrganizadorDAO() {
		super();
		stm = null;
		rs = null;
		miOrganizador = new Organizador();
	}
	
	
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
	
	
	
	public void cargarDatos(JLabel label, String selected) throws SQLException
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
	        label.setText(cuenta);
	    }
	    //label.setText(cuenta);

	    rs.close();
	    stm.close();

	}
	
	public boolean crearDatos(Organizador miOrganizador) {
		PreparedStatement pr;
		//Cliente miCLiente = new Cliente();
		try {
			pr = (PreparedStatement) super.cn.prepareStatement("insert into organizador" + "(titulo,correo,username,password,sitioweb) values(?,?,?,?,?);");
			pr.setString(1, miOrganizador.getTitulo());
			pr.setString(2, miOrganizador.getCorreo());
			pr.setString(3, miOrganizador.getUsername());
			pr.setString(4, miOrganizador.getPassword());
			pr.setString(5, miOrganizador.getSitioweb());
			pr.executeUpdate();
			return true;
		}
		catch (SQLException e) {
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
	
}
