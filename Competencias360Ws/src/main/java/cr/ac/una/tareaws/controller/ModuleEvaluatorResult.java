/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.EvaluatedDto;
import cr.ac.una.tareaws.model.EvaluatorResult;
import cr.ac.una.tareaws.model.EvaluatorResultDto;
import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.service.EvaluatorResultService;
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
 * Clase que implementa un servicio web para gestionar los resultados de
 * evaluadores. Este servicio proporciona operaciones como obtención por ID,
 * obtención por nota, registro, eliminación y listado de resultados. Se utiliza
 * anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
@WebService(serviceName = "ModuleEvaluatorResult")
public class ModuleEvaluatorResult {

    @EJB
    EvaluatorResultService evaluatoResultService;

    /**
     * Obtiene un resultado de evaluador por su ID.
     *
     * @param id El ID del resultado de evaluador que se desea obtener.
     * @return Un objeto EvaluatorResultDto que representa el resultado de
     * evaluador.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getEvaluatorResultById")
    public EvaluatorResultDto getEvaluatorResultById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = evaluatoResultService.getEvaluatorResultById(id);
        EvaluatorResultDto evaluatorResultDto = new EvaluatorResultDto((EvaluatorResult) respuesta.getResultado("EvaluatorResult"));
        return evaluatorResultDto;
    }

    /**
     * Obtiene un resultado de evaluador por su nota.
     *
     * @param nota La nota del resultado de evaluador que se desea obtener.
     * @return Un objeto EvaluatorResultDto que representa el resultado de
     * evaluador.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getEvaluatorResultByGrade")
    public EvaluatorResultDto getEvaluatorResultByGrade(@WebParam(name = "nota") Integer nota) throws IOException {
        Respuesta respuesta = evaluatoResultService.getEvaluatorResultByGrade(nota);
        EvaluatorResultDto evaluatorResultDto = new EvaluatorResultDto((EvaluatorResult) respuesta.getResultado("EvaluatorResult"));
        return evaluatorResultDto;
    }

    /**
     * Registra un resultado de evaluador.
     *
     * @param evaluatorResultDto Un objeto EvaluatorResultDto que contiene el
     * resultado de evaluador a registrar.
     * @return true si la operación de registro fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "RegisterEvaluatorResult")
    public Boolean RegisterEvaluatorResult(EvaluatorResultDto evaluatorResultDto) {
        Respuesta respuesta = evaluatoResultService.saveEvaluatorResult(evaluatorResultDto);
        return respuesta.getEstado();
    }

    /**
     * Elimina un resultado de evaluador por su ID.
     *
     * @param id El ID del resultado de evaluador a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = evaluatoResultService.DeleteEvaluatorResult(id);
        return respuesta.getEstado();
    }

    /**
     * Obtiene una lista de todos los resultados de evaluadores disponibles.
     *
     * @return Una lista de objetos EvaluatorResultDto que representan los
     * resultados de evaluadores.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getEvaluatorResult")
    public List<EvaluatorResultDto> getEvaluatorResult() throws IOException {
        Respuesta respuesta = evaluatoResultService.getEvaluators();
        List<EvaluatorResult> evaluatorResult = (List<EvaluatorResult>) respuesta.getResultado("EvaluatorResult");
        List<EvaluatorResultDto> evaluatorResultDto = new ArrayList<>();

        for (EvaluatorResult evaluator : evaluatorResult) {
            EvaluatorResultDto aux = new EvaluatorResultDto(evaluator);
            evaluatorResultDto.add(aux);
        }

        return evaluatorResultDto;
    }
}
