package negocio;

import dao.UsuarioDao;
import entidad.Usuario;


public class UsuarioNegocio {

    private static UsuarioNegocio instance;
    private UsuarioDao usuarioDao;

    public UsuarioNegocio() {
      
    }

    public static UsuarioNegocio getInstance() {
        if (instance == null) {
            instance = new UsuarioNegocio();
        }
        return instance;
    }

    public boolean agregarUsuario(Usuario usuario) {
        usuarioDao = new UsuarioDao();
        boolean existe = usuarioDao.Exist(usuario.getUsuario());
        if (!existe) {
            usuarioDao.Add(usuario);
            return true;
        }
        return false;
    }
}