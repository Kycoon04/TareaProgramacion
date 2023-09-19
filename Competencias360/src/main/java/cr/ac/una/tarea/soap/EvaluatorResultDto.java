
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for evaluatorResultDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="evaluatorResultDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="erCompe" type="{http://controller.tareaws.una.ac.cr/}competences" minOccurs="0"/>
 *         <element name="erEvaluator" type="{http://controller.tareaws.una.ac.cr/}evaluators" minOccurs="0"/>
 *         <element name="erId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="erNota" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evaluatorResultDto", propOrder = {
    "erCompe",
    "erEvaluator",
    "erId",
    "erNota"
})
public class EvaluatorResultDto {

    protected Competences erCompe;
    protected Evaluators erEvaluator;
    protected Integer erId;
    protected Integer erNota;

    /**
     * Gets the value of the erCompe property.
     * 
     * @return
     *     possible object is
     *     {@link Competences }
     *     
     */
    public Competences getErCompe() {
        return erCompe;
    }

    /**
     * Sets the value of the erCompe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Competences }
     *     
     */
    public void setErCompe(Competences value) {
        this.erCompe = value;
    }

    /**
     * Gets the value of the erEvaluator property.
     * 
     * @return
     *     possible object is
     *     {@link Evaluators }
     *     
     */
    public Evaluators getErEvaluator() {
        return erEvaluator;
    }

    /**
     * Sets the value of the erEvaluator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Evaluators }
     *     
     */
    public void setErEvaluator(Evaluators value) {
        this.erEvaluator = value;
    }

    /**
     * Gets the value of the erId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErId() {
        return erId;
    }

    /**
     * Sets the value of the erId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErId(Integer value) {
        this.erId = value;
    }

    /**
     * Gets the value of the erNota property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErNota() {
        return erNota;
    }

    /**
     * Sets the value of the erNota property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErNota(Integer value) {
        this.erNota = value;
    }

}
