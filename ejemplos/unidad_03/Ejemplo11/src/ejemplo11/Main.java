package ejemplo11;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory;
        Session session;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                
        {
            Profesor profesor1;
            Profesor profesor2;

            session=sessionFactory.openSession();
            session.beginTransaction();
            profesor1=(Profesor)session.get(Profesor.class,1001);
            session.getTransaction().commit();
            session.close();

            session=sessionFactory.openSession();
            session.beginTransaction();
            profesor2=(Profesor)session.get(Profesor.class,1001);
            session.getTransaction().commit();
            session.close();

            boolean igualesProfesores=profesor1.equals(profesor2);
            System.out.println("Los dos profesores son iguales pero al comprarlos, ¿son iguales?:"+igualesProfesores);

            Set<Profesor> setProfesores=new HashSet<>();
            setProfesores.add(profesor1);
            setProfesores.add(profesor2);
            System.out.println("Debe haber un único profesor en el Set y hay:"+setProfesores.size());
        }
        
        
        {
            //Añadimos un usuario
            session=sessionFactory.openSession();
            session.beginTransaction();
            Usuario usuario=new Usuario(10000,"rgutierrez","Ramón","Gutiérrez","Olmo","12345678");
            session.save(usuario);
            session.getTransaction().commit();
            session.close();
        }
        
        {   //Ahora hacemos lo mismo que hemos hecho con el profesor pero con el Usuario pero ahora si que irá bien
            Usuario usuario1;
            Usuario usuario2;

            session=sessionFactory.openSession();
            session.beginTransaction();
            usuario1=(Usuario)session.get(Usuario.class,10000);
            session.getTransaction().commit();
            session.close();

            session=sessionFactory.openSession();
            session.beginTransaction();
            usuario2=(Usuario)session.get(Usuario.class,10000);
            session.getTransaction().commit();
            session.close();

            boolean igualesUsuarios=usuario1.equals(usuario2);
            System.out.println("Los dos usuarios son iguales pero al comprarlos, ¿son iguales?:"+igualesUsuarios);

            Set<Usuario> setUsuarios=new HashSet<>();
            setUsuarios.add(usuario1);
            setUsuarios.add(usuario2);
            System.out.println("Debe haber un único usuario en el Set y hay:"+setUsuarios.size());
        }
        
        
        sessionFactory.close();
    }
}
