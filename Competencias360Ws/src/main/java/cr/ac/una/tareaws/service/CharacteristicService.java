package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.Characteristic;
import cr.ac.una.tareaws.model.CharacteristicDto;
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
public class CharacteristicService {
    
    private static final Logger LOG = Logger.getLogger(CharacteristicService.class.getName());
  
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public Respuesta getCharById(Integer id) {
        try {
            Query qryJob = em.createNamedQuery("Characteristic.findByCcId", Characteristic.class);
            qryJob.setParameter("ccId", id);
            return new Respuesta(true, "", "", "Characteristic", qryJob.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe Caracteristicas con este Id.", "getCharacteristic NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(CharacteristicService.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener la caracteristica.", ex);
            return new Respuesta(false, "Ocurrio un error al obtener la caracteristica.", "getCharacteristic NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(CharacteristicService.class.getName()).log(Level.SEVERE, "error al obtener la caracteristica [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo la caracteristica", "getCharacteristic " + ex.getMessage());
        }
    }
    
    public Respuesta getCharByName(String name) {
        try {
            Query qryJob = em.createNamedQuery("Characteristic.findByCcName", Characteristic.class);
            qryJob.setParameter("ccName", name);
            return new Respuesta(true, "", "", "Characteristic", qryJob.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe Caracteristicas con ese nombres.", "getCharacteristic NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(CharacteristicService.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener la caracteristica.", ex);
            return new Respuesta(false, "Ocurrio un error al obtener la caracteristica.", "getCharacteristic NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(CharacteristicService.class.getName()).log(Level.SEVERE, " error al obtener la caracteristica [" + name + "]", ex);
            return new Respuesta(false, "Error obteniendo la caracteristica.", "getCharacteristic " + ex.getMessage());
        }
    }
     
    public Respuesta SaveCharacteristic(CharacteristicDto characteristicDto) {
        Characteristic characteristic;
        try {
            if (characteristicDto.getCcId() != null && characteristicDto.getCcId() > 0) {
                characteristic = em.find(Characteristic.class, characteristicDto.getCcId());
                if (characteristic == null) {
                    return new Respuesta(false, "No se encrontró el characteristic a modificar.", "guardarcharacteristic NoResultException");
                }
                characteristic.Actualizar(characteristicDto);
                characteristic = em.merge(characteristic);
            } else {
                characteristic = new Characteristic(characteristicDto);
                em.persist(characteristic);
            }
            em.flush();
            return new Respuesta(true, "", "", "Characteristic", new CharacteristicDto(characteristic));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el characteristic.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el characteristic.", "guardarcharacteristic " + ex.getMessage());
        }
    }
    
      public Respuesta Delete(Integer id) {
        try {
            Characteristic characteristic;
            if (id != null && id > 0) {
                characteristic = em.find(Characteristic.class, id);
                if (characteristic == null) {
                    return new Respuesta(false, "No se encrontró el characteristic a eliminar.", "eliminarTrabajoxCompetencia NoResultException");
                }
                em.remove(characteristic);
            } else {
                return new Respuesta(false, "Debe cargar el characteristic a eliminar.", "eliminarTrabajoxCompetencia NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el characteristic porque tiene relaciones con otros registros.", "eliminarTrabajoxCompetencia " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el characteristic.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el characteristic.", "eliminarTrabajoxCompetencia " + ex.getMessage());
        }
    }
      
}
