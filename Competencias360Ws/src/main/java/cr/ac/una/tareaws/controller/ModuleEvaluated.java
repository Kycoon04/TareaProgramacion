/*
 * Esta clase define un servicio web llamado ModuleEvaluated que proporciona operaciones relacionadas con la evaluación de trabajadores.
 * Utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Evaluated;
import cr.ac.una.tareaws.model.EvaluatedDto;
import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.model.ProcesoevaDto;
import cr.ac.una.tareaws.service.EvaluatedService;
import cr.ac.una.tareaws.service.EvaluatorService;
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
 * Clase que implementa un servicio web para gestionar la evaluación de
 * trabajadores. Este servicio proporciona operaciones como obtención por ID,
 * registro, eliminación y listado de evaluaciones. También incluye un método
 * para establecer fechas en un objeto Procesoeva y hacer la conversion. Se
 * utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
@WebService(serviceName = "ModuleEvaluated")
public class ModuleEvaluated {

    @EJB
    EvaluatedService evaluatedService;

    /**
     * Obtiene una evaluación por ID.
     *
     * @param id El ID de la evaluación que se desea obtener.
     * @return Un objeto EvaluatedDto que representa la evaluación.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetEvaluatedById")
    public EvaluatedDto GetEvaluatedById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = evaluatedService.getEvaluatedById(id);
        EvaluatedDto evaluatedDto = new EvaluatedDto((Evaluated) respuesta.getResultado("Evaluated"));
        return evaluatedDto;
    }

    /**
     * Obtiene una evaluación por información de trabajador y proceso.
     *
     * @param worker El ID del trabajador.
     * @param proceso El ID del proceso.
     * @return Un objeto EvaluatedDto que representa la evaluación.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetEvaluatedByInfo")
    public EvaluatedDto GetEvaluatedByInfo(@WebParam(name = "worker") Integer worker, @WebParam(name = "proceso") Integer proceso) throws IOException {
        Respuesta respuesta = evaluatedService.getEvaluatedByInfomation(worker, proceso);
        EvaluatedDto evaluatedDto = new EvaluatedDto((Evaluated) respuesta.getResultado("Evaluated"));
        return evaluatedDto;
    }

    /**
     * Registra una evaluación.
     *
     * @param evaluatedDto Un objeto EvaluatedDto que contiene la evaluación a
     * registrar.
     * @return true si la operación de registro fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "RegisterEvaluated")
    public Boolean RegisterEvaluated(EvaluatedDto evaluatedDto) {
        Respuesta respuesta = evaluatedService.SaveEvaluated(evaluatedDto);
        return respuesta.getEstado();
    }

    /**
     * Elimina una evaluación por ID.
     *
     * @param id El ID de la evaluación a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = evaluatedService.DeleteEvaluated(id);
        return respuesta.getEstado();
    }

    /**
     * Establece las fechas en un objeto Procesoeva.
     *
     * @param proceso El objeto Procesoeva al que se le establecerán las fechas.
     * @param Aplicacion La fecha de aplicación en formato String.
     * @param finalizado La fecha de finalización en formato String.
     * @param inicio La fecha de inicio en formato String.
     */
    @WebMethod(operationName = "setDate")
    public void setDate(@WebParam(name = "dto") Procesoeva proceso, @WebParam(name = "Aplicacion") String Aplicacion, @WebParam(name = "finalizado") String finalizado, @WebParam(name = "inicio") String inicio) {
        proceso.setEnApplication(LocalDate.parse(Aplicacion));
        proceso.setEnFinalperiod(LocalDate.parse(finalizado));
        proceso.setEnInicialperiod(LocalDate.parse(inicio));
    }

    /**
     * Obtiene una lista de todas las evaluaciones disponibles.
     *
     * @return Una lista de objetos EvaluatedDto que representan las
     * evaluaciones.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetEvaluateds")
    public List<EvaluatedDto> GetEvaluateds() throws IOException {
        Respuesta respuesta = evaluatedService.getEvaluated();
        List<Evaluated> evaluated = (List<Evaluated>) respuesta.getResultado("Evaluated");
        List<EvaluatedDto> evaluatedDto = new ArrayList<>();
        for (Evaluated j : evaluated) {
            EvaluatedDto jobDto = new EvaluatedDto(j);
            evaluatedDto.add(jobDto);
        }
        return evaluatedDto;
    }
}
