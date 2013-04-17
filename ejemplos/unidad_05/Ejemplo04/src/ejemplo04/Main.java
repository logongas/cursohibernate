
package ejemplo04;

import java.util.List;
import org.hibernate.Query;
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



        Session session = sessionFactory.openSession();

        {
            System.out.println("----------- Navegación por una propiedad -----------");
            String ape1 = (String) session.createQuery("SELECT p.nombre.ape1 FROM Profesor p WHERE id=1100").uniqueResult();
            System.out.println("Ape1="+ape1);


        }


        {
            System.out.println("----------- Navegar por varias propiedades enlazadas-----------");
            Query query = session.createQuery("SELECT p.nombre.ape1,p.direccion.municipio.nombre FROM Profesor p WHERE p.id IN (1100,1101,1102,1103)");
            List<Object[]> listDatos = (List<Object[]>) query.list();
            for (Object[] datos : listDatos) {
                System.out.println("El profesor " + datos[0] + " vive en " + datos[1]);
            }
        }

 
        {
            System.out.println("----------- Función SIZE en colecciones -----------");
            Query query = session.createQuery("SELECT p.nombre.ape1,SIZE(p.correosElectronicos) FROM Profesor p WHERE p.id IN (1100,1101,1102,1103) Group by p.nombre.ape1");
            List<Object[]> listDatos = (List<Object[]>) query.list();
            for (Object[] datos : listDatos) {
                System.out.println("El profesor " + datos[0] + " tiene  " + datos[1]+ " direcciones de correo electrónico");
            }
        }

        {
            System.out.println("----------- Función IS EMPTY en colecciones -----------");
            Query query = session.createQuery("SELECT p.nombre FROM Profesor p WHERE p.correosElectronicos IS EMPTY");
            List<Object> listDatos = (List<Object>) query.list();
            for (Object datos : listDatos) {
                System.out.println("El profesor " + datos + " no tiene  direcciones de correo electrónico");
            }
        }




        session.close();

        sessionFactory.close();
    }
}
