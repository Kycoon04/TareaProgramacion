package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.soap.ModuleProcesoeva;
import cr.ac.una.tarea.soap.ModuleProcesoeva_Service;
import cr.ac.una.tarea.soap.ProcesoevaDto;
import cr.ac.una.tarea.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jomav
 */
public class ProcesoevaService {

        public Respuesta getProcesos() {
        try {
            ModuleProcesoeva_Service servicio = new ModuleProcesoeva_Service();
            ModuleProcesoeva cliente = servicio.getModuleProcesoevaPort();
           

            List<ProcesoevaDto> procesosWs = cliente.getProcesos();
            List<ProcesosevaDto> jobs = new ArrayList<>();
            
            for (ProcesoevaDto procesoevaDto : procesosWs) {
                ProcesosevaDto procesosevaD = new ProcesosevaDto();
                procesosevaD.setName(procesoevaDto.getName());
                procesosevaD.setId(procesoevaDto.getId());
                procesosevaD.setState(procesoevaDto.getState());
             //   procesosevaD.setApplication(procesoevaDto.get());
             //   procesosevaD.setApplication(procesoevaDto.getState());
             //   procesosevaD.setApplication(procesoevaDto.getState());
                
                jobs.add(procesosevaD);
            }

            return new Respuesta(true, "Error obteniendo los puestos.", "getJobs", "Jobs", jobs);
        } catch (Exception ex) {
            Logger.getLogger(ProcesoevaService.class.getName()).log(Level.SEVERE, "Error obteniendo los puestos.", ex);
            return new Respuesta(false, "Error obteniendo los puestos.", "getJobs" + ex.getMessage());
        }
    }
    
    public Respuesta SaveProceso(ProcesosevaDto procesosevaDto) {
        try {
            ModuleProcesoeva_Service servicio = new ModuleProcesoeva_Service();
            ModuleProcesoeva cliente = servicio.getModuleProcesoevaPort();
            ProcesoevaDto procesoDto = new ProcesoevaDto();
            
            procesoDto.setId(procesosevaDto.getId());
            procesoDto.setName(procesosevaDto.getName());
            procesoDto.setState(procesosevaDto.getState());
            
            
           cliente.setDates(procesoDto, procesosevaDto.getApplication().toString(), 
    procesosevaDto.getFinalperiod().toString(),procesosevaDto.getInicialperiod().toString());
            
    
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


*/
}
