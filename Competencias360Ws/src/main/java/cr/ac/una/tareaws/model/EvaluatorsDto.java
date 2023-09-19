package cr.ac.una.tareaws.model;

import java.io.IOException;

public class EvaluatorsDto {
    
   
    private String evsFeedback;
    private String evsConnection;
    private Integer evsId;
    private String evsState;
    private Evaluated evsEvaluated;
    private Workers evsWorker;
    
    public EvaluatorsDto() {
    }

    public EvaluatorsDto(Integer evsId) {
        this.evsId = evsId;
    }

    public EvaluatorsDto(Evaluators evaluators) throws IOException {
        this.evsId= evaluators.getEvsId();
        this.evsState = evaluators.getEvsState();
        this.evsFeedback = evaluators.getEvsFeedback();
        this.evsWorker = evaluators.getEvsWorker();
        this.evsEvaluated=evaluators.getEvsEvaluated();
        this.evsConnection=evaluators.getEvsConnection();
    }

    public String getEvsConnection() {
        return evsConnection;
    }

    public void setEvsConnection(String evsConnection) {
        this.evsConnection = evsConnection;
    }

    public String getEvsFeedback() {
        return evsFeedback;
    }

    public Integer getEvsId() {
        return evsId;
    }

    public String getEvsState() {
        return evsState;
    }

    public Evaluated getEvsEvaluated() {
        return evsEvaluated;
    }

    public Workers getEvsWorker() {
        return evsWorker;
    }
    
    public void setEvsFeedback(String evsFeedback) {
        this.evsFeedback = evsFeedback;
    }



    public void setEvsId(Integer evsId) {
        this.evsId = evsId;
    }



    public void setEvsState(String evsState) {
        this.evsState = evsState;
    }


    public void setEvsEvaluated(Evaluated evsEvaluated) {
        this.evsEvaluated = evsEvaluated;
    }

 

    public void setEvsWorker(Workers evsWorker) {
        this.evsWorker = evsWorker;
    }

}
