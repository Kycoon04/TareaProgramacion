
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para procesoevaDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="procesoevaDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="getAplicationPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="getFinalPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="getInicialPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procesoevaDto", propOrder = {
    "getAplicationPeriodo",
    "getFinalPeriodo",
    "getInicialPeriodo",
    "id",
    "name",
    "state"
})
public class ProcesoevaDto {

    protected String getAplicationPeriodo;
    protected String getFinalPeriodo;
    protected String getInicialPeriodo;
    protected Integer id;
    protected String name;
    protected String state;

    /**
     * Obtiene el valor de la propiedad getAplicationPeriodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetAplicationPeriodo() {
        return getAplicationPeriodo;
    }

    /**
     * Define el valor de la propiedad getAplicationPeriodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetAplicationPeriodo(String value) {
        this.getAplicationPeriodo = value;
    }

    /**
     * Obtiene el valor de la propiedad getFinalPeriodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetFinalPeriodo() {
        return getFinalPeriodo;
    }

    /**
     * Define el valor de la propiedad getFinalPeriodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetFinalPeriodo(String value) {
        this.getFinalPeriodo = value;
    }

    /**
     * Obtiene el valor de la propiedad getInicialPeriodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetInicialPeriodo() {
        return getInicialPeriodo;
    }

    /**
     * Define el valor de la propiedad getInicialPeriodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetInicialPeriodo(String value) {
        this.getInicialPeriodo = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

}
