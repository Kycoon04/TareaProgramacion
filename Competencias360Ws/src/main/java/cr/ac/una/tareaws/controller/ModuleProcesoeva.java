package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.model.ProcesoevaDto;
import cr.ac.una.tareaws.service.ProcesoevaService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jomav
 */
/**
 * Clase que implementa un servicio web para gestionar los procesos de
 * evaluación (Procesoeva). Este servicio proporciona operaciones como registro,
 * obtención por nombre, eliminación y listado de procesos de evaluación.
 * También proporciona una operación para establecer fechas en un proceso de
 * evaluación. Se utiliza anotaciones JAX-WS para exponer los métodos como
 * operaciones web.
 */
@WebService(serviceName = "ModuleProcesoeva")
public class ModuleProcesoeva {

    @EJB
    ProcesoevaService procesoevaService;

    /**
     * Registra un proceso de evaluación.
     *
     * @param procesoevaDto Un objeto ProcesoevaDto que contiene la información
     * del proceso de evaluación a registrar.
     * @return true si la operación de registro fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "RegisterProcesova")
    public Boolean RegisterProcesova(ProcesoevaDto procesoevaDto) {
        Respuesta respuesta = procesoevaService.SaveProceso(procesoevaDto);
        return respuesta.getEstado();
    }

    /**
     * Obtiene un proceso de evaluación por su nombre.
     *
     * @param Name El nombre del proceso de evaluación que se desea obtener.
     * @return Un objeto ProcesoevaDto que representa el proceso de evaluación.
     */
    @WebMethod(operationName = "getProcesova")
    public ProcesoevaDto getProcesova(@WebParam(name = "Name") String Name) {
        Respuesta respuesta = procesoevaService.getProceso(Name);
        ProcesoevaDto procesoevaDto = new ProcesoevaDto((Procesoeva) respuesta.getResultado("Proceso"));
        return procesoevaDto;
    }

    /**
     * Elimina un proceso de evaluación por su ID.
     *
     * @param id El ID del proceso de evaluación a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = procesoevaService.DeleteProceso(id);
        return respuesta.getEstado();
    }

    /**
     * Establece las fechas (Aplicación, Finalización, Inicio) de un proceso de
     * evaluación dado un objeto ProcesoevaDto.
     *
     * @param procesodto Un objeto ProcesoevaDto que contiene las fechas a
     * establecer en el proceso de evaluación.
     * @param Aplicacion La fecha de aplicación del proceso de evaluación en
     * formato String.
     * @param finalizado La fecha de finalización del proceso de evaluación en
     * formato String.
     * @param inicio La fecha de inicio del proceso de evaluación en formato
     * String.
     */
    @WebMethod(operationName = "setDates")
    public void setDates(@WebParam(name = "dto") ProcesoevaDto procesodto, @WebParam(name = "Aplicacion") String Aplicacion, @WebParam(name = "finalizado") String finalizado, @WebParam(name = "inicio") String inicio) {
        procesodto.setApplication(Aplicacion);
        procesodto.setFinalperiod(finalizado);
        procesodto.setInicialperiod(inicio);
        RegisterProcesova(procesodto);
    }

    /**
     * Obtiene una lista de todos los procesos de evaluación disponibles.
     *
     * @return Una lista de objetos ProcesoevaDto que representan los procesos
     * de evaluación.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetProcesos")
    public List<ProcesoevaDto> GetProcesos() throws IOException {
        Respuesta respuesta = procesoevaService.getProcesos();
        List<Procesoeva> poc = (List<Procesoeva>) respuesta.getResultado("Procesos");
        List<ProcesoevaDto> procesoevaDtos = new ArrayList<>();
        for (Procesoeva j : poc) {
            ProcesoevaDto procesoevaDto = new ProcesoevaDto(j);
            procesoevaDtos.add(procesoevaDto);
        }
        return procesoevaDtos;
    }

}
