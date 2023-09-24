package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.Competences;
import cr.ac.una.tarea.soap.EvaluatorResultDto;
import cr.ac.una.tarea.soap.Evaluators;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author jomav
 */
public class EvaluatorResultsDto {

    private SimpleIntegerProperty erNota;

    private SimpleIntegerProperty erId;

    private Competences erCompe;

    private Evaluators erEvaluator;

    public EvaluatorResultsDto() {
        this.erId = new SimpleIntegerProperty();
        this.erNota = new SimpleIntegerProperty();
    }

    public EvaluatorResultsDto(EvaluatorResultDto EvaluatorResultDto) {
        this.erCompe = EvaluatorResultDto.getErCompe();
        this.erEvaluator = EvaluatorResultDto.getErEvaluator();
        this.erId.set(EvaluatorResultDto.getErId());
        this.erNota.set(EvaluatorResultDto.getErNota());
    }

    public Competences getErCompe() {
        return erCompe;
    }

    public void setErCompe(Competences erCompe) {
        this.erCompe = erCompe;
    }

    public Evaluators getErEvaluator() {
        return erEvaluator;
    }

    public void setErEvaluator(Evaluators erEvaluator) {
        this.erEvaluator = erEvaluator;
    }

    public Integer getId() {
        return erId.get();
    }

    public void setId(Integer id) {
        this.erId.set(id);
    }

    public Integer getNota() {
        return erNota.get();
    }

    public void setNota(Integer nota) {
        this.erNota.set(nota);
    }
}
