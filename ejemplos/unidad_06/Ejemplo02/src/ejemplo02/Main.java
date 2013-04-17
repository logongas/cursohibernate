package ejemplo02;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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
        
        {
            System.out.println("----------- Las primeras validaciones -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = new Profesor("ca", null, "Gomez");
            
            try {
                
                session.beginTransaction();

                session.save(profesor);

                session.getTransaction().commit();
            } catch (ConstraintViolationException cve) {
                session.getTransaction().rollback();
                System.out.println("No se ha podido insertar el profesor");
            }
            session.close();

                
        }      
       
        {
            System.out.println("----------- Mensajes de error -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = new Profesor("ca", null, "Gomez");

            try {
                session.beginTransaction();

                session.save(profesor);

                session.getTransaction().commit();
            } catch (ConstraintViolationException cve) {
                session.getTransaction().rollback();
                System.out.println("No se ha podido insertar el profesor debido a los siguientes errores:");
                for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                    System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
                }                
            }
            session.close();
        }        
        
        

        sessionFactory.close();
    }
}
