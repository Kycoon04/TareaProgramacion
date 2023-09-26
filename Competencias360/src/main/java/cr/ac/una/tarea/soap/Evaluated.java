
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for evaluated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="evaluated">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="esId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="esProcesoeva" type="{http://controller.tareaws.una.ac.cr/}procesoeva" minOccurs="0"/>
 *         <element name="esWorker" type="{http://controller.tareaws.una.ac.cr/}workers" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evaluated", propOrder = {
    "esId",
    "esProcesoeva",
    "esWorker"
})
public class Evaluated {

    protected Integer esId;
    protected Procesoeva esProcesoeva;
    protected Workers esWorker;

    /**
     * Gets the value of the esId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEsId() {
        return esId;
    }

    /**
     * Sets the value of the esId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEsId(Integer value) {
        this.esId = value;
    }

    /**
     * Gets the value of the esProcesoeva property.
     * 
     * @return
     *     possible object is
     *     {@link Procesoeva }
     *     
     */
    public Procesoeva getEsProcesoeva() {
        return esProcesoeva;
    }

    /**
     * Sets the value of the esProcesoeva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Procesoeva }
     *     
     */
    public void setEsProcesoeva(Procesoeva value) {
        this.esProcesoeva = value;
    }

    /**
     * Gets the value of the esWorker property.
     * 
     * @return
     *     possible object is
     *     {@link Workers }
     *     
     */
    public Workers getEsWorker() {
        return esWorker;
    }

    /**
     * Sets the value of the esWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Workers }
     *     
     */
    public void setEsWorker(Workers value) {
        this.esWorker = value;
    }

}
