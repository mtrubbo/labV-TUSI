package GRUPO6.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;
    private String Nombre;
    private String Apellido;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNacionalidad")
    private Nacionalidad Nacionalidad;
    private String Email;



    public Autor() { }

    public Autor(int ID, String nombre, String apellido,
                 Nacionalidad nacionalidad, String email) {
        this.ID = ID;
        Nombre = nombre;
        Apellido = apellido;
        Nacionalidad = nacionalidad;
        Email = email;
    }



    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public GRUPO6.entity.Nacionalidad getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(GRUPO6.entity.Nacionalidad nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return 
                "ID: " + ID +
                ", Nombre: " + Nombre +
                ", Apellido: " + Apellido +
                ", Email: " + Email +
                ", Nacionalidad: " + Nacionalidad.getDescripcion();
    }
}
