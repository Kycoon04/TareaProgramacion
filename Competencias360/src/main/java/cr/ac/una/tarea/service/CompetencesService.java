/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.CompetenceDto;
import cr.ac.una.tarea.soap.CompetencesDto;
import cr.ac.una.tarea.soap.ModuleCompetences;
import cr.ac.una.tarea.soap.ModuleCompetences_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase proporciona servicios relacionados con las competencias,
 * incluyendo guardar, obtener y eliminar competencias utilizando un servicio
 * web SOAP (ModuleCompetences).
 *
 * @author dilan
 */

public class CompetencesService {
  /**
     * Guarda una competencia llamando al método registerCompetences del
     * servicio web SOAP ModuleCompetences.
     *
     * @param competenceDto El objeto de transferencia de datos que contiene la
     * información de la competencia.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */

    public Respuesta SaveCompetence(CompetenceDto competenceDto) {
        try {
            ModuleCompetences_Service servicio = new ModuleCompetences_Service();
            ModuleCompetences cliente = servicio.getModuleCompetencesPort();

            CompetencesDto competencesDto = new CompetencesDto();
            competencesDto.setId(competenceDto.getId());
            competencesDto.setName(competenceDto.getName());
            competencesDto.setState(competenceDto.getState());
            cliente.registerCompetences(competencesDto);
            return new Respuesta(true, "", "", "Competencia", competencesDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
/**
     * Obtiene las competencias llamando al método getCompetences del servicio
     * web SOAP ModuleCompetences.
     *
     * @return Una respuesta que contiene la lista de competencias o indica un
     * error.
     */
    public Respuesta getCompetences() {
        try {
            ModuleCompetences_Service servicio = new ModuleCompetences_Service();
            ModuleCompetences cliente = servicio.getModuleCompetencesPort();

            List<CompetencesDto> competencesWs = cliente.getCompetences();
            List<CompetenceDto> competences = new ArrayList<>();
            for (CompetencesDto comp : competencesWs) {
                CompetenceDto competenceDto = new CompetenceDto();
                competenceDto.setName(comp.getName());
                competenceDto.setId(comp.getId());
                competenceDto.setState(comp.getState());
                competences.add(competenceDto);
            }

            return new Respuesta(true, "Error obteniendo las competencias.", "getCompetences", "Competences", competences);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo las competencias.", ex);
            return new Respuesta(false, "Error obteniendo las competencias.", "getCompetences" + ex.getMessage());
        }
    }
    
        public Respuesta eliminarCompe(int id) {
        try {
            ModuleCompetences_Service servicio = new ModuleCompetences_Service();
            ModuleCompetences cliente = servicio.getModuleCompetencesPort();

            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error eliminando la competencia.", ex);
            return new Respuesta(false, "Error eliminando la competencia.", "eliminarCompetence " + ex.getMessage());
        }
    }

}
