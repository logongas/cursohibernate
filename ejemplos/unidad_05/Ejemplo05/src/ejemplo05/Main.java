package ejemplo05;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            System.out.println("----------- Problema n+1 SELECT -----------");
            Query query = session.createQuery("SELECT p FROM Profesor p");
            List<Profesor> profesores = query.list();

            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
                for (CorreoElectronico correoElectronico : profesor.getCorreosElectronicos()) {
                    System.out.println("\t" + correoElectronico);
                }
            }
        }

        {
            System.out.println("----------- SOLUCION al n+1 SELECT con join -----------");
            Query query = session.createQuery("SELECT p FROM Profesor p LEFT JOIN FETCH p.correosElectronicos");
            List<Profesor> profesores = query.list();

            Set<Profesor> profesoresSinDuplicar = new HashSet<Profesor>(profesores);
            profesores.clear();
            profesores.addAll(profesoresSinDuplicar);

            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
                for (CorreoElectronico correoElectronico : profesor.getCorreosElectronicos()) {
                    System.out.println("\t" + correoElectronico);
                }
            }
        }

        {
            System.out.println("----------- consulta nativa en SQL -----------");
            Query query = session.createSQLQuery("SELECT IdCiclo,nombreCiclo,Horas FROM CicloFormativo");
            List<Object[]> listDatos = query.list();

            for (Object[] datos : listDatos) {
                System.out.println(datos[0] + "-" + datos[1] + " " + datos[2] + " Horas");
            }
        }


        {
            System.out.println("----------- Consultas peronalizadas para INSERT,  UPDATE y DELETE -----------");
            Profesor profesor;

            session.beginTransaction();
            profesor = new Profesor("Celia", "Sanchez", "Jordá");
            session.save(profesor);
            session.getTransaction().commit();

            session.beginTransaction();
            profesor.setNombre("Juan Carlos");
            session.update(profesor);
            session.getTransaction().commit();

            session.beginTransaction();
            session.delete(profesor);
            session.getTransaction().commit();
        }

        session.close();
        sessionFactory.close();
    }
}
