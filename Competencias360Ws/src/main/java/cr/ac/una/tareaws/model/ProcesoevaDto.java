package cr.ac.una.tareaws.model;

import java.time.LocalDate;
public class ProcesoevaDto {

    private Integer id;
    private String name;
    private String state;
    private LocalDate Inicialperiod;
    private LocalDate Finalperiod;
    private LocalDate Application;
    
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

    public void setInicialperiod(LocalDate Inicialperiod) {
        this.Inicialperiod = Inicialperiod;
    }

    public void setFinalperiod(LocalDate Finalperiod) {
        this.Finalperiod = Finalperiod;
    }

    public void setApplication(LocalDate Application) {
        this.Application = Application;
    }
    
}
