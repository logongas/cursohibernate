package ejemplo05;

import java.io.Serializable;
import java.util.Set;



public class Profesor implements Serializable  {
    
    private int id;
    private String nombre;
    private String ape1;
    private String ape2;
    private Set<CorreoElectronico> correosElectronicos;
    

    public Profesor(){ 
    }

    public Profesor(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
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
    public Set<CorreoElectronico> getCorreosElectronicos() {
        return correosElectronicos;
    }

    /**
     * @param correosElectronicos the correosElectronicos to set
     */
    public void setCorreosElectronicos(Set<CorreoElectronico> correosElectronicos) {
        this.correosElectronicos = correosElectronicos;
    }

    @Override
    public String toString() {
        return getId() + "-" + getNombre() + " " + getApe1() + " " + getApe2();
    }
    
}
