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
 * Esta clase proporciona servicios relacionados con los procesos de evaluación,
 * incluyendo obtener, guardar, obtener por nombre, eliminar y obtener todos los
 * procesos de evaluación utilizando un servicio web SOAP (ModuleProcesoeva).
 *
 * @author jomav
 */
public class ProcesoevaService {

    /**
     * Obtiene la información de todos los procesos de evaluación llamando al
     * método getProcesos del servicio web SOAP ModuleProcesoeva.
     *
     * @return Una respuesta que contiene la lista de procesos de evaluación o
     * indica un error.
     */
    public Respuesta getProcesos() {
        try {
            ModuleProcesoeva_Service servicio = new ModuleProcesoeva_Service();
            ModuleProcesoeva cliente = servicio.getModuleProcesoevaPort();
            List<ProcesoevaDto> procesosWs = cliente.getProcesos();
            List<ProcesosevaDto> procesos = new ArrayList<>();

            for (ProcesoevaDto procesoevaDto : procesosWs) {
                ProcesosevaDto procesosevaD = new ProcesosevaDto();
                procesosevaD.setName(procesoevaDto.getName());
                procesosevaD.setId(procesoevaDto.getId());
                procesosevaD.setState(procesoevaDto.getState());
                procesosevaD.setInicialperiod(LocalDate.parse(procesoevaDto.getGetInicialPeriodo()));
                procesosevaD.setApplication(LocalDate.parse(procesoevaDto.getGetAplicationPeriodo()));
                procesosevaD.setFinalperiod(LocalDate.parse(procesoevaDto.getGetFinalPeriodo()));
                procesos.add(procesosevaD);
            }
            return new Respuesta(true, "Error obteniendo los procesos.", "getProceso", "ProcesosevaDto", procesos);
        } catch (Exception ex) {
            Logger.getLogger(ProcesoevaService.class.getName()).log(Level.SEVERE, "Error obteniendo los procesos.", ex);
            return new Respuesta(false, "Error obteniendo los procesos.", "getJobs" + ex.getMessage());
        }
    }

    /**
     * Guarda la información de un proceso de evaluación llamando al método
     * registerProceso del servicio web SOAP ModuleProcesoeva.
     *
     * @param procesosevaDto El objeto de transferencia de datos que contiene la
     * información del proceso de evaluación.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta SaveProceso(ProcesosevaDto procesosevaDto) {
        try {
            ModuleProcesoeva_Service servicio = new ModuleProcesoeva_Service();
            ModuleProcesoeva cliente = servicio.getModuleProcesoevaPort();
            ProcesoevaDto procesoDto = new ProcesoevaDto();

            procesoDto.setId(procesosevaDto.getId());
            procesoDto.setName(procesosevaDto.getName());
            procesoDto.setState(procesosevaDto.getState());

            cliente.setDates(procesoDto, procesosevaDto.getApplication().toString(),
                    procesosevaDto.getFinalperiod().toString(), procesosevaDto.getInicialperiod().toString());

            return new Respuesta(true, "", "", "Competencia", procesoDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }

    /**
     * Obtiene la información de un proceso de evaluación por nombre llamando al
     * método getProcesova del servicio web SOAP ModuleProcesoeva.
     *
     * @param jobName El nombre del proceso de evaluación.
     * @return Una respuesta que contiene la información del proceso de
     * evaluación o indica un error.
     */
    public Respuesta getProcesoByName(String jobName) {
        try {
            ModuleProcesoeva_Service servicio = new ModuleProcesoeva_Service();
            ModuleProcesoeva cliente = servicio.getModuleProcesoevaPort();

            ProcesosevaDto procesosev = new ProcesosevaDto();
            procesosev.setApplication(LocalDate.parse(cliente.getProcesova(jobName).getGetAplicationPeriodo()));
            procesosev.setId(cliente.getProcesova(jobName).getId());
            procesosev.setInicialperiod(LocalDate.parse(cliente.getProcesova(jobName).getGetInicialPeriodo()));
            procesosev.setFinalperiod(LocalDate.parse(cliente.getProcesova(jobName).getGetFinalPeriodo()));
            procesosev.setState(cliente.getProcesova(jobName).getState());
            procesosev.setName(cliente.getProcesova(jobName).getName());

            return new Respuesta(true, "", "", "Procesoeva", procesosev);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error obteniendo el proceso [" + jobName + "]", ex);
            return new Respuesta(false, "Error obteniendo el proceso.", "getProceso " + ex.getMessage());
        }
    }

    /**
     * Elimina un proceso de evaluación por ID llamando al método delete del
     * servicio web SOAP ModuleProcesoeva.
     *
     * @param id El identificador del proceso de evaluación que se va a
     * eliminar.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta deleteProceso(int id) {
        try {
            ModuleProcesoeva_Service servicio = new ModuleProcesoeva_Service();
            ModuleProcesoeva cliente = servicio.getModuleProcesoevaPort();
            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error eliminando el Proceso.", ex);
            return new Respuesta(false, "Error eliminando el Proceso .", "eliminarProceso " + ex.getMessage());
        }
    }

}
