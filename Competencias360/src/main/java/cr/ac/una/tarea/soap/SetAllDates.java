
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para setAllDates complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="setAllDates">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="dto" type="{http://controller.tareaws.una.ac.cr/}procesoeva" minOccurs="0"/>
 *         <element name="Aplicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="finalizado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="inicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setAllDates", propOrder = {
    "dto",
    "aplicacion",
    "finalizado",
    "inicio"
})
public class SetAllDates {

    protected Procesoeva dto;
    @XmlElement(name = "Aplicacion")
    protected String aplicacion;
    protected String finalizado;
    protected String inicio;

    /**
     * Obtiene el valor de la propiedad dto.
     * 
     * @return
     *     possible object is
     *     {@link Procesoeva }
     *     
     */
    public Procesoeva getDto() {
        return dto;
    }

    /**
     * Define el valor de la propiedad dto.
     * 
     * @param value
     *     allowed object is
     *     {@link Procesoeva }
     *     
     */
    public void setDto(Procesoeva value) {
        this.dto = value;
    }

    /**
     * Obtiene el valor de la propiedad aplicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAplicacion() {
        return aplicacion;
    }

    /**
     * Define el valor de la propiedad aplicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAplicacion(String value) {
        this.aplicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad finalizado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalizado() {
        return finalizado;
    }

    /**
     * Define el valor de la propiedad finalizado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalizado(String value) {
        this.finalizado = value;
    }

    /**
     * Obtiene el valor de la propiedad inicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * Define el valor de la propiedad inicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInicio(String value) {
        this.inicio = value;
    }

}
