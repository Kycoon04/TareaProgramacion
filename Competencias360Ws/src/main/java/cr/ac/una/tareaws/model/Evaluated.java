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
@Table(name = "EVA_EVALUATED")
@NamedQueries({
    @NamedQuery(name = "Evaluated.findAll", query = "SELECT e FROM Evaluated e"),
    @NamedQuery(name = "Evaluated.findByEsId", query = "SELECT e FROM Evaluated e WHERE e.esId = :esId")})
public class Evaluated implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ES_ID")
    private Integer esId;
    @JoinColumn(name = "ES_PROCESOEVA", referencedColumnName = "EN_ID")
    @ManyToOne(optional = false)
    private Procesoeva esProcesoeva;
    @JoinColumn(name = "ES_WORKER", referencedColumnName = "WR_ID")
    @ManyToOne(optional = false)
    private Workers esWorker;

    public Evaluated() {
    }

    public Evaluated(EvaluatedDto evaluatedDto) {
        this.esId = 1;
        Actualizar(evaluatedDto);
    }

    public void Actualizar(EvaluatedDto evaluatedDto) {
        this.esProcesoeva = evaluatedDto.getEsProcesoeva();
        this.esWorker = evaluatedDto.getEsWorker();
    }

    public Evaluated(Integer esId) {
        this.esId = esId;
    }

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public Procesoeva getEsProcesoeva() {
        return esProcesoeva;
    }

    public void setEsProcesoeva(Procesoeva esProcesoeva) {
        this.esProcesoeva = esProcesoeva;
    }

    public Workers getEsWorker() {
        return esWorker;
    }

    public void setEsWorker(Workers esWorker) {
        this.esWorker = esWorker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esId != null ? esId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluated)) {
            return false;
        }
        Evaluated other = (Evaluated) object;
        if ((this.esId == null && other.esId != null) || (this.esId != null && !this.esId.equals(other.esId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.Evaluated[ esId=" + esId + " ]";
    }

}
