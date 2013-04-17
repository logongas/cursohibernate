
package ejemplo06;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Profesor")
public class Profesor implements Serializable  {
    
    @Id
    @Column(name="Id")
    private int id;
    @Embedded
    private Nombre nombre;
    

    public Profesor(){ 
    }

    public Profesor(int id, Nombre nombre) {
        this.id = id;
        this.nombre=nombre;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public Nombre getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }




    
}
