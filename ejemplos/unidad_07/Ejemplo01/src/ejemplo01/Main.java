package ejemplo01;

import com.fpmislata.persistencia.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();

        try {
            HibernateUtil.openSessionAndBindToThread();

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Profesor profesor = (Profesor) session.get(Profesor.class, 1001);
            System.out.println(profesor.toString());
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }

        HibernateUtil.closeSessionFactory();
    }
}
