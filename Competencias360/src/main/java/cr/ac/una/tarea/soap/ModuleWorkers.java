
package cr.ac.una.tarea.soap;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ModuleWorkers", targetNamespace = "http://controller.tareaws.una.ac.cr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ModuleWorkers {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "Register")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Register", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.Register")
    @ResponseWrapper(localName = "RegisterResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.RegisterResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/RegisterRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/RegisterResponse")
    public Boolean register(
        @WebParam(name = "arg0", targetNamespace = "")
        WorkersDto arg0);

    /**
     * 
     * @param code
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "Active")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Active", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.Active")
    @ResponseWrapper(localName = "ActiveResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.ActiveResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/ActiveRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/ActiveResponse")
    public Boolean active(
        @WebParam(name = "Code", targetNamespace = "")
        String code);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "Delete")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Delete", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.Delete")
    @ResponseWrapper(localName = "DeleteResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.DeleteResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/DeleteRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/DeleteResponse")
    public Boolean delete(
        @WebParam(name = "Id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param email
     * @param password
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "ResetAccontPassword")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ResetAccontPassword", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.ResetAccontPassword")
    @ResponseWrapper(localName = "ResetAccontPasswordResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.ResetAccontPasswordResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/ResetAccontPasswordRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/ResetAccontPasswordResponse")
    public Boolean resetAccontPassword(
        @WebParam(name = "Email", targetNamespace = "")
        String email,
        @WebParam(name = "Password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param user
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "Login")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Login", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.LoginResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/LoginRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/LoginResponse")
    public Boolean login(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param user
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "IsAnAdmin")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "IsAnAdmin", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.IsAnAdmin")
    @ResponseWrapper(localName = "IsAnAdminResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.IsAnAdminResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/IsAnAdminRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/IsAnAdminResponse")
    public Boolean isAnAdmin(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param user
     * @return
     *     returns cr.ac.una.tarea.soap.WorkersDto
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUsuario", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetUsuario")
    @ResponseWrapper(localName = "getUsuarioResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetUsuarioResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/getUsuarioRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/getUsuarioResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleWorkers/getUsuario/Fault/IOException")
    })
    public WorkersDto getUsuario(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password)
        throws IOException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<cr.ac.una.tarea.soap.WorkersDto>
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetUsuarios")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetUsuarios", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetUsuarios")
    @ResponseWrapper(localName = "GetUsuariosResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetUsuariosResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/GetUsuariosRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/GetUsuariosResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleWorkers/GetUsuarios/Fault/IOException")
    })
    public List<WorkersDto> getUsuarios()
        throws IOException_Exception
    ;

    /**
     * 
     * @param password
     * @param user
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "IsTempPassword")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "IsTempPassword", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.IsTempPassword")
    @ResponseWrapper(localName = "IsTempPasswordResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.IsTempPasswordResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/IsTempPasswordRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/IsTempPasswordResponse")
    public Boolean isTempPassword(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password);

    /**
     * 
     * @param code
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "IsActiveWorker")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "IsActiveWorker", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.IsActiveWorker")
    @ResponseWrapper(localName = "IsActiveWorkerResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.IsActiveWorkerResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleWorkers/IsActiveWorkerRequest", output = "http://controller.tareaws.una.ac.cr/ModuleWorkers/IsActiveWorkerResponse")
    public Boolean isActiveWorker(
        @WebParam(name = "Code", targetNamespace = "")
        String code);

}
