/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.CompetencesDto;
import cr.ac.una.tarea.soap.Jobs;
import cr.ac.una.tarea.soap.WorkersDto;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jomav
 */
public class CompetenceDto {

    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty state;
    public SimpleStringProperty characteristics;

    public CompetenceDto() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
        this.characteristics = new SimpleStringProperty();
    }

    public CompetenceDto(CompetencesDto competenceDto) {
        this.id.set(competenceDto.getId());
        this.name.set(competenceDto.getName());
        this.state.set(competenceDto.getState());
        this.name.set(competenceDto.getCharacteristics());
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

    public String getState() {
        return state.get();
    }
     public String getStates() {
         String st;
         if("S".equals(state.get())){
             st="Activo";
         }else{
             st="Inactivo";
         }
        return st;
    }

    public void setState(String State) {
        this.state.set(State);
    }

    public String getCharacteristics() {
        return characteristics.get();
    }

    public void setCharacteristics(String Characteristics) {
        this.characteristics.set(Characteristics);
    }
}
