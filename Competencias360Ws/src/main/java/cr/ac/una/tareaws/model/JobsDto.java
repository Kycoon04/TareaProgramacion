package cr.ac.una.tareaws.model;

import java.io.IOException;

public class JobsDto {

    private Integer id;
    private String name;
    private String state;

    public JobsDto() {
    }

    public JobsDto(Jobs job) throws IOException {
        this.id = job.getJsId();
        this.name = job.getJsName();
        this.state = job.getJsState();
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
