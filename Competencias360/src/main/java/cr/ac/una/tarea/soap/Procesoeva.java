
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para procesoeva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad enApplication.
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
     * Define el valor de la propiedad enApplication.
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
     * Obtiene el valor de la propiedad enFinalperiod.
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
     * Define el valor de la propiedad enFinalperiod.
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
     * Obtiene el valor de la propiedad enId.
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
     * Define el valor de la propiedad enId.
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
     * Obtiene el valor de la propiedad enInicialperiod.
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
     * Define el valor de la propiedad enInicialperiod.
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
     * Obtiene el valor de la propiedad enName.
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
     * Define el valor de la propiedad enName.
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
     * Obtiene el valor de la propiedad enState.
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
     * Define el valor de la propiedad enState.
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
