package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user")
	private String usuario;
	
	@Column(name="pass")
	private String contrasenia;
	
	//Constructor vacio
	public Usuario()
	{
		
	}


	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	//Desarrollo métodos init y destroy
	
		public void initUsuario()
		{
			System.out.println("Se inicializa bean");
		}
		
		public void destroyUsuario()
		{
			System.out.println("Se destruye bean");
		}

	@Override
	public String toString() {
		return "Usuario= " + usuario + ", Contraseña= " + contrasenia + "";
	}

}
