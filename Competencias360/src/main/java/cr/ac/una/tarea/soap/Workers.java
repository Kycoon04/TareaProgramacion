
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para workers complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="workers">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="wrActive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrAdmin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrCodeactive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="wrIdentification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrJob" type="{http://controller.tareaws.una.ac.cr/}jobs" minOccurs="0"/>
 *         <element name="wrLandline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrPhoto" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         <element name="wrPsurname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrRecover" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrSsurname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrTelephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="wrUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workers", propOrder = {
    "wrActive",
    "wrAdmin",
    "wrCodeactive",
    "wrEmail",
    "wrId",
    "wrIdentification",
    "wrJob",
    "wrLandline",
    "wrName",
    "wrPassword",
    "wrPhoto",
    "wrPsurname",
    "wrRecover",
    "wrSsurname",
    "wrTelephone",
    "wrUsername"
})
public class Workers {

    protected String wrActive;
    protected String wrAdmin;
    protected String wrCodeactive;
    protected String wrEmail;
    protected Integer wrId;
    protected String wrIdentification;
    protected Jobs wrJob;
    protected String wrLandline;
    protected String wrName;
    protected String wrPassword;
    protected byte[] wrPhoto;
    protected String wrPsurname;
    protected String wrRecover;
    protected String wrSsurname;
    protected String wrTelephone;
    protected String wrUsername;

    /**
     * Obtiene el valor de la propiedad wrActive.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrActive() {
        return wrActive;
    }

    /**
     * Define el valor de la propiedad wrActive.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrActive(String value) {
        this.wrActive = value;
    }

    /**
     * Obtiene el valor de la propiedad wrAdmin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrAdmin() {
        return wrAdmin;
    }

    /**
     * Define el valor de la propiedad wrAdmin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrAdmin(String value) {
        this.wrAdmin = value;
    }

    /**
     * Obtiene el valor de la propiedad wrCodeactive.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrCodeactive() {
        return wrCodeactive;
    }

    /**
     * Define el valor de la propiedad wrCodeactive.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrCodeactive(String value) {
        this.wrCodeactive = value;
    }

    /**
     * Obtiene el valor de la propiedad wrEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrEmail() {
        return wrEmail;
    }

    /**
     * Define el valor de la propiedad wrEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrEmail(String value) {
        this.wrEmail = value;
    }

    /**
     * Obtiene el valor de la propiedad wrId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWrId() {
        return wrId;
    }

    /**
     * Define el valor de la propiedad wrId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWrId(Integer value) {
        this.wrId = value;
    }

    /**
     * Obtiene el valor de la propiedad wrIdentification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrIdentification() {
        return wrIdentification;
    }

    /**
     * Define el valor de la propiedad wrIdentification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrIdentification(String value) {
        this.wrIdentification = value;
    }

    /**
     * Obtiene el valor de la propiedad wrJob.
     * 
     * @return
     *     possible object is
     *     {@link Jobs }
     *     
     */
    public Jobs getWrJob() {
        return wrJob;
    }

    /**
     * Define el valor de la propiedad wrJob.
     * 
     * @param value
     *     allowed object is
     *     {@link Jobs }
     *     
     */
    public void setWrJob(Jobs value) {
        this.wrJob = value;
    }

    /**
     * Obtiene el valor de la propiedad wrLandline.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrLandline() {
        return wrLandline;
    }

    /**
     * Define el valor de la propiedad wrLandline.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrLandline(String value) {
        this.wrLandline = value;
    }

    /**
     * Obtiene el valor de la propiedad wrName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrName() {
        return wrName;
    }

    /**
     * Define el valor de la propiedad wrName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrName(String value) {
        this.wrName = value;
    }

    /**
     * Obtiene el valor de la propiedad wrPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrPassword() {
        return wrPassword;
    }

    /**
     * Define el valor de la propiedad wrPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrPassword(String value) {
        this.wrPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad wrPhoto.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getWrPhoto() {
        return wrPhoto;
    }

    /**
     * Define el valor de la propiedad wrPhoto.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setWrPhoto(byte[] value) {
        this.wrPhoto = value;
    }

    /**
     * Obtiene el valor de la propiedad wrPsurname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrPsurname() {
        return wrPsurname;
    }

    /**
     * Define el valor de la propiedad wrPsurname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrPsurname(String value) {
        this.wrPsurname = value;
    }

    /**
     * Obtiene el valor de la propiedad wrRecover.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrRecover() {
        return wrRecover;
    }

    /**
     * Define el valor de la propiedad wrRecover.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrRecover(String value) {
        this.wrRecover = value;
    }

    /**
     * Obtiene el valor de la propiedad wrSsurname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrSsurname() {
        return wrSsurname;
    }

    /**
     * Define el valor de la propiedad wrSsurname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrSsurname(String value) {
        this.wrSsurname = value;
    }

    /**
     * Obtiene el valor de la propiedad wrTelephone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrTelephone() {
        return wrTelephone;
    }

    /**
     * Define el valor de la propiedad wrTelephone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrTelephone(String value) {
        this.wrTelephone = value;
    }

    /**
     * Obtiene el valor de la propiedad wrUsername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrUsername() {
        return wrUsername;
    }

    /**
     * Define el valor de la propiedad wrUsername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrUsername(String value) {
        this.wrUsername = value;
    }

}
