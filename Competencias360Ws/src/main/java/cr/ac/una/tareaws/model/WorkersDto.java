package cr.ac.una.tareaws.model;


import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author jomav
 */
public class WorkersDto implements Serializable {

    private String name;
    private String username;
    private String psurname;
    private String ssurname;
    private Jobs job;
    private Integer id;
    private String identification;
    private String email;
    private String password;
    private String landline;
    private String telephone;
    private String active;
    private String administrator;
    private String recover;
    private byte[] photo;
    private String code;

    public WorkersDto() {
    }

    public WorkersDto(Workers worker) throws IOException {
        this.job = worker.getWrJob();
        this.recover = worker.getWrRecover();
        this.id = worker.getWrId();
        this.name = worker.getWrName();
        this.username = worker.getWrUsername();
        this.identification = worker.getWrIdentification();
        this.psurname = worker.getWrPsurname();
        this.ssurname = worker.getWrSsurname();
        this.email = worker.getWrEmail();
        this.password = worker.getWrPassword();
        this.landline = worker.getWrLandline();
        this.telephone = worker.getWrTelephone();
        this.photo = worker.getWrPhoto();
        this.administrator = worker.getWrAdmin();
        this.active = worker.getWrActive();
        this.code = worker.getWrCodeactive();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPsurname() {
        return psurname;
    }

    public String getSsurname() {
        return ssurname;
    }

    public Jobs getJob() {
        return job;
    }

    public Integer getId() {
        return id;
    }

    public String getIdentification() {
        return identification;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLandline() {
        return landline;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getActive() {
        return active;
    }

    public String getAdministrator() {
        return administrator;
    }

    public String getRecover() {
        return recover;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setRecover(String recover) {
        this.recover = recover;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPsurname(String psurname) {
        this.psurname = psurname;
    }

    public void setSsurname(String ssurname) {
        this.ssurname = ssurname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WorkersDto other = (WorkersDto) obj;
        return Objects.equals(this.id, other.id);
    }

}
