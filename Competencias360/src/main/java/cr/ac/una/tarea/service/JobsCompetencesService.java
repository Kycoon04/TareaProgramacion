/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.EvaJobCompetenceDto;
import cr.ac.una.tarea.soap.JobsCompetencesDto;
import cr.ac.una.tarea.soap.ModuleJobsCompetences;
import cr.ac.una.tarea.soap.ModuleJobsCompetences_Service;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase proporciona servicios relacionados con las competencias de los
 * trabajos, incluyendo guardar, obtener, obtener por ID y eliminar competencias
 * utilizando un servicio web SOAP (ModuleJobsCompetences).
 *
 * @author dilan
 */
public class JobsCompetencesService {

    /**
     * Guarda la información de las competencias de un trabajo llamando al
     * método registerJobCompetences del servicio web SOAP
     * ModuleJobsCompetences.
     *
     * @param evaJobCompetenceDto El objeto de transferencia de datos que
     * contiene la información de las competencias del trabajo.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta SaveJobCompetences(EvaJobCompetenceDto evaJobCompetenceDto) {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();

            JobsCompetencesDto jobCompetencesDto = new JobsCompetencesDto();
            jobCompetencesDto.setJobs(evaJobCompetenceDto.getJobs());
            jobCompetencesDto.setJxcCompetence(evaJobCompetenceDto.getJxcCompetence());

            cliente.registerJobCompetences(jobCompetencesDto);
            return new Respuesta(true, "", "", "Competencia", jobCompetencesDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error guardando las comptencias.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarCompetencias " + ex.getMessage());
        }
    }

    /**
     * Obtiene la información de las competencias de un trabajo por ID llamando
     * al método getJobCompetenceId del servicio web SOAP ModuleJobsCompetences.
     *
     * @param id El identificador de las competencias del trabajo.
     * @return Una respuesta que contiene la información de las competencias del
     * trabajo o indica un error.
     */
    public Respuesta getJobCompetence(int id) {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();

            JobsCompetencesDto jobCompetencesDto = new JobsCompetencesDto();
            jobCompetencesDto.setJxcIdcojob(cliente.getJobCompetenceId(id).getJxcIdcojob());
            jobCompetencesDto.setJobs(cliente.getJobCompetenceId(id).getJobs());
            jobCompetencesDto.setJxcJob(cliente.getJobCompetenceId(id).getJxcJob());
            jobCompetencesDto.setJxcCompetence(cliente.getJobCompetenceId(id).getJxcCompetence());

            return new Respuesta(true, "", "", "JobsCompetences", jobCompetencesDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo la competencias del trabaj [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo la competencias del trabajo.", "getJob " + ex.getMessage());
        }
    }

    /**
     * Obtiene la información de todas las competencias de los trabajos llamando
     * al método getJobCompetences del servicio web SOAP ModuleJobsCompetences.
     *
     * @return Una respuesta que contiene la lista de competencias de los
     * trabajos o indica un error.
     */
    public Respuesta getjCompetences() {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();

            List<JobsCompetencesDto> cs = cliente.getJobCompetences();
            List<EvaJobCompetenceDto> csJ = new ArrayList<>();
            for (JobsCompetencesDto comjob : cs) {
                EvaJobCompetenceDto evaComJo = new EvaJobCompetenceDto();
                evaComJo.setEvaJobs(comjob.getJobs());
                evaComJo.setJxcCompetence(comjob.getJxcCompetence());
                evaComJo.setJxcIdcojob(comjob.getJxcIdcojob());
                csJ.add(evaComJo);
            }
            return new Respuesta(true, "Error obteniendo las competencias de los trabajos.", "getJobsCompetences", "JobsCompetences", csJ);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo las competencias de los trabajos.", ex);
            return new Respuesta(false, "Error obteniendo las competencias de los trabajos.", "getJobsCompetences" + ex.getMessage());
        }
    }

    /**
     * Elimina las competencias de un trabajo por ID llamando al método delete
     * del servicio web SOAP ModuleJobsCompetences.
     *
     * @param id El identificador de las competencias del trabajo que se van a
     * eliminar.
     * @return Una respuesta que indica el éxito o fracaso de la operación.
     */
    public Respuesta eliminjCompetences(int id) {
        try {
            ModuleJobsCompetences_Service servicio = new ModuleJobsCompetences_Service();
            ModuleJobsCompetences cliente = servicio.getModuleJobsCompetencesPort();

            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error eliminando las competencias del trabajo.", ex);
            return new Respuesta(false, "\"Error eliminando las competencias del trabajo.", "eliminarJcompetence " + ex.getMessage());
        }
    }

}
