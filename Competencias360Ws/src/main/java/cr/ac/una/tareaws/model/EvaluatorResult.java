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
@Table(name = "EVA_EVALUATOR_RESULT")
@NamedQueries({
    @NamedQuery(name = "EvaluatorResult.findAll", query = "SELECT e FROM EvaluatorResult e"),
    @NamedQuery(name = "EvaluatorResult.findByErNota", query = "SELECT e FROM EvaluatorResult e WHERE e.erNota = :erNota"),
    @NamedQuery(name = "EvaluatorResult.findByErId", query = "SELECT e FROM EvaluatorResult e WHERE e.erId = :erId")})
public class EvaluatorResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ER_NOTA")
    private Integer erNota;
    @Id
    @Basic(optional = false)
    @Column(name = "ER_ID")
    private Integer erId;
    @JoinColumn(name = "ER_COMPE", referencedColumnName = "CS_ID")
    @ManyToOne
    private Competences erCompe;
    @JoinColumn(name = "ER_EVALUATOR", referencedColumnName = "EVS_ID")
    @ManyToOne
    private Evaluators erEvaluator;

    public EvaluatorResult() {
    }
   public EvaluatorResult(EvaluatorResultDto evaluatorResultDto) {
        this.erId = 1;
        Actualizar(evaluatorResultDto);
    }

    public void Actualizar(EvaluatorResultDto evaluatorResultDto) {
        this.erCompe = evaluatorResultDto.getErCompe();
        this.erEvaluator = evaluatorResultDto.getErEvaluator();
         this.erNota = evaluatorResultDto.getErNota();
    
    }
    public EvaluatorResult(Integer erId) {
        this.erId = erId;
    }

    public Integer getErNota() {
        return erNota;
    }

    public void setErNota(Integer erNota) {
        this.erNota = erNota;
    }

    public Integer getErId() {
        return erId;
    }

    public void setErId(Integer erId) {
        this.erId = erId;
    }

    public Competences getErCompe() {
        return erCompe;
    }

    public void setErCompe(Competences erCompe) {
        this.erCompe = erCompe;
    }

    public Evaluators getErEvaluator() {
        return erEvaluator;
    }

    public void setErEvaluator(Evaluators erEvaluator) {
        this.erEvaluator = erEvaluator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erId != null ? erId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluatorResult)) {
            return false;
        }
        EvaluatorResult other = (EvaluatorResult) object;
        if ((this.erId == null && other.erId != null) || (this.erId != null && !this.erId.equals(other.erId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.EvaluatorResult[ erId=" + erId + " ]";
    }
    
}
