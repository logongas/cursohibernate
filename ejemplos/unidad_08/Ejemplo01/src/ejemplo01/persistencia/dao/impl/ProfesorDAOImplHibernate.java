package ejemplo01.persistencia.dao.impl;

import ejemplo01.persistencia.dao.ProfesorDAO;
import ejemplo01.dominio.Profesor;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

public class ProfesorDAOImplHibernate extends GenericDAOImplHibernate<Profesor,Integer> implements  ProfesorDAO {

}
