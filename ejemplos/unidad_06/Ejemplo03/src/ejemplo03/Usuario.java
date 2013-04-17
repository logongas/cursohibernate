
package ejemplo03;

import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert.List({
  @ScriptAssert(lang="javascript",script="(_this.password!=null)?  _this.password.equals(_this.confirmPassword) : false",message="Los 2 passwords deben ser iguales"),
  @ScriptAssert(lang="javascript",script="(!_this.password.equals('1234567'))",message="La contraseña no puede ser tan tonta")
})

public class Usuario implements Serializable  {
    
    private int idUsuario;
    
    @NotNull
    @Size(min = 3, max = 50)
    
    @Column(name="login",unique=true)
    private String login; 
    
    @NotNull
    @Size(min = 3, max = 50)    
    private String nombre;
    
    @NotNull(message="No puede estar vacío")
    @Size(min = 3, max = 50)
    private String ape1;
    
    @Size(min = 3, max = 50)  
    private String ape2;
    
    @NotNull
    @Size(min = 7, max = 50)  
    private String password;

    @NotNull
    @Size(min = 7, max = 50)  
    private String confirmPassword;    
    
    @AssertTrue(message="El login y el password no pueden coincidir")
    private boolean isPassword() {
        if ((login!=null) && (login.equalsIgnoreCase(password))) {
            return false;
        } else {
            return true;
        }
    }
    
    
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
}
