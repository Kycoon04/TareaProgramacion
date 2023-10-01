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
 * Clase que define un modelo de datos para competencias.
 * Se utiliza para mapear datos entre la capa de vista y la capa de servicio.
 * Utiliza propiedades simples de JavaFX para facilitar la integración con interfaces gráficas.
 */
public class CompetenceDto {

    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty state;

    public CompetenceDto() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
    }

    public CompetenceDto(CompetencesDto competenceDto) {
        this.id.set(competenceDto.getId());
        this.name.set(competenceDto.getName());
        this.state.set(competenceDto.getState());
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
}
