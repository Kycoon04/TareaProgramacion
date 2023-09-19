/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.model;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author jomav
 */
@Entity
@Table(name = "EVA_PROCESOEVA")
@NamedQueries({
    @NamedQuery(name = "Procesoeva.findAll", query = "SELECT p FROM Procesoeva p"),
    @NamedQuery(name = "Procesoeva.findByEnId", query = "SELECT p FROM Procesoeva p WHERE p.enId = :enId"),
    @NamedQuery(name = "Procesoeva.findByEnName", query = "SELECT p FROM Procesoeva p WHERE p.enName = :enName"),
    @NamedQuery(name = "Procesoeva.findByEnState", query = "SELECT p FROM Procesoeva p WHERE p.enState = :enState"),
    @NamedQuery(name = "Procesoeva.findByEnInicialperiod", query = "SELECT p FROM Procesoeva p WHERE p.enInicialperiod = :enInicialperiod"),
    @NamedQuery(name = "Procesoeva.findByEnFinalperiod", query = "SELECT p FROM Procesoeva p WHERE p.enFinalperiod = :enFinalperiod"),
    @NamedQuery(name = "Procesoeva.findByEnApplication", query = "SELECT p FROM Procesoeva p WHERE p.enApplication = :enApplication")})
public class Procesoeva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EN_ID")
    private Integer enId;
    @Basic(optional = false)
    @Column(name = "EN_NAME")
    private String enName;
    @Basic(optional = false)
    @Column(name = "EN_STATE")
    private String enState;
    @Column(name = "EN_INICIALPERIOD")
    private LocalDate enInicialperiod;
    @Column(name = "EN_FINALPERIOD")
    private LocalDate enFinalperiod;
    @Column(name = "EN_APPLICATION")
    private LocalDate enApplication;

    public Procesoeva() {
    }
    public Procesoeva(ProcesoevaDto procesoevaDto) {
        this.enId = 1;
        Actualizar(procesoevaDto);
    }

    public void Actualizar(ProcesoevaDto procesoevaDto) {
        this.enName = procesoevaDto.getName();
        this.enState = procesoevaDto.getState();
        this.enInicialperiod = procesoevaDto.getInicialperiod();
        this.enFinalperiod = procesoevaDto.getFinalperiod();
        this.enApplication = procesoevaDto.getApplication();
    }
    public Procesoeva(Integer enId) {
        this.enId = enId;
    }

    public Procesoeva(Integer enId, String enName, String enState) {
        this.enId = enId;
        this.enName = enName;
        this.enState = enState;
    }

    public Integer getEnId() {
        return enId;
    }

    public void setEnId(Integer enId) {
        this.enId = enId;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEnState() {
        return enState;
    }

    public void setEnState(String enState) {
        this.enState = enState;
    }

    public LocalDate getEnInicialperiod() {
        return enInicialperiod;
    }

    public void setEnInicialperiod(LocalDate enInicialperiod) {
        this.enInicialperiod = enInicialperiod;
    }

    public LocalDate getEnFinalperiod() {
        return enFinalperiod;
    }

    public void setEnFinalperiod(LocalDate enFinalperiod) {
        this.enFinalperiod = enFinalperiod;
    }

    public LocalDate getEnApplication() {
        return enApplication;
    }

    public void setEnApplication(LocalDate enApplication) {
        this.enApplication = enApplication;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enId != null ? enId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesoeva)) {
            return false;
        }
        Procesoeva other = (Procesoeva) object;
        if ((this.enId == null && other.enId != null) || (this.enId != null && !this.enId.equals(other.enId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.Procesoeva[ enId=" + enId + " ]";
    }
    
}
