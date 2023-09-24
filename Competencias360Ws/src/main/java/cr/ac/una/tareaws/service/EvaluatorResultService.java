package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.EvaluatorResult;
import cr.ac.una.tareaws.model.EvaluatorResultDto;
import cr.ac.una.tareaws.model.Jobs;
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
public class EvaluatorResultService {

    private static final Logger LOG = Logger.getLogger(EvaluatorResultService.class.getName());
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Respuesta getEvaluatorResultById(Integer id) {
        try {
            Query qryEvaluator = em.createNamedQuery("EvaluatorResult.findByErId", EvaluatorResult.class);
            qryEvaluator.setParameter("erId", id);
            return new Respuesta(true, "", "", "EvaluatorResult", qryEvaluator.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un EvaluatorResult con las credenciales ingresadas.", "getEvaluator NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(EvaluatorResultService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el EvaluatorResult.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el EvaluatorResult.", "getEvaluator NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(EvaluatorResultService.class.getName()).log(Level.SEVERE, "Error obteniendo el EvaluatorResult [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el EvaluatorResult.", "getEvaluator " + ex.getMessage());
        }
    }

    public Respuesta getEvaluatorResultByGrade(Integer nota) {
        try {
            Query qryEvaluator = em.createNamedQuery("EvaluatorResult.findByErNota", EvaluatorResult.class);
            qryEvaluator.setParameter("erNota", nota);
            return new Respuesta(true, "", "", "EvaluatorResult", qryEvaluator.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un EvaluatorResult con las credenciales ingresadas.", "getEvaluator NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(EvaluatorResultService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el EvaluatorResult.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el EvaluatorResult.", "getEvaluatoEvaluatorEvaluator NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(EvaluatorResultService.class.getName()).log(Level.SEVERE, "Error obteniendo el EvaluatorResult [" + nota + "]", ex);
            return new Respuesta(false, "Error obteniendo el EvaluatorResult.", "getEvaluator " + ex.getMessage());
        }
    }

    public Respuesta saveEvaluatorResult(EvaluatorResultDto evaluatorResultDto) {
        EvaluatorResult evaluatorResult;
        try {
            if (evaluatorResultDto.getErId() != null && evaluatorResultDto.getErId() > 0) {
                evaluatorResult = em.find(EvaluatorResult.class, evaluatorResultDto.getErId());
                if (evaluatorResult == null) {
                    return new Respuesta(false, "No se encrontró el EvaluatorResult a modificar.", "guardarEvaluatorResult NoResultException");
                }
                evaluatorResult.Actualizar(evaluatorResultDto);
                evaluatorResult = em.merge(evaluatorResult);
            } else {
                evaluatorResult = new EvaluatorResult(evaluatorResultDto);
                em.persist(evaluatorResult);
            }
            em.flush();
            return new Respuesta(true, "", "", "EvaluatorResult", new EvaluatorResultDto(evaluatorResult));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el EvaluatorResult.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el EvaluatorResult.", "guardarEvaluatorResult " + ex.getMessage());
        }
    }

    public Respuesta DeleteEvaluatorResult(Integer id) {
        try {
            EvaluatorResult evaluatorResult;
            if (id != null && id > 0) {
                evaluatorResult = em.find(EvaluatorResult.class, id);
                if (evaluatorResult == null) {
                    return new Respuesta(false, "No se encrontró el resultado del EvaluatorResult a eliminar.", "eliminarEvaluatorResult NoResultException");
                }
                em.remove(evaluatorResult);
            } else {
                return new Respuesta(false, "Debe cargar el resultado del EvaluatorResult a eliminar.", "eliminarEvaluatorResult NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el resultado del EvaluatorResult.", "eliminarEvaluatorResult " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al eliminar el resultado del EvaluatorResult.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el resultado del EvaluatorResult,", "eliminarEvaluatorResult " + ex.getMessage());
        }
    }
    public Respuesta getEvaluators() {
        try {
            Query qryEvaluator = em.createNamedQuery("EvaluatorResult.findAll", EvaluatorResult.class);
            List<EvaluatorResult> evaluator = qryEvaluator.getResultList();
            return new Respuesta(true, "", "", "EvaluatorResult", evaluator);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No hay Evaluato en la base", "getEvaluators NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo Evaluators", ex);
            return new Respuesta(false, "Error al obtener Evaluators", "getEvaluators" + ex.getMessage());
        }
    }
}
