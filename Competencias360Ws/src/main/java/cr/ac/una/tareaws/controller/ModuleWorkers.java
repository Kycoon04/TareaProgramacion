package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Workers;
import cr.ac.una.tareaws.service.WorkersService;
import cr.ac.una.tareaws.model.WorkersDto;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jomav
 */
/**
 * Clase que implementa un servicio web para gestionar los trabajadores
 * (Workers). Este servicio proporciona operaciones como inicio de sesión,
 * eliminación, registro de trabajadores, activación, restablecimiento de
 * contraseña, obtención de usuarios, comprobación de administradores,
 * comprobación de contraseña temporal y comprobación de trabajadores activos.
 * Se utiliza anotaciones JAX-WS para exponer los métodos como operaciones web.
 */
@WebService(serviceName = "ModuleWorkers")
public class ModuleWorkers {

    @EJB
    WorkersService workersService;

    /**
     * Realiza la autenticación de un trabajador mediante el nombre de usuario y
     * contraseña proporcionados.
     *
     * @param User El nombre de usuario del trabajador.
     * @param Password La contraseña del trabajador.
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "Login")
    public Boolean Login(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) {
        Respuesta respuesta = workersService.getUsuario(User, Password);
        return respuesta.getEstado();
    }

    /**
     * Elimina un trabajador por su ID.
     *
     * @param id El ID del trabajador a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = workersService.DeleteWorker(id);
        return respuesta.getEstado();
    }

    /**
     * Obtiene un trabajador por su nombre de usuario y contraseña.
     *
     * @param User El nombre de usuario del trabajador.
     * @param Password La contraseña del trabajador.
     * @return Un objeto WorkersDto que representa al trabajador.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "getUsuario")
    public WorkersDto getUsuario(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) throws IOException {
        Respuesta respuesta = workersService.getUsuario(User, Password);
        WorkersDto workerDto = new WorkersDto((Workers) respuesta.getResultado("Usuario"));
        return workerDto;
    }

    /**
     * Registra un nuevo trabajador.
     *
     * @param workerDto Un objeto WorkersDto que contiene la información del
     * trabajador a registrar.
     * @return true si la operación de registro fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Register")
    public Boolean register(WorkersDto workerDto) {
        Respuesta respuesta = workersService.guardarEmpleado(workerDto);
        return respuesta.getEstado();
    }

    /**
     * Activa un trabajador por su código.
     *
     * @param code El código del trabajador a activar.
     * @return true si la operación de activación fue exitosa, false en caso
     * contrario.
     */
    @WebMethod(operationName = "Active")
    public Boolean Active(@WebParam(name = "Code") String code) {
        WorkersDto workerDto = new WorkersDto();
        workerDto.setActive("S");
        workerDto.setCode(code);
        Respuesta respuesta = workersService.actualizarPorCodigo(workerDto);
        return respuesta.getEstado();
    }

    /**
     * Restablece la contraseña de la cuenta de un trabajador por su correo
     * electrónico y nueva contraseña.
     *
     * @param Email El correo electrónico del trabajador.
     * @param Password La nueva contraseña.
     * @return true si la operación de restablecimiento de contraseña fue
     * exitosa, false en caso contrario.
     */
    @WebMethod(operationName = "ResetAccontPassword")
    public Boolean ResetAccontPassword(@WebParam(name = "Email") String Email, @WebParam(name = "Password") String Password) {
        WorkersDto workerDto = new WorkersDto();
        workerDto.setEmail(Email);
        workerDto.setPassword(Password);
        workerDto.setRecover("S");
        Respuesta respuesta = workersService.actualizarContrasenaPorEmail(workerDto);
        return respuesta.getEstado();
    }

    /**
     * Obtiene una lista de todos los trabajadores registrados.
     *
     * @return Una lista de objetos WorkersDto que representan a los
     * trabajadores.
     * @throws IOException Si ocurre un error al acceder a los datos.
     */
    @WebMethod(operationName = "GetUsuarios")
    public List<WorkersDto> GetUsuarios() throws IOException {
        Respuesta respuesta = workersService.getUsuarios();
        List<Workers> worker = (List<Workers>) respuesta.getResultado("Usuarios");
        List<WorkersDto> workersDto = new ArrayList<>();
        for (Workers w : worker) {
            WorkersDto workerDto = new WorkersDto(w);
            workersDto.add(workerDto);
        }
        return workersDto;
    }

    /**
     * Verifica si un trabajador tiene permisos de administrador basados en su
     * nombre de usuario y contraseña.
     *
     * @param User El nombre de usuario del trabajador.
     * @param Password La contraseña del trabajador.
     * @return true si el trabajador tiene permisos de administrador, false en
     * caso contrario.
     */
    @WebMethod(operationName = "IsAnAdmin")
    public Boolean IsAnAdmin(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) {
        Respuesta respuesta = workersService.isAdmin(User, Password);
        return respuesta.getEstado();
    }

    /**
     * Verifica si la contraseña de un trabajador es temporal basado en su
     * nombre de usuario y contraseña.
     *
     * @param User El nombre de usuario del trabajador.
     * @param Password La contraseña del trabajador.
     * @return true si la contraseña del trabajador es temporal, false en caso
     * contrario.
     */
    @WebMethod(operationName = "IsTempPassword")
    public Boolean IsTempPassword(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) {
        Respuesta respuesta = workersService.isTempPassword(User, Password);
        return respuesta.getEstado();
    }

    /**
     * Verifica si un trabajador está activo basado en su código.
     *
     * @param Code El código del trabajador.
     * @return true si el trabajador está activo, false en caso contrario.
     */
    @WebMethod(operationName = "IsActiveWorker")
    public Boolean IsActiveWorker(@WebParam(name = "Code") String Code) {
        Respuesta respuesta = workersService.isIdActiveW(Code);
        return respuesta.getEstado();
    }
}
