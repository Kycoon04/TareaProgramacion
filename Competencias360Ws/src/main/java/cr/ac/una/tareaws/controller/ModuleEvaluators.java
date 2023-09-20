/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Evaluated;
import cr.ac.una.tareaws.model.EvaluatedDto;
import cr.ac.una.tareaws.model.Evaluators;
import cr.ac.una.tareaws.model.EvaluatorsDto;
import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.service.EvaluatorService;
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
@WebService(serviceName = "ModuleEvaluators")
public class ModuleEvaluators {
    @EJB
    EvaluatorService evaluatorsService;
    
    @WebMethod(operationName = "GetEvaluatorById")
    public EvaluatorsDto GetEvaluatorById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = evaluatorsService.getEvaluatorByID(id);
        EvaluatorsDto evaluatorsDto = new EvaluatorsDto((Evaluators) respuesta.getResultado("Evaluators"));
        return evaluatorsDto;
    }

    @WebMethod(operationName = "GetEvaluatorByState")
    public EvaluatorsDto GetEvaluatorByState(@WebParam(name = "state") String state) throws IOException {
        Respuesta respuesta = evaluatorsService.getEvaluatorByState(state);
        EvaluatorsDto evaluatorsDto = new EvaluatorsDto((Evaluators) respuesta.getResultado("Evaluators"));
        return evaluatorsDto;
    }

    @WebMethod(operationName = "GetEvaluatorByFeedBack")
    public EvaluatorsDto GetEvaluatorByFeedBack(@WebParam(name = "FeedBack") String FeedBack) throws IOException {
        Respuesta respuesta = evaluatorsService.getEvaluatorByFeedBack(FeedBack);
        EvaluatorsDto evaluatorsDto = new EvaluatorsDto((Evaluators) respuesta.getResultado("Evaluators"));
        return evaluatorsDto;
    }

    @WebMethod(operationName = "")
    public Boolean RegisterEvaluators(EvaluatorsDto evaluatorsDto) {
        Respuesta respuesta = evaluatorsService.SaveEvaluator(evaluatorsDto);
        return respuesta.getEstado();
    }
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = evaluatorsService.DeleteEvaluator(id);
        return respuesta.getEstado();
    }
        @WebMethod(operationName = "setAllDates")
    public void setAllDates(@WebParam(name = "dto") Procesoeva proceso, @WebParam(name = "Aplicacion") String Aplicacion,@WebParam(name = "finalizado") String finalizado,@WebParam(name = "inicio") String inicio) {
        proceso.setEnApplication(LocalDate.parse(Aplicacion));
        proceso.setEnFinalperiod(LocalDate.parse(finalizado));
        proceso.setEnInicialperiod(LocalDate.parse(inicio));
    }  
}
