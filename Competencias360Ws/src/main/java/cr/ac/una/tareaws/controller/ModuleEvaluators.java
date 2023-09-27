/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Evaluated;
import cr.ac.una.tareaws.model.EvaluatedDto;
import cr.ac.una.tareaws.model.Evaluators;
import cr.ac.una.tareaws.model.EvaluatorsDto;
import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.model.Procesoeva;
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
 *
 * @author dilan
 */
/**
 * Clase que implementa un servicio web para gestionar los evaluadores. Este
 * servicio proporciona operaciones como obtención por ID, obtención por estado,
 * obtención por retroalimentación, registro, eliminación y listado de
 * evaluadores. Se utiliza anotaciones JAX-WS para exponer los métodos como
 * operaciones web.
 */
@WebService(serviceName = "ModuleEvaluators")
public class ModuleEvaluators {

    @EJB
    EvaluatorService evaluatorsService;

    /**
     * Obtiene un evaluador por su ID.
     *
     * @param id El ID del evaluador que se desea obtener.
     * @return Un objeto EvaluatorsDto que representa al evaluador.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetEvaluatorById")
    public EvaluatorsDto GetEvaluatorById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = evaluatorsService.getEvaluatorByID(id);
        EvaluatorsDto evaluatorsDto = new EvaluatorsDto((Evaluators) respuesta.getResultado("Evaluators"));
        return evaluatorsDto;
    }

    /**
     * Obtiene evaluadores por su estado.
     *
     * @param state El estado de los evaluadores que se desean obtener.
     * @return Un objeto EvaluatorsDto que representa a los evaluadores.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetEvaluatorByState")
    public EvaluatorsDto GetEvaluatorByState(@WebParam(name = "state") String state) throws IOException {
        Respuesta respuesta = evaluatorsService.getEvaluatorByState(state);
        EvaluatorsDto evaluatorsDto = new EvaluatorsDto((Evaluators) respuesta.getResultado("Evaluators"));
        return evaluatorsDto;
    }

    /**
     * Obtiene evaluadores por retroalimentación.
     *
     * @param FeedBack La retroalimentación de los evaluadores que se desean
     * obtener.
     * @return Un objeto EvaluatorsDto que representa a los evaluadores.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetEvaluatorByFeedBack")
    public EvaluatorsDto GetEvaluatorByFeedBack(@WebParam(name = "FeedBack") String FeedBack) throws IOException {
        Respuesta respuesta = evaluatorsService.getEvaluatorByFeedBack(FeedBack);
        EvaluatorsDto evaluatorsDto = new EvaluatorsDto((Evaluators) respuesta.getResultado("Evaluators"));
        return evaluatorsDto;
    }

    /**
     * Registra un evaluador.
     *
     * @param evaluatorsDto Un objeto EvaluatorsDto que contiene al evaluador a
     * registrar.
     * @return true si la operación de registro fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "")
    public Boolean RegisterEvaluators(EvaluatorsDto evaluatorsDto) {
        Respuesta respuesta = evaluatorsService.SaveEvaluator(evaluatorsDto);
        return respuesta.getEstado();
    }

    /**
     * Elimina un evaluador por su ID.
     *
     * @param id El ID del evaluador a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = evaluatorsService.DeleteEvaluator(id);
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
    @WebMethod(operationName = "setAllDates")
    public void setAllDates(@WebParam(name = "dto") Procesoeva proceso, @WebParam(name = "Aplicacion") String Aplicacion, @WebParam(name = "finalizado") String finalizado, @WebParam(name = "inicio") String inicio) {
        proceso.setEnApplication(LocalDate.parse(Aplicacion));
        proceso.setEnFinalperiod(LocalDate.parse(finalizado));
        proceso.setEnInicialperiod(LocalDate.parse(inicio));
    }

    /**
     * Obtiene una lista de todos los evaluadores disponibles.
     *
     * @return Una lista de objetos EvaluatorsDto que representan a los
     * evaluadores.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetEvaluators")
    public List<EvaluatorsDto> GetEvaluators() throws IOException {
        Respuesta respuesta = evaluatorsService.getEvaluators();
        List<Evaluators> ev = (List<Evaluators>) respuesta.getResultado("Evaluators");
        List<EvaluatorsDto> evaDto = new ArrayList<>();
        for (Evaluators j : ev) {
            EvaluatorsDto jobDto = new EvaluatorsDto(j);
            evaDto.add(jobDto);
        }
        return evaDto;
    }
}
