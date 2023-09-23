/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.EvaJobCompetenceDto;
import cr.ac.una.tarea.model.EvaluatedsDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.soap.EvaluatedDto;
import cr.ac.una.tarea.soap.JobsCompetencesDto;
import cr.ac.una.tarea.soap.ModuleEvaluated;
import cr.ac.una.tarea.soap.ModuleEvaluated_Service;
import cr.ac.una.tarea.soap.ModuleJobsCompetences;
import cr.ac.una.tarea.soap.ModuleJobsCompetences_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jomav
 */
public class EvaluatedService {

    public Respuesta SaveEvaluated(EvaluatedsDto evaluatedDto, ProcesosevaDto proceso) {
        try {
            ModuleEvaluated_Service servicio = new ModuleEvaluated_Service();
            ModuleEvaluated cliente = servicio.getModuleEvaluatedPort();

            cliente.setDate(evaluatedDto.getEsProcesoeva(),
                    proceso.getApplication().toString(),
                    proceso.getFinalperiod().toString(),
                    proceso.getInicialperiod().toString());

            EvaluatedDto evaluatedsDto = new EvaluatedDto();
            evaluatedsDto.setEsProcesoeva(evaluatedDto.getEsProcesoeva());
            evaluatedsDto.setEsWorker(evaluatedDto.getEsWorker());

            cliente.registerEvaluated(evaluatedsDto);
            return new Respuesta(true, "", "", "Evaluated", evaluatedsDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error guardando las comptencias.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarCompetencias " + ex.getMessage());
        }
    }

    public Respuesta getEvaluateds() {
        try {
            ModuleEvaluated_Service servicio = new ModuleEvaluated_Service();
            ModuleEvaluated cliente = servicio.getModuleEvaluatedPort();

            List<EvaluatedDto> EvaluatedsWs = cliente.getEvaluateds();
            List<EvaluatedsDto> EvaluatedDto = new ArrayList<>();

            for (EvaluatedDto evaluateds : EvaluatedsWs) {
                EvaluatedsDto evaluatedsDto = new EvaluatedsDto();

                evaluatedsDto.setEsProcesoeva(evaluateds.getEsProcesoeva());
                evaluatedsDto.setEsWorker(evaluateds.getEsWorker());
                evaluatedsDto.setId(evaluateds.getEsId());
                EvaluatedDto.add(evaluatedsDto);
            }
            return new Respuesta(true, "Error obteniendo los puestos.", "getJobs", "Evaluated", EvaluatedDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo los puestos.", ex);
            return new Respuesta(false, "Error obteniendo los puestos.", "getJobs" + ex.getMessage());
        }
    }
    
        public Respuesta eliminarEvaluated(int id) {
        try {
              ModuleEvaluated_Service servicio = new ModuleEvaluated_Service();
            ModuleEvaluated cliente = servicio.getModuleEvaluatedPort();

            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error eliminando el evaluador.", ex);
            return new Respuesta(false, "Error eliminando el Evaluador.", "eliminarEvaluador " + ex.getMessage());
        }
    }
}
