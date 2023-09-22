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
import cr.ac.una.tarea.soap.Procesoeva;
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

    //hacer
    public Respuesta getJobCompetence(int id) {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();

            JobsCompetencesDto jobCompetencesDto = new JobsCompetencesDto();
            jobCompetencesDto.setJxcIdcojob(cliente.getJobCompetenceId(id).getJxcIdcojob());
            jobCompetencesDto.setJxcJob(cliente.getJobCompetenceId(id).getJxcJob());
            jobCompetencesDto.setJxcCompetence(cliente.getJobCompetenceId(id).getJxcCompetence());

            return new Respuesta(true, "", "", "Job", jobCompetencesDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo las competencias por trabajo [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo las competencias del trabajo.", "getJobCompetence " + ex.getMessage());
        }
    }

    public Respuesta getJobsCompetences() {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();

            List<JobsCompetencesDto> listCom = cliente.getJobCompetences();
            List<EvaJobCompetenceDto> jcs = new ArrayList<>();
            for (JobsCompetencesDto cj : listCom) {
                EvaJobCompetenceDto competencesJob = new EvaJobCompetenceDto();
                competencesJob.setEvaJobs(cj.getJobs());
                competencesJob.setJxcCompetence(cj.getJxcCompetence());
                competencesJob.setJxcJob(cj.getJxcJob());
                competencesJob.setJxcIdcojob(cj.getJxcIdcojob());

                jcs.add(competencesJob);
            }
            return new Respuesta(true, "Error obteniendo las competencias de los trabajos.", "getJobCompetences", "JobCompetences", jcs);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo las competencias de los trabajos .", ex);
            return new Respuesta(false, "Error obteniendo las competencias.", "getJobCompetences" + ex.getMessage());
        }
    }
}
