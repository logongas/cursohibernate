package ejemplo11;

import java.io.Serializable;
import org.hibernate.Hibernate;

public class Usuario implements Serializable {

    private int idUsuario;
    private String login;
    private String nombre;
    private String ape1;
    private String ape2;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario, String login, String nombre, String ape1, String ape2, String password) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.password = password;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (Hibernate.getClass(this) != Hibernate.getClass(obj)) {
            return false;
        }

        Usuario usuario = (Usuario) obj;
        Object dato1 = getLogin();
        Object dato2 = usuario.getLogin();

        if (dato1 == null) {
            if (dato2 == null) {
                return true;
            } else {
                return false;
            }
        } else if (dato1.equals(dato2) == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        Object dato1 = getLogin();
        int resultado = 45;

        resultado = 31 * resultado + (dato1 == null ? 0 : dato1.hashCode());

        return resultado;
    }
}
