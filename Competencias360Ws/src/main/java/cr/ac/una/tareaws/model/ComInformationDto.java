package cr.ac.una.tareaws.model;

import java.io.IOException;

/**
 * @author jomav
 */
public class ComInformationDto {
    
    private Integer id;
    private String name;
    private String email;
    private byte[] photo;
    private String information;
    private String cpKey;

    public String getCpKey() {
        return cpKey;
    }

    public void setCpKey(String cpKey) {
        this.cpKey = cpKey;
    }
    
    public ComInformationDto() {
    }

    public ComInformationDto(Cominformation information) throws IOException {
        this.id = information.getCpId();
        this.name = information.getCpName();
        this.email = information.getCpEmail();
        this.photo = information.getCpPhoto();
        this.information= information.getCpInformation();
        this.cpKey= information.getCpKey();
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getInformation() {
        return information;
    }

  
}
