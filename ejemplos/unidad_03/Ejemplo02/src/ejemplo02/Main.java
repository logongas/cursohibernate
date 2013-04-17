
package ejemplo02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Main {


    public static void main(String[] args) {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                
        Direccion direccion=new Direccion(2, "Avd Del Cid", 4, "Mislata", "Valencia");
        Profesor profesor=new Profesor(2, "Carlos", "González", "Oltra");
        profesor.setDireccion(direccion);
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(profesor);
        
        session.getTransaction().commit();
        session.close();

    }
}

