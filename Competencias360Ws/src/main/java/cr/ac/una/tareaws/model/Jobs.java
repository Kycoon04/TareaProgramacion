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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author jomav
 */
@Entity
@Table(name = "EVA_JOBS")
@NamedQueries({
    @NamedQuery(name = "Jobs.findAll", query = "SELECT j FROM Jobs j"),
    @NamedQuery(name = "Jobs.findByJsId", query = "SELECT j FROM Jobs j WHERE j.jsId = :jsId"),
    @NamedQuery(name = "Jobs.findByJsName", query = "SELECT j FROM Jobs j WHERE j.jsName = :jsName"),
    @NamedQuery(name = "Jobs.findByJsState", query = "SELECT j FROM Jobs j WHERE j.jsState = :jsState")})
public class Jobs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JS_ID")
    private Integer jsId;
    @Column(name = "JS_NAME")
    private String jsName;
    @Column(name = "JS_STATE")
    private String jsState;

    public Jobs() {
    }
    public Jobs(JobsDto jobsDto) {
        this.jsId = 1;
        Actualizar(jobsDto);
    }

    public void Actualizar(JobsDto jobsDto) {
        this.jsName = jobsDto.getName();
        this.jsState = jobsDto.getState();
    }
    public Jobs(Integer jsId) {
        this.jsId = jsId;
    }

    public Integer getJsId() {
        return jsId;
    }

    public void setJsId(Integer jsId) {
        this.jsId = jsId;
    }

    public String getJsName() {
        return jsName;
    }

    public void setJsName(String jsName) {
        this.jsName = jsName;
    }

    public String getJsState() {
        return jsState;
    }

    public void setJsState(String jsState) {
        this.jsState = jsState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jsId != null ? jsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobs)) {
            return false;
        }
        Jobs other = (Jobs) object;
        if ((this.jsId == null && other.jsId != null) || (this.jsId != null && !this.jsId.equals(other.jsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.Jobs[ jsId=" + jsId + " ]";
    }
    
}
