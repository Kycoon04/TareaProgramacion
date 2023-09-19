
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for jobs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="jobs">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="jsId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="jsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="jsState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jobs", propOrder = {
    "jsId",
    "jsName",
    "jsState"
})
public class Jobs {

    protected Integer jsId;
    protected String jsName;
    protected String jsState;

    /**
     * Gets the value of the jsId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJsId() {
        return jsId;
    }

    /**
     * Sets the value of the jsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJsId(Integer value) {
        this.jsId = value;
    }

    /**
     * Gets the value of the jsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsName() {
        return jsName;
    }

    /**
     * Sets the value of the jsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsName(String value) {
        this.jsName = value;
    }

    /**
     * Gets the value of the jsState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsState() {
        return jsState;
    }

    /**
     * Sets the value of the jsState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsState(String value) {
        this.jsState = value;
    }

}
