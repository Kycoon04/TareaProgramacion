
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para competences complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="competences">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="csCharacteristics" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "csCharacteristics",
    "csId",
    "csName",
    "csState"
})
public class Competences {

    protected String csCharacteristics;
    protected Integer csId;
    protected String csName;
    protected String csState;

    /**
     * Obtiene el valor de la propiedad csCharacteristics.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCharacteristics() {
        return csCharacteristics;
    }

    /**
     * Define el valor de la propiedad csCharacteristics.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCharacteristics(String value) {
        this.csCharacteristics = value;
    }

    /**
     * Obtiene el valor de la propiedad csId.
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
     * Define el valor de la propiedad csId.
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
     * Obtiene el valor de la propiedad csName.
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
     * Define el valor de la propiedad csName.
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
     * Obtiene el valor de la propiedad csState.
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
     * Define el valor de la propiedad csState.
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
