/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.Competences;
import cr.ac.una.tarea.soap.Evaluated;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author jomav
 */
public class ResultsDto {

    private Double rsNotasis;
    private Double rsNotajefatura;
    private SimpleIntegerProperty rsId;
    private Competences rsCompe;
    private Evaluated rsEvaluated;

    public ResultsDto() {
        rsId = new SimpleIntegerProperty();
    }

    public Double getRsNotasis() {
        return rsNotasis;
    }

    public void setRsNotasis(Double rsNotasis) {
        this.rsNotasis = rsNotasis;
    }

    public Double getRsNotajefatura() {
        return rsNotajefatura;
    }

    public void setRsNotajefatura(Double rsNotajefatura) {
        this.rsNotajefatura = rsNotajefatura;
    }

    public Integer getRsId() {
        return rsId.get();
    }

    public void setRsId(Integer rsId) {
        this.rsId.set(rsId); 
    }

    public Competences getRsCompe() {
        return rsCompe;
    }

    public void setRsCompe(Competences rsCompe) {
        this.rsCompe = rsCompe;
    }

    public Evaluated getRsEvaluated() {
        return rsEvaluated;
    }

    public void setRsEvaluated(Evaluated rsEvaluated) {
        this.rsEvaluated = rsEvaluated;
    }

}
