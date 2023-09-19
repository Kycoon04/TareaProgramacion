package cr.ac.una.tareaws.model;


public class EvaluatorResultDto {

    private Integer erNota;

    private Integer erId;

    private Competences erCompe;

    private Evaluators erEvaluator;

    public EvaluatorResultDto() {
    }

    public EvaluatorResultDto(EvaluatorResult evaluatorResult) {
        this.erCompe = evaluatorResult.getErCompe();
        this.erEvaluator = evaluatorResult.getErEvaluator();
        this.erId = evaluatorResult.getErId();
        this.erNota = evaluatorResult.getErNota();
    }

    public Integer getErNota() {
        return erNota;
    }

    public Integer getErId() {
        return erId;
    }

    public Competences getErCompe() {
        return erCompe;
    }

    public Evaluators getErEvaluator() {
        return erEvaluator;
    }

    public EvaluatorResultDto(Integer erId) {
        this.erId = erId;
    }

    public void setErNota(Integer erNota) {
        this.erNota = erNota;
    }

    public void setErId(Integer erId) {
        this.erId = erId;
    }

    public void setErCompe(Competences erCompe) {
        this.erCompe = erCompe;
    }

    public void setErEvaluator(Evaluators erEvaluator) {
        this.erEvaluator = erEvaluator;
    }

}
