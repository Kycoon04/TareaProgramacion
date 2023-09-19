/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.JobDto;
import cr.ac.una.tarea.soap.JobsDto;
import cr.ac.una.tarea.soap.ModuleJobs;
import cr.ac.una.tarea.soap.ModuleJobs_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilan
 */
public class JobsService {
    
    public Respuesta SaveJob(JobDto jobDto) {
        try {
            ModuleJobs_Service servicio = new ModuleJobs_Service();
            ModuleJobs cliente = servicio.getModuleJobsPort();

            JobsDto JobDto = new JobsDto();
            JobDto.setId(jobDto.getId());
            JobDto.setName(jobDto.getName());
            JobDto.setState(jobDto.getState());

            cliente.registerJob(JobDto);
            return new Respuesta(true, "", "", "Competencia", JobDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
        public Respuesta getJob(String jobName) {
        try {
        ModuleJobs_Service servicio = new ModuleJobs_Service();
            ModuleJobs cliente = servicio.getModuleJobsPort();

            JobDto jobDto = new JobDto();
            jobDto.setId(cliente.getJob(jobName).getId());
            jobDto.setName(cliente.getJob(jobName).getName());
            jobDto.setState(cliente.getJob(jobName).getState());
          
            return new Respuesta(true, "", "", "Job", jobDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error obteniendo el puesto [" + jobName + "]", ex);
            return new Respuesta(false, "Error obteniendo el puesto.", "getJob " + ex.getMessage());
        }
    }
       public Respuesta deleteJob(int id) {
        try {
            ModuleJobs_Service servicio = new ModuleJobs_Service();
            ModuleJobs cliente = servicio.getModuleJobsPort();
            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error eliminando el empleado.", ex);
            return new Respuesta(false, "Error eliminando el empleado.", "eliminarEmpleado " + ex.getMessage());
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
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error obteniendo los puestos.", ex);
            return new Respuesta(false, "Error obteniendo los puestos.", "getJobs" + ex.getMessage());
        }
    }
}
