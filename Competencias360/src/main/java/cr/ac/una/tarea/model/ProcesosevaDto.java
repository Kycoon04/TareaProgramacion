/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.ProcesoevaDto;
import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jomav
 */
public class ProcesosevaDto {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty state;
    private LocalDate Inicialperiod;
    private LocalDate Finalperiod;
    private LocalDate Application;

    public ProcesosevaDto() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
    }

    public ProcesosevaDto(ProcesoevaDto procesoevadto) {
        this.id.set(procesoevadto.getId());
        this.name.set(procesoevadto.getName());
        this.state.set(procesoevadto.getState());
    }

    public LocalDate getInicialperiod() {
        return Inicialperiod;
    }

    public void setInicialperiod(LocalDate Inicialperiod) {
        this.Inicialperiod = Inicialperiod;
    }

    public LocalDate getFinalperiod() {
        return Finalperiod;
    }

    public void setFinalperiod(LocalDate Finalperiod) {
        this.Finalperiod = Finalperiod;
    }

    public LocalDate getApplication() {
        return Application;
    }

    public void setApplication(LocalDate Application) {
        this.Application = Application;
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
    public void setState(String State) {
        this.state.set(State);
    }
    public String getState() {
        return state.get();
    }
}
