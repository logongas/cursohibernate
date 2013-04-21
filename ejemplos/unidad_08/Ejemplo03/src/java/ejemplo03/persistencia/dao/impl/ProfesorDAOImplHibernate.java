package ejemplo03.persistencia.dao.impl;

import ejemplo03.persistencia.dao.ProfesorDAO;
import ejemplo03.dominio.Profesor;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

public class ProfesorDAOImplHibernate extends GenericDAOImplHibernate<Profesor,Integer> implements  ProfesorDAO {

}
