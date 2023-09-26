package cr.ac.una.tareaws.controller;
/*
 * Esta clase define un servicio web llamado ModuleCompetences que proporciona operaciones relacionadas con las competencias.
 * Utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
import cr.ac.una.tareaws.model.Competences;
import cr.ac.una.tareaws.model.CompetencesDto;
import cr.ac.una.tareaws.service.CompetencesService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa un servicio web para gestionar competencias.
 * Este servicio proporciona operaciones como registro, obtención, eliminación y listado de competencias.
 * Se utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
@WebService(serviceName = "ModuleCompetences")
public class ModuleCompetences {

    @EJB
    CompetencesService competencesService;

    
    /**
     * Registra una competencia.
     * @param competencesDto Un objeto CompetencesDto que contiene la competencia a registrar.
     * @return true si la operación de registro fue exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "RegisterCompetences")
    public Boolean RegisterCompetences(CompetencesDto competencesDto) {
        Respuesta respuesta = competencesService.SaveCompetences(competencesDto);
        return respuesta.getEstado();
    }

    /**
     * Obtiene una competencia por nombre.
     * @param Name El nombre de la competencia que se desea obtener.
     * @return Un objeto CompetencesDto que representa la competencia.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetCompetence")
    public CompetencesDto GetCompetence(@WebParam(name = "Name") String Name) throws IOException {
        Respuesta respuesta = competencesService.getCompetence(Name);
        CompetencesDto competencesDto = new CompetencesDto((Competences) respuesta.getResultado("Competence"));
        return competencesDto;
    }
   
    /**
     * Obtiene una lista de todas las competencias disponibles.
     * @return Una lista de objetos CompetencesDto que representan las competencias.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetCompetences")
    public List<CompetencesDto> GetCompetences() throws IOException {
        Respuesta respuesta = competencesService.getCompetences();
        List<Competences> competences = (List<Competences>) respuesta.getResultado("Competences");
        List<CompetencesDto> competencesDto = new ArrayList<>();
        for (Competences c : competences) {
            CompetencesDto competenceDto = new CompetencesDto(c);
            competencesDto.add(competenceDto);
        }
        return competencesDto;
    }
    
    /**
     * Elimina una competencia por ID.
     * @param id El ID de la competencia a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = competencesService.Delete(id);
        return respuesta.getEstado();
    }
}
