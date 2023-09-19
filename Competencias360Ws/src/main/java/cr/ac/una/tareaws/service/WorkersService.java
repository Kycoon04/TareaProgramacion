package cr.ac.una.tareaws.service;

import cr.ac.una.tareaws.model.Workers;
import cr.ac.una.tareaws.model.WorkersDto;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Stateless
@LocalBean
public class WorkersService {

    private static final Logger LOG = Logger.getLogger(WorkersService.class.getName());

    //TODO
    @PersistenceContext(unitName = "cr.ac.una.tareaws_Competencias360Ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public Respuesta getUsuario(String usuario, String clave) {
        try {
            Query qryUsuario = em.createNamedQuery("Workers.findByUsuarioClave", Workers.class);
            qryUsuario.setParameter("fname", usuario);
            qryUsuario.setParameter("fpassword", clave);
            return new Respuesta(true, "", "", "Usuario", qryUsuario.getSingleResult());
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el usuario.", "getUsuario NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }

    public Respuesta getEmpleado(Long id) {
        try {
            Query qryUsuario = em.createNamedQuery("Empleado.findById", Workers.class);
            qryUsuario.setParameter("id", id);
            WorkersDto workersDto = new WorkersDto((Workers) qryUsuario.getSingleResult());
            return new Respuesta(true, "", "", "Empleado", workersDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un empleado con el código ingresado.", "getEmpleado NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el empleado.", "getEmpleado NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el empleado [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el empleado.", "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta guardarEmpleado(WorkersDto workersDto) {
        Workers worker;
        try {
            if (workersDto.getId() != null && workersDto.getId() > 0) {
                worker = em.find(Workers.class, workersDto.getId());
                if (worker == null) {
                    return new Respuesta(false, "No se encrontró el empleado a modificar.", "guardarEmpleado NoResultException");
                }
                worker.Actualizar(workersDto);
                worker = em.merge(worker);
            } else {
                worker = new Workers(workersDto);
                worker.setWrJob(null);
                em.persist(worker);
            }
            em.flush();
            return new Respuesta(true, "", "", "Empleado", new WorkersDto(worker));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el empleado.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta actualizarPorCodigo(WorkersDto workersDto) {
        Workers worker;
        try {
            if (workersDto.getCode() != null) {
                TypedQuery<Workers> query = em.createNamedQuery("Workers.findByWrCodeactive", Workers.class);
                query.setParameter("wrCodeactive", workersDto.getCode());
                try {
                    worker = query.getSingleResult();
                } catch (NoResultException nre) {
                    return new Respuesta(false, "No se encontró el empleado a modificar.", "actualizarEmpleadoPorNombre NoResultException");
                }
                worker.ActualizarCuentaActivo(workersDto);
                worker = em.merge(worker);
                em.flush();
                return new Respuesta(true, "Empleado Actualizado", "", "Empleado actualizado", new WorkersDto(worker));
            } else {
                return new Respuesta(false, "Codigo invalido para actualización.", "actualizarEmpleadoPorNombre InvalidDataException");
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrió un error al actualizar el empleado.", ex);
            return new Respuesta(false, "Ocurrió un error al actualizar el empleado.", "actualizarEmpleadoPorNombre " + ex.getMessage());
        }
    }

    public Respuesta actualizarContrasenaPorEmail(WorkersDto workersDto) {
        Workers worker;
        try {
            if (workersDto.getEmail() != null || workersDto.getPassword() != null) {
                TypedQuery<Workers> query = em.createNamedQuery("Workers.findByWrEmail", Workers.class);
                query.setParameter("wrEmail", workersDto.getEmail());  // Corregir aquí
                try {
                    worker = query.getSingleResult();
                } catch (NoResultException nre) {
                    return new Respuesta(false, "No se encontró el empleado a modificar.", "actualizarContrasenaPorNombre NoResultException");
                }
                worker.ActualizarContrasena(workersDto);
                worker = em.merge(worker);
                em.flush();
                return new Respuesta(true, "Empleado Actualizado", "", "Empleado actualizado", new WorkersDto(worker));
            } else {
                return new Respuesta(false, "Correo invalido para actualización.", "actualizarContrasenaPorNombre InvalidDataException");
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrió un error al actualizar el empleado.", ex);
            return new Respuesta(false, "Ocurrió un error al actualizar el empleado.", "actualizarContrasenaPorNombre " + ex.getMessage());
        }
    }

    public Respuesta getUsuarios() {

        try {
            Query qryUsuario = em.createNamedQuery("Workers.findAll", Workers.class);
            List<Workers> usuarios = qryUsuario.getResultList();
            return new Respuesta(true, "", "", "Usuarios", usuarios);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No hay usuarios en la base", "getUsuarios NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo usuarios", ex);
            return new Respuesta(false, "Error al obtener usuarios", "getUsuarios" + ex.getMessage());
        }
    }

    public Respuesta isAdmin(String usuario, String clave) {
        Workers worker;
        try {
            Query qryUsuario = em.createNamedQuery("Workers.findByUsuarioClave", Workers.class);
            qryUsuario.setParameter("fname", usuario);
            qryUsuario.setParameter("fpassword", clave);
            worker = (Workers) qryUsuario.getSingleResult();
            if (worker != null) {
                if ("N".equals(worker.getWrAdmin())) {
                    return new Respuesta(false, "No es un usuario administrador.", "getUsuario");
                } else if ("S".equals(worker.getWrAdmin())) {
                    return new Respuesta(true, "", "", "Usuario", worker);
                }
            } else {
                return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario");
            }
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrió un error al consultar el usuario.", ex);
            return new Respuesta(false, "Ocurrió un error al consultar el usuario.", "getUsuario NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
        return new Respuesta(false, "Ocurrió un error inesperado.", "getUsuario");
    }

    public Respuesta isTempPassword(String usuario, String clave) {
        Workers worker;
        try {
            Query qryUsuario = em.createNamedQuery("Workers.findByUsuarioClave", Workers.class);
            qryUsuario.setParameter("fname", usuario);
            qryUsuario.setParameter("fpassword", clave);
            worker = (Workers) qryUsuario.getSingleResult();
            if (worker != null) {
                if ("N".equals(worker.getWrRecover())) {
                    return new Respuesta(false, "No es un usuario con clave temporal.", "getUsuario");
                } else if ("S".equals(worker.getWrRecover())) {
                    return new Respuesta(true, "", "", "Usuario", worker);
                }
            } else {
                return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario");
            }
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrió un error al consultar el usuario.", ex);
            return new Respuesta(false, "Ocurrió un error al consultar el usuario.", "getUsuario NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
        return new Respuesta(false, "Ocurrió un error inesperado.", "getUsuario");
    }

    public Respuesta isIdActiveW(String code) {
        Workers worker;
        try {
            Query qryUsuario = em.createNamedQuery("Workers.findByWrCodeactive", Workers.class);
            qryUsuario.setParameter("wrCodeactive", code);
            worker = (Workers) qryUsuario.getSingleResult();
            if (worker != null) {
                if ("N".equals(worker.getWrActive())) {
                    return new Respuesta(false, "No esta activa.", "getUsuario");
                } else if ("S".equals(worker.getWrActive())) {
                    return new Respuesta(true, "", "", "Usuario", worker);
                }
            } else {
                return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario");
            }
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Ocurrió un error al consultar el usuario.", ex);
            return new Respuesta(false, "Ocurrió un error al consultar el usuario.", "getUsuario NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario con codigo [" + code + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
        return new Respuesta(false, "Ocurrió un error inesperado.", "getUsuario");
    }

    public Respuesta DeleteWorker(Integer id) {
        try {
            Workers worker;
            if (id != null && id > 0) {
                worker = em.find(Workers.class, id);
                if (worker == null) {
                    return new Respuesta(false, "No se encrontró el empleado a eliminar.", "eliminarEmpleado NoResultException");
                }
                em.remove(worker);
            } else {
                return new Respuesta(false, "Debe cargar el empleado a eliminar.", "eliminarEmpleado NoResultException");
            }
            em.flush();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el empleado porque tiene relaciones con otros registros.", "eliminarEmpleado " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el empleado.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el empleado.", "eliminarEmpleado " + ex.getMessage());
        }
    }
}
