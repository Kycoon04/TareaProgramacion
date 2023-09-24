
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jobsCompetencesDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="jobsCompetencesDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="jobs" type="{http://controller.tareaws.una.ac.cr/}jobs" minOccurs="0"/>
 *         <element name="jxcCompetence" type="{http://controller.tareaws.una.ac.cr/}competences" minOccurs="0"/>
 *         <element name="jxcIdcojob" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="jxcJob" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jobsCompetencesDto", propOrder = {
    "jobs",
    "jxcCompetence",
    "jxcIdcojob",
    "jxcJob"
})
public class JobsCompetencesDto {

    protected Jobs jobs;
    protected Competences jxcCompetence;
    protected Integer jxcIdcojob;
    protected Integer jxcJob;

    /**
     * Obtiene el valor de la propiedad jobs.
     * 
     * @return
     *     possible object is
     *     {@link Jobs }
     *     
     */
    public Jobs getJobs() {
        return jobs;
    }

    /**
     * Define el valor de la propiedad jobs.
     * 
     * @param value
     *     allowed object is
     *     {@link Jobs }
     *     
     */
    public void setJobs(Jobs value) {
        this.jobs = value;
    }

    /**
     * Obtiene el valor de la propiedad jxcCompetence.
     * 
     * @return
     *     possible object is
     *     {@link Competences }
     *     
     */
    public Competences getJxcCompetence() {
        return jxcCompetence;
    }

    /**
     * Define el valor de la propiedad jxcCompetence.
     * 
     * @param value
     *     allowed object is
     *     {@link Competences }
     *     
     */
    public void setJxcCompetence(Competences value) {
        this.jxcCompetence = value;
    }

    /**
     * Obtiene el valor de la propiedad jxcIdcojob.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJxcIdcojob() {
        return jxcIdcojob;
    }

    /**
     * Define el valor de la propiedad jxcIdcojob.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJxcIdcojob(Integer value) {
        this.jxcIdcojob = value;
    }

    /**
     * Obtiene el valor de la propiedad jxcJob.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJxcJob() {
        return jxcJob;
    }

    /**
     * Define el valor de la propiedad jxcJob.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJxcJob(Integer value) {
        this.jxcJob = value;
    }

}
