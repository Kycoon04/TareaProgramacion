
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para resultDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="resultDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="rsCompe" type="{http://controller.tareaws.una.ac.cr/}competences" minOccurs="0"/>
 *         <element name="rsEvaluated" type="{http://controller.tareaws.una.ac.cr/}evaluated" minOccurs="0"/>
 *         <element name="rsId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="rsNotajefatura" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         <element name="rsNotasis" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultDto", propOrder = {
    "rsCompe",
    "rsEvaluated",
    "rsId",
    "rsNotajefatura",
    "rsNotasis"
})
public class ResultDto {

    protected Competences rsCompe;
    protected Evaluated rsEvaluated;
    protected Integer rsId;
    protected Short rsNotajefatura;
    protected Short rsNotasis;

    /**
     * Obtiene el valor de la propiedad rsCompe.
     * 
     * @return
     *     possible object is
     *     {@link Competences }
     *     
     */
    public Competences getRsCompe() {
        return rsCompe;
    }

    /**
     * Define el valor de la propiedad rsCompe.
     * 
     * @param value
     *     allowed object is
     *     {@link Competences }
     *     
     */
    public void setRsCompe(Competences value) {
        this.rsCompe = value;
    }

    /**
     * Obtiene el valor de la propiedad rsEvaluated.
     * 
     * @return
     *     possible object is
     *     {@link Evaluated }
     *     
     */
    public Evaluated getRsEvaluated() {
        return rsEvaluated;
    }

    /**
     * Define el valor de la propiedad rsEvaluated.
     * 
     * @param value
     *     allowed object is
     *     {@link Evaluated }
     *     
     */
    public void setRsEvaluated(Evaluated value) {
        this.rsEvaluated = value;
    }

    /**
     * Obtiene el valor de la propiedad rsId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRsId() {
        return rsId;
    }

    /**
     * Define el valor de la propiedad rsId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRsId(Integer value) {
        this.rsId = value;
    }

    /**
     * Obtiene el valor de la propiedad rsNotajefatura.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getRsNotajefatura() {
        return rsNotajefatura;
    }

    /**
     * Define el valor de la propiedad rsNotajefatura.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setRsNotajefatura(Short value) {
        this.rsNotajefatura = value;
    }

    /**
     * Obtiene el valor de la propiedad rsNotasis.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getRsNotasis() {
        return rsNotasis;
    }

    /**
     * Define el valor de la propiedad rsNotasis.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setRsNotasis(Short value) {
        this.rsNotasis = value;
    }

}
