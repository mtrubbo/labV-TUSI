package frgp.utn.edu.ar.dtos;

import frgp.utn.edu.ar.dominio.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteRequest {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String sexo;
    private String fechaNac;
    private String direccion;
    private String localidad;
    private String email;
    private String telefono;

    public ClienteRequest(){ }

    public ClienteRequest(
            int id,
            String dni,
            String nombre,
            String apellido,
            String sexo,
            String fechaNac,
            String direccion,
            String localidad,
            String email,
            String telefono){
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.localidad = localidad;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fechaNac=" + fechaNac +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public int getId() { return id; }

    public void setId(int id) {this.id = id; }

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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
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

    public Cliente construirCliente(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try{
            fecha = df.parse(this.fechaNac);
        }
        catch (Exception e){
            System.out.println(e);
        }

        Cliente c = new Cliente(dni, nombre, apellido, sexo, fecha, direccion, localidad, email, telefono);

        if(id != 0){
            c.setId(id);
        }

        return c;
    }
}
