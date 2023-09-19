/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.WorkerDto;
import cr.ac.una.tarea.soap.ModuleWorkers;
import cr.ac.una.tarea.soap.ModuleWorkers_Service;
import cr.ac.una.tarea.soap.WorkersDto;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jomav
 */
public class WorkersService {

    public Respuesta getUsuario(String usuario, String clave) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();
            return new Respuesta(cliente.login(usuario, clave), "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }

    public Respuesta getEmpleado(String usuario, String clave) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();

            WorkerDto workerDto = new WorkerDto();
            workerDto.setId(cliente.getUsuario(usuario, clave).getId());
            workerDto.setJob(cliente.getUsuario(usuario, clave).getJob());
            workerDto.setRecover(cliente.getUsuario(usuario, clave).getRecover());
            workerDto.setActive(cliente.getUsuario(usuario, clave).getActive());
            workerDto.setAdministrator(cliente.getUsuario(usuario, clave).getAdministrator());
            workerDto.setEmail(cliente.getUsuario(usuario, clave).getEmail());
            workerDto.setIdentification(cliente.getUsuario(usuario, clave).getIdentification());
            workerDto.setLandline(cliente.getUsuario(usuario, clave).getLandline());
            workerDto.setName(cliente.getUsuario(usuario, clave).getName());
            workerDto.setPassword(cliente.getUsuario(usuario, clave).getPassword());
            workerDto.setPsurname(cliente.getUsuario(usuario, clave).getPsurname());
            workerDto.setSsurname(cliente.getUsuario(usuario, clave).getSsurname());
            workerDto.setTelephone(cliente.getUsuario(usuario, clave).getTelephone());
            workerDto.setUsername(cliente.getUsuario(usuario, clave).getUsername());
            return new Respuesta(true, "", "", "Usuario", workerDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }

    public Respuesta getEmpleados(String cedula, String nombre, String pApellido) {
        try {
            // TODO
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo empleados.", ex);
            return new Respuesta(false, "Error obteniendo empleados.", "getEmpleados " + ex.getMessage());
        }
    }

    public Respuesta guardarEmpleado(WorkerDto workerDto) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();
            WorkersDto worker = new WorkersDto();
            worker.setCode(workerDto.getCode());
            worker.setId(workerDto.getId());
            worker.setJob(workerDto.getJob());
            worker.setRecover(workerDto.getRecover());
            worker.setActive(workerDto.getActive());
            worker.setAdministrator(workerDto.getAdministrator());
            worker.setEmail(workerDto.getEmail());
            worker.setPhoto(workerDto.getPhoto());
            worker.setIdentification(workerDto.getIden());
            worker.setLandline(workerDto.getLandline());
            worker.setName(workerDto.getName());
            worker.setPassword(workerDto.getPassword());
            worker.setPsurname(workerDto.getPsurname());
            worker.setSsurname(workerDto.getSsurname());
            worker.setTelephone(workerDto.getTelephone());
            worker.setUsername(workerDto.getUsername());
            cliente.register(worker);
            return new Respuesta(true, "", "", "Empleado", workerDto);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta eliminarEmpleado(int id) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();
            cliente.delete(id);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error eliminando el empleado.", ex);
            return new Respuesta(false, "Error eliminando el empleado.", "eliminarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta TempPassword(String email, String password) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();
            cliente.resetAccontPassword(email, password);
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuarop[" + email + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }

    public Respuesta getUsuarios() {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();
            List<WorkersDto> workersWs = cliente.getUsuarios();
            List<WorkerDto> workers = new ArrayList<>();
            for (WorkersDto user : workersWs) {
                WorkerDto workerDto = new WorkerDto();
                workerDto.setPhoto(user.getPhoto());
                workerDto.setId(user.getId());
                workerDto.setJob(user.getJob());
                workerDto.setRecover(user.getRecover());
                workerDto.setActive(user.getActive());
                workerDto.setAdministrator(user.getAdministrator());
                workerDto.setEmail(user.getEmail());
                workerDto.setIdentification(user.getIdentification());
                workerDto.setLandline(user.getLandline());
                workerDto.setName(user.getName());
                workerDto.setPassword(user.getPassword());
                workerDto.setPsurname(user.getPsurname());
                workerDto.setSsurname(user.getSsurname());
                workerDto.setTelephone(user.getTelephone());
                workerDto.setUsername(user.getUsername());
                workers.add(workerDto);
            }

            return new Respuesta(true, "Error obteniendo los usuarios.", "getUsuarios ", "Usuarios", workers);
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo los usuarios.", ex);
            return new Respuesta(false, "Error obteniendo los usuarios.", "getUsuarios " + ex.getMessage());
        }
    }

    public Respuesta isTempPassword(String usuario, String clave) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();

            if (cliente.isTempPassword(usuario, clave)) {
                return new Respuesta(true, "La contraseña es temporal.", "getUsuario");
            } else {
                return new Respuesta(false, "", "");
            }
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }

    public Respuesta isAdminWorker(String usuario, String clave) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();

            if (cliente.isAnAdmin(usuario, clave)) {
                return new Respuesta(true, "La contraseña es temporal.", "getUsuario");
            } else {
                return new Respuesta(false, "", "");
            }
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }

    public Respuesta isActiveWorker(String Code) {
        try {
            ModuleWorkers_Service servicio = new ModuleWorkers_Service();
            ModuleWorkers cliente = servicio.getModuleWorkersPort();

            if (cliente.isActiveWorker(Code)) {
                return new Respuesta(true, "La contraseña es temporal.", "getUsuario");
            } else {
                return new Respuesta(false, "", "");
            }
        } catch (Exception ex) {
            Logger.getLogger(WorkersService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + Code + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }



}
