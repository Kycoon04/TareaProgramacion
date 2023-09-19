package cr.ac.una.tareaws.controller;

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

@WebService(serviceName = "ModuleCompetences")
public class ModuleCompetences {

    @EJB
    CompetencesService competencesService;

    @WebMethod(operationName = "RegisterCompetences")
    public Boolean RegisterCompetences(CompetencesDto competencesDto) {
        Respuesta respuesta = competencesService.SaveCompetences(competencesDto);
        return respuesta.getEstado();
    }

    @WebMethod(operationName = "GetCompetence")
    public CompetencesDto GetCompetence(@WebParam(name = "Name") String Name) throws IOException {
        Respuesta respuesta = competencesService.getCompetence(Name);
        CompetencesDto competencesDto = new CompetencesDto((Competences) respuesta.getResultado("Competence"));
        return competencesDto;
    }

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

    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = competencesService.Delete(id);
        return respuesta.getEstado();
    }
}
