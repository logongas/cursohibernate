package ejemplo03.dominio;

import com.fpmislata.persistencia.dao.Caption;
import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class Usuario implements Serializable {

    private int idUsuario;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(unique=true)
    @Caption("Login")
    private String login;

    @NotBlank
    @Size(min = 3, max = 50)
    @Caption("Nombre")
    private String nombre;

    @NotBlank
    @Size(min = 3, max = 50)
    @Caption("1º Apellido")
    private String ape1;

    @Size(min = 3, max = 50)
    @Caption("2º Apellido")
    @Column(unique=true)
    private String ape2;

    @NotBlank
    @Size(min = 7, max = 50)
    @Caption("Contraseña")
    private String password;

    @AssertTrue(message="El login y el password no pueden coincidir")
    @Caption("")
    private boolean isIgualUsuarioPassword() {
        if ((login!=null) && (login.equalsIgnoreCase(password))) {
            return false;
        } else {
            return true;
        }
    }

    public Usuario() {
    }

    public Usuario(String login, String nombre, String ape1, String ape2, String password) {
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

}
