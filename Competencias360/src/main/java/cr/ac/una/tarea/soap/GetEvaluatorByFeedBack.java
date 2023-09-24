
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetEvaluatorByFeedBack complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="GetEvaluatorByFeedBack">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="FeedBack" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEvaluatorByFeedBack", propOrder = {
    "feedBack"
})
public class GetEvaluatorByFeedBack {

    @XmlElement(name = "FeedBack")
    protected String feedBack;

    /**
     * Obtiene el valor de la propiedad feedBack.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedBack() {
        return feedBack;
    }

    /**
     * Define el valor de la propiedad feedBack.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedBack(String value) {
        this.feedBack = value;
    }

}
