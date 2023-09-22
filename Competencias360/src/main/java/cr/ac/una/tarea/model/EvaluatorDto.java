/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.Evaluated;
import cr.ac.una.tarea.soap.EvaluatorsDto;
import cr.ac.una.tarea.soap.Workers;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author dilan
 */
public class EvaluatorDto {

    private SimpleStringProperty evsFeedback;
    private SimpleStringProperty evsConnection;
    private SimpleIntegerProperty evsId;
    private SimpleStringProperty evsState;
    private Evaluated evsEvaluated;
    private Workers evsWorker;

    public EvaluatorDto() {
        this.evsFeedback = new SimpleStringProperty();
        this.evsConnection = new SimpleStringProperty();
        this.evsState = new SimpleStringProperty();
        this.evsId = new SimpleIntegerProperty();
        this.evsEvaluated = new Evaluated();
        this.evsWorker = new Workers();
    }

    public EvaluatorDto(EvaluatorsDto evaluatorsDto) {
        this.evsId.set(evaluatorsDto.getEvsId());
        this.evsState.set(evaluatorsDto.getEvsState());
        this.evsFeedback.set(evaluatorsDto.getEvsFeedback());
        this.evsWorker = evaluatorsDto.getEvsWorker();
        this.evsEvaluated = evaluatorsDto.getEvsEvaluated();
        this.evsConnection.set(evaluatorsDto.getEvsConnection());
    }

    public String getEvsConnection() {
        return evsConnection.get();
    }

    public String getEvsFeedback() {
        return evsFeedback.get();
    }

    public Integer getEvsId() {
        return evsId.get();
    }

    public String getEvsState() {
        String state = "Sin realizar";
        if(evsState.equals("N")){
            state ="Realizado";
        }
        return state;
    }

    public Evaluated getEvsEvaluated() {
        return evsEvaluated;
    }

    public Workers getEvsWorker() {
        return evsWorker;
    }

    public void setEvsConnection(String evsConnection) {
        this.evsConnection.set(evsConnection);
    }

    public void setEvsFeedback(String evsFeedback) {
        this.evsFeedback.set(evsFeedback);
    }

    public void setEvsId(Integer evsId) {
        this.evsId.set(evsId);
    }

    public void setEvsState(String evsState) {
        this.evsState.set(evsState);
    }

    public void setEvsEvaluated(Evaluated evsEvaluated) {
        this.evsEvaluated = evsEvaluated;
    }

    public void setEvsWorker(Workers evsWorker) {
        this.evsWorker = evsWorker;
    }
    
     public String getIden() {
        return evsWorker.getWrIdentification();
    }
     public String getName() {
        return evsWorker.getWrName();
    }
      public String getPsurname() {
        return evsWorker.getWrPsurname();
    }
      public String getEmail() {
        return evsWorker.getWrEmail();
    }
       public String getUsername() {
        return evsWorker.getWrUsername();
    }

}
