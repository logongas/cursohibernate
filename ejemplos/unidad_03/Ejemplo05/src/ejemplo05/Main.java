package ejemplo05;

import java.util.HashSet;
import java.util.Set;
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
            
        
        Profesor profesor=new Profesor(7, "Sara", "Barrrera", "Salas");
        Set<CorreoElectronico> correosElectronicos=new HashSet<>();
        correosElectronicos.add(new CorreoElectronico(3, "sara@yahoo.com",profesor));
        correosElectronicos.add(new CorreoElectronico(2, "sara@hotmail.com",profesor));
        correosElectronicos.add(new CorreoElectronico(1, "sara@gmail.com",profesor));

        profesor.setCorreosElectronicos(correosElectronicos);

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(profesor);


        session.getTransaction().commit();
        session.close();
        
    }
}
