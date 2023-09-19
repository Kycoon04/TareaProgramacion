/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.model.JobsDto;
import cr.ac.una.tareaws.service.JobsService;
import cr.ac.una.tareaws.service.WorkersService;
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
@WebService(serviceName = "ModuleJobs")
public class ModuleJobs {
       
    @EJB
    JobsService jobsService;
    
    @WebMethod(operationName = "RegisterJob")
    public Boolean RegisterJob(JobsDto job) {
        Respuesta respuesta = jobsService.SaveJobs(job);
        return respuesta.getEstado();
    }
    @WebMethod(operationName = "getJob")
    public JobsDto getJob(@WebParam(name = "Name") String Name) throws IOException {
        Respuesta respuesta = jobsService.getJob(Name);
        JobsDto jobDto = new JobsDto((Jobs) respuesta.getResultado("Job"));
        return jobDto;
    }
    @WebMethod(operationName = "GetJobs")
    public List<JobsDto> GetJobs() throws IOException {
        Respuesta respuesta = jobsService.getJobs();
        List<Jobs> jobs = (List<Jobs>) respuesta.getResultado("Jobs");
        List<JobsDto> jobsDto = new ArrayList<>();
        for (Jobs j : jobs) {
            JobsDto jobDto = new JobsDto(j);
            jobsDto.add(jobDto);
        }
        return jobsDto;
    }
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = jobsService.DeleteJob(id);
        return respuesta.getEstado();
    }
}
