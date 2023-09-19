package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.Result;
import cr.ac.una.tareaws.model.ResultDto;
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
public class ResultService {
    
    private static final Logger LOG = Logger.getLogger(ResultService.class.getName());
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public Respuesta getResultById(Integer id) {
        try {
            Query qryResult = em.createNamedQuery("Result.findByRsId", Result.class);
            qryResult.setParameter("rsId", id);
            return new Respuesta(true, "", "", "Result", qryResult.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un resultado con las credenciales ingresadas.", "getResultById NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(ResultService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el resultado.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el resultado.", "getResultById NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(ResultService.class.getName()).log(Level.SEVERE, "Error obteniendo el resultado [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el resultado.", "getResultById " + ex.getMessage());
        }
    }
    
    public Respuesta getResultByName(Integer nota) {
        try {
            Query qryResult = em.createNamedQuery("Result.findByRsNota", Result.class);
            qryResult.setParameter("rsNota", nota);
            return new Respuesta(true, "", "", "Result", qryResult.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un resultado con las credenciales ingresadas.", "getResultByName NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(JobsCompetencesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el resultado.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el resultado.", "getResultByName NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(JobsCompetencesService.class.getName()).log(Level.SEVERE, "Error obteniendo el resultado [" + nota + "]", ex);
            return new Respuesta(false, "Error obteniendo el resultado.", "getResultByName " + ex.getMessage());
        }
    }
    
        public Respuesta DeleteResult(Integer id) {
        try {
            Result result;
            if (id != null && id > 0) {
                result = em.find(Result.class, id);
                if (result == null) {
                    return new Respuesta(false, "No se encrontró el resultado a eliminar.", "DeleteResult NoResultException");
                }
                em.remove(result);
            } else {
                return new Respuesta(false, "Debe cargar el resultado a eliminar.", "DeleteResult NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el resultado porque tiene relaciones con otros registros.", "eliminarResultado " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el resultado.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el Resultado.", "eliminarResultado " + ex.getMessage());
        }
    }
        
          
    public Respuesta SaveResult(ResultDto resultDto) {
        Result result;
        try {
            if (resultDto.getRsId() != null && resultDto.getRsId() > 0) {
                result = em.find(Result.class, resultDto.getRsId());
                if (result == null) {
                    return new Respuesta(false, "No se encrontró el resultado a modificar.", "SaveResult NoResultException");
                }
                result.Actualizar(resultDto);
                result = em.merge(result);
            } else {
                result = new Result(resultDto);
                em.persist(result);
            }
            em.flush();
            return new Respuesta(true, "", "", "Competence", new ResultDto(result));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el resultado.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el resultado.", "SaveResult " + ex.getMessage());
        }
    }
    
}
