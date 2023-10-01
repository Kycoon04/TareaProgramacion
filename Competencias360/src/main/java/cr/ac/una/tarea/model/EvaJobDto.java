package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.JobsDto;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author jomav
 */
public class EvaJobDto {
/**
 * Clase que define un modelo de datos para la evaluación de trabajos.
 * Se utiliza para mapear datos entre la capa de vista y la capa de servicio.
 * Utiliza propiedades simples de JavaFX para facilitar la integración con interfaces gráficas.
 */
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty state;

    public EvaJobDto() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
    }
    public EvaJobDto(JobsDto jobDto) throws IOException {
        this.id.set(jobDto.getId());
        this.name.set(jobDto.getName());
        this.state.set(jobDto.getState());
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
