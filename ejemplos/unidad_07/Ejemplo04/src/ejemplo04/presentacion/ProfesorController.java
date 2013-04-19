
package ejemplo04.presentacion;

import ejemplo04.persistencia.dao.impl.ProfesorDAOImplHibernate;
import ejemplo04.persistencia.dao.ProfesorDAO;
import ejemplo04.dominio.Profesor;
import com.fpmislata.persistencia.dao.BussinessException;



public class ProfesorController {


    ProfesorDAO profesorDAO;

    public ProfesorController() {
        profesorDAO=new ProfesorDAOImplHibernate();
    }

    public void guardar(Profesor profesor) throws BussinessException {

            profesorDAO.saveOrUpdate(profesor);
    }

}
