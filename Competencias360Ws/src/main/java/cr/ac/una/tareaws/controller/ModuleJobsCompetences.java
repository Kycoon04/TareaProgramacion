/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.EvaluatedDto;
import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.model.JobsCompetences;
import cr.ac.una.tareaws.model.JobsCompetencesDto;
import cr.ac.una.tareaws.model.JobsDto;
import cr.ac.una.tareaws.service.JobsCompetencesService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dilan
 */
/**
 * Clase que implementa un servicio web para gestionar las competencias de los
 * trabajos o empleos. Este servicio proporciona operaciones como registro,
 * obtención por ID de competencia asociado, obtención por ID de tabla, listado
 * y eliminación de competencias de trabajos. Se utiliza anotaciones JAX-WS para
 * exponer los métodos como operaciones web.
 */
@WebService(serviceName = "ModuleJobsCompetences")
public class ModuleJobsCompetences {

    /*
    findByJxcIdcojob findByJxcJob
     */
    @EJB
    JobsCompetencesService jobsCompetencesService;

    /**
     * Obtiene una competencia de trabajo por su ID de competencia asociado.
     *
     * @param id El ID de la competencia asociado a la competencia de trabajo
     * que se desea obtener.
     * @return Un objeto JobsCompetencesDto que representa la competencia de
     * trabajo.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getJobCompetenceId")
    public JobsCompetencesDto getJobCompetenceId(@WebParam(name = "id") Integer id) throws IOException {
        Respuesta respuesta = jobsCompetencesService.getJobCompetencesID(id);
        JobsCompetencesDto jobDto = new JobsCompetencesDto((JobsCompetences) respuesta.getResultado("JobCompetences"));
        return jobDto;
    }

    /**
     * Obtiene una competencia de trabajo por su ID de tabla.
     *
     * @param idJobC El ID de la tabla de competencias de trabajo que se desea
     * obtener.
     * @return Un objeto JobsCompetencesDto que representa la competencia de
     * trabajo.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getJobCompetenceIDJob")
    public JobsCompetencesDto getJobCompetenceIDJob(@WebParam(name = "idJobC") Integer idJobC) throws IOException {
        Respuesta respuesta = jobsCompetencesService.getJobCompetencesJoID(idJobC);
        JobsCompetencesDto jobDto = new JobsCompetencesDto((JobsCompetences) respuesta.getResultado("JobCompetences"));
        return jobDto;
    }

    /**
     * Registra una competencia de trabajo.
     *
     * @param jobsCompetencesDto Un objeto JobsCompetencesDto que contiene la
     * información de la competencia de trabajo a registrar.
     * @return true si la operación de registro fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "RegisterJobCompetences")
    public Boolean RegisterJobCompetences(JobsCompetencesDto jobsCompetencesDto) {
        Respuesta respuesta = jobsCompetencesService.SaveJobCompetences(jobsCompetencesDto);
        return respuesta.getEstado();
    }

    /**
     * Obtiene una lista de todas las competencias de trabajo disponibles.
     *
     * @return Una lista de objetos JobsCompetencesDto que representan las
     * competencias de trabajo.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetJobCompetences")
    public List<JobsCompetencesDto> GetJobCompetences() throws IOException {
        Respuesta respuesta = jobsCompetencesService.getJobsCompetences();
        List<JobsCompetences> jobsCompetences = (List<JobsCompetences>) respuesta.getResultado("JobsCompetences");
        List<JobsCompetencesDto> jobsCompetencesDto = new ArrayList<>();

        for (JobsCompetences j : jobsCompetences) {
            JobsCompetencesDto jobsCompetenceDto = new JobsCompetencesDto(j);
            jobsCompetencesDto.add(jobsCompetenceDto);
        }
        return jobsCompetencesDto;
    }

    /**
     * Elimina una competencia de trabajo por su ID.
     *
     * @param id El ID de la competencia de trabajo a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = jobsCompetencesService.DeleteJobsCompetences(id);
        return respuesta.getEstado();
    }
}
