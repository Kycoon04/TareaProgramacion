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

/**
 *
 * @author dilan
 */
@WebService(serviceName = "ModuleResult")
public class ModuleResult {

    @EJB
    ResultService resultService;

    @WebMethod(operationName = "getResultById")
    public ResultDto getResultById(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = resultService.getResultById(id);
        ResultDto resultDto = new ResultDto((Result) respuesta.getResultado("Result"));
        return resultDto;
    }

    @WebMethod(operationName = "getResultByGrade")
    public ResultDto getResultByGrade(@WebParam(name = "nota") Integer nota) throws IOException {
        Respuesta respuesta = resultService.getResultByName(nota);
        ResultDto resultDto = new ResultDto((Result) respuesta.getResultado("Result"));
        return resultDto;
    }

    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = resultService.DeleteResult(id);
        return respuesta.getEstado();
    }
    @WebMethod(operationName = "RegisterResult")
    public Boolean RegisterResult(ResultDto job) {
        Respuesta respuesta = resultService.SaveResult(job);
        return respuesta.getEstado();
    }
    
    
}
