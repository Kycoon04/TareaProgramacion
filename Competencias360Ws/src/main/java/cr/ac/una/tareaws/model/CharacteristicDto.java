/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.model;

/**
 *
 * @author dilan
 */
public class CharacteristicDto {
    
    

    private Integer ccId;

    private String ccName;

    private Competences ccComid;

    public CharacteristicDto() {
    }

    public CharacteristicDto(Integer ccId) {
        this.ccId = ccId;
    }

    public CharacteristicDto(Integer ccId, String ccName) {
        this.ccId = ccId;
        this.ccName = ccName;
    }
       public CharacteristicDto(Characteristic characteristic) {
        this.ccComid = characteristic.getCcComid();
        this.ccId = characteristic.getCcId();
        this.ccName = characteristic.getCcName();
  

    }

    public Integer getCcId() {
        return ccId;
    }

    public String getCcName() {
        return ccName;
    }

    public Competences getCcComid() {
        return ccComid;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }



    public void setCcName(String ccName) {
        this.ccName = ccName;
    }



    public void setCcComid(Competences ccComid) {
        this.ccComid = ccComid;
    }


}
