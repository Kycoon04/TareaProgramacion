package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.ComInformationDto;
import cr.ac.una.tareaws.model.Cominformation;
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
 * La clase `CharacteristicService` proporciona funciones para gestionar las características
 * en la aplicación, incluyendo búsqueda, creación, modificación y eliminación de características.
 * También ofrece métodos para buscar características por su identificación o nombre.
 * 
 * Esta clase se utiliza para administrar las características que pueden estar asociadas a empleados
 * u otros elementos dentro de la aplicación.
 * 
 * Autores:
 * - Dilan Sancho
 * - Jose Valverde
 * - Anderson Fernandez
 */
@Stateless
@LocalBean
public class ComInformationService {

    private static final Logger LOG = Logger.getLogger(ComInformationService.class.getName());

    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Respuesta SaveInformation(ComInformationDto comInformationDto) {
        Cominformation comInformation;
        try {
            if (comInformationDto.getId() != null && comInformationDto.getId() > 0) {
                comInformation = em.find(Cominformation.class, comInformationDto.getId());
                if (comInformation == null) {
                    return new Respuesta(false, "No se encrontró el Information a modificar.", "guardarInformation NoResultException");
                }
                comInformation.Actualizar(comInformationDto);
                comInformation = em.merge(comInformation);
            } else {
                comInformation = new Cominformation(comInformationDto);
                em.persist(comInformation);
            }
            em.flush();
            return new Respuesta(true, "", "", "Information", new ComInformationDto(comInformation));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Information.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el Information.", "guardarInformation " + ex.getMessage());
        }
    }

    public Respuesta getInformation(String Name) {
        try {
            Query qryInformation = em.createNamedQuery("Cominformation.findByCpName", Cominformation.class);
            qryInformation.setParameter("cpName", Name);
            return new Respuesta(true, "", "", "Information", qryInformation.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un Information con las credenciales ingresadas.", "getInformation NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(ComInformationService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el Information.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el Information.", "getInformation NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(ComInformationService.class.getName()).log(Level.SEVERE, "Error obteniendo el Information [" + Name + "]", ex);
            return new Respuesta(false, "Error obteniendo el Information.", "getInformation " + ex.getMessage());
        }
    }

    public Respuesta getAllInfo() {
        try {
            Query qryJob = em.createNamedQuery("Cominformation.findAll", Cominformation.class);
            List<Cominformation> cominformation = qryJob.getResultList();
            return new Respuesta(true, "", "", "Cominformation", cominformation);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No hay informacion en la base", "getInformation NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error al obtener informacion", ex);
            return new Respuesta(false, "Error al obtener informacion", "getInformation" + ex.getMessage());
        }
    }

    public Respuesta Delete(Integer id) {
        try {
            Cominformation cominformation;
            if (id != null && id > 0) {
                cominformation = em.find(Cominformation.class, id);
                if (cominformation == null) {
                    return new Respuesta(false, "No se encrontró el information a eliminar.", "eliminarInformation NoResultException");
                }
                em.remove(cominformation);
            } else {
                return new Respuesta(false, "Debe cargar el information a eliminar.", "eliminarInformation NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el information porque tiene relaciones con otros registros.", "eliminarInformation " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el information.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el information.", "eliminarInformation " + ex.getMessage());
        }
    }

}
