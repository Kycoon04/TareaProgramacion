package cr.ac.una.tareaws.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author jomav
 */
@Entity
@Table(name = "EVA_WORKERS")
@NamedQueries({
    @NamedQuery(name = "Workers.findByUsuarioClave", query = "SELECT p FROM Workers p where p.wrUsername = :fname AND p.wrPassword = :fpassword"),
    @NamedQuery(name = "Workers.findAll", query = "SELECT w FROM Workers w"),
    @NamedQuery(name = "Workers.findByWrName", query = "SELECT w FROM Workers w WHERE w.wrName = :wrName"),
    @NamedQuery(name = "Workers.findByWrUsername", query = "SELECT w FROM Workers w WHERE w.wrUsername = :wrUsername"),
    @NamedQuery(name = "Workers.findByWrPsurname", query = "SELECT w FROM Workers w WHERE w.wrPsurname = :wrPsurname"),
    @NamedQuery(name = "Workers.findByWrSsurname", query = "SELECT w FROM Workers w WHERE w.wrSsurname = :wrSsurname"),
    @NamedQuery(name = "Workers.findByWrId", query = "SELECT w FROM Workers w WHERE w.wrId = :wrId"),
    @NamedQuery(name = "Workers.findByWrIdentification", query = "SELECT w FROM Workers w WHERE w.wrIdentification = :wrIdentification"),
    @NamedQuery(name = "Workers.findByWrEmail", query = "SELECT w FROM Workers w WHERE w.wrEmail = :wrEmail"),
    @NamedQuery(name = "Workers.findByWrLandline", query = "SELECT w FROM Workers w WHERE w.wrLandline = :wrLandline"),
    @NamedQuery(name = "Workers.findByWrTelephone", query = "SELECT w FROM Workers w WHERE w.wrTelephone = :wrTelephone"),
    @NamedQuery(name = "Workers.findByWrPassword", query = "SELECT w FROM Workers w WHERE w.wrPassword = :wrPassword"),
    @NamedQuery(name = "Workers.findByWrActive", query = "SELECT w FROM Workers w WHERE w.wrActive = :wrActive"),
    @NamedQuery(name = "Workers.findByWrAdmin", query = "SELECT w FROM Workers w WHERE w.wrAdmin = :wrAdmin"),
    @NamedQuery(name = "Workers.findByWrRecover", query = "SELECT w FROM Workers w WHERE w.wrRecover = :wrRecover"),
    @NamedQuery(name = "Workers.findByWrCodeactive", query = "SELECT w FROM Workers w WHERE w.wrCodeactive = :wrCodeactive")})
public class Workers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "WR_NAME")
    private String wrName;
    @Basic(optional = false)
    @Column(name = "WR_USERNAME")
    private String wrUsername;
    @Column(name = "WR_PSURNAME")
    private String wrPsurname;
    @Column(name = "WR_SSURNAME")
    private String wrSsurname;
    @Id
    @Basic(optional = false)
    @Column(name = "WR_ID")
    private Integer wrId;
    @Basic(optional = false)
    @Column(name = "WR_IDENTIFICATION")
    private String wrIdentification;
    @Basic(optional = false)
    @Column(name = "WR_EMAIL")
    private String wrEmail;
    @Column(name = "WR_LANDLINE")
    private String wrLandline;
    @Column(name = "WR_TELEPHONE")
    private String wrTelephone;
    @Lob
    @Column(name = "WR_PHOTO")
    private byte[] wrPhoto;
    @Basic(optional = false)
    @Column(name = "WR_PASSWORD")
    private String wrPassword;
    @Basic(optional = false)
    @Column(name = "WR_ACTIVE")
    private String wrActive;
    @Basic(optional = false)
    @Column(name = "WR_ADMIN")
    private String wrAdmin;
    @Column(name = "WR_RECOVER")
    private String wrRecover;
    @Column(name = "WR_CODEACTIVE")
    private String wrCodeactive;
    @JoinColumn(name = "WR_JOB", referencedColumnName = "JS_ID")
    @ManyToOne
    private Jobs wrJob;

    public Workers() {
    }

    public Workers(Integer wrId) {
        this.wrId = wrId;
    }

    public Workers(String wrName, String wrUsername, String wrPsurname, String wrSsurname, Integer wrId, String wrIdentification, String wrEmail, String wrLandline, String wrTelephone, byte[] wrPhoto, String wrPassword, String wrActive, String wrAdmin, String wrRecover, String wrCodeactive, Jobs wrJob) {
        this.wrName = wrName;
        this.wrUsername = wrUsername;
        this.wrPsurname = wrPsurname;
        this.wrSsurname = wrSsurname;
        this.wrId = wrId;
        this.wrIdentification = wrIdentification;
        this.wrEmail = wrEmail;
        this.wrLandline = wrLandline;
        this.wrTelephone = wrTelephone;
        this.wrPhoto = wrPhoto;
        this.wrPassword = wrPassword;
        this.wrActive = wrActive;
        this.wrAdmin = wrAdmin;
        this.wrRecover = wrRecover;
        this.wrCodeactive = wrCodeactive;
        this.wrJob = wrJob;
    }

    public Workers(Integer wrId, String wrName, String wrUsername, String wrIdentification, String wrEmail, String wrPassword, String wrActive, String wrAdmin) {
        this.wrId = wrId;
        this.wrName = wrName;
        this.wrUsername = wrUsername;
        this.wrIdentification = wrIdentification;
        this.wrEmail = wrEmail;
        this.wrPassword = wrPassword;
        this.wrActive = wrActive;
        this.wrAdmin = wrAdmin;
    }
    public Workers(WorkersDto workerDto) {
        this.wrId = 1;
        Actualizar(workerDto);
    }

    public void Actualizar(WorkersDto workerDto) {
        this.wrName = workerDto.getName();
        this.wrCodeactive = workerDto.getCode();
        this.wrUsername = workerDto.getUsername();
        this.wrIdentification = workerDto.getIdentification();
        this.wrPsurname = workerDto.getPsurname();
        this.wrSsurname = workerDto.getSsurname();
        this.wrEmail = workerDto.getEmail();
        this.wrPassword = workerDto.getPassword();
        this.wrLandline = workerDto.getLandline();
        this.wrTelephone = workerDto.getTelephone();
        this.wrPhoto = workerDto.getPhoto();
        this.wrAdmin = workerDto.getAdministrator();
        this.wrActive = workerDto.getActive();
        this.wrJob = workerDto.getJob();
        this.wrRecover = workerDto.getRecover();
    }
    public void ActualizarCuentaActivo(WorkersDto workerDto) {
        this.wrActive = workerDto.getActive();
    }

    public void ActualizarContrasena(WorkersDto workerDto) {
        this.wrPassword = workerDto.getPassword();
         this.wrRecover = workerDto.getRecover();
    }
    public String getWrName() {
        return wrName;
    }

    public void setWrName(String wrName) {
        this.wrName = wrName;
    }

    public String getWrUsername() {
        return wrUsername;
    }

    public void setWrUsername(String wrUsername) {
        this.wrUsername = wrUsername;
    }

    public String getWrPsurname() {
        return wrPsurname;
    }

    public void setWrPsurname(String wrPsurname) {
        this.wrPsurname = wrPsurname;
    }

    public String getWrSsurname() {
        return wrSsurname;
    }

    public void setWrSsurname(String wrSsurname) {
        this.wrSsurname = wrSsurname;
    }

    public Integer getWrId() {
        return wrId;
    }

    public void setWrId(Integer wrId) {
        this.wrId = wrId;
    }

    public String getWrIdentification() {
        return wrIdentification;
    }

    public void setWrIdentification(String wrIdentification) {
        this.wrIdentification = wrIdentification;
    }

    public String getWrEmail() {
        return wrEmail;
    }

    public void setWrEmail(String wrEmail) {
        this.wrEmail = wrEmail;
    }

    public String getWrLandline() {
        return wrLandline;
    }

    public void setWrLandline(String wrLandline) {
        this.wrLandline = wrLandline;
    }

    public String getWrTelephone() {
        return wrTelephone;
    }

    public void setWrTelephone(String wrTelephone) {
        this.wrTelephone = wrTelephone;
    }

    public byte[] getWrPhoto() {
        return wrPhoto;
    }

    public void setWrPhoto(byte[] wrPhoto) {
        this.wrPhoto = wrPhoto;
    }

    public String getWrPassword() {
        return wrPassword;
    }

    public void setWrPassword(String wrPassword) {
        this.wrPassword = wrPassword;
    }

    public String getWrActive() {
        return wrActive;
    }

    public void setWrActive(String wrActive) {
        this.wrActive = wrActive;
    }

    public String getWrAdmin() {
        return wrAdmin;
    }

    public void setWrAdmin(String wrAdmin) {
        this.wrAdmin = wrAdmin;
    }

    public String getWrRecover() {
        return wrRecover;
    }

    public void setWrRecover(String wrRecover) {
        this.wrRecover = wrRecover;
    }

    public String getWrCodeactive() {
        return wrCodeactive;
    }

    public void setWrCodeactive(String wrCodeactive) {
        this.wrCodeactive = wrCodeactive;
    }

    /*public List<Evaluators> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluators> evaluationList) {
        this.evaluationList = evaluationList;
    }*/

    public Jobs getWrJob() {
        return wrJob;
    }

    public void setWrJob(Jobs wrJob) {
        this.wrJob = wrJob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wrId != null ? wrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workers)) {
            return false;
        }
        Workers other = (Workers) object;
        if ((this.wrId == null && other.wrId != null) || (this.wrId != null && !this.wrId.equals(other.wrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.tareaws.model.Workers[ wrId=" + wrId + " ]";
    }
    
}