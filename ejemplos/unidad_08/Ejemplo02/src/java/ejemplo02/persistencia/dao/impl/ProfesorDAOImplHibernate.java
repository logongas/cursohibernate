package ejemplo02.persistencia.dao.impl;

import ejemplo02.persistencia.dao.ProfesorDAO;
import ejemplo02.dominio.Profesor;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

public class ProfesorDAOImplHibernate extends GenericDAOImplHibernate<Profesor,Integer> implements  ProfesorDAO {

}
