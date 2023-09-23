
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procesoevaDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="procesoevaDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="getAplicationPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="getFinalPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="getInicialPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procesoevaDto", propOrder = {
    "getAplicationPeriodo",
    "getFinalPeriodo",
    "getInicialPeriodo",
    "id",
    "name",
    "state"
})
public class ProcesoevaDto {

    protected String getAplicationPeriodo;
    protected String getFinalPeriodo;
    protected String getInicialPeriodo;
    protected Integer id;
    protected String name;
    protected String state;

    /**
     * Gets the value of the getAplicationPeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetAplicationPeriodo() {
        return getAplicationPeriodo;
    }

    /**
     * Sets the value of the getAplicationPeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetAplicationPeriodo(String value) {
        this.getAplicationPeriodo = value;
    }

    /**
     * Gets the value of the getFinalPeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetFinalPeriodo() {
        return getFinalPeriodo;
    }

    /**
     * Sets the value of the getFinalPeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetFinalPeriodo(String value) {
        this.getFinalPeriodo = value;
    }

    /**
     * Gets the value of the getInicialPeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetInicialPeriodo() {
        return getInicialPeriodo;
    }

    /**
     * Sets the value of the getInicialPeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetInicialPeriodo(String value) {
        this.getInicialPeriodo = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

}
