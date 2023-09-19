
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para procesoevaDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="procesoevaDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="application" type="{http://controller.tareaws.una.ac.cr/}localDate" minOccurs="0"/>
 *         <element name="finalperiod" type="{http://controller.tareaws.una.ac.cr/}localDate" minOccurs="0"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="inicialperiod" type="{http://controller.tareaws.una.ac.cr/}localDate" minOccurs="0"/>
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
    "application",
    "finalperiod",
    "id",
    "inicialperiod",
    "name",
    "state"
})
public class ProcesoevaDto {

    protected LocalDate application;
    protected LocalDate finalperiod;
    protected Integer id;
    protected LocalDate inicialperiod;
    protected String name;
    protected String state;

    /**
     * Obtiene el valor de la propiedad application.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getApplication() {
        return application;
    }

    /**
     * Define el valor de la propiedad application.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setApplication(LocalDate value) {
        this.application = value;
    }

    /**
     * Obtiene el valor de la propiedad finalperiod.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFinalperiod() {
        return finalperiod;
    }

    /**
     * Define el valor de la propiedad finalperiod.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFinalperiod(LocalDate value) {
        this.finalperiod = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
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
     * Define el valor de la propiedad id.
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
     * Obtiene el valor de la propiedad inicialperiod.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getInicialperiod() {
        return inicialperiod;
    }

    /**
     * Define el valor de la propiedad inicialperiod.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setInicialperiod(LocalDate value) {
        this.inicialperiod = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad state.
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
     * Define el valor de la propiedad state.
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
