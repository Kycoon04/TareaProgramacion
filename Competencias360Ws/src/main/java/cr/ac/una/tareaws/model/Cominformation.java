/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author dilan
 */
@Entity
@Table(name = "EVA_COMINFORMATION")
@NamedQueries({
    @NamedQuery(name = "Cominformation.findAll", query = "SELECT c FROM Cominformation c"),
    @NamedQuery(name = "Cominformation.findByCpId", query = "SELECT c FROM Cominformation c WHERE c.cpId = :cpId"),
    @NamedQuery(name = "Cominformation.findByCpName", query = "SELECT c FROM Cominformation c WHERE c.cpName = :cpName"),
    @NamedQuery(name = "Cominformation.findByCpEmail", query = "SELECT c FROM Cominformation c WHERE c.cpEmail = :cpEmail"),
    @NamedQuery(name = "Cominformation.findByCpInformation", query = "SELECT c FROM Cominformation c WHERE c.cpInformation = :cpInformation"),
    @NamedQuery(name = "Cominformation.findByCpKey", query = "SELECT c FROM Cominformation c WHERE c.cpKey = :cpKey")})
public class Cominformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CP_ID")
    private Integer cpId;
    @Basic(optional = false)
    @Column(name = "CP_NAME")
    private String cpName;
    @Basic(optional = false)
    @Column(name = "CP_EMAIL")
    private String cpEmail;
    @Column(name = "CP_INFORMATION")
    private String cpInformation;
    @Lob
    @Column(name = "CP_PHOTO")
    private byte[] cpPhoto;
    @Column(name = "CP_KEY")
    private String cpKey;

    public Cominformation() {
    }
    public Cominformation(ComInformationDto comInformationDto) {
        this.cpId = 1;
        Actualizar(comInformationDto);
    }

    public void Actualizar(ComInformationDto comInformationDto) {
        this.cpName = comInformationDto.getName();
        this.cpInformation = comInformationDto.getInformation();
        this.cpEmail = comInformationDto.getEmail();
        this.cpPhoto= comInformationDto.getPhoto();
        this.cpKey=comInformationDto.getCpKey();
    }
    
    public Cominformation(Integer cpId) {
        this.cpId = cpId;
    }

    public Cominformation(Integer cpId, String cpName, String cpEmail) {
        this.cpId = cpId;
        this.cpName = cpName;
        this.cpEmail = cpEmail;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpEmail() {
        return cpEmail;
    }

    public void setCpEmail(String cpEmail) {
        this.cpEmail = cpEmail;
    }

    public String getCpInformation() {
        return cpInformation;
    }

    public void setCpInformation(String cpInformation) {
        this.cpInformation = cpInformation;
    }

    public byte[] getCpPhoto() {
        return cpPhoto;
    }

    public void setCpPhoto(byte[] cpPhoto) {
        this.cpPhoto = cpPhoto;
    }

    public String getCpKey() {
        return cpKey;
    }

    public void setCpKey(String cpKey) {
        this.cpKey = cpKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpId != null ? cpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cominformation)) {
            return false;
        }
        Cominformation other = (Cominformation) object;
        if ((this.cpId == null && other.cpId != null) || (this.cpId != null && !this.cpId.equals(other.cpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.controller.Cominformation[ cpId=" + cpId + " ]";
    }

}
