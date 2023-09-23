
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for jobsCompetencesDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the jobs property.
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
     * Sets the value of the jobs property.
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
     * Gets the value of the jxcCompetence property.
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
     * Sets the value of the jxcCompetence property.
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
     * Gets the value of the jxcIdcojob property.
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
     * Sets the value of the jxcIdcojob property.
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
     * Gets the value of the jxcJob property.
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
     * Sets the value of the jxcJob property.
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
