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
@WebService(serviceName = "ModuleWorkers")
public class ModuleWorkers {

    @EJB
    WorkersService workersService;

    @WebMethod(operationName = "Login")
    public Boolean Login(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) {
        Respuesta respuesta = workersService.getUsuario(User, Password);
        return respuesta.getEstado();
    }

    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = workersService.DeleteWorker(id);
        return respuesta.getEstado();
    }
    
    @WebMethod(operationName = "getUsuario")
    public WorkersDto getUsuario(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) throws IOException {
        Respuesta respuesta = workersService.getUsuario(User, Password);
        WorkersDto workerDto = new WorkersDto((Workers) respuesta.getResultado("Usuario"));
        return workerDto;
    }

    @WebMethod(operationName = "Register")
    public Boolean register(WorkersDto workerDto) {
        Respuesta respuesta = workersService.guardarEmpleado(workerDto);
        return respuesta.getEstado();
    }

    @WebMethod(operationName = "Active")
    public Boolean Active(@WebParam(name = "Code") String code) {
        WorkersDto workerDto = new WorkersDto();
        workerDto.setActive("S");
        workerDto.setCode(code);
        Respuesta respuesta = workersService.actualizarPorCodigo(workerDto);
        return respuesta.getEstado();
    }

    @WebMethod(operationName = "ResetAccontPassword")
    public Boolean ResetAccontPassword(@WebParam(name = "Email") String Email, @WebParam(name = "Password") String Password) {
        WorkersDto workerDto = new WorkersDto();
        workerDto.setEmail(Email);
        workerDto.setPassword(Password);
        workerDto.setRecover("S");
        Respuesta respuesta = workersService.actualizarContrasenaPorEmail(workerDto);
        return respuesta.getEstado();
    }

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

    @WebMethod(operationName = "IsAnAdmin")
    public Boolean IsAnAdmin(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) {
        Respuesta respuesta = workersService.isAdmin(User, Password);
        return respuesta.getEstado();
    }

    @WebMethod(operationName = "IsTempPassword")
    public Boolean IsTempPassword(@WebParam(name = "User") String User, @WebParam(name = "Password") String Password) {
        Respuesta respuesta = workersService.isTempPassword(User, Password);
        return respuesta.getEstado();
    }

    @WebMethod(operationName = "IsActiveWorker")
    public Boolean IsActiveWorker(@WebParam(name = "Code") String Code) {
        Respuesta respuesta = workersService.isIdActiveW(Code);
        return respuesta.getEstado();
    }
}
