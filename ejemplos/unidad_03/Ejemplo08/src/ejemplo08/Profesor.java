
package ejemplo08;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="Profesor")
public class Profesor implements Serializable  {
    
    @Id
    @Column(name="Id")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="ape1")
    private String ape1;
    
    @Column(name="ape2")    
    private String ape2;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdProfesor")
    @IndexColumn(name="idx")
    private List<CorreoElectronico> correosElectronicos;
    

    public Profesor(){ 
    }

    public Profesor(int id, String nombre, String ape1, String ape2) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
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
     * @return the correosElectronicos
     */
    public List<CorreoElectronico> getCorreosElectronicos() {
        return correosElectronicos;
    }

    /**
     * @param correosElectronicos the correosElectronicos to set
     */
    public void setCorreosElectronicos(List<CorreoElectronico> correosElectronicos) {
        this.correosElectronicos = correosElectronicos;
    }


    
}
