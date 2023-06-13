package frgp.utn.edu.ar.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles_usuario")
public class RolUsuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String descripcion;
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
