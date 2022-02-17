package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.jdbc.PreparedStatement;

import conexion.Conexion;
import modelos.EmailSender;
import modelos.Usuario;

public class UsuarioDAO extends AbstractDAO {

	
	Statement stm;
	ResultSet rs;
	Usuario miUsuario;
		
	public UsuarioDAO() {
		super();
		stm = null;
		rs = null;
		miUsuario = new Usuario();
	}
	
	public boolean pruebaLogin(Usuario miUsuario) {
		//String miSeudo, String miContra
		
		//Conexion miConexion = new Conexion();
		
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectar();
		
		String sql = "SELECT Email, Password FROM user WHERE Email = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, miUsuario.getEmail());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if (miUsuario.getPassword().equals(rs.getString(2))) {
					return true;
				}else {
					return false;
				}
			}
			
		
			return false;
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
	
	public boolean registrarUsuario(String email, String password) {
		PreparedStatement pr;
		Connection con = conectar();
		EmailSender myEmailSender = new EmailSender();
		try {
			//String password = String.copyValueOf(generatePass());
			pr = (PreparedStatement) super.cn.prepareStatement("insert into user" + "(email,password) values(?,?);");
			pr.setString(1,email);	
			pr.setString(2,password);
			pr.executeUpdate();
			myEmailSender.sendAnEmail(email);
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isPasswordCorrect (char[] j1,char[] j2) {
		boolean valor = false;
		int i = 0;
			if (j1.length != j2.length){
				valor = false;
			}
			else{
				while((!valor)&&(i < j1.length)){
					if (j1[i] != j2[i]){
						valor = false;
				}
			else{
				valor = true;
				}
			}
		}
		return valor;
		}
	
	
	
}
