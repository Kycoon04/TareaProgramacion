package cr.ac.una.tarea.model;

import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author jomav
 */
public class InformationDto {
    
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty email;
    public byte[] photo;
    public SimpleStringProperty information;

    public InformationDto() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.information = new SimpleStringProperty();
    }

    public InformationDto(InformationDto informationDto) throws IOException {
        this.id.set(informationDto.getId());
        this.name.set(informationDto.getName());
        this.email.set(informationDto.getEmail());
        this.photo = informationDto.getPhoto();
    }
    
    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email); 
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getInformation() {
        return information.get();
    }

    public void setInformation(String information) {
        this.information.set(information);
    }
    public byte[] getPhoto() {
        return photo;
    }
}
