/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.ComInformationDto;
import cr.ac.una.tareaws.model.Cominformation;
import cr.ac.una.tareaws.service.ComInformationService;

import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;

/**
 *
 * @author dilan
 */
@WebService(serviceName = "ModuleComInformation")
public class ModuleComInformation {
           
    @EJB
    ComInformationService comInformationService;
  
    
    @WebMethod(operationName = "getInformation")
    public ComInformationDto getInformation(@WebParam(name = "Name") String Name) throws IOException{
        Respuesta respuesta = comInformationService.getInformation(Name);
        ComInformationDto comInformationDto = new ComInformationDto((Cominformation) respuesta.getResultado("Usuario"));
        return comInformationDto;
    } 
        @WebMethod(operationName = "GeneralParameters")
    public Boolean GeneralParameters(ComInformationDto coninformation) {
        Respuesta respuesta = comInformationService.SaveInformation(coninformation);
        return respuesta.getEstado();
    }
    
    
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = comInformationService.Delete(id);
        return respuesta.getEstado();
    }
    
    
    
}
