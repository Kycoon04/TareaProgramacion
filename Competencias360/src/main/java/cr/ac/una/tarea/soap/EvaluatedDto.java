
package cr.ac.una.tarea.soap;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for evaluatedDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
