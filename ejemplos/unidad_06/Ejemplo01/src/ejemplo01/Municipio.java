package ejemplo01;

import java.io.Serializable;

public class Municipio implements Serializable {

    private int idMunicipio;
    private String codProvincia;
    private String codMunicipio;
    private String nombre;

    public Municipio() {
    }

    public Municipio(int idMunicipio, String codProvincia, String codMunicipio, String nombre) {
        this.idMunicipio = idMunicipio;
        this.codProvincia = codProvincia;
        this.codMunicipio = codMunicipio;
        this.nombre = nombre;
    }

    /**
     * @return the idMunicipio
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * @param idMunicipio the idMunicipio to set
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /**
     * @return the codProvincia
     */
    public String getCodProvincia() {
        return codProvincia;
    }

    /**
     * @param codProvincia the codProvincia to set
     */
    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    /**
     * @return the codMunicipio
     */
    public String getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * @param codMunicipio the codMunicipio to set
     */
    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
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

    public String toString() {
        return idMunicipio + "." + nombre;
    }
}
