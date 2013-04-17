
package ejemplo09;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Modulo implements Serializable {
    private int idModulo;
    private String nombre;
    private Set<Profesor> profesores=new HashSet();

    public Modulo() {
        
    }

    public Modulo(int idModulo, String nombre) {
        this.idModulo = idModulo;
        this.nombre = nombre;

    }
   
    
    
    /**
     * @return the idModulo
     */
    public int getIdModulo() {
        return idModulo;
    }

    /**
     * @param idModulo the idModulo to set
     */
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
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
     * @return the profesores
     */
    public Set<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * @param profesor the profesores to set
     */
    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }
    
}
