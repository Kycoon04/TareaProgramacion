package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.Evaluated;
import cr.ac.una.tareaws.model.EvaluatedDto;
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

/**
 * La clase `EvaluatedService` proporciona funciones para gestionar los
 * evaluados en la aplicación, incluyendo búsqueda por identificación, creación,
 * modificación y eliminación de evaluados. También ofrece métodos para obtener
 * una lista de todos los evaluados y buscar evaluados por información
 * relacionada.
 *
 * Esta clase se utiliza para administrar los evaluados, que pueden estar
 * asociados a trabajadores.
 *
 * Autores: - Dilan Sancho - Jose Valverde - Anderson Fernandez
 */
@Stateless
@LocalBean
public class EvaluatedService {

    private static final Logger LOG = Logger.getLogger(EvaluatorService.class.getName());
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Respuesta getEvaluatedById(Integer Id) {
        try {
            Query qryEvaluated = em.createNamedQuery("Evaluated.findByEsId", Evaluated.class);
            qryEvaluated.setParameter("esId", Id);
            return new Respuesta(true, "", "", "Evaluated", qryEvaluated.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Evaluado con las credenciales ingresadas.", "getEvaluated NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(CompetencesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Evaluated.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el Evaluado.", "getEvaluated NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(CompetencesService.class.getName()).log(Level.SEVERE, "Error obteniendo el Evaluado [" + Id + "]", ex);
            return new Respuesta(false, "Error obteniendo el Evaluado.", "getEvaluated " + ex.getMessage());
        }
    }

    public Respuesta SaveEvaluated(EvaluatedDto evaluatedDto) {
        Evaluated evaluated;
        try {
            if (evaluatedDto.getEsId() != null && evaluatedDto.getEsId() > 0) {
                evaluated = em.find(Evaluated.class, evaluatedDto.getEsId());
                if (evaluated == null) {
                    return new Respuesta(false, "No se encrontró el Evaluated a modificar.", "guardarEvaluated NoResultException");
                }
                evaluated.Actualizar(evaluatedDto);
                evaluated = em.merge(evaluated);
            } else {
                evaluated = new Evaluated(evaluatedDto);
                em.persist(evaluated);
            }
            em.flush();
            return new Respuesta(true, "", "", "Evaluated", new EvaluatedDto(evaluated));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Evaluated.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el Evaluated.", "guardarEvaluated " + ex.getMessage());
        }
    }

    public Respuesta DeleteEvaluated(Integer id) {
        try {
            Evaluated evaluated;
            if (id != null && id > 0) {
                evaluated = em.find(Evaluated.class, id);
                if (evaluated == null) {
                    return new Respuesta(false, "No se encrontró el trabajo x Competencia a eliminar.", "eliminarTrabajoxCompetencia NoResultException");
                }
                em.remove(evaluated);
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

    public Respuesta getEvaluated() {
        try {
            Query qryJob = em.createNamedQuery("Evaluated.findAll", Evaluated.class);
            List<Evaluated> evaluated = qryJob.getResultList();
            return new Respuesta(true, "", "", "Evaluated", evaluated);
        } catch (NoResultException ex) {
            return new Respuesta(false, "trabajo x Competencia", "getEvaluated NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo puestos", ex);
            return new Respuesta(false, "Error al obtener trabajo x Competencia", "getEvaluated" + ex.getMessage());
        }
    }

    public Respuesta getEvaluatedByInfomation(Integer worker, Integer proceso) {
        try {
            Query qryEvaluated = em.createNamedQuery("Evaluated.findByEsWorker", Evaluated.class);
            qryEvaluated.setParameter("esWorker", worker);
            qryEvaluated.setParameter("esProceso", proceso);
            return new Respuesta(true, "", "", "Evaluated", qryEvaluated.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Evaluado con las credenciales ingresadas.", "getEvaluated NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(CompetencesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Evaluated.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el Evaluado.", "getEvaluated NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(CompetencesService.class.getName()).log(Level.SEVERE, "Error obteniendo el Evaluado [" + worker + "]", ex);
            return new Respuesta(false, "Error obteniendo el Evaluado.", "getEvaluated " + ex.getMessage());
        }
    }
}
