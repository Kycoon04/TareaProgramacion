package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.Jobs;
import cr.ac.una.tarea.soap.WorkersDto;
import java.util.Objects;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author jomav
 */
public class WorkerDto {

    public SimpleStringProperty name;
    public SimpleStringProperty code;
    public SimpleStringProperty psurname;
    public SimpleStringProperty username;
    public SimpleStringProperty ssurname;
    public SimpleIntegerProperty id;
    public SimpleStringProperty identification;
    public SimpleStringProperty email;
    public SimpleStringProperty password;
    public SimpleStringProperty landline;
    public SimpleStringProperty telephone;
    public SimpleBooleanProperty active;
    public SimpleStringProperty administrator;
    public byte[] photo;
    private Long version;
    private Boolean modificado;
    private Jobs job;
    private SimpleBooleanProperty recover;

    public WorkerDto() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.code = new SimpleStringProperty();
        this.username = new SimpleStringProperty();
        this.identification = new SimpleStringProperty();
        this.psurname = new SimpleStringProperty();
        this.ssurname = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.landline = new SimpleStringProperty();
        this.telephone = new SimpleStringProperty();
        this.administrator = new SimpleStringProperty("N");
        this.active = new SimpleBooleanProperty(false);
        this.job = new Jobs();
        this.recover = new SimpleBooleanProperty();

    }

    public WorkerDto(WorkersDto Worker) {
        this.code.set(Worker.getCode());
        this.id.set(Worker.getId());
        this.name.set(Worker.getName());
        this.username.set(Worker.getUsername());
        this.identification.set(Worker.getIdentification());
        this.psurname.set(Worker.getPsurname());
        this.ssurname.set(Worker.getSsurname());
        this.email.set(Worker.getEmail());
        this.password.set(Worker.getPassword());
        this.landline.set(Worker.getLandline());
        this.telephone.set(Worker.getTelephone());
        this.photo = Worker.getPhoto();
        this.administrator.set(Worker.getAdministrator());
        this.active.set(Worker.getActive().equals("S"));
        this.job = Worker.getJob();
        this.recover.set(Worker.getRecover().equals("S"));
    }

    public String getCode() {
        return code.get();
    }

    public boolean isFill(WorkerDto wor) {
        if (wor.getName() != "" && wor.getSsurname() != "" && wor.getUsername() != "" && wor.getEmail() != "" && wor.getPassword() != "") {
            return true;
        }
        return false;
    }

    public void setCode(String codeP) {
        this.code.set(codeP);
    }

    public String getIden() {
        return identification.get();
    }

    public void setUsername(String usernameP) {
        this.username.set(usernameP);
    }

    public String getUsername() {
        return username.get();
    }

    public void setIdentification(String identificationP) {
        this.identification.set(identificationP);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPsurname() {
        return psurname.get();
    }

    public void setPsurname(String psurname) {
        this.psurname.set(psurname);
    }

    public String getSsurname() {
        return ssurname.get();
    }

    public void setSsurname(String ssurname) {
        this.ssurname.set(ssurname);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getLandline() {
        return landline.get();
    }

    public void setLandline(String landline) {
        this.landline.set(landline);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getActive() {
        return active.get() ? "S" : "N";
    }

    public String getActives() {
        String act;
        if (active.get()) {
            act = "Activo";
        } else {
            act = "Inactivo";
        }
        return act;
    }

    public void setActive(String active) {
        this.active.set(active.equals("S"));
    }

    public String getAdministrator() {
        return administrator.get();
    }

    public void setAdministrator(String administrator) {
        this.administrator.set(administrator);
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public String getRecover() {
        return recover.get() ? "S" : "N";
    }

    public void setRecover(String Recover) {
        this.recover.set(Recover.equals("S"));
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
        final WorkerDto other = (WorkerDto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "EmpleadoDto{" + "id=" + id + ", nombre=" + name + ", primerApellido=" + psurname + ", segundoApellido=" + ssurname + ", cedula=" + id + '}';
    }
}
