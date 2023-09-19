/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;


import cr.ac.una.tareaws.model.EvaluatedDto;
import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.model.JobsCompetences;
import cr.ac.una.tareaws.model.JobsCompetencesDto;
import cr.ac.una.tareaws.model.JobsDto;
import cr.ac.una.tareaws.service.JobsCompetencesService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dilan
 */
@WebService(serviceName = "ModuleJobsCompetences")
public class ModuleJobsCompetences {
       /*
    findByJxcIdcojob findByJxcJob
    */
    @EJB
    JobsCompetencesService jobsCompetencesService;
    
    //obtener por id de competencia asiciado
    @WebMethod(operationName = "getJobCompetenceId")
    public JobsCompetencesDto getJobCompetenceId(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = jobsCompetencesService.getJobCompetencesID(id);
        JobsCompetencesDto jobDto = new JobsCompetencesDto((JobsCompetences) respuesta.getResultado("JobCompetences"));
        return jobDto;
    }
    //obtener por id de tabla 
        @WebMethod(operationName = "getJobCompetenceIDJob")
    public JobsCompetencesDto getJobCompetenceIDJob(@WebParam(name = "idJobC") Integer idJobC) throws IOException {
        Respuesta respuesta = jobsCompetencesService.getJobCompetencesJoID(idJobC);
        JobsCompetencesDto jobDto = new JobsCompetencesDto((JobsCompetences) respuesta.getResultado("JobCompetences"));
        return jobDto;
    }
  
    
   @WebMethod(operationName = "RegisterJobCompetences")
    public Boolean RegisterJobCompetences(JobsCompetencesDto jobsCompetencesDto) {
        Respuesta respuesta = jobsCompetencesService.SaveJobCompetences(jobsCompetencesDto);
        return respuesta.getEstado();
    }
    
    @WebMethod(operationName = "GetJobCompetences")
    public List<JobsCompetencesDto> GetJobCompetences() throws IOException {
        Respuesta respuesta = jobsCompetencesService.getJobsCompetences();
        List<JobsCompetences> jobsCompetences = (List<JobsCompetences>) respuesta.getResultado("JobsCompetences");
        List<JobsCompetencesDto> jobsCompetencesDto = new ArrayList<>();
    
        for (JobsCompetences j : jobsCompetences) {
            JobsCompetencesDto jobsCompetenceDto = new JobsCompetencesDto(j);
            jobsCompetencesDto.add(jobsCompetenceDto);
        }
        return jobsCompetencesDto;
    }
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = jobsCompetencesService.DeleteJobsCompetences(id);
        return respuesta.getEstado();
    }
}
