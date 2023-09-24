
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setDates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="setDates">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="dto" type="{http://controller.tareaws.una.ac.cr/}procesoevaDto" minOccurs="0"/>
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
@XmlType(name = "setDates", propOrder = {
    "dto",
    "aplicacion",
    "finalizado",
    "inicio"
})
public class SetDates {

    protected ProcesoevaDto dto;
    @XmlElement(name = "Aplicacion")
    protected String aplicacion;
    protected String finalizado;
    protected String inicio;

    /**
     * Gets the value of the dto property.
     * 
     * @return
     *     possible object is
     *     {@link ProcesoevaDto }
     *     
     */
    public ProcesoevaDto getDto() {
        return dto;
    }

    /**
     * Sets the value of the dto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcesoevaDto }
     *     
     */
    public void setDto(ProcesoevaDto value) {
        this.dto = value;
    }

    /**
     * Gets the value of the aplicacion property.
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
     * Sets the value of the aplicacion property.
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
     * Gets the value of the finalizado property.
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
     * Sets the value of the finalizado property.
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
     * Gets the value of the inicio property.
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
     * Sets the value of the inicio property.
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
