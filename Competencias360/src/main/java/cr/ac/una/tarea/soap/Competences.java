
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for competences complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="competences">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="csId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="csName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="csState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competences", propOrder = {
    "csId",
    "csName",
    "csState"
})
public class Competences {

    protected Integer csId;
    protected String csName;
    protected String csState;

    /**
     * Gets the value of the csId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCsId() {
        return csId;
    }

    /**
     * Sets the value of the csId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCsId(Integer value) {
        this.csId = value;
    }

    /**
     * Gets the value of the csName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsName() {
        return csName;
    }

    /**
     * Sets the value of the csName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsName(String value) {
        this.csName = value;
    }

    /**
     * Gets the value of the csState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsState() {
        return csState;
    }

    /**
     * Sets the value of the csState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsState(String value) {
        this.csState = value;
    }

}
