
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procesoeva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="procesoeva">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="enApplication" type="{http://controller.tareaws.una.ac.cr/}localDate" minOccurs="0"/>
 *         <element name="enFinalperiod" type="{http://controller.tareaws.una.ac.cr/}localDate" minOccurs="0"/>
 *         <element name="enId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="enInicialperiod" type="{http://controller.tareaws.una.ac.cr/}localDate" minOccurs="0"/>
 *         <element name="enName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="enState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procesoeva", propOrder = {
    "enApplication",
    "enFinalperiod",
    "enId",
    "enInicialperiod",
    "enName",
    "enState"
})
public class Procesoeva {

    protected LocalDate enApplication;
    protected LocalDate enFinalperiod;
    protected Integer enId;
    protected LocalDate enInicialperiod;
    protected String enName;
    protected String enState;

    /**
     * Gets the value of the enApplication property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getEnApplication() {
        return enApplication;
    }

    /**
     * Sets the value of the enApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setEnApplication(LocalDate value) {
        this.enApplication = value;
    }

    /**
     * Gets the value of the enFinalperiod property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getEnFinalperiod() {
        return enFinalperiod;
    }

    /**
     * Sets the value of the enFinalperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setEnFinalperiod(LocalDate value) {
        this.enFinalperiod = value;
    }

    /**
     * Gets the value of the enId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnId() {
        return enId;
    }

    /**
     * Sets the value of the enId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnId(Integer value) {
        this.enId = value;
    }

    /**
     * Gets the value of the enInicialperiod property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getEnInicialperiod() {
        return enInicialperiod;
    }

    /**
     * Sets the value of the enInicialperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setEnInicialperiod(LocalDate value) {
        this.enInicialperiod = value;
    }

    /**
     * Gets the value of the enName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnName() {
        return enName;
    }

    /**
     * Sets the value of the enName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnName(String value) {
        this.enName = value;
    }

    /**
     * Gets the value of the enState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnState() {
        return enState;
    }

    /**
     * Sets the value of the enState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnState(String value) {
        this.enState = value;
    }

}
