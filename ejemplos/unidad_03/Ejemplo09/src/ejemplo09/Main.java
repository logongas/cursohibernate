
package ejemplo09;

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
            
                
        Profesor profesor1=new Profesor(11, "Isabel", "Fuertes", "Gascón");
        Profesor profesor2=new Profesor(12, "Jose", "Valenciano", "Gimeno");        

        Modulo modulo1=new Modulo(1, "Sistemas Operativos en Red");
        Modulo modulo2=new Modulo(2, "Entornos de desarrollo");
        Modulo modulo3=new Modulo(3, "Sistemas Informáticos");

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
