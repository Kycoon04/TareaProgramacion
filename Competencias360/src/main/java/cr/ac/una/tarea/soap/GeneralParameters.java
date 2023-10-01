
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GeneralParameters complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="GeneralParameters">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="arg0" type="{http://controller.tareaws.una.ac.cr/}comInformationDto" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralParameters", propOrder = {
    "arg0"
})
public class GeneralParameters {

    protected ComInformationDto arg0;

    /**
     * Obtiene el valor de la propiedad arg0.
     * 
     * @return
     *     possible object is
     *     {@link ComInformationDto }
     *     
     */
    public ComInformationDto getArg0() {
        return arg0;
    }

    /**
     * Define el valor de la propiedad arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link ComInformationDto }
     *     
     */
    public void setArg0(ComInformationDto value) {
        this.arg0 = value;
    }

}
