/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.ComInformationDto;
import cr.ac.una.tareaws.model.Cominformation;
import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.service.ComInformationService;

import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dilan
 */

/**
 * Clase que implementa un servicio web para gestionar información de la empresa.
 * Este servicio proporciona operaciones como obtención, registro, eliminación y listado de información.
 * Se utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */

@WebService(serviceName = "ModuleComInformation")
public class ModuleComInformation {
           
    @EJB
    ComInformationService comInformationService;
    
    /**
     * Obtiene información de comunicación por nombre.
     * @param Name El nombre de la información que se desea obtener.
     * @return Un objeto ComInformationDto que representa la información.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    
    @WebMethod(operationName = "getInformation")
    public ComInformationDto getInformation(@WebParam(name = "Name") String Name) throws IOException{
        Respuesta respuesta = comInformationService.getInformation(Name);
        ComInformationDto comInformationDto = new ComInformationDto((Cominformation) respuesta.getResultado("Usuario"));
        return comInformationDto;
    } 
    
    /**
     * Registra información de comunicación general.
     * @param coninformation Un objeto ComInformationDto que contiene la información a registrar.
     * @return true si la operación de registro fue exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "GeneralParameters")
    public Boolean GeneralParameters(ComInformationDto coninformation) {
        Respuesta respuesta = comInformationService.SaveInformation(coninformation);
        return respuesta.getEstado();
    }
    
       
    /**
     * Obtiene una lista de todas las informaciones de comunicación disponibles.
     * @return Una lista de objetos ComInformationDto que representan la información de comunicación.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetComInfo")
    public List<ComInformationDto> GetComInfo() throws IOException {
        Respuesta respuesta = comInformationService.getAllInfo();
        List<Cominformation>  cominformations= (List<Cominformation>) respuesta.getResultado("Cominformation");
        List<ComInformationDto> comInformationDto = new ArrayList<>();
        for (Cominformation j : cominformations) {
            ComInformationDto comInformationDt = new ComInformationDto(j);
            comInformationDto.add(comInformationDt);
        }
        return comInformationDto;
    }
   
     /**
     * Elimina información de comunicación por ID.
     * @param id El ID de la información de comunicación a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = comInformationService.Delete(id);
        return respuesta.getEstado();
    }
}
