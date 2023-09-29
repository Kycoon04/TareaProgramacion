
package cr.ac.una.tarea.soap;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluatedDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="evaluatedDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="esId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="esProcesoeva" type="{http://controller.tareaws.una.ac.cr/}procesoeva" minOccurs="0"/>
 *         <element name="esWorker" type="{http://controller.tareaws.una.ac.cr/}workers" minOccurs="0"/>
 *         <element name="evaluatorsCollection" type="{http://controller.tareaws.una.ac.cr/}evaluators" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evaluatedDto", propOrder = {
    "esId",
    "esProcesoeva",
    "esWorker",
    "evaluatorsCollection"
})
public class EvaluatedDto {

    protected Integer esId;
    protected Procesoeva esProcesoeva;
    protected Workers esWorker;
    @XmlElement(nillable = true)
    protected List<Evaluators> evaluatorsCollection;

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

    /**
     * Gets the value of the evaluatorsCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the evaluatorsCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvaluatorsCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Evaluators }
     * 
     * 
     * @return
     *     The value of the evaluatorsCollection property.
     */
    public List<Evaluators> getEvaluatorsCollection() {
        if (evaluatorsCollection == null) {
            evaluatorsCollection = new ArrayList<>();
        }
        return this.evaluatorsCollection;
    }

}
