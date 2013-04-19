package ejemplo04.presentacion;

import ejemplo04.persistencia.dao.impl.UsuarioDAOImplHibernate;
import ejemplo04.persistencia.dao.UsuarioDAO;
import ejemplo04.dominio.Usuario;
import com.fpmislata.persistencia.dao.BussinessException;



public class UsuarioController {
    UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO=new UsuarioDAOImplHibernate();
    }

    public void guardar(Usuario usuario) throws BussinessException {
            usuarioDAO.saveOrUpdate(usuario);
    }
}
