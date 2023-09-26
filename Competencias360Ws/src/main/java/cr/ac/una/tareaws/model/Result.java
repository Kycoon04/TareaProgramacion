/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.model;

import cr.ac.una.tareaws.model.Competences;
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
@Table(name = "EVA_RESULT")
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findByRsNotasis", query = "SELECT r FROM Result r WHERE r.rsNotasis = :rsNotasis"),
    @NamedQuery(name = "Result.findByRsNotajefatura", query = "SELECT r FROM Result r WHERE r.rsNotajefatura = :rsNotajefatura"),
    @NamedQuery(name = "Result.findByRsId", query = "SELECT r FROM Result r WHERE r.rsId = :rsId")})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RS_NOTASIS")
    private Double rsNotasis;
    @Column(name = "RS_NOTAJEFATURA")
    private Double rsNotajefatura;
    @Id
    @Basic(optional = false)
    @Column(name = "RS_ID")
    private Integer rsId;
    @JoinColumn(name = "RS_COMPE", referencedColumnName = "CS_ID")
    @ManyToOne(optional = false)
    private Competences rsCompe;
    @JoinColumn(name = "RS_EVALUATED", referencedColumnName = "ES_ID")
    @ManyToOne(optional = false)
    private Evaluated rsEvaluated;

    public Result() {
    }
    public Result(ResultDto resultDto) {
        this.rsId = 1;
        Actualizar(resultDto);
    }

    public void Actualizar(ResultDto resultDto) {
        this.rsCompe = resultDto.getRsCompe();
        this.rsEvaluated = resultDto.getRsEvaluated();
        this.rsNotasis= resultDto.getRsNotasis();
        this.rsNotajefatura= resultDto.getRsNotajefatura();
    }
    public Result(Integer rsId) {
        this.rsId = rsId;
    }

    public Evaluated getRsEvaluated() {
        return rsEvaluated;
    }

    public void setRsEvaluated(Evaluated rsEvaluated) {
        this.rsEvaluated = rsEvaluated;
    }

    public Double getRsNotasis() {
        return rsNotasis;
    }

    public void setRsNotasis(Double rsNotasis) {
        this.rsNotasis = rsNotasis;
    }

    public Double getRsNotajefatura() {
        return rsNotajefatura;
    }

    public void setRsNotajefatura(Double rsNotajefatura) {
        this.rsNotajefatura = rsNotajefatura;
    }

    public Integer getRsId() {
        return rsId;
    }

    public void setRsId(Integer rsId) {
        this.rsId = rsId;
    }

    public Competences getRsCompe() {
        return rsCompe;
    }

    public void setRsCompe(Competences rsCompe) {
        this.rsCompe = rsCompe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rsId != null ? rsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.rsId == null && other.rsId != null) || (this.rsId != null && !this.rsId.equals(other.rsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.controller.Result[ rsId=" + rsId + " ]";
    }
    
}
