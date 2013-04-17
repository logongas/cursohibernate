
package ejemplo07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Lorenzo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
                
        Profesor profesor1=new Profesor(412, "Elias", "Rubio", "Sánchez",TipoFuncionario.Carrera);
        Profesor profesor2=new Profesor(413, "Juan Mnuael", "Campos", "Alierta",TipoFuncionario.Practicas);        
        Profesor profesor3=new Profesor(414, "Anabel", "Marco", "Izquierdo",TipoFuncionario.Interino);
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(profesor1);
        session.save(profesor2);
        session.save(profesor3);

        session.getTransaction().commit();
        session.close();
                
    }
}
