/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo01.persistencia.dao.impl;

import ejemplo01.persistencia.dao.UsuarioDAO;
import ejemplo01.dominio.Usuario;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

/**
 *
 * @author papa
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario,Integer> implements  UsuarioDAO {

}
