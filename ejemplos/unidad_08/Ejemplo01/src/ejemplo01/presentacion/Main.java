package ejemplo01.presentacion;

import ejemplo01.dominio.Profesor;
import com.fpmislata.persistencia.dao.BussinessException;
import com.fpmislata.persistencia.dao.BussinessMessage;
import com.fpmislata.persistencia.hibernate.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        HibernateUtil.buildSessionFactory();

        try {
            HibernateUtil.openSessionAndBindToThread();

            ProfesorController profesorController=context.getBean(ProfesorController.class);
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
