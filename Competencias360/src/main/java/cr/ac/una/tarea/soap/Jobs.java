
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jobs complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad jsId.
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
     * Define el valor de la propiedad jsId.
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
     * Obtiene el valor de la propiedad jsName.
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
     * Define el valor de la propiedad jsName.
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
     * Obtiene el valor de la propiedad jsState.
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
     * Define el valor de la propiedad jsState.
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
