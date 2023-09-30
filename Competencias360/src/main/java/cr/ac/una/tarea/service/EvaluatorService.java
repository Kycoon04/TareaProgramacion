/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.EvaluatedsDto;
import cr.ac.una.tarea.model.EvaluatorDto;
import cr.ac.una.tarea.model.ProcesosevaDto;
import cr.ac.una.tarea.soap.EvaluatedDto;
import cr.ac.una.tarea.soap.EvaluatorsDto;
import cr.ac.una.tarea.soap.ModuleEvaluators;
import cr.ac.una.tarea.soap.ModuleEvaluators_Service;
import cr.ac.una.tarea.soap.ModuleJobs_Service;
import cr.ac.una.tarea.soap.Procesoeva;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase proporciona servicios relacionados con los evaluadores, incluyendo
 * guardar, obtener, obtener por ID y eliminar evaluadores utilizando un
 * servicio web SOAP (ModuleEvaluators).
 *
 * También gestiona la información relacionada con los procesos de evaluación
 * asociados a los evaluadores utilizando un servicio web SOAP adicional
 * (ModuleJobs_Service).
 *
 * @author dilan
 */
public class EvaluatorService {

    /**
     * Guarda la información de un evaluador llamando al método
     * registerEvaluators del servicio web SOAP ModuleEvaluators.
     *
     * @param evaluatorDto El objeto de transferencia de datos que contiene la
     * información del evaluador.
     * @param proceso El objeto que contiene información sobre el proceso de
     * evaluación asociado al evaluador.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta SaveEvaluator(EvaluatorDto evaluatorDto, ProcesosevaDto proceso) {
        try {
            ModuleEvaluators_Service servicio = new ModuleEvaluators_Service();
            ModuleEvaluators cliente = servicio.getModuleEvaluatorsPort();
            Procesoeva aux = new Procesoeva();

            cliente.setAllDates(aux,
                    proceso.getApplication().toString(),
                    proceso.getFinalperiod().toString(),
                    proceso.getInicialperiod().toString());
            evaluatorDto.getEvsEvaluated().setEsProcesoeva(aux);

            EvaluatorsDto evaluatorsDto = new EvaluatorsDto();
            evaluatorsDto.setEvsId(evaluatorDto.getEvsId());
            evaluatorsDto.setEvsWorker(evaluatorDto.getEvsWorker());
            evaluatorsDto.setEvsConnection(evaluatorDto.getEvsConnection());
            evaluatorsDto.setEvsFeedback(evaluatorDto.getEvsFeedback());
            evaluatorsDto.setEvsState(evaluatorDto.getEvsState());
            evaluatorsDto.setEvsEvaluated(evaluatorDto.getEvsEvaluated());
            cliente.registerEvaluators(evaluatorsDto);
            return new Respuesta(true, "", "", "Evaluador", evaluatorsDto);

        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error guardando el Evaluador.", ex);
            return new Respuesta(false, "Error guardando el Evaluador.", "guardarEvaluador " + ex.getMessage());
        }
    }

    /**
     * Obtiene la información de un evaluador por ID llamando al método
     * getEvaluatorById del servicio web SOAP ModuleEvaluators.
     *
     * @param id El identificador del evaluador.
     * @return Una respuesta que contiene la información del evaluador o indica
     * un error.
     */
    public Respuesta getEvaluatorByID(int id) {
        try {
            ModuleEvaluators_Service servicio = new ModuleEvaluators_Service();
            ModuleEvaluators cliente = servicio.getModuleEvaluatorsPort();

            EvaluatorDto evaluatorDto = new EvaluatorDto();
            evaluatorDto.setEvsId(cliente.getEvaluatorById(id).getEvsId());
            evaluatorDto.setEvsWorker(cliente.getEvaluatorById(id).getEvsWorker());
            evaluatorDto.setEvsConnection(cliente.getEvaluatorById(id).getEvsConnection());
            evaluatorDto.setEvsFeedback(cliente.getEvaluatorById(id).getEvsFeedback());
            evaluatorDto.setEvsState(cliente.getEvaluatorById(id).getEvsState());

            return new Respuesta(true, "", "", "Evaluator", evaluatorDto);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error obteniendo el puesto [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el puesto.", "getJob " + ex.getMessage());
        }
    }

    /**
     * Elimina un evaluador llamando al método delete del servicio web SOAP
     * ModuleEvaluators.
     *
     * @param id El identificador del evaluador que se va a eliminar.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta eliminarEvaluator(int id) {
        try {
            ModuleEvaluators_Service servicio = new ModuleEvaluators_Service();
            ModuleEvaluators cliente = servicio.getModuleEvaluatorsPort();
            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error eliminando el evaluador.", ex);
            return new Respuesta(false, "Error eliminando el Evaluador.", "eliminarEvaluador " + ex.getMessage());
        }
    }

    /**
     * Obtiene la información de todos los evaluadores llamando al método
     * getEvaluators del servicio web SOAP ModuleEvaluators.
     *
     * @return Una respuesta que contiene la lista de evaluadores o indica un
     * error.
     */
    public Respuesta getEvaluators() {
        try {
            ModuleEvaluators_Service servicio = new ModuleEvaluators_Service();
            ModuleEvaluators cliente = servicio.getModuleEvaluatorsPort();

            List<EvaluatorsDto> jobsWs = cliente.getEvaluators();
            List<EvaluatorDto> e = new ArrayList<>();
            for (EvaluatorsDto evt : jobsWs) {
                EvaluatorDto es = new EvaluatorDto();
                es.setEvsConnection(evt.getEvsConnection());
                es.setEvsEvaluated(evt.getEvsEvaluated());
                es.setEvsFeedback(evt.getEvsFeedback());
                es.setEvsId(evt.getEvsId());
                es.setEvsState(evt.getEvsState());
                es.setEvsWorker(evt.getEvsWorker());

                e.add(es);
            }

            return new Respuesta(true, "Error obteniendo los evaluadores.", "getEvaluators", "Evaluators", e);
        } catch (Exception ex) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error obteniendo los puestos.", ex);
            return new Respuesta(false, "Error obteniendo los evaluadores.", "getEvaluators" + ex.getMessage());
        }
    }
}
