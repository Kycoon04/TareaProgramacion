
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getJobCompetenceIDJobResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="getJobCompetenceIDJobResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="return" type="{http://controller.tareaws.una.ac.cr/}jobsCompetencesDto" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getJobCompetenceIDJobResponse", propOrder = {
    "_return"
})
public class GetJobCompetenceIDJobResponse {

    @XmlElement(name = "return")
    protected JobsCompetencesDto _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link JobsCompetencesDto }
     *     
     */
    public JobsCompetencesDto getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link JobsCompetencesDto }
     *     
     */
    public void setReturn(JobsCompetencesDto value) {
        this._return = value;
    }

}
