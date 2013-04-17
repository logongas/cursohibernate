package ejemplo03;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Profesor implements Serializable  {
    
    private int id;
    @NotNull
    @Size(min = 3, max = 50)    
    private String nombre;
    @NotNull(message="No puede estar vacío")
    @Size(min = 3, max = 50)
    private String ape1;
    @Size(min = 3, max = 50)  
    private String ape2;
    
    public Profesor(){ 
        
    }
    
    public Profesor(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }    

    @Override
    public String toString() {
        return getId() + "-" + getNombre() + " " + getApe1() + " " + getApe2();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

 
}
