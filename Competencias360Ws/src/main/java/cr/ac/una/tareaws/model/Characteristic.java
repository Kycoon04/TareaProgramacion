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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author jomav
 */
@Entity
@Table(name = "EVA_CHARACTERISTIC")
@NamedQueries({
    @NamedQuery(name = "Characteristic.findAll", query = "SELECT c FROM Characteristic c"),
    @NamedQuery(name = "Characteristic.findByCcId", query = "SELECT c FROM Characteristic c WHERE c.ccId = :ccId"),
    @NamedQuery(name = "Characteristic.findByCcName", query = "SELECT c FROM Characteristic c WHERE c.ccName = :ccName")})
public class Characteristic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CC_ID")
    private Integer ccId;
    @Basic(optional = false)
    @Column(name = "CC_NAME")
    private String ccName;
    @JoinColumn(name = "CC_COMID", referencedColumnName = "CS_ID")
    @ManyToOne
    private Competences ccComid;

    public Characteristic() {
    }
    public Characteristic(CharacteristicDto characteristicDto) {
        this.ccId = 1;
        Actualizar(characteristicDto);
    }

    public void Actualizar(CharacteristicDto characteristicDto) {
        this.ccComid = characteristicDto.getCcComid();
        this.ccName = characteristicDto.getCcName();
    }
    public Characteristic(Integer ccId) {
        this.ccId = ccId;
    }

    public Characteristic(Integer ccId, String ccName) {
        this.ccId = ccId;
        this.ccName = ccName;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public Competences getCcComid() {
        return ccComid;
    }

    public void setCcComid(Competences ccComid) {
        this.ccComid = ccComid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccId != null ? ccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Characteristic)) {
            return false;
        }
        Characteristic other = (Characteristic) object;
        if ((this.ccId == null && other.ccId != null) || (this.ccId != null && !this.ccId.equals(other.ccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.Characteristic[ ccId=" + ccId + " ]";
    }
    
}
