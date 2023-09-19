
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resultDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the rsCompe property.
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
     * Sets the value of the rsCompe property.
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
     * Gets the value of the rsEvaluated property.
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
     * Sets the value of the rsEvaluated property.
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
     * Gets the value of the rsId property.
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
     * Sets the value of the rsId property.
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
     * Gets the value of the rsNotajefatura property.
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
     * Sets the value of the rsNotajefatura property.
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
     * Gets the value of the rsNotasis property.
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
     * Sets the value of the rsNotasis property.
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
