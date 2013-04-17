package ejemplo03;

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
               
        Direccion direccion1=new Direccion(3, "Calle de la sarten", 23, "Manises", "Valencia");
        Profesor profesor1=new Profesor(3, "Sergio", "Mateo", "Ramis");
        profesor1.setDireccion(direccion1);
        direccion1.setProfesor(profesor1);
        
        Direccion direccion2=new Direccion(4, "Calle Luis lamarca", 45, "Torrente", "Valencia");
        Profesor profesor2=new Profesor(4, "Paco", "Moreno", "Díaz");
        profesor2.setDireccion(direccion2);
        direccion2.setProfesor(profesor2);        
        
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(profesor1);
        session.save(direccion2);
        
        session.getTransaction().commit();
        session.close();

    }
}
