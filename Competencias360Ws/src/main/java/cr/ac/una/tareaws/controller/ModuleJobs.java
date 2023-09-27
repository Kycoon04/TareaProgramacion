/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.model.JobsDto;
import cr.ac.una.tareaws.service.JobsService;
import cr.ac.una.tareaws.service.WorkersService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Clase que implementa un servicio web para gestionar los trabajos o empleos.
 * Este servicio proporciona operaciones como registro, obtención por nombre, listado y eliminación de trabajos.
 * Se utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
@WebService(serviceName = "ModuleJobs")
public class ModuleJobs {

    @EJB
    JobsService jobsService;

    /**
     * Registra un trabajo o empleo.
     *
     * @param job Un objeto JobsDto que contiene la información del trabajo a
     * registrar.
     * @return true si la operación de registro fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "RegisterJob")
    public Boolean RegisterJob(JobsDto job) {
        Respuesta respuesta = jobsService.SaveJobs(job);
        return respuesta.getEstado();
    }

    /**
     * Obtiene un trabajo por su nombre.
     *
     * @param Name El nombre del trabajo que se desea obtener.
     * @return Un objeto JobsDto que representa al trabajo.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getJob")
    public JobsDto getJob(@WebParam(name = "Name") String Name) throws IOException {
        Respuesta respuesta = jobsService.getJob(Name);
        JobsDto jobDto = new JobsDto((Jobs) respuesta.getResultado("Job"));
        return jobDto;
    }

    /**
     * Obtiene una lista de todos los trabajos disponibles.
     *
     * @return Una lista de objetos JobsDto que representan a los trabajos.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetJobs")
    public List<JobsDto> GetJobs() throws IOException {
        Respuesta respuesta = jobsService.getJobs();
        List<Jobs> jobs = (List<Jobs>) respuesta.getResultado("Jobs");
        List<JobsDto> jobsDto = new ArrayList<>();
        for (Jobs j : jobs) {
            JobsDto jobDto = new JobsDto(j);
            jobsDto.add(jobDto);
        }
        return jobsDto;
    }

    /**
     * Elimina un trabajo por su ID.
     *
     * @param id El ID del trabajo a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = jobsService.DeleteJob(id);
        return respuesta.getEstado();
    }
}
