package frgp.utn.edu.ar.dominio;

import frgp.utn.edu.ar.dtos.ClienteRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Entity
@Table(name = "clientes")

public class Cliente {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String dni;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Column(nullable = false)
	private String sexo;
	@Column(nullable = false)
	private Date fechaNac;
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private String localidad;
	@Column(nullable = false, unique = true)
	private String email;
	@Column
	private String telefono;
	@Column(nullable = false)
	private Boolean eliminado;

	public Cliente() { }

	public Cliente(String dni,
				   String nombre,
				   String apellido,
				   String sexo,
				   Date fechaNac,
				   String direccion,
				   String localidad,
				   String email,
				   String telefono)
	{
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.direccion = direccion;

		this.localidad = localidad;
		this.email = email;
		this.telefono = telefono;

		this.eliminado = false;
	}


	// Getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getEliminado() { return eliminado; }

	public void setEliminado(Boolean eliminado) { this.eliminado = eliminado; }

	public String getNombreCompleto(){
		return this.nombre + " " + this.apellido;
	}

	public ClienteRequest construirDtoClienteRequest(){

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formatter.format(fechaNac);

		ClienteRequest c = new ClienteRequest
				(this.id, this.dni, this.nombre, this.apellido,
				this.sexo, fecha, this.direccion, this.localidad, this.email, this.telefono);

		return c;
	}
}
