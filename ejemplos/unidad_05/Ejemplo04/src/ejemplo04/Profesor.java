package ejemplo04;

import java.io.Serializable;
import java.util.Set;



public class Profesor implements Serializable  {
    
    private int id;
    private Nombre nombre;
    private Set<CorreoElectronico> correosElectronicos;
    private Direccion direccion;    

    public Profesor(){ 
    }

    public Profesor(int id, Nombre nombre, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    
    
    

 
    
    @Override
    public String toString() {
        return getId() + "-" + getNombre();
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
    public Nombre getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
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

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
}
