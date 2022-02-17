package modelos;

public class Organizador {
	
	private String titulo;
	private String correo;
	private String username;
	private String password;
	private String sitioweb;
	
	public Organizador(String titulo, String correo, String username, String password, String sitioweb) {
		super();
		this.titulo = titulo;
		this.correo = correo;
		this.username = username;
		this.password = password;
		this.sitioweb = sitioweb;
	}
	
	public Organizador() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSitioweb() {
		return sitioweb;
	}

	public void setSitioweb(String sitioweb) {
		this.sitioweb = sitioweb;
	}
	
	
}
