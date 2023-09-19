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
@Table(name = "EVA_EVALUATORS")
@NamedQueries({
    @NamedQuery(name = "Evaluators.findAll", query = "SELECT e FROM Evaluators e"),
    @NamedQuery(name = "Evaluators.findByEvsFeedback", query = "SELECT e FROM Evaluators e WHERE e.evsFeedback = :evsFeedback"),
    @NamedQuery(name = "Evaluators.findByEvsConnection", query = "SELECT e FROM Evaluators e WHERE e.evsConnection = :evsConnection"),
    @NamedQuery(name = "Evaluators.findByEvsId", query = "SELECT e FROM Evaluators e WHERE e.evsId = :evsId"),
    @NamedQuery(name = "Evaluators.findByEvsState", query = "SELECT e FROM Evaluators e WHERE e.evsState = :evsState")})
public class Evaluators implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "EVS_FEEDBACK")
    private String evsFeedback;
    @Column(name = "EVS_CONNECTION")
    private String evsConnection;
    @Id
    @Basic(optional = false)
    @Column(name = "EVS_ID")
    private Integer evsId;
    @Column(name = "EVS_STATE")
    private String evsState;
    @JoinColumn(name = "EVS_EVALUATED", referencedColumnName = "ES_ID")
    @ManyToOne(optional = false)
    private Evaluated evsEvaluated;
    @JoinColumn(name = "EVS_WORKER", referencedColumnName = "WR_ID")
    @ManyToOne
    private Workers evsWorker;

    public Evaluators() {
    }
    
     public Evaluators(EvaluatorsDto evaluatorsDto) {
        this.evsId = 1;
        Actualizar(evaluatorsDto);
    }

    public void Actualizar(EvaluatorsDto evaluatorsDto) {
       this.evsEvaluated = evaluatorsDto.getEvsEvaluated();
       this.evsFeedback = evaluatorsDto.getEvsFeedback();
       this.evsState= evaluatorsDto.getEvsState();
       this.evsWorker= evaluatorsDto.getEvsWorker();
       this.evsConnection= evaluatorsDto.getEvsConnection();
       
    }
    public Evaluators(Integer evsId) {
        this.evsId = evsId;
    }

    public String getEvsFeedback() {
        return evsFeedback;
    }

    public void setEvsFeedback(String evsFeedback) {
        this.evsFeedback = evsFeedback;
    }

    public String getEvsConnection() {
        return evsConnection;
    }

    public void setEvsConnection(String evsConnection) {
        this.evsConnection = evsConnection;
    }

    public Integer getEvsId() {
        return evsId;
    }

    public void setEvsId(Integer evsId) {
        this.evsId = evsId;
    }

    public String getEvsState() {
        return evsState;
    }

    public void setEvsState(String evsState) {
        this.evsState = evsState;
    }

    public Evaluated getEvsEvaluated() {
        return evsEvaluated;
    }

    public void setEvsEvaluated(Evaluated evsEvaluated) {
        this.evsEvaluated = evsEvaluated;
    }

    public Workers getEvsWorker() {
        return evsWorker;
    }

    public void setEvsWorker(Workers evsWorker) {
        this.evsWorker = evsWorker;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evsId != null ? evsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluators)) {
            return false;
        }
        Evaluators other = (Evaluators) object;
        if ((this.evsId == null && other.evsId != null) || (this.evsId != null && !this.evsId.equals(other.evsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.Evaluators[ evsId=" + evsId + " ]";
    }
    
}
