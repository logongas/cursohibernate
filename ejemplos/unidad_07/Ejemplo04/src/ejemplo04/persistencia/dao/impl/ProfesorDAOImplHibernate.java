package ejemplo04.persistencia.dao.impl;

import ejemplo04.persistencia.dao.ProfesorDAO;
import ejemplo04.dominio.Profesor;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

public class ProfesorDAOImplHibernate extends GenericDAOImplHibernate<Profesor,Integer> implements  ProfesorDAO {

}
