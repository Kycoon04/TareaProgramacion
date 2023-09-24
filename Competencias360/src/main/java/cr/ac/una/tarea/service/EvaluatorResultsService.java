/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.CompetenceDto;
import cr.ac.una.tarea.model.EvaluatorResultsDto;
import cr.ac.una.tarea.soap.CompetencesDto;
import cr.ac.una.tarea.soap.EvaluatorResultDto;
import cr.ac.una.tarea.soap.ModuleCompetences;
import cr.ac.una.tarea.soap.ModuleCompetences_Service;
import cr.ac.una.tarea.soap.ModuleEvaluatorResult;
import cr.ac.una.tarea.soap.ModuleEvaluatorResult_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jomav
 */
public class EvaluatorResultsService {
    
        public Respuesta SaveEvaluatorResult(EvaluatorResultsDto evaluatorResultsDto) {
        try {
            ModuleEvaluatorResult_Service servicio = new ModuleEvaluatorResult_Service();
            ModuleEvaluatorResult cliente = servicio.getModuleEvaluatorResultPort();

            EvaluatorResultDto evaluatorResultDto = new EvaluatorResultDto();
            
            evaluatorResultDto.setErCompe(evaluatorResultsDto.getErCompe());
            evaluatorResultDto.setErEvaluator(evaluatorResultsDto.getErEvaluator());
            evaluatorResultDto.setErId(evaluatorResultsDto.getId());
            evaluatorResultDto.setErNota(evaluatorResultsDto.getNota());
            cliente.registerEvaluatorResult(evaluatorResultDto);
            return new Respuesta(true, "", "", "Competencia", evaluatorResultDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
    
    
    
}
