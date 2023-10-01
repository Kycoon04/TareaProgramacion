package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.EvaluatedDto;
import cr.ac.una.tarea.soap.Procesoeva;
import cr.ac.una.tarea.soap.Workers;
import javafx.beans.property.SimpleIntegerProperty;

/*
 * Esta clase representa un modelo de datos para la evaluación de trabajadores en un proceso específico.
 * Se utiliza para mapear datos entre la capa de vista y la capa de servicio.
 * Utiliza propiedades simples de JavaFX para facilitar la integración con interfaces gráficas.
 */
public class EvaluatedsDto {

    private SimpleIntegerProperty id;
    private Procesoeva esProcesoeva;
    private Workers esWorker;

    public EvaluatedsDto() {
        this.id = new SimpleIntegerProperty();
    }
    public EvaluatedsDto(EvaluatedDto evaluatedDto) {
        this.id.set(evaluatedDto.getEsId());
        this.esProcesoeva = evaluatedDto.getEsProcesoeva();
        this.esWorker = evaluatedDto.getEsWorker();
    }
    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public Procesoeva getEsProcesoeva() {
        return esProcesoeva;
    }

    public void setEsProcesoeva(Procesoeva esProcesoeva) {
        this.esProcesoeva = esProcesoeva;
    }

    public Workers getEsWorker() {
        return esWorker;
    }

    public void setEsWorker(Workers esWorker) {
        this.esWorker = esWorker;
    }

}
