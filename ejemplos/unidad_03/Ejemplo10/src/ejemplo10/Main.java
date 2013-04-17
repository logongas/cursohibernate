
package ejemplo10;

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
            
                
        Profesor profesor1=new Profesor(13, "Ana Isabel", "Perez", "León");
        Profesor profesor2=new Profesor(14, "Francisco", "Moya", "Salas");        

        Modulo modulo1=new Modulo(4, "Sistemas gestores de bases de datos");
        Modulo modulo2=new Modulo(5, "Programación");
        Modulo modulo3=new Modulo(6, "Lenguaje de marcas");

        profesor1.getModulos().add(modulo1);
        profesor1.getModulos().add(modulo2);
        profesor2.getModulos().add(modulo3);

        modulo1.getProfesores().add(profesor1);
        modulo2.getProfesores().add(profesor1);
        modulo3.getProfesores().add(profesor2);


        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(profesor1);
        session.save(profesor2);     

        session.getTransaction().commit();
        session.close();
        
    }
}
