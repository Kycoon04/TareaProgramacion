/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.CharacteristicsDto;
import cr.ac.una.tarea.soap.CharacteristicDto;
import cr.ac.una.tarea.soap.ModuleCharacteristic;
import cr.ac.una.tarea.soap.ModuleCharacteristic_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson
 */

/**
 * Esta clase proporciona servicios relacionados con las características, incluyendo guardar, eliminar y recuperar características.
 * Interactúa con un servicio web SOAP (ModuleCharacteristic) para realizar estas operaciones.
 * 
 * @author Anderson
 */
public class CharacteristicService {
    /**
     * Guarda una característica llamando al método registerCharacteristic del servicio web SOAP ModuleCharacteristic.
     * 
     * @param characteristicsDto El objeto de transferencia de datos que contiene la información de la característica.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta SaveCharacteristic(CharacteristicsDto characteristicsDto) {
        try {
            ModuleCharacteristic_Service servicio = new ModuleCharacteristic_Service();
            ModuleCharacteristic cliente = servicio.getModuleCharacteristicPort();

            CharacteristicDto characteristicDto = new CharacteristicDto();
            characteristicDto.setCcId(characteristicsDto.getCcId());
            characteristicDto.setCcName(characteristicsDto.getCcName());
            characteristicDto.setCcComid(characteristicsDto.getCcComid());

            cliente.registerCharacteristic(characteristicDto);
            return new Respuesta(true, "", "", "Competencia", characteristicDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
 /**
     * Elimina una característica llamando al método delete del servicio web SOAP ModuleCharacteristic.
     * 
     * @param id El identificador de la característica que se va a eliminar.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta deleteCharacteristic(int id) {
        try {
            ModuleCharacteristic_Service servicio = new ModuleCharacteristic_Service();
            ModuleCharacteristic cliente = servicio.getModuleCharacteristicPort();
            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error eliminando el caracteristica.", ex);
            return new Respuesta(false, "Error eliminando caracteristica.", "eliminarCaracteristica " + ex.getMessage());
        }
    }
/**
     * Recupera características llamando al método getCharacteristics del servicio web SOAP ModuleCharacteristic.
     * 
     * @return Una respuesta que contiene una lista de características o indica un error.
     */
    public Respuesta getCharacteristic() {
        try {
            ModuleCharacteristic_Service servicio = new ModuleCharacteristic_Service();
            ModuleCharacteristic cliente = servicio.getModuleCharacteristicPort();

            List<CharacteristicDto> jobsWs = cliente.getCharacteristics();
            if (!jobsWs.isEmpty()) {
                List<CharacteristicsDto> characteristics = new ArrayList<>();
                for (CharacteristicDto job : jobsWs) {
                    CharacteristicsDto characteristicDto = new CharacteristicsDto();
                    characteristicDto.setCcComid(job.getCcComid());
                    characteristicDto.setCcId(job.getCcId());
                    characteristicDto.setCcName(job.getCcName());
                    characteristics.add(characteristicDto);
                }

                System.out.println(characteristics.get(0).getCcComid());

                return new Respuesta(true, "Error obteniendo las caracteristicas.", "getCharacteristic", "Characteristic", characteristics);
            } else {
              
                return new Respuesta(false, "Error obteniendo las caracteristicas.", "getCharacteristic" );
            }
        } catch (Exception ex) {
            Logger.getLogger(CharacteristicService.class.getName()).log(Level.SEVERE, "Error obteniendo los caracteristicas.", ex);
            return new Respuesta(false, "Error obteniendo las caracteristicas.", "getCharacteristic" + ex.getMessage());
        }
    }
}
