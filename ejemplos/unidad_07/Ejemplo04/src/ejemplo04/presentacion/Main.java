package ejemplo04.presentacion;

import ejemplo04.dominio.Profesor;
import com.fpmislata.persistencia.dao.BussinessException;
import com.fpmislata.persistencia.dao.BussinessMessage;
import com.fpmislata.persistencia.hibernate.HibernateUtil;

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
