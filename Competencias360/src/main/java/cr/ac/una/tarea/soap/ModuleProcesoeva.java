
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
@WebService(name = "ModuleProcesoeva", targetNamespace = "http://controller.tareaws.una.ac.cr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ModuleProcesoeva {


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
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/DeleteRequest", output = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/DeleteResponse")
    public Boolean delete(
        @WebParam(name = "Id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param name
     * @return
     *     returns cr.ac.una.tarea.soap.ProcesoevaDto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProcesova", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetProcesova")
    @ResponseWrapper(localName = "getProcesovaResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetProcesovaResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/getProcesovaRequest", output = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/getProcesovaResponse")
    public ProcesoevaDto getProcesova(
        @WebParam(name = "Name", targetNamespace = "")
        String name);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "RegisterProcesova")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "RegisterProcesova", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.RegisterProcesova")
    @ResponseWrapper(localName = "RegisterProcesovaResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.RegisterProcesovaResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/RegisterProcesovaRequest", output = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/RegisterProcesovaResponse")
    public Boolean registerProcesova(
        @WebParam(name = "arg0", targetNamespace = "")
        ProcesoevaDto arg0);

    /**
     * 
     * @return
     *     returns java.util.List<cr.ac.una.tarea.soap.ProcesoevaDto>
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetProcesos")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetProcesos", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetProcesos")
    @ResponseWrapper(localName = "GetProcesosResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetProcesosResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/GetProcesosRequest", output = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/GetProcesosResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/GetProcesos/Fault/IOException")
    })
    public List<ProcesoevaDto> getProcesos()
        throws IOException_Exception
    ;

    /**
     * 
     * @param aplicacion
     * @param dto
     * @param finalizado
     * @param inicio
     */
    @WebMethod
    @RequestWrapper(localName = "setDates", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.SetDates")
    @ResponseWrapper(localName = "setDatesResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.SetDatesResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/setDatesRequest", output = "http://controller.tareaws.una.ac.cr/ModuleProcesoeva/setDatesResponse")
    public void setDates(
        @WebParam(name = "dto", targetNamespace = "")
        ProcesoevaDto dto,
        @WebParam(name = "Aplicacion", targetNamespace = "")
        String aplicacion,
        @WebParam(name = "finalizado", targetNamespace = "")
        String finalizado,
        @WebParam(name = "inicio", targetNamespace = "")
        String inicio);

}
