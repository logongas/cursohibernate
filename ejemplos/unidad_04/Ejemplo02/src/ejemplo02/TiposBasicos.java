package ejemplo02;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name="TiposBasicos")
public class TiposBasicos implements Serializable {

    @Id
    @Type(type="integer")
    private int inte;
    @Type(type="long")
    private long long1;
    @Type(type="short")
    private short short1;
    @Type(type="float")
    private float float1;
    @Type(type="double")
    private double double1;
    @Type(type="character")
    private char character1;
    @Type(type="byte")
    private byte byte1;
    @Type(type="boolean")
    private boolean boolean1;
    @Type(type="yes_no")
    private boolean yesno1;
    @Type(type="true_false")
    private boolean truefalse1;
    @Type(type="string")
    private String stri;
    @Temporal(TemporalType.DATE)
    private Date dateDate;
    @Temporal(TemporalType.TIME)
    private Date dateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimestamp;
    @Lob
    private String texto;
    @Type(type="binary")
    private byte[] binario;
    @Type(type="big_decimal")
    private BigDecimal bigDecimal;
    @Type(type="big_integer")
    private BigInteger bigInteger;


    public TiposBasicos() {
        
    }
    
    /**
     * @return the int1
     */
    public int getInte() {
        return inte;
    }

    /**
     * @param int1 the int1 to set
     */
    public void setInte(int inte) {
        this.inte = inte;
    }

    /**
     * @return the long1
     */
    public long getLong1() {
        return long1;
    }

    /**
     * @param long1 the long1 to set
     */
    public void setLong1(long long1) {
        this.long1 = long1;
    }

    /**
     * @return the short1
     */
    public short getShort1() {
        return short1;
    }

    /**
     * @param short1 the short1 to set
     */
    public void setShort1(short short1) {
        this.short1 = short1;
    }

    /**
     * @return the float1
     */
    public float getFloat1() {
        return float1;
    }

    /**
     * @param float1 the float1 to set
     */
    public void setFloat1(float float1) {
        this.float1 = float1;
    }

    /**
     * @return the double1
     */
    public double getDouble1() {
        return double1;
    }

    /**
     * @param double1 the double1 to set
     */
    public void setDouble1(double double1) {
        this.double1 = double1;
    }

    /**
     * @return the character1
     */
    public char getCharacter1() {
        return character1;
    }

    /**
     * @param character1 the character1 to set
     */
    public void setCharacter1(char character1) {
        this.character1 = character1;
    }

    /**
     * @return the byte1
     */
    public byte getByte1() {
        return byte1;
    }

    /**
     * @param byte1 the byte1 to set
     */
    public void setByte1(byte byte1) {
        this.byte1 = byte1;
    }

    /**
     * @return the boolean1
     */
    public boolean isBoolean1() {
        return boolean1;
    }

    /**
     * @param boolean1 the boolean1 to set
     */
    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
    }

    /**
     * @return the yesno1
     */
    public boolean isYesno1() {
        return yesno1;
    }

    /**
     * @param yesno1 the yesno1 to set
     */
    public void setYesno1(boolean yesno1) {
        this.yesno1 = yesno1;
    }

    /**
     * @return the truefalse1
     */
    public boolean isTruefalse1() {
        return truefalse1;
    }

    /**
     * @param truefalse1 the truefalse1 to set
     */
    public void setTruefalse1(boolean truefalse1) {
        this.truefalse1 = truefalse1;
    }

    /**
     * @return the stri
     */
    public String getStri() {
        return stri;
    }

    /**
     * @param stri the stri to set
     */
    public void setStri(String stri) {
        this.stri = stri;
    }

    /**
     * @return the dateDate
     */
    public Date getDateDate() {
        return dateDate;
    }

    /**
     * @param dateDate the dateDate to set
     */
    public void setDateDate(Date dateDate) {
        this.dateDate = dateDate;
    }

    /**
     * @return the datetime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param datetime the datetime to set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the dateTimestamp
     */
    public Date getDateTimestamp() {
        return dateTimestamp;
    }

    /**
     * @param dateTimestamp the dateTimestamp to set
     */
    public void setDateTimestamp(Date dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }


    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the binario
     */
    public byte[] getBinario() {
        return binario;
    }

    /**
     * @param binario the binario to set
     */
    public void setBinario(byte[] binario) {
        this.binario = binario;
    }

    /**
     * @return the bigDecimal
     */
    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    /**
     * @param bigDecimal the bigDecimal to set
     */
    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    /**
     * @return the bigInteger
     */
    public BigInteger getBigInteger() {
        return bigInteger;
    }

    /**
     * @param bigInteger the bigInteger to set
     */
    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    
    
    
}
