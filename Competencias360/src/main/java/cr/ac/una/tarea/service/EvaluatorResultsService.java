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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase proporciona servicios relacionados con los resultados de
 * evaluadores, incluyendo guardar y obtener resultados utilizando un servicio
 * web SOAP (ModuleEvaluatorResult).
 *
 * También gestiona la información de las competencias asociadas a los
 * resultados.
 *
 */
public class EvaluatorResultsService {

    /**
     * Guarda la información de los resultados del evaluador llamando al método
     * registerEvaluatorResult del servicio web SOAP ModuleEvaluatorResult.
     *
     * @param evaluatorResultsDto El objeto de transferencia de datos que
     * contiene la información de los resultados del evaluador.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
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

    /**
     * Obtiene la información de los resultados de los evaluadores llamando al
     * método getEvaluatorResult del servicio web SOAP ModuleEvaluatorResult.
     *
     * @return Una respuesta que contiene la lista de resultados de evaluadores
     * o indica un error.
     */
    public Respuesta getEvaluatorResults() {
        try {
            ModuleEvaluatorResult_Service servicio = new ModuleEvaluatorResult_Service();
            ModuleEvaluatorResult cliente = servicio.getModuleEvaluatorResultPort();

            List<EvaluatorResultDto> evaluatorResultDto = cliente.getEvaluatorResult();
            List<EvaluatorResultsDto> evaluatorsDto = new ArrayList<>();

            for (EvaluatorResultDto evaluator : evaluatorResultDto) {
                EvaluatorResultsDto aux = new EvaluatorResultsDto();
                aux.setErCompe(evaluator.getErCompe());
                aux.setErEvaluator(evaluator.getErEvaluator());
                aux.setId(evaluator.getErId());
                aux.setNota(evaluator.getErNota());
                evaluatorsDto.add(aux);
            }

            return new Respuesta(true, "Error obteniendo los puestos.", "getJobs", "EvaluatorsDto", evaluatorsDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error obteniendo los puestos.", ex);
            return new Respuesta(false, "Error obteniendo los puestos.", "getJobs" + ex.getMessage());
        }
    }

}
