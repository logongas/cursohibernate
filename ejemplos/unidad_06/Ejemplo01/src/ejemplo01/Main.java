
package ejemplo01;

import org.hibernate.LockOptions;
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
            System.out.println("----------- Acceso a direccion -----------");
            Session session = sessionFactory.openSession();

            Profesor profesor = (Profesor) session.get(Profesor.class, 1066);
            System.out.println("Leido el profesor");
            System.out.println("Calle=" + profesor.getDireccion().getMunicipio().getNombre());

            session.close();
        }
        {
            System.out.println("----------- Acceso a direccion con sesion cerrada -----------");
            Session session = sessionFactory.openSession();

            Profesor profesor = (Profesor) session.get(Profesor.class, 1065);
            System.out.println("Leido el profesor");

            session.close();
            try {
                System.out.println("Municipio=" + profesor.getDireccion().getMunicipio().getNombre());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        {
            System.out.println("----------- evict -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = (Profesor) session.get(Profesor.class, 1001);
            session.evict(profesor);
            session.close();
        }

        {
            System.out.println("----------- Uso de merge -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = new Profesor(1001, "LLUIS", "GOMIS", "MARTINEZ");

            Profesor profesor2 = (Profesor) session.merge(profesor);
            System.out.println("¿Son iguales los objeto profesor y profesor2? " + (profesor == profesor2));

            Profesor profesor3 = (Profesor) session.merge(profesor2);
            System.out.println("¿Son iguales los objeto profesor2 y profesor3? " + (profesor2 == profesor3));

            session.close();
        }


        {
            System.out.println("----------- Uso de refresh con profesor que existe -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = new Profesor(1001, "LLUIS", "GOMIS", "MARTINEZ");
            session.refresh(profesor);
            session.close();
        }

        {
            System.out.println("----------- Uso de refresh con profesor que NO existe -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = new Profesor(-1, "LLUIS", "GOMIS", "MARTINEZ");
            try {
                session.refresh(profesor);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            session.close();
        }

        {
            System.out.println("----------- lock -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = (Profesor) session.get(Profesor.class, 1001);
            session.buildLockRequest(LockOptions.UPGRADE).lock(profesor);
            session.close();
        }


        
        {
            System.out.println("----------- Uso de merge -----------");
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Profesor profesor = new Profesor(1001, "LLUIS", "GOMIS", "MARTINEZ");
            Profesor profesor2 = (Profesor) session.get(Profesor.class, 1001);

            profesor.setNombre("JUAN");
            session.saveOrUpdate(profesor);

            session.getTransaction().commit();
            session.close();
        }

        sessionFactory.close();        
        
    }
}
