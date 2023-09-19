package cr.ac.una.tareaws.model;

import java.io.IOException;
import java.util.Collection;

public class EvaluatedDto {
    
    private Integer esId;
    private Procesoeva esProcesoeva;
    private Workers esWorker;
    private Collection<Evaluators> evaluatorsCollection;

    public EvaluatedDto() {
    }

    public EvaluatedDto(Integer esId) {
        this.esId = esId;
    }

    public EvaluatedDto(Evaluated evaluated) throws IOException {
        this.esId= evaluated.getEsId();
        this.esProcesoeva = evaluated.getEsProcesoeva();
        this.esWorker = evaluated.getEsWorker();
    }

    public Integer getEsId() {
        return esId;
    }

    public Procesoeva getEsProcesoeva() {
        return esProcesoeva;
    }

    public Workers getEsWorker() {
        return esWorker;
    }

    public Collection<Evaluators> getEvaluatorsCollection() {
        return evaluatorsCollection;
    }
        
    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public void setEsProcesoeva(Procesoeva esProcesoeva) {
        this.esProcesoeva = esProcesoeva;
    }

    public void setEsWorker(Workers esWorker) {
        this.esWorker = esWorker;
    }

    public void setEvaluatorsCollection(Collection<Evaluators> evaluatorsCollection) {
        this.evaluatorsCollection = evaluatorsCollection;
    }
}
