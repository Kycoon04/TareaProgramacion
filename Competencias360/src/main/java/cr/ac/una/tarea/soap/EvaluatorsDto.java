
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluatorsDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="evaluatorsDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="evsConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="evsEvaluated" type="{http://controller.tareaws.una.ac.cr/}evaluated" minOccurs="0"/>
 *         <element name="evsFeedback" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="evsId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="evsState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="evsWorker" type="{http://controller.tareaws.una.ac.cr/}workers" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evaluatorsDto", propOrder = {
    "evsConnection",
    "evsEvaluated",
    "evsFeedback",
    "evsId",
    "evsState",
    "evsWorker"
})
public class EvaluatorsDto {

    protected String evsConnection;
    protected Evaluated evsEvaluated;
    protected String evsFeedback;
    protected Integer evsId;
    protected String evsState;
    protected Workers evsWorker;

    /**
     * Obtiene el valor de la propiedad evsConnection.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvsConnection() {
        return evsConnection;
    }

    /**
     * Define el valor de la propiedad evsConnection.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvsConnection(String value) {
        this.evsConnection = value;
    }

    /**
     * Obtiene el valor de la propiedad evsEvaluated.
     * 
     * @return
     *     possible object is
     *     {@link Evaluated }
     *     
     */
    public Evaluated getEvsEvaluated() {
        return evsEvaluated;
    }

    /**
     * Define el valor de la propiedad evsEvaluated.
     * 
     * @param value
     *     allowed object is
     *     {@link Evaluated }
     *     
     */
    public void setEvsEvaluated(Evaluated value) {
        this.evsEvaluated = value;
    }

    /**
     * Obtiene el valor de la propiedad evsFeedback.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvsFeedback() {
        return evsFeedback;
    }

    /**
     * Define el valor de la propiedad evsFeedback.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvsFeedback(String value) {
        this.evsFeedback = value;
    }

    /**
     * Obtiene el valor de la propiedad evsId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEvsId() {
        return evsId;
    }

    /**
     * Define el valor de la propiedad evsId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEvsId(Integer value) {
        this.evsId = value;
    }

    /**
     * Obtiene el valor de la propiedad evsState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvsState() {
        return evsState;
    }

    /**
     * Define el valor de la propiedad evsState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvsState(String value) {
        this.evsState = value;
    }

    /**
     * Obtiene el valor de la propiedad evsWorker.
     * 
     * @return
     *     possible object is
     *     {@link Workers }
     *     
     */
    public Workers getEvsWorker() {
        return evsWorker;
    }

    /**
     * Define el valor de la propiedad evsWorker.
     * 
     * @param value
     *     allowed object is
     *     {@link Workers }
     *     
     */
    public void setEvsWorker(Workers value) {
        this.evsWorker = value;
    }

}
