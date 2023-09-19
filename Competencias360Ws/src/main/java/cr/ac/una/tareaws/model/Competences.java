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
@Table(name = "EVA_COMPETENCES")
@NamedQueries({
    @NamedQuery(name = "Competences.findAll", query = "SELECT c FROM Competences c"),
    @NamedQuery(name = "Competences.findByCsId", query = "SELECT c FROM Competences c WHERE c.csId = :csId"),
    @NamedQuery(name = "Competences.findByCsName", query = "SELECT c FROM Competences c WHERE c.csName = :csName"),
    @NamedQuery(name = "Competences.findByCsState", query = "SELECT c FROM Competences c WHERE c.csState = :csState"),
    @NamedQuery(name = "Competences.findByCsCharacteristics", query = "SELECT c FROM Competences c WHERE c.csCharacteristics = :csCharacteristics")})
public class Competences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CS_ID")
    private Integer csId;
    @Column(name = "CS_NAME")
    private String csName;
    @Column(name = "CS_STATE")
    private String csState;
    @Column(name = "CS_CHARACTERISTICS")
    private String csCharacteristics;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "jxcCompetence")
    //private List<JobsCompetences> jobsCompetencesList;

    public Competences() {
    }
    public Competences(CompetencesDto competencesDto) {
        this.csId = 1;
        Actualizar(competencesDto);
    }

    public void Actualizar(CompetencesDto competencesDto) {
        this.csName = competencesDto.getName();
        this.csState = competencesDto.getState();
        this.csCharacteristics = competencesDto.getCharacteristics();
    }
    public Competences(Integer csId) {
        this.csId = csId;
    }

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }

    public String getCsState() {
        return csState;
    }

    public void setCsState(String csState) {
        this.csState = csState;
    }

    public String getCsCharacteristics() {
        return csCharacteristics;
    }

    public void setCsCharacteristics(String csCharacteristics) {
        this.csCharacteristics = csCharacteristics;
    }
/*
    public List<JobsCompetences> getJobsCompetencesList() {
        return jobsCompetencesList;
    }

    public void setJobsCompetencesList(List<JobsCompetences> jobsCompetencesList) {
        this.jobsCompetencesList = jobsCompetencesList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csId != null ? csId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competences)) {
            return false;
        }
        Competences other = (Competences) object;
        if ((this.csId == null && other.csId != null) || (this.csId != null && !this.csId.equals(other.csId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.Competences[ csId=" + csId + " ]";
    }
    
}