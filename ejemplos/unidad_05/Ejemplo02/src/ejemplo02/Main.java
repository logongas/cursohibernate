
package ejemplo02;

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
            System.out.println("----------- Simple consulta con HQL -----------");
            Query query = session.createQuery("SELECT c FROM Ciclo c ORDER BY nombre");
            List<Ciclo> ciclos = query.list();
            for (Ciclo ciclo : ciclos) {
                System.out.println(ciclo.toString());
            }

        }

        {
            System.out.println("----------- Uso de AND y OR -----------");
            Query query = session.createQuery("SELECT p FROM Profesor p WHERE nombre='ANTONIO' AND (ape1='LARA' OR ape2='RUBIO')");
            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }

        {
            System.out.println("----------- Funciones de agregación -----------");
            Query query = session.createQuery("SELECT AVG(c.horas),SUM(c.horas),MIN(c.horas),MAX(c.horas),COUNT(*) FROM Ciclo c");
            Object[] datos = (Object[]) query.uniqueResult();
            System.out.println("AVG(c.horas)=" + datos[0]);
            System.out.println("SUM(c.horas)=" + datos[1]);
            System.out.println("MIN(c.horas)=" + datos[2]);
            System.out.println("MAX(c.horas)=" + datos[3]);
            System.out.println("COUNT(*)=" + datos[4]);
        }

        {
            System.out.println("----------- Concatenar Strings -----------");
            Query query = session.createQuery("SELECT p.nombre || ' ' || p.ape1 || ' ' || p.ape2 FROM Profesor p WHERE Id=1001");
            List<Object> listDatos = (List<Object>) query.list();
            for (Object datos : listDatos) {
                System.out.println(datos);
            }
        }



        {
            System.out.println("----------- GROUP BY y HAVING -----------");
            Query query = session.createQuery("SELECT nombre,count(nombre) FROM Profesor p GROUP BY nombre HAVING count(nombre)>1 ORDER BY count(nombre)");
            List<Object[]> listDatos = (List<Object[]>) query.list();
            for (Object[] datos : listDatos) {
                System.out.println("El nombre \"" + datos[0] + "\" se repite  " + datos[1] + " veces");
            }
        }

        {
            System.out.println("----------- Subconsultas -----------");
            Query query = session.createQuery("SELECT c.nombre,c.horas FROM Ciclo c WHERE c.horas >  (SELECT  AVG(c2.horas) FROM Ciclo c2)");
            List<Object[]> listDatos = (List<Object[]>) query.list();
            for (Object[] datos : listDatos) {
                System.out.println("El ciclo \"" + datos[0] + "\" es de " + datos[1] + " horas, siendo mayor que la media de horas de todos los ciclos");
            }
        }

        session.close();

        sessionFactory.close();
    }
}
