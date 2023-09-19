/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.EvaJobCompetenceDto;
import cr.ac.una.tarea.soap.JobsCompetencesDto;
import cr.ac.una.tarea.soap.ModuleJobsCompetences;
import cr.ac.una.tarea.soap.ModuleJobsCompetences_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilan
 */
public class JobsCompetencesService {
    
     public Respuesta SaveJobCompetences(EvaJobCompetenceDto evaJobCompetenceDto) {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();
            
            JobsCompetencesDto jobCompetencesDto = new JobsCompetencesDto();
            jobCompetencesDto.setJobs(evaJobCompetenceDto.getJobs());
            jobCompetencesDto.setJxcCompetence(evaJobCompetenceDto.getJxcCompetence());
            
            System.out.println(jobCompetencesDto.getJobs().getJsId());
            System.out.println(jobCompetencesDto.getJxcCompetence().getCsId());
            
            
            cliente.registerJobCompetences(jobCompetencesDto);
            return new Respuesta(true, "", "", "Competencia", jobCompetencesDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error guardando las comptencias.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarCompetencias " + ex.getMessage());
        }
    }

     
     /*
        public Respuesta getJobCompetence(String jobName) {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();

           JobsCompetencesDto jobCompetencesDto = new JobsCompetencesDto();
            jobCompetencesDto.setJxcIdcojob(cliente.get(jobName).getId());
            jobCompetencesDto.setJxcJob(cliente.getJob(jobName).getName());
       
            return new Respuesta(true, "", "", "Job", jobCompetencesDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el puesto [" + jobName + "]", ex);
            return new Respuesta(false, "Error obteniendo el puesto.", "getJob " + ex.getMessage());
        }
    }
     
    public Respuesta getJobs() {
        try {
        ModuleJobs_Service servicio = new ModuleJobs_Service();
            ModuleJobs cliente = servicio.getModuleJobsPort();

            List<JobsDto> jobsWs = cliente.getJobs();
            List<JobDto> jobs = new ArrayList<>();
            for (JobsDto job : jobsWs) {
                JobDto jobDto = new JobDto();
                jobDto.setName(job.getName());
                jobDto.setId(job.getId());
                jobDto.setState(job.getState());
           
                jobs.add(jobDto);
            }

            return new Respuesta(true, "Error obteniendo los puestos.", "getJobs", "Jobs", jobs);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo los puestos.", ex);
            return new Respuesta(false, "Error obteniendo los puestos.", "getJobs" + ex.getMessage());
        }
    }
    */
        
        
        
}
