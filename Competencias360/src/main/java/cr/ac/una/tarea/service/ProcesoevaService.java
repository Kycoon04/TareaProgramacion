package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.soap.ModuleProcesoeva;
import cr.ac.una.tarea.soap.ModuleProcesoeva_Service;
import cr.ac.una.tarea.soap.ProcesoevaDto;
import cr.ac.una.tarea.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
/**
 *
 * @author jomav
 */
public class ProcesoevaService {

    public Respuesta SaveProceso(ProcesosevaDto procesosevaDto) {
        try {
            ModuleProcesoeva_Service servicio = new ModuleProcesoeva_Service();
            ModuleProcesoeva cliente = servicio.getModuleProcesoevaPort();
            ProcesoevaDto procesoDto = new ProcesoevaDto();
            
            procesoDto.setId(procesosevaDto.getId());
            procesoDto.setName(procesosevaDto.getName());
            procesoDto.setName(procesosevaDto.getState());
            
            /*cliente.setDates(procesoDto, procesosevaDto.getApplication().toString(), 
                    procesosevaDto.getFinalperiod().toString(),procesosevaDto.getInicialperiod().toString());*/
            
            
            cliente.registerProcesova(procesoDto);
            
            return new Respuesta(true, "", "", "Competencia", procesoDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
/*
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
*/
}
