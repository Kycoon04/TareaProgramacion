package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.Jobs;
import cr.ac.una.tareaws.model.JobsDto;
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
public class JobsService {

    private static final Logger LOG = Logger.getLogger(JobsService.class.getName());

    //TODO
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Respuesta SaveJobs(JobsDto jobsDto) {
        Jobs jobs;
        try {
            if (jobsDto.getId() != null && jobsDto.getId() > 0) {
                jobs = em.find(Jobs.class, jobsDto.getId());
                if (jobs == null) {
                    return new Respuesta(false, "No se encrontró el puesto a modificar.", "SaveJobs NoResultException");
                }
                jobs.Actualizar(jobsDto);
                jobs = em.merge(jobs);
            } else {
                jobs = new Jobs(jobsDto);
                em.persist(jobs);
            }
            em.flush();
            return new Respuesta(true, "", "", "Job", new JobsDto(jobs));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el puesto.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el puesto.", "SaveJobs " + ex.getMessage());
        }
    }

    public Respuesta getJob(String Name) {
        try {
            Query qryJob = em.createNamedQuery("Jobs.findByJsName", Jobs.class);
            qryJob.setParameter("jsName", Name);
            return new Respuesta(true, "", "", "Job", qryJob.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un puesto con las credenciales ingresadas.", "getJob NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el puesto.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el puesto.", "getJob NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el puesto [" + Name + "]", ex);
            return new Respuesta(false, "Error obteniendo el puesto.", "getJob " + ex.getMessage());
        }
    }

    public Respuesta getJobs() {
        try {
            Query qryJob = em.createNamedQuery("Jobs.findAll", Jobs.class);
            List<Jobs> jobs = qryJob.getResultList();
            return new Respuesta(true, "", "", "Jobs", jobs);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No hay puestos en la base", "getJobs NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo puestos", ex);
            return new Respuesta(false, "Error al obtener puestos", "getJobs" + ex.getMessage());
        }
    }

    public Respuesta DeleteJob(Integer id) {
        try {
            Jobs jobs;
            if (id != null && id > 0) {
                jobs = em.find(Jobs.class, id);
                if (jobs == null) {
                    return new Respuesta(false, "No se encrontró el puesto a eliminar.", "eliminarpuesto NoResultException");
                }
                em.remove(jobs);
            } else {
                return new Respuesta(false, "Debe cargar el puesto a eliminar.", "eliminarpuesto NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el puesto porque tiene relaciones con otros registros.", "eliminarpuesto " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el puesto.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el puesto.", "eliminarPuesto " + ex.getMessage());
        }
    }
}
