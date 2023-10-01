/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.ProcesoevaDto;
import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * Esta clase representa un modelo de datos para la información de procesos de evaluación.
 * Se utiliza para mapear datos entre la capa de vista y la capa de servicio.
 * Utiliza propiedades simples de JavaFX para facilitar la integración con interfaces gráficas.
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

    public void setInicialperiod(LocalDate Inicialperiod) {
        this.Inicialperiod = Inicialperiod;
    }

    public void setFinalperiod(LocalDate Finalperiod) {
        this.Finalperiod = Finalperiod;
    }

    public void setApplication(LocalDate Application) {
        this.Application = Application;
    }

    public LocalDate getInicialperiod() {
        return Inicialperiod;
    }

    public void setsetInicialperiod(String Inicialperiod) {
        this.Inicialperiod = LocalDate.parse(Inicialperiod);
    }

    public LocalDate getFinalperiod() {
        return Finalperiod;
    }
    public void setsetFinalperiod(String Finalperiod) {
        this.Finalperiod = LocalDate.parse(Finalperiod);
    }
    public LocalDate getApplication() {
        return Application;
    }

    public void setsetApplication(String Application) {
        this.Application = LocalDate.parse(Application);
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
