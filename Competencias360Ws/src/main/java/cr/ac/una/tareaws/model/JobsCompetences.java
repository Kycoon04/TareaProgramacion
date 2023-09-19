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
@Table(name = "EVA_JOBS_COMPETENCES")
@NamedQueries({
    @NamedQuery(name = "JobsCompetences.findAll", query = "SELECT j FROM JobsCompetences j"),
    @NamedQuery(name = "JobsCompetences.findByJxcIdcojob", query = "SELECT j FROM JobsCompetences j WHERE j.jxcIdcojob = :jxcIdcojob")})
public class JobsCompetences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JXC_IDCOJOB")
    private Integer jxcIdcojob;
    @JoinColumn(name = "JXC_COMPETENCE", referencedColumnName = "CS_ID")
    @ManyToOne(optional = false)
    private Competences jxcCompetence;
    @JoinColumn(name = "JXC_JOB", referencedColumnName = "JS_ID")
    @ManyToOne(optional = false)
    private Jobs jxcJob;

    public JobsCompetences() {
    }
    public JobsCompetences(JobsCompetencesDto jobsCompetencesDto) {
        this.jxcIdcojob = 1;
        Actualizar(jobsCompetencesDto);
    }

    public void Actualizar(JobsCompetencesDto jobsCompetencesDto) {
        this.jxcCompetence = jobsCompetencesDto.getJxcCompetence();
        this.jxcJob= jobsCompetencesDto.getJobs();
    }
    public JobsCompetences(Integer jxcIdcojob) {
        this.jxcIdcojob = jxcIdcojob;
    }

    public Integer getJxcIdcojob() {
        return jxcIdcojob;
    }

    public void setJxcIdcojob(Integer jxcIdcojob) {
        this.jxcIdcojob = jxcIdcojob;
    }

    public Competences getJxcCompetence() {
        return jxcCompetence;
    }

    public void setJxcCompetence(Competences jxcCompetence) {
        this.jxcCompetence = jxcCompetence;
    }

    public Jobs getJxcJob() {
        return jxcJob;
    }

    public void setJxcJob(Jobs jxcJob) {
        this.jxcJob = jxcJob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jxcIdcojob != null ? jxcIdcojob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobsCompetences)) {
            return false;
        }
        JobsCompetences other = (JobsCompetences) object;
        if ((this.jxcIdcojob == null && other.jxcIdcojob != null) || (this.jxcIdcojob != null && !this.jxcIdcojob.equals(other.jxcIdcojob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.JobsCompetences[ jxcIdcojob=" + jxcIdcojob + " ]";
    }
    
}
