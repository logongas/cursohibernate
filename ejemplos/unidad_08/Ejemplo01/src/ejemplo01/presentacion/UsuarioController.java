package ejemplo01.presentacion;

import ejemplo01.persistencia.dao.UsuarioDAO;
import ejemplo01.dominio.Usuario;
import com.fpmislata.persistencia.dao.BussinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UsuarioController {

    @Autowired
    UsuarioDAO usuarioDAO;


    public void guardar(Usuario usuario) throws BussinessException {
            usuarioDAO.saveOrUpdate(usuario);
    }
}
