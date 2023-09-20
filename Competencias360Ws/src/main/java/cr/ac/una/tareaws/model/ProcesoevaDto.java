package cr.ac.una.tareaws.model;

import java.time.LocalDate;
public class ProcesoevaDto {

    private Integer id;
    private String name;
    private String state;
    private LocalDate Inicialperiod;
    private LocalDate Finalperiod;
    private LocalDate Application;
    private String getInicialPeriodo; 
    private String getFinalPeriodo; 
    private String getAplicationPeriodo; 
    
    public ProcesoevaDto(){
    }
    public ProcesoevaDto(Procesoeva proceso){
        this.id = proceso.getEnId();
        this.name = proceso.getEnName();
        this.state = proceso.getEnState();
        this.Application = proceso.getEnApplication();
        this.Finalperiod = proceso.getEnFinalperiod();
        this.Inicialperiod = proceso.getEnInicialperiod();
    }

    public String getGetFinalPeriodo() {
        getFinalPeriodo= Finalperiod.toString();
        return getFinalPeriodo;
    }

    public void setGetFinalPeriodo(String getFinalPeriodo) {
        this.getFinalPeriodo = getFinalPeriodo;
    }

    public String getGetAplicationPeriodo() {
        getAplicationPeriodo= Application.toString();
        return getAplicationPeriodo;
    }

    public void setGetAplicationPeriodo(String getAplicationPeriodo) {
        this.getAplicationPeriodo = getAplicationPeriodo;
    }

    public String getGetInicialPeriodo() {
        getInicialPeriodo= Inicialperiod.toString();
        return getInicialPeriodo;
    }

    
    public void setGetInicialPeriodo(String getInicialPeriodo) {
        this.getInicialPeriodo = getInicialPeriodo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public LocalDate getInicialperiod() {
        return Inicialperiod;
    }

    public LocalDate getFinalperiod() {
        return Finalperiod;
    }

    public LocalDate getApplication() {
        return Application;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setInicialperiod(String Inicialperiod) {
        this.Inicialperiod= LocalDate.parse(Inicialperiod);
    }

    public void setFinalperiod(String Finalperiod) {
       this.Finalperiod= LocalDate.parse(Finalperiod);
    }

    public void setApplication(String Application) {
       this.Application= LocalDate.parse(Application);
    }
    
}
