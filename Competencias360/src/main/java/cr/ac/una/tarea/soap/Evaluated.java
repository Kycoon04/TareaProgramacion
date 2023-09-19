
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluated complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad esId.
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
     * Define el valor de la propiedad esId.
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
     * Obtiene el valor de la propiedad esProcesoeva.
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
     * Define el valor de la propiedad esProcesoeva.
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
     * Obtiene el valor de la propiedad esWorker.
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
     * Define el valor de la propiedad esWorker.
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
