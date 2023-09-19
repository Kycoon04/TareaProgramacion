
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the wrActive property.
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
     * Sets the value of the wrActive property.
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
     * Gets the value of the wrAdmin property.
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
     * Sets the value of the wrAdmin property.
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
     * Gets the value of the wrCodeactive property.
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
     * Sets the value of the wrCodeactive property.
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
     * Gets the value of the wrEmail property.
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
     * Sets the value of the wrEmail property.
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
     * Gets the value of the wrId property.
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
     * Sets the value of the wrId property.
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
     * Gets the value of the wrIdentification property.
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
     * Sets the value of the wrIdentification property.
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
     * Gets the value of the wrJob property.
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
     * Sets the value of the wrJob property.
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
     * Gets the value of the wrLandline property.
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
     * Sets the value of the wrLandline property.
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
     * Gets the value of the wrName property.
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
     * Sets the value of the wrName property.
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
     * Gets the value of the wrPassword property.
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
     * Sets the value of the wrPassword property.
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
     * Gets the value of the wrPhoto property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getWrPhoto() {
        return wrPhoto;
    }

    /**
     * Sets the value of the wrPhoto property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setWrPhoto(byte[] value) {
        this.wrPhoto = value;
    }

    /**
     * Gets the value of the wrPsurname property.
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
     * Sets the value of the wrPsurname property.
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
     * Gets the value of the wrRecover property.
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
     * Sets the value of the wrRecover property.
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
     * Gets the value of the wrSsurname property.
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
     * Sets the value of the wrSsurname property.
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
     * Gets the value of the wrTelephone property.
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
     * Sets the value of the wrTelephone property.
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
     * Gets the value of the wrUsername property.
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
     * Sets the value of the wrUsername property.
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
