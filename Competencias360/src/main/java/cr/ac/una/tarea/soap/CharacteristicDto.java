
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para characteristicDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad ccComid.
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
     * Define el valor de la propiedad ccComid.
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
     * Obtiene el valor de la propiedad ccId.
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
     * Define el valor de la propiedad ccId.
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
     * Obtiene el valor de la propiedad ccName.
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
     * Define el valor de la propiedad ccName.
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
