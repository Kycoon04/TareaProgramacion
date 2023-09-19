
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for characteristicDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="characteristicDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ccComid" type="{http://controller.tareaws.una.ac.cr/}competences" minOccurs="0"/>
 *         <element name="ccId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="ccName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "characteristicDto", propOrder = {
    "ccComid",
    "ccId",
    "ccName"
})
public class CharacteristicDto {

    protected Competences ccComid;
    protected Integer ccId;
    protected String ccName;

    /**
     * Gets the value of the ccComid property.
     * 
     * @return
     *     possible object is
     *     {@link Competences }
     *     
     */
    public Competences getCcComid() {
        return ccComid;
    }

    /**
     * Sets the value of the ccComid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Competences }
     *     
     */
    public void setCcComid(Competences value) {
        this.ccComid = value;
    }

    /**
     * Gets the value of the ccId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCcId() {
        return ccId;
    }

    /**
     * Sets the value of the ccId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCcId(Integer value) {
        this.ccId = value;
    }

    /**
     * Gets the value of the ccName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcName() {
        return ccName;
    }

    /**
     * Sets the value of the ccName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcName(String value) {
        this.ccName = value;
    }

}
