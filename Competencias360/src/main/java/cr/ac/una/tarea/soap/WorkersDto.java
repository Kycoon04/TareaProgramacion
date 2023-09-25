
package cr.ac.una.tarea.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para workersDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="workersDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="active" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="administrator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="identification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="job" type="{http://controller.tareaws.una.ac.cr/}jobs" minOccurs="0"/>
 *         <element name="landline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="photo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         <element name="psurname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="recover" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ssurname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workersDto", propOrder = {
    "active",
    "administrator",
    "code",
    "email",
    "id",
    "identification",
    "job",
    "landline",
    "name",
    "password",
    "photo",
    "psurname",
    "recover",
    "ssurname",
    "telephone",
    "username"
})
public class WorkersDto {

    protected String active;
    protected String administrator;
    protected String code;
    protected String email;
    protected Integer id;
    protected String identification;
    protected Jobs job;
    protected String landline;
    protected String name;
    protected String password;
    protected byte[] photo;
    protected String psurname;
    protected String recover;
    protected String ssurname;
    protected String telephone;
    protected String username;

    /**
     * Obtiene el valor de la propiedad active.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActive() {
        return active;
    }

    /**
     * Define el valor de la propiedad active.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActive(String value) {
        this.active = value;
    }

    /**
     * Obtiene el valor de la propiedad administrator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdministrator() {
        return administrator;
    }

    /**
     * Define el valor de la propiedad administrator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdministrator(String value) {
        this.administrator = value;
    }

    /**
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * Obtiene el valor de la propiedad identification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Define el valor de la propiedad identification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentification(String value) {
        this.identification = value;
    }

    /**
     * Obtiene el valor de la propiedad job.
     * 
     * @return
     *     possible object is
     *     {@link Jobs }
     *     
     */
    public Jobs getJob() {
        return job;
    }

    /**
     * Define el valor de la propiedad job.
     * 
     * @param value
     *     allowed object is
     *     {@link Jobs }
     *     
     */
    public void setJob(Jobs value) {
        this.job = value;
    }

    /**
     * Obtiene el valor de la propiedad landline.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandline() {
        return landline;
    }

    /**
     * Define el valor de la propiedad landline.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandline(String value) {
        this.landline = value;
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
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtiene el valor de la propiedad photo.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * Define el valor de la propiedad photo.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPhoto(byte[] value) {
        this.photo = value;
    }

    /**
     * Obtiene el valor de la propiedad psurname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsurname() {
        return psurname;
    }

    /**
     * Define el valor de la propiedad psurname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsurname(String value) {
        this.psurname = value;
    }

    /**
     * Obtiene el valor de la propiedad recover.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecover() {
        return recover;
    }

    /**
     * Define el valor de la propiedad recover.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecover(String value) {
        this.recover = value;
    }

    /**
     * Obtiene el valor de la propiedad ssurname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsurname() {
        return ssurname;
    }

    /**
     * Define el valor de la propiedad ssurname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsurname(String value) {
        this.ssurname = value;
    }

    /**
     * Obtiene el valor de la propiedad telephone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Define el valor de la propiedad telephone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Obtiene el valor de la propiedad username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define el valor de la propiedad username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
