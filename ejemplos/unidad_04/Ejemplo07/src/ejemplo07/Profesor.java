
package ejemplo07;

import java.io.Serializable;



public class Profesor implements Serializable  {
    
    private int id;
    private String nombre;
    private String ape1;
    private String ape2;
    private TipoFuncionario tipoFuncionario;

    public Profesor(){ 
    }

    public Profesor(int id, String nombre, String ape1, String ape2, TipoFuncionario tipoFuncionario) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.tipoFuncionario = tipoFuncionario;
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
     * @return the tipoFuncionario
     */
    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    /**
     * @param tipoFuncionario the tipoFuncionario to set
     */
    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }






    
}
