package frgp.utn.edu.ar.servicioImpl;

import frgp.utn.edu.ar.dao.UsuarioDao;
import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.dtos.LoginRequest;
import frgp.utn.edu.ar.servicio.LoginServicio;

import java.util.Objects;

public class LoginServicioImpl implements LoginServicio {

    private UsuarioDao dataAccess = null;

    public void setDataAccess(UsuarioDao dataAccess) {
        this.dataAccess = dataAccess;
    }
    @Override
    public Usuario autenticar(LoginRequest datosLogin) {
        Usuario usuario = dataAccess.obtenerUsuario(datosLogin.getUsuario());
        System.out.println(usuario.toString());
        
        if(usuario == null) {
            System.out.println("No se encontro usuario");
            return null;
        }

        if(!Objects.equals(usuario.getContrasena(), datosLogin.getContrasena())) {
            System.out.println("Contrasenia incorrecta");
            return null;
        }

        return usuario;
    }
}
