package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.Evaluators;
import cr.ac.una.tareaws.model.EvaluatorsDto;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class EvaluatorService {
    
    private static final Logger LOG = Logger.getLogger(EvaluatorService.class.getName());
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

   
    public Respuesta getEvaluatorByID(Integer id) {
        try {
            Query qryEvaluador = em.createNamedQuery("Evaluators.findByEvsId", Evaluators.class);
            qryEvaluador.setParameter("evsId", id);
            return new Respuesta(true, "", "", "Evaluators", qryEvaluador.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Evaluador con las credenciales ingresadas.", "getEvaluators NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(EvaluatorService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Evaluador.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el evaluador.", "getEvaluador NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(EvaluatorService.class.getName()).log(Level.SEVERE, "Error obteniendo el Evaluador [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el evaluador.", "getEvaluators " + ex.getMessage());
        }
    } 
    
     public Respuesta getEvaluatorByState(String state) {
        try {
            Query qryEvaluador = em.createNamedQuery("Evaluators.findByEvsState", Evaluators.class);
            qryEvaluador.setParameter("evsState", state);
            return new Respuesta(true, "", "", "Evaluators", qryEvaluador.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Evaluador con las credenciales ingresadas.", "getEvaluators NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(EvaluatorService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Evaluador.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el Evaluador.", "getEvaluador NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(EvaluatorService.class.getName()).log(Level.SEVERE, "Error obteniendo el Evaluador [" + state + "]", ex);
            return new Respuesta(false, "Error obteniendo el Evaluador.", "getEvaluators " + ex.getMessage());
        }
    }

     public Respuesta getEvaluatorByFeedBack(String FeedBack) {
        try {
            Query qryEvaluador = em.createNamedQuery("Evaluators.findByEvsFeedback", Evaluators.class);
            qryEvaluador.setParameter("evsFeedback", FeedBack);
            return new Respuesta(true, "", "", "Evaluators", qryEvaluador.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Evaluador con las credenciales ingresadas.", "getEvaluators NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(EvaluatorService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Evaluador.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el Evaluador.", "getEvaluador NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(EvaluatorService.class.getName()).log(Level.SEVERE, "Error obteniendo el Evaluador [" + FeedBack + "]", ex);
            return new Respuesta(false, "Error obteniendo el EvaluatorEvaluatorEvaluador.", "getEvaluators " + ex.getMessage());
        }
    }
     
  
 public Respuesta SaveEvaluator(EvaluatorsDto evaluatorsDto) {
        Evaluators evaluators;
        try {
            if (evaluatorsDto.getEvsId() != null && evaluatorsDto.getEvsId() > 0) {
                evaluators = em.find(Evaluators.class, evaluatorsDto.getEvsId());
                if (evaluators == null) {
                    return new Respuesta(false, "No se encrontró la Evaluacion.", "Guardar Evaluacion NoResultException");
                }
                evaluators.Actualizar(evaluatorsDto);
                evaluators = em.merge(evaluators);
            } else {
                evaluators = new Evaluators(evaluatorsDto);
                em.persist(evaluators);
            }
            em.flush();
            return new Respuesta(true, "", "", "Evaluator", new EvaluatorsDto(evaluators));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el evaluador.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el evaluador.", "guardarEvaluacion " + ex.getMessage());
        }
    }
    public Respuesta DeleteEvaluator(Integer id) {
        try {
            Evaluators evaluators;
            if (id != null && id > 0) {
                evaluators = em.find(Evaluators.class, id);
                if (evaluators == null) {
                    return new Respuesta(false, "No se encrontró el evaluador a eliminar.", "eliminarEvaluador NoResultException");
                }
                em.remove(evaluators);
            } else {
                return new Respuesta(false, "Debe cargar el evaluador a eliminar.", "eliminarEvaluador NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el evaluador porque tiene relaciones con otros registros.", "eliminarEvaluador " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al eliminar el evaluador.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el evaluador.", "eliminarEvaluador " + ex.getMessage());
        }
    }
}
