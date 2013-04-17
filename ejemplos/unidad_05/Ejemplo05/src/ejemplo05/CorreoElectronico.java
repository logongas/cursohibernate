package ejemplo05;

import java.io.Serializable;


public class CorreoElectronico implements Serializable {
    private int idCorreo;
    private String direccionCorreo;
    private Profesor profesor;
    
    public CorreoElectronico() {
        
    }
    
    public CorreoElectronico(int idCorreo,String direccionCorreo,Profesor profesor) {
        this.idCorreo=idCorreo;
        this.direccionCorreo=direccionCorreo;
        this.profesor=profesor;
    }
    
    
    
    /**
     * @return the idCorreo
     */
    public int getIdCorreo() {
        return idCorreo;
    }

    /**
     * @param idCorreo the idCorreo to set
     */
    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    /**
     * @return the direccionCorreo
     */
    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    /**
     * @param direccionCorreo the direccionCorreo to set
     */
    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return direccionCorreo;
    }    

}
