
package ejemplo01.presentacion;

import ejemplo01.persistencia.dao.ProfesorDAO;
import ejemplo01.dominio.Profesor;
import com.fpmislata.persistencia.dao.BussinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProfesorController {

    @Autowired
    ProfesorDAO profesorDAO;

    public void guardar(Profesor profesor) throws BussinessException {

            profesorDAO.saveOrUpdate(profesor);
    }

}
