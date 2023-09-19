
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for evaluators complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="evaluators">
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
@XmlType(name = "evaluators", propOrder = {
    "evsConnection",
    "evsEvaluated",
    "evsFeedback",
    "evsId",
    "evsState",
    "evsWorker"
})
public class Evaluators {

    protected String evsConnection;
    protected Evaluated evsEvaluated;
    protected String evsFeedback;
    protected Integer evsId;
    protected String evsState;
    protected Workers evsWorker;

    /**
     * Gets the value of the evsConnection property.
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
     * Sets the value of the evsConnection property.
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
     * Gets the value of the evsEvaluated property.
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
     * Sets the value of the evsEvaluated property.
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
     * Gets the value of the evsFeedback property.
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
     * Sets the value of the evsFeedback property.
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
     * Gets the value of the evsId property.
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
     * Sets the value of the evsId property.
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
     * Gets the value of the evsState property.
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
     * Sets the value of the evsState property.
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
     * Gets the value of the evsWorker property.
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
     * Sets the value of the evsWorker property.
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
