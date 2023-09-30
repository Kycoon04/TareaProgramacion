/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.InformationDto;
import cr.ac.una.tarea.model.JobDto;
import cr.ac.una.tarea.soap.ComInformationDto;
import cr.ac.una.tarea.soap.ModuleComInformation;
import cr.ac.una.tarea.soap.ModuleComInformation_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilan
 */
/**
 * Esta clase proporciona servicios relacionados con la información de la
 * empresa, incluyendo guardar y obtener información utilizando un servicio web
 * SOAP (ModuleComInformation).
 *
 * @author dilan
 */
public class ComInformationService {

    /**
     * Guarda la información de la empresa llamando al método generalParameters
     * del servicio web SOAP ModuleComInformation.
     *
     * @param comInformationDto El objeto de transferencia de datos que contiene
     * la información de la empresa.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta SaveInformation(InformationDto comInformationDto) {
        try {
            ModuleComInformation_Service servicio = new ModuleComInformation_Service();
            ModuleComInformation cliente = servicio.getModuleComInformationPort();

            ComInformationDto comInformation = new ComInformationDto();
            comInformation.setInformation(comInformationDto.getInformation());
            comInformation.setId(comInformationDto.getId());
            comInformation.setName(comInformationDto.getName());
            comInformation.setEmail(comInformationDto.getEmail());
            comInformation.setPhoto(comInformationDto.getPhoto());
            comInformation.setCpKey(comInformationDto.getCpKey());
            cliente.generalParameters(comInformation);
            return new Respuesta(true, "", "", "Informacion", comInformation);
        } catch (Exception ex) {
            Logger.getLogger(ComInformationService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }

    /**
     * Obtiene la información de la empresa llamando al método getComInfo del
     * servicio web SOAP ModuleComInformation.
     *
     * @return Una respuesta que contiene la información de la empresa o indica
     * un error.
     */
    public Respuesta getComInformation() {
        try {
            ModuleComInformation_Service servicio = new ModuleComInformation_Service();
            ModuleComInformation cliente = servicio.getModuleComInformationPort();

            List<ComInformationDto> listComInfo = cliente.getComInfo();
            if (!listComInfo.isEmpty()) {
                List<InformationDto> listInfo = new ArrayList<>();
                InformationDto lis = new InformationDto();
                lis.setEmail(listComInfo.get(0).getEmail());
                lis.setInformation(listComInfo.get(0).getInformation());
                lis.setName(listComInfo.get(0).getName());
                lis.setPhoto(listComInfo.get(0).getPhoto());
                lis.setId(listComInfo.get(0).getId());
                lis.setCpKey(listComInfo.get(0).getCpKey());
                listInfo.add(lis);
                return new Respuesta(true, "Error obteniendo la informacion.", "getInformation", "ComInformation", listInfo);
            } else {
                return new Respuesta(false, "Error obteniendo la informacion.", "getComInformation");
            }
        } catch (Exception ex) {
            Logger.getLogger(ComInformationService.class.getName()).log(Level.SEVERE, "Error obteniendo la informacion.", ex);
            return new Respuesta(false, "Error obteniendo la informacion.", "getComInformation" + ex.getMessage());
        }
    }

}
