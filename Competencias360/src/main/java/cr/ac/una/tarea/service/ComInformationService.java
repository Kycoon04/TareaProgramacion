/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.InformationDto;
import cr.ac.una.tarea.soap.ComInformationDto;
import cr.ac.una.tarea.soap.ModuleComInformation;
import cr.ac.una.tarea.soap.ModuleComInformation_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilan
 */
public class ComInformationService {
    
    public Respuesta SaveInformation(InformationDto comInformationDto) {
        try {
            ModuleComInformation_Service servicio = new ModuleComInformation_Service();
            ModuleComInformation cliente = servicio.getModuleComInformationPort();
            
            ComInformationDto comInformation = new ComInformationDto();
            comInformation.setInformation(comInformationDto.getInformation());
            comInformation.setId(comInformationDto.getId());
            comInformation.setName(comInformationDto.getName());
            comInformation.setEmail(comInformationDto.getEmail());
            cliente.generalParameters(comInformation);
            return new Respuesta(true, "", "", "Informacion", comInformation);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }

}
