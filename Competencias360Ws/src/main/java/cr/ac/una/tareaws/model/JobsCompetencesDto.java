package cr.ac.una.tareaws.model;

public class JobsCompetencesDto {

    private Integer jxcJob;

    private Integer jxcIdcojob;

    private Competences jxcCompetence;

    private Jobs jobs;

    public JobsCompetencesDto() {

    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public JobsCompetencesDto(JobsCompetences job) {
        this.jxcIdcojob = job.getJxcIdcojob();
        this.jxcCompetence = job.getJxcCompetence();
        this.jobs = job.getJxcJob();

    }

    public Integer getJxcJob() {
        return jxcJob;
    }

    public Integer getJxcIdcojob() {
        return jxcIdcojob;
    }

    public Competences getJxcCompetence() {
        return jxcCompetence;
    }

    public JobsCompetencesDto(Integer jxcJob) {
        this.jxcJob = jxcJob;
    }

    public void setJxcJob(Integer jxcJob) {
        this.jxcJob = jxcJob;
    }

    public void setJxcIdcojob(Integer jxcIdcojob) {
        this.jxcIdcojob = jxcIdcojob;
    }

    public void setJxcCompetence(Competences jxcCompetence) {
        this.jxcCompetence = jxcCompetence;
    }
}
