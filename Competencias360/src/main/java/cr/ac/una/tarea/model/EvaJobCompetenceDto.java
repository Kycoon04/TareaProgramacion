package cr.ac.una.tarea.model;

import cr.ac.una.tarea.soap.Competences;
import cr.ac.una.tarea.soap.Jobs;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;

public class EvaJobCompetenceDto {

    private SimpleIntegerProperty jxcJob;
    private SimpleIntegerProperty jxcIdcojob;
    private Competences jxcCompetence;
    private Jobs jobs;

    public EvaJobCompetenceDto() {
        this.jxcIdcojob = new SimpleIntegerProperty();
        this.jxcJob = new SimpleIntegerProperty();
        this.jxcCompetence = new Competences();
        this.jobs = new Jobs();
    }

    public EvaJobCompetenceDto(EvaJobCompetenceDto evaJobCompetenceDto)throws IOException {
        this.jxcIdcojob.set(evaJobCompetenceDto.getJxcIdcojob());
        this.jxcJob.set(evaJobCompetenceDto.getJxcJob());
        this.jxcCompetence = evaJobCompetenceDto.getJxcCompetence();
        this.jobs = evaJobCompetenceDto.getJobs();

    }

    public Integer getJxcJob() {
        return jxcJob.get();
    }

    public Integer getJxcIdcojob() {
        return jxcIdcojob.get();
    }

    public Competences getJxcCompetence() {
        return jxcCompetence;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public EvaJobCompetenceDto(Integer jxcJob) {
        this.jxcJob.set(jxcJob);
    }

    public void setJxcJob(Integer jxcJob) {
        this.jxcJob.set(jxcJob);
    }

    public void setJxcIdcojob(Integer jxcIdcojob) {
        this.jxcIdcojob.set(jxcIdcojob);
    }

    public void setJxcCompetence(Competences jxcCompetence) {
        this.jxcCompetence=jxcCompetence;
    }

    public void setEvaJobs(Jobs evaJobs) {
        this.jobs = evaJobs;
    }
}