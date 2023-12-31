package cr.ac.una.tareaws.model;

import java.io.IOException;

public class ResultDto {

    private Double rsNotasis;
    private Double rsNotajefatura;
    private Integer rsId;
    private Competences rsCompe;
    private Evaluated rsEvaluated;

    public ResultDto() {
    }

    public ResultDto(Result result) throws IOException {
        this.rsCompe = result.getRsCompe();
        this.rsEvaluated = result.getRsEvaluated();
        this.rsNotasis = result.getRsNotasis();
        this.rsNotajefatura = result.getRsNotajefatura();
        this.rsId = result.getRsId();
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
        return rsId;
    }

    public Competences getRsCompe() {
        return rsCompe;
    }

    public Evaluated getRsEvaluated() {
        return rsEvaluated;
    }

    public ResultDto(Integer rsId) {
        this.rsId = rsId;
    }

    public void setRsId(Integer rsId) {
        this.rsId = rsId;
    }

    public void setRsCompe(Competences rsCompe) {
        this.rsCompe = rsCompe;
    }

    public void setRsEvaluated(Evaluated rsEvaluated) {
        this.rsEvaluated = rsEvaluated;
    }
}
