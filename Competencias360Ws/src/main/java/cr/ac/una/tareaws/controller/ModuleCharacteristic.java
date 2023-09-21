/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Characteristic;
import cr.ac.una.tareaws.model.CharacteristicDto;
import cr.ac.una.tareaws.service.CharacteristicService;
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
@WebService(serviceName = "ModuleCharacteristic")
public class ModuleCharacteristic {
   
    @EJB
    CharacteristicService characteristicService;
    
    @WebMethod(operationName = "getByCcId")
    public CharacteristicDto getByCcId(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = characteristicService.getCharById(id);
        CharacteristicDto characteristicDto = new CharacteristicDto((Characteristic) respuesta.getResultado("Characteristic"));
        return characteristicDto;
    }   
        @WebMethod(operationName = "findByCcName")
    public CharacteristicDto findByCcName(@WebParam(name = "name") String name) throws IOException {
        Respuesta respuesta = characteristicService.getCharByName(name);
        CharacteristicDto characteristicDto = new CharacteristicDto((Characteristic) respuesta.getResultado("Characteristic"));
        return characteristicDto;
    }   
    
        @WebMethod(operationName = "RegisterCharacteristic")
    public Boolean RegisterCharacteristic(CharacteristicDto characteristicDto) {
        Respuesta respuesta = characteristicService.SaveCharacteristic(characteristicDto);
        return respuesta.getEstado();
    }
    
         @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = characteristicService.Delete(id);
        return respuesta.getEstado();
    }
        @WebMethod(operationName = "GetCharacteristics")
    public List<CharacteristicDto> GetCharacteristics() throws IOException {
        Respuesta respuesta = characteristicService.getCharacteristics();
        List<Characteristic> characteristics = (List<Characteristic>) respuesta.getResultado("Characteristic");
        List<CharacteristicDto> CharacteristicDto = new ArrayList<>();
        for (Characteristic j : characteristics) {
            CharacteristicDto characteristicDto = new CharacteristicDto(j);
            CharacteristicDto.add(characteristicDto);
        }
        return CharacteristicDto;
    }
}
