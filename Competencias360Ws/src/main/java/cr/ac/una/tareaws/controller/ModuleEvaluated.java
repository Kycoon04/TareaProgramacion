/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 *
 * @author dilan
 */
@WebService(serviceName = "ModuleEvaluated")
public class ModuleEvaluated {
    @EJB
    EvaluatedService evaluatedService;
        
    @WebMethod(operationName = "GetEvaluatedById")
    public EvaluatedDto GetEvaluatedById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = evaluatedService.getEvaluatedById(id);
        EvaluatedDto evaluatedDto = new EvaluatedDto((Evaluated) respuesta.getResultado("Evaluated"));
        return evaluatedDto;
    }   
    @WebMethod(operationName = "GetEvaluatedByInfo")
    public EvaluatedDto GetEvaluatedByInfo(@WebParam(name = "worker") Integer worker,@WebParam(name = "proceso") Integer proceso) throws IOException {
        Respuesta respuesta = evaluatedService.getEvaluatedByInfomation(worker,proceso);
        EvaluatedDto evaluatedDto = new EvaluatedDto((Evaluated) respuesta.getResultado("Evaluated"));
        return evaluatedDto;
    }   
   @WebMethod(operationName = "RegisterEvaluated")
    public Boolean RegisterEvaluated(EvaluatedDto evaluatedDto) {
        Respuesta respuesta = evaluatedService.SaveEvaluated(evaluatedDto);
        return respuesta.getEstado();
    }
    
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = evaluatedService.DeleteEvaluated(id);
        return respuesta.getEstado();
    }
    @WebMethod(operationName = "setDate")
    public void setDate(@WebParam(name = "dto") Procesoeva proceso, @WebParam(name = "Aplicacion") String Aplicacion,@WebParam(name = "finalizado") String finalizado,@WebParam(name = "inicio") String inicio) {
        proceso.setEnApplication(LocalDate.parse(Aplicacion));
        proceso.setEnFinalperiod(LocalDate.parse(finalizado));
        proceso.setEnInicialperiod(LocalDate.parse(inicio));
    }  
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
