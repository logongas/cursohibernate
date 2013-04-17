package ejemplo01;

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
        
        
        Direccion direccion=new Direccion(1, "Plaza del ayuntamiento", 8, "Xativa", "Valencia");
        Profesor profesor=new Profesor(1, "Juan", "Perez", "García");
        profesor.setDireccion(direccion);
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(profesor);
        
        session.getTransaction().commit();
        session.close();

    }
}
