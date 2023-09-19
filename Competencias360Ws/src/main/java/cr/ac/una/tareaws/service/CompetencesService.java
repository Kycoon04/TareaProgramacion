package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.Competences;
import cr.ac.una.tareaws.model.CompetencesDto;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class CompetencesService {

    private static final Logger LOG = Logger.getLogger(CompetencesService.class.getName());

    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Respuesta getCompetence(String Name) {
        try {
            Query qryCompetence = em.createNamedQuery("Competences.findByCsName", Competences.class);
            qryCompetence.setParameter("csName", Name);
            return new Respuesta(true, "", "", "Competence", qryCompetence.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Competence con las credenciales ingresadas.", "getCompetence NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(CompetencesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Competence.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el Competence.", "getCompetence NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(CompetencesService.class.getName()).log(Level.SEVERE, "Error obteniendo el Competence [" + Name + "]", ex);
            return new Respuesta(false, "Error obteniendo el Competence.", "getCompetence " + ex.getMessage());
        }
    }

    public Respuesta getCompetences() {
        try {
            Query qryCompetence = em.createNamedQuery("Competences.findAll", Competences.class);
            List<Competences> competencias = qryCompetence.getResultList();
            return new Respuesta(true, "", "", "Competences", competencias);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No hay Competences en la base", "getCompetences NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(CompetencesService.class.getName()).log(Level.SEVERE, "Error obteniendo competences", ex);
            return new Respuesta(false, "Error al obtener Competences", "getCompetences" + ex.getMessage());
        }
    }

    public Respuesta SaveCompetences(CompetencesDto competencesDto) {
        Competences competences;
        try {
            if (competencesDto.getId() != null && competencesDto.getId() > 0) {
                competences = em.find(Competences.class, competencesDto.getId());
                if (competences == null) {
                    return new Respuesta(false, "No se encrontró el empleado a modificar.", "guardarEmpleado NoResultException");
                }
                competences.Actualizar(competencesDto);
                competences = em.merge(competences);
            } else {
                competences = new Competences(competencesDto);
                em.persist(competences);
            }
            em.flush();
            return new Respuesta(true, "", "", "Competence", new CompetencesDto(competences));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el empleado.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta Delete(Integer id) {
        try {
            Competences competences;
            if (id != null && id > 0) {
                competences = em.find(Competences.class, id);
                if (competences == null) {
                    return new Respuesta(false, "No se encrontró el trabajo x Competencia a eliminar.", "eliminarTrabajoxCompetencia NoResultException");
                }
                em.remove(competences);
            } else {
                return new Respuesta(false, "Debe cargar el trabajo x Competencia a eliminar.", "eliminarTrabajoxCompetencia NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el trabajo x Competencia porque tiene relaciones con otros registros.", "eliminarTrabajoxCompetencia " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el trabajo x Competencia.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el trabajo x Competencia.", "eliminarTrabajoxCompetencia " + ex.getMessage());
        }
    }

}
