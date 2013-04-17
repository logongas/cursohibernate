package ejemplo03;

import com.fpmislata.persistencia.hibernate.util.BussinessException;



public class UsuarioController {
    UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO=new UsuarioDAOImplHibernate();
    }

    public void guardar(Usuario usuario) throws BussinessException {
            usuarioDAO.saveOrUpdate(usuario);
    }
}
