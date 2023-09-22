
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para evaluatorResultDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad erCompe.
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
     * Define el valor de la propiedad erCompe.
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
     * Obtiene el valor de la propiedad erEvaluator.
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
     * Define el valor de la propiedad erEvaluator.
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
     * Obtiene el valor de la propiedad erId.
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
     * Define el valor de la propiedad erId.
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
     * Obtiene el valor de la propiedad erNota.
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
     * Define el valor de la propiedad erNota.
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
