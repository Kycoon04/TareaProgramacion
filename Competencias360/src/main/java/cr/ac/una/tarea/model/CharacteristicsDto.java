/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.CharacteristicDto;
import cr.ac.una.tarea.soap.Competences;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Clase que define un modelo de datos para características.
 * Se utiliza para mapear datos entre la capa de vista y la capa de servicio.
 * Utiliza propiedades simples de JavaFX para facilitar la integración con interfaces gráficas.
 */
public class CharacteristicsDto {
    private SimpleIntegerProperty ccId;
    private SimpleStringProperty ccName;
    private Competences ccComid;

    public CharacteristicsDto() {
        this.ccId = new SimpleIntegerProperty();
        this.ccName = new SimpleStringProperty();
        this.ccComid = new Competences();
        
    }

    public CharacteristicsDto(Integer ccId, String ccName) {
        this.ccId = new SimpleIntegerProperty();
        this.ccName = new SimpleStringProperty();
        this.ccComid = new Competences();
    }

    public CharacteristicsDto(CharacteristicDto characteristicDto) {
        this.ccId.set(characteristicDto.getCcId());
        this.ccName.set(characteristicDto.getCcName());
        this.ccComid = characteristicDto.getCcComid();
    }


    
    
    public Integer getCcId() {
        return ccId.get();
    }

    public String getCcName() {
        return ccName.get();
    }

    public Competences getCcComid() {
        return ccComid;
    }
    public String getCcComName(){
        return ccComid.getCsName();
    }

    public void setCcId(Integer ccId) {
        this.ccId.set(ccId);
    }

    public void setCcName(String ccName) {
        this.ccName.set(ccName);
    }

    public void setCcComid(Competences ccComid) {
        this.ccComid = ccComid;
    }
}
