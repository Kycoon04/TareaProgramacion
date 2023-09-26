package cr.ac.una.tareaws.model;

import java.io.IOException;

/**
 *
 * @author jomav
 */
public class CompetencesDto {

    private Integer id;
    private String name;
    private String state;
    private CompetencesDto() {
    }

    public CompetencesDto(Competences Competence) throws IOException {
        this.id = Competence.getCsId();
        this.name = Competence.getCsName();
        this.state = Competence.getCsState();
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

}
