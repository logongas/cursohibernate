package ejemplo01;

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
            System.out.println("----------- Uso de list() -----------");
            Query query = session.createQuery("SELECT p FROM Profesor p");
            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }

        
        {
            System.out.println("----------- Uso de list() con datos escalares -----------");
            Query query = session.createQuery("SELECT p.id,p.nombre FROM Profesor p");
            List<Object[]> listDatos = query.list();
            for (Object[] datos : listDatos) {
                System.out.println(datos[0] + "--" + datos[1]);
            }
        }        
        
        {
            System.out.println("----------- Uso de list() con un único dato escalar -----------");
            Query query = session.createQuery("SELECT p.nombre FROM Profesor p");
            List<Object> listDatos = query.list();
            for (Object datos : listDatos) {
                System.out.println(datos);
            }
        }         
        
        
        {
            System.out.println("----------- Uso de uniqueResult -----------");
            Profesor profesor = (Profesor) session.createQuery("SELECT p FROM Profesor p WHERE id=1001").uniqueResult();
            System.out.println("Profesor con Id 1001=" + profesor.getNombre());
        }


        {
            System.out.println("----------- Mostrar una página -----------");
            int tamanyoPagina = 10;
            int paginaAMostrar = 7;

            Query query = session.createQuery("SELECT p FROM Profesor p Order By p.id");
            query.setMaxResults(tamanyoPagina);
            query.setFirstResult(paginaAMostrar * tamanyoPagina);
            List<Profesor> profesores = query.list();

            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }

        {
            System.out.println("----------- Calcular el nº de páginas -----------");
            int tamanyoPagina = 10;
            long numTotalObjetos = (Long) session.createQuery("SELECT count(*) FROM Profesor p").uniqueResult();
            int numPaginas =(int) Math.ceil((double)numTotalObjetos / (double)tamanyoPagina);
            
            System.out.println("Nº de páginas="+numPaginas);
        }


        {
            System.out.println("----------- Consultas con nombre -----------");
            Query query = session.getNamedQuery("findAllProfesores");
            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }

        
        session.close();


        sessionFactory.close();

    }
}
