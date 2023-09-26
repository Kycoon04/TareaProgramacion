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
 * Clase que define un servicio web para la entidad "Characteristic".
 * Proporciona métodos para operaciones CRUD y búsqueda.
 */
@WebService(serviceName = "ModuleCharacteristic")
public class ModuleCharacteristic {

    @EJB
    CharacteristicService characteristicService;

    /**
     * Obtiene una Characteristic por su ID y la retorna.
     *
     * @param id El ID de la Characteristic que se desea obtener.
     * @return Una instancia de CharacteristicDto que representa la Characteristic
     *         encontrada, o null si no se encontró ninguna.
     * @throws IOException Si se produce un error de E/S durante la operación.
     */
    @WebMethod(operationName = "getByCcId")
    public CharacteristicDto getByCcId(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = characteristicService.getCharById(id);
        CharacteristicDto characteristicDto = new CharacteristicDto((Characteristic) respuesta.getResultado("Characteristic"));
        return characteristicDto;
    }

    /**
     * Busca una Characteristic por su nombre y la retorna.
     *
     * @param name El nombre de la Characteristic que se desea buscar.
     * @return Una instancia de CharacteristicDto que representa la Characteristic
     *         encontrada, o null si no se encontró ninguna.
     * @throws IOException Si se produce un error de E/S durante la operación.
     */
    @WebMethod(operationName = "findByCcName")
    public CharacteristicDto findByCcName(@WebParam(name = "name") String name) throws IOException {
        Respuesta respuesta = characteristicService.getCharByName(name);
        CharacteristicDto characteristicDto = new CharacteristicDto((Characteristic) respuesta.getResultado("Characteristic"));
        return characteristicDto;
    }

        /**
     * Registra una nueva Characteristic en la base de datos.
     *
     * @param characteristicDto El objeto CharacteristicDto que contiene los datos
     *                          de la Characteristic a registrar.
     * @return true si la Characteristic se registró exitosamente, false si ocurrió
     *         un error.
     */
    @WebMethod(operationName = "RegisterCharacteristic")
    public Boolean RegisterCharacteristic(CharacteristicDto characteristicDto) {
        Respuesta respuesta = characteristicService.SaveCharacteristic(characteristicDto);
        return respuesta.getEstado();
    }
     
    /**
     * Elimina una Characteristic de la base de datos por su ID.
     *
     * @param id El ID de la Characteristic que se desea eliminar.
     * @return true si la Characteristic se eliminó exitosamente, false si ocurrió
     *         un error.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = characteristicService.Delete(id);
        return respuesta.getEstado();
    }
    
    /**
     * Obtiene una lista de todas las características disponibles en la base de datos.
     *
     * @return Una lista de instancias de CharacteristicDto que representan todas las
     *         características encontradas, o null si no se encontraron características.
     * @throws IOException Si se produce un error de E/S durante la operación.
     */
    @WebMethod(operationName = "GetCharacteristics")
    public List<CharacteristicDto> GetCharacteristics() throws IOException {
        Respuesta respuesta = characteristicService.getCharacteristics();
        if (respuesta.getEstado()) {
            List<Characteristic> characteristics = (List<Characteristic>) respuesta.getResultado("Characteristic");
            List<CharacteristicDto> CharacteristicDto = new ArrayList<>();
            for (Characteristic j : characteristics) {
                CharacteristicDto characteristicDto = new CharacteristicDto(j);
                CharacteristicDto.add(characteristicDto);
            }
            return CharacteristicDto;
        }else{
            return null;
        }
    }
}
