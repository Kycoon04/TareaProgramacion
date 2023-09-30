/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.EvaluatorResultsDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.model.ResultsDto;
import cr.ac.una.tarea.soap.EvaluatorResultDto;
import cr.ac.una.tarea.soap.ModuleEvaluators;
import cr.ac.una.tarea.soap.ModuleEvaluators_Service;
import cr.ac.una.tarea.soap.ModuleResult;
import cr.ac.una.tarea.soap.ModuleResult_Service;
import cr.ac.una.tarea.soap.Procesoeva;
import cr.ac.una.tarea.soap.ResultDto;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase proporciona servicios relacionados con los resultados de
 * evaluación, incluyendo guardar y eliminar resultados utilizando servicios web
 * SOAP (ModuleEvaluators y ModuleResult).
 *
 * @author dilan
 */
public class ResultsService {
/**
     * Guarda la información de un resultado de evaluación llamando al método
     * registerResult del servicio web SOAP ModuleResult.
     *
     * @param results El objeto de transferencia de datos que contiene la
     * información del resultado.
     * @param proceso El objeto de transferencia de datos que contiene la
     * información del proceso de evaluación.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */

    public Respuesta SaveResult(ResultsDto results, ProcesosevaDto proceso) {
        try {
            ModuleEvaluators_Service servicioEva = new ModuleEvaluators_Service();
            ModuleEvaluators clienteeva = servicioEva.getModuleEvaluatorsPort();
            ModuleResult_Service servicio = new ModuleResult_Service();
            ModuleResult cliente = servicio.getModuleResultPort();

            Procesoeva aux = new Procesoeva();

            clienteeva.setAllDates(aux,
                    proceso.getApplication().toString(),
                    proceso.getFinalperiod().toString(),
                    proceso.getInicialperiod().toString());
            results.getRsEvaluated().setEsProcesoeva(aux);

            ResultDto resultDto = new ResultDto();
            resultDto.setRsId(results.getRsId());
            resultDto.setRsCompe(results.getRsCompe());
            resultDto.setRsEvaluated(results.getRsEvaluated());
            resultDto.setRsNotajefatura(results.getRsNotajefatura());
            resultDto.setRsNotasis(results.getRsNotasis());

            cliente.registerResult(resultDto);
            return new Respuesta(true, "", "", "Resultado", resultDto);
        } catch (Exception ex) {
            Logger.getLogger(ResultsService.class.getName()).log(Level.SEVERE, "Error guardando el resultado.", ex);
            return new Respuesta(false, "Error guardando el resultado.", "guardarEmpleado " + ex.getMessage());
        }
    }
  /**
     * Elimina un resultado de evaluación por ID llamando al método delete del
     * servicio web SOAP ModuleResult.
     *
     * @param id El identificador del resultado de evaluación que se va a
     * eliminar.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta getResults() {
        try {
            ModuleResult_Service servicio = new ModuleResult_Service();
            ModuleResult cliente = servicio.getModuleResultPort();
            List<ResultDto> ResultDto = cliente.getResults();
            List<ResultsDto> ResultsDto = new ArrayList<>();
            for (ResultDto evaluator : ResultDto) {
                ResultsDto aux = new ResultsDto();
                aux.setRsCompe(evaluator.getRsCompe());
                aux.setRsEvaluated(evaluator.getRsEvaluated());
                aux.setRsId(evaluator.getRsId());
                aux.setRsNotajefatura(evaluator.getRsNotajefatura());
                aux.setRsNotasis(evaluator.getRsNotasis());
                ResultsDto.add(aux);
            }
            return new Respuesta(true, "Error obteniendo los puestos.", "getResults", "ResultsDto", ResultsDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error obteniendo los puestos.", ex);
            return new Respuesta(false, "Error obteniendo los puestos.", "getJobs" + ex.getMessage());
        }
    }
}
