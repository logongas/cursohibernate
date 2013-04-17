package ejemplo03;

import com.fpmislata.persistencia.hibernate.util.BussinessException;
import com.fpmislata.persistencia.hibernate.util.BussinessMessage;
import com.fpmislata.persistencia.hibernate.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        HibernateUtil.buildSessionFactory();

        try {
            HibernateUtil.openSessionAndBindToThread();

            ProfesorController profesorController = new ProfesorController();
            Profesor profesor = new Profesor(null, null, null);

            profesorController.guardar(profesor);

        } catch (BussinessException be) {
            System.out.println("No se ha podido guardar el profesor.Se han producido los siguientes errores:");
            for (BussinessMessage bussinessMessage : be.getBussinessMessages()) {
                System.out.println(bussinessMessage.toString());
            }
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }

        HibernateUtil.closeSessionFactory();
    }
}
