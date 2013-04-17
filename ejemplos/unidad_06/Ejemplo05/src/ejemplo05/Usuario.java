package ejemplo05;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

public class Usuario implements Serializable, PreInsertEventListener {

    private int idUsuario;
    private String login;
    private String nombre;
    private String ape1;
    private String ape2;
    private String password;
    private String confirmPassword;
    private Date fechaCreacion;

    public Usuario() {
    }

    public Usuario(String login, String nombre, String ape1, String ape2, String password, String confirmPassword) {
        this.login = login;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean onPreInsert(PreInsertEvent pie) {
        int propertyNameIndex = getPropertyNameIndex(pie.getPersister().getPropertyNames(), "fechaCreacion");
        pie.getState()[propertyNameIndex] = new Date();

        return false;
    }

    /**
     * Obtiene el índice de una propiedad en función de su nombre
     * @param propertyNames Array con el nombre de las propiedades de una entidad
     * @param propertyName Nombre de la entidad de la que queremos obtener su índice
     * @return El indice de la propiedad o -1 si no existe la propiedad.
     */
    private int getPropertyNameIndex(String[] propertyNames, String propertyName) {
        for (int i = 0; i < propertyNames.length; i++) {
            if (propertyNames[i].equals(propertyName)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        return getLogin() + "-" + getNombre() + " " + getApe1() + " " + getApe2();
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ape1
     */
    public String getApe1() {
        return ape1;
    }

    /**
     * @param ape1 the ape1 to set
     */
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    /**
     * @return the ape2
     */
    public String getApe2() {
        return ape2;
    }

    /**
     * @param ape2 the ape2 to set
     */
    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
