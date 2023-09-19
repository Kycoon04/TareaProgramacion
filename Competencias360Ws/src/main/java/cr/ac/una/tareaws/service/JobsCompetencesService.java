package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.JobsCompetences;
import cr.ac.una.tareaws.model.JobsCompetencesDto;
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
public class JobsCompetencesService {

    private static final Logger LOG = Logger.getLogger(JobsCompetencesService.class.getName());
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Respuesta getJobCompetencesID(Integer idJobComp) {
        try {
            Query qryJob = em.createNamedQuery("JobsCompetences.findByJxcIdcojob", JobsCompetences.class);
            qryJob.setParameter("jxcIdcojob", idJobComp);
            return new Respuesta(true, "", "", "JobsCompetences", qryJob.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe una competencia con las credenciales ingresadas.", "getCompetencesJob NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(JobsCompetencesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar las competencias del puesto.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar las competencias del puesto.", "getCompetencesJob NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(JobsCompetencesService.class.getName()).log(Level.SEVERE, "Error obteniendo el Las competencias del trabajo [" + idJobComp + "]", ex);
            return new Respuesta(false, "Error obteniendo el Las competencias del puesto.", "getCompetencesJob " + ex.getMessage());
        }
    }

    public Respuesta getJobCompetencesJoID(Integer idJob) {
        try {
            Query qryJob = em.createNamedQuery("JobsCompetences.findByJxcJob", JobsCompetences.class);
            qryJob.setParameter("jxcJob", idJob);
            return new Respuesta(true, "", "", "JobCompetences", qryJob.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe una competencia con las credenciales ingresadas.", "getCompetencesJob NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrio un error obteniendo las competencias..", ex);
            return new Respuesta(false, "Ocurrio un error al consultar las competencias del puesto.", "getCompetencesJob NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo las competencias. [" + idJob + "]", ex);
            return new Respuesta(false, "Error obteniendo las competencias.", "getCompetencesJob " + ex.getMessage());
        }
    }

    public Respuesta SaveJobCompetences(JobsCompetencesDto jobsCompetencesDto) {
        JobsCompetences jobsCompetences;
        try {
            if (jobsCompetencesDto.getJxcIdcojob() != null && jobsCompetencesDto.getJxcIdcojob() > 0) {
                jobsCompetences = em.find(JobsCompetences.class, jobsCompetencesDto.getJxcIdcojob());
                if (jobsCompetences == null) {
                    return new Respuesta(false, "No existe una competencia con las credenciales ingresadas..", "guardarCompetencesJob NoResultException");
                }
                jobsCompetences.Actualizar(jobsCompetencesDto);
                jobsCompetences = em.merge(jobsCompetences);
            } else {
                jobsCompetences = new JobsCompetences(jobsCompetencesDto);
                em.persist(jobsCompetences);
            }
            em.flush();
            return new Respuesta(true, "", "", "JobCompetences", new JobsCompetencesDto(jobsCompetences));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la competencia.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar la competencia.", "guardarCompetencesJob " + ex.getMessage());
        }
    }

    public Respuesta getJobsCompetences() {
        try {
            Query qryJob = em.createNamedQuery("JobsCompetences.findAll", JobsCompetences.class);
            List<JobsCompetences> jobCompetences = qryJob.getResultList();
            return new Respuesta(true, "", "", "Jobs", jobCompetences);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No hay competencias en el puesto", "getjobsCompetences NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo puestos", ex);
            return new Respuesta(false, "Error al obtener competencias", "getjobsCompetences" + ex.getMessage());
        }
    }

    public Respuesta DeleteJobsCompetences(Integer id) {
        try {
            JobsCompetences jobsCompetences;
            if (id != null && id > 0) {
                jobsCompetences = em.find(JobsCompetences.class, id);
                if (jobsCompetences == null) {
                    return new Respuesta(false, "No se encrontró el trabajo x Competencia a eliminar.", "eliminarTrabajoxCompetencia NoResultException");
                }
                em.remove(jobsCompetences);
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
