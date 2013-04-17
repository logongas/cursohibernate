
package ejemplo05;

import java.io.Serializable;


public class Nombre implements Serializable {

    private String nombre;
    private String ape1;
    private String ape2;
    
    public Nombre() {
        
    }

    public Nombre(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    
    
    public String getNombreCompleto() {
        StringBuilder sb=new StringBuilder();
        if ((ape1!=null) && (ape1.trim().length()>0)) {
            sb.append(ape1);
        }        
        if ((ape2!=null) && (ape2.trim().length()>0)) {
            if (sb.length()>0) {
                sb.append(" ");
            }
            sb.append(ape2);
        }         
        if ((nombre!=null) && (nombre.trim().length()>0)) {
            if (sb.length()>0) {
                sb.append(",");
            }
            sb.append(nombre);
        }
       
        
        return sb.toString();
    }
    
    public String getIniciales() {
        StringBuilder sb=new StringBuilder();
        if ((nombre!=null) && (nombre.trim().length()>0)) {
            sb.append(nombre.substring(0,1));
        }
        if ((ape1!=null) && (ape1.trim().length()>0)) {
            sb.append(ape1.substring(0,1));
        }        
        if ((ape2!=null) && (ape2.trim().length()>0)) {
            sb.append(ape2.substring(0,1));
        }        
        
        return sb.toString().toUpperCase();
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
