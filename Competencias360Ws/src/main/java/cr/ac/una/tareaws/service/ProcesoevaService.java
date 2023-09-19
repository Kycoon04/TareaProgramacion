package cr.ac.una.tareaws.service;
import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.model.ProcesoevaDto;
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
public class ProcesoevaService {
     private static final Logger LOG = Logger.getLogger(CompetencesService.class.getName());

    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
        public Respuesta getProceso(String Name) {
        try {
            Query qryProceso = em.createNamedQuery("Procesoeva.findByEnName", Procesoeva.class);
            qryProceso.setParameter("enName", Name);
            return new Respuesta(true, "", "", "Proceso", qryProceso.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Proceso ese nombre.", "getProceso NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Proceso.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el Proceso.", "getProceso NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el Proceso [" + Name + "]", ex);
            return new Respuesta(false, "Error obteniendo el Proceso.", "getProceso " + ex.getMessage());
        }
    }

    public Respuesta getProcesos() {
        try {
            Query qryProceso = em.createNamedQuery("Procesoeva.findAll", Procesoeva.class);
            List<Procesoeva> procesos = qryProceso.getResultList();
            return new Respuesta(true, "", "", "Procesos", procesos);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No hay Procesos en la base", "getProcesos NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo Procesos", ex);
            return new Respuesta(false, "Error al obtener Procesos", "getProcesos" + ex.getMessage());
        }
    }

    public Respuesta SaveProceso(ProcesoevaDto procesoevaDto) {
        Procesoeva procesoeva;
        try {
            if (procesoevaDto.getId() != null && procesoevaDto.getId() > 0) {
                procesoeva = em.find(Procesoeva.class, procesoevaDto.getId());
                if (procesoeva == null) {
                    return new Respuesta(false, "No se encrontró el Proceso a modificar.", "guardarProceso NoResultException");
                }
                procesoeva.Actualizar(procesoevaDto);
                procesoeva = em.merge(procesoeva);
            } else {
                procesoeva = new Procesoeva(procesoevaDto);
                em.persist(procesoeva);
            }
            em.flush();
            return new Respuesta(true, "", "", "Competence", new ProcesoevaDto(procesoeva));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Proceso.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el Proceso.", "guardarProceso " + ex.getMessage());
        }
    }
        public Respuesta DeleteProceso(Integer id) {
        try {
            Procesoeva procesoeva;
            if (id != null && id > 0) {
                procesoeva = em.find(Procesoeva.class, id);
                if (procesoeva == null) {
                    return new Respuesta(false, "No se encrontró el Proceso a eliminar.", "eliminarProceso NoResultException");
                }
                em.remove(procesoeva);
            } else {
                return new Respuesta(false, "Debe cargar el Proceso a eliminar.", "eliminarProceso NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el Proceso porque tiene relaciones con otros registros.", "eliminarProceso " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Proceso.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el Proceso.", "eliminarProceso " + ex.getMessage());
        }
    }
}
