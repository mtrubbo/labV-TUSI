package negocio;

import dao.UsuarioDao;
import entidad.Usuario;

public class UsuarioNegocio {

	private UsuarioDao usuarioDao;

	public UsuarioNegocio(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public boolean agregarUsuario(Usuario usuario)
	{
		String u = usuario.getUsuario();
		boolean existe = this.usuarioDao.Exist(u);
		if(existe ==false)
		{
			this.usuarioDao.Add(usuario);
			return true;
		}
		return false;
	}
}
