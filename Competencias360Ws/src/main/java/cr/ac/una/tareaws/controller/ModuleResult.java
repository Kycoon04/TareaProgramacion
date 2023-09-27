/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.model.Result;
import cr.ac.una.tareaws.model.ResultDto;
import cr.ac.una.tareaws.service.ResultService;
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
 * Clase que implementa un servicio web para gestionar los resultados de evaluación (Result).
 * Este servicio proporciona operaciones como obtención por ID, obtención por nota, eliminación y registro de resultados.
 * Se utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
@WebService(serviceName = "ModuleResult")
public class ModuleResult {

    @EJB
    ResultService resultService;
  /**
     * Obtiene un resultado de evaluación por su ID.
     * @param id El ID del resultado de evaluación que se desea obtener.
     * @return Un objeto ResultDto que representa el resultado de evaluación.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getResultById")
    public ResultDto getResultById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = resultService.getResultById(id);
        ResultDto resultDto = new ResultDto((Result) respuesta.getResultado("Result"));
        return resultDto;
    }
    /**
     * Obtiene un resultado de evaluación por su nota.
     * @param nota La nota del resultado de evaluación que se desea obtener.
     * @return Un objeto ResultDto que representa el resultado de evaluación.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getResultByGrade")
    public ResultDto getResultByGrade(@WebParam(name = "nota") Integer nota) throws IOException {
        Respuesta respuesta = resultService.getResultByName(nota);
        ResultDto resultDto = new ResultDto((Result) respuesta.getResultado("Result"));
        return resultDto;
    }
    /**
     * Elimina un resultado de evaluación por su ID.
     * @param id El ID del resultado de evaluación a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = resultService.DeleteResult(id);
        return respuesta.getEstado();
    }
        /**
     * Registra un resultado de evaluación.
     * @param job Un objeto ResultDto que contiene la información del resultado de evaluación a registrar.
     * @return true si la operación de registro fue exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "RegisterResult")
    public Boolean RegisterResult(ResultDto job) {
        Respuesta respuesta = resultService.SaveResult(job);
        return respuesta.getEstado();
    }
       /**
     * Obtiene una lista de todos los resultados de evaluación disponibles.
     *
     * @return Una lista de objetos ResultDto que representan los Resultados
     * de evaluación.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
        @WebMethod(operationName = "getResults")
    public List<ResultDto> getResults() throws IOException {
        Respuesta respuesta = resultService.getResult();
        List<Result> Result = (List<Result>) respuesta.getResultado("Result");
        List<ResultDto> ResultDto = new ArrayList<>();
        for (Result evaluator : Result) {
            ResultDto aux = new ResultDto(evaluator);
            ResultDto.add(aux);
        }
        return ResultDto;
    }
    
}
