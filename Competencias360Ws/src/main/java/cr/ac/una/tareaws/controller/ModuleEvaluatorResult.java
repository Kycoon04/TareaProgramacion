/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.EvaluatedDto;
import cr.ac.una.tareaws.model.EvaluatorResult;
import cr.ac.una.tareaws.model.EvaluatorResultDto;
import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.service.EvaluatorResultService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author dilan
 */
@WebService(serviceName = "ModuleEvaluatorResult")
public class ModuleEvaluatorResult {
   @EJB
    EvaluatorResultService evaluatoResultService;
   
    @WebMethod(operationName = "getEvaluatorResultById")
    public EvaluatorResultDto getEvaluatorResultById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = evaluatoResultService.getEvaluatorResultById(id);
        EvaluatorResultDto evaluatorResultDto = new EvaluatorResultDto((EvaluatorResult) respuesta.getResultado("EvaluatorResult"));
        return evaluatorResultDto;
    }   
    
    @WebMethod(operationName = "getEvaluatorResultByGrade")
    public EvaluatorResultDto getEvaluatorResultByGrade(@WebParam(name = "nota") Integer nota) throws IOException {
        Respuesta respuesta = evaluatoResultService.getEvaluatorResultByGrade(nota);
        EvaluatorResultDto evaluatorResultDto = new EvaluatorResultDto((EvaluatorResult) respuesta.getResultado("EvaluatorResult"));
        return evaluatorResultDto;
    }  
    
    @WebMethod(operationName = "RegisterEvaluatorResult")
    public Boolean RegisterEvaluatorResult(EvaluatorResultDto evaluatorResultDto) {
        Respuesta respuesta = evaluatoResultService.saveEvaluatorResult(evaluatorResultDto);
        return respuesta.getEstado();
    }
    
      @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = evaluatoResultService.DeleteEvaluatorResult(id);
        return respuesta.getEstado();
    }
}
