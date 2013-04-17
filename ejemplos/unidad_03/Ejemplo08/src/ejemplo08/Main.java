
package ejemplo08;

import java.util.ArrayList;
import java.util.List;
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


        Profesor profesor = new Profesor(10, "Laura", "Vivó", "López");
        List<CorreoElectronico> correosElectronicos = new ArrayList<>();
        correosElectronicos.add(new CorreoElectronico(3, "laura@yahoo.com", profesor));
        correosElectronicos.add(new CorreoElectronico(2, "laura@hotmail.com", profesor));
        correosElectronicos.add(new CorreoElectronico(1, "laura@gmail.com", profesor));

        profesor.setCorreosElectronicos(correosElectronicos);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(profesor);


        session.getTransaction().commit();
        session.close();

    }
}
