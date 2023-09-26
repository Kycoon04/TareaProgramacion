
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
@WebService(name = "ModuleComInformation", targetNamespace = "http://controller.tareaws.una.ac.cr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ModuleComInformation {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "GeneralParameters")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GeneralParameters", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GeneralParameters")
    @ResponseWrapper(localName = "GeneralParametersResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GeneralParametersResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleComInformation/GeneralParametersRequest", output = "http://controller.tareaws.una.ac.cr/ModuleComInformation/GeneralParametersResponse")
    public Boolean generalParameters(
        @WebParam(name = "arg0", targetNamespace = "")
        ComInformationDto arg0);

    /**
     * 
     * @param name
     * @return
     *     returns cr.ac.una.tarea.soap.ComInformationDto
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInformation", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetInformation")
    @ResponseWrapper(localName = "getInformationResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetInformationResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleComInformation/getInformationRequest", output = "http://controller.tareaws.una.ac.cr/ModuleComInformation/getInformationResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleComInformation/getInformation/Fault/IOException")
    })
    public ComInformationDto getInformation(
        @WebParam(name = "Name", targetNamespace = "")
        String name)
        throws IOException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<cr.ac.una.tarea.soap.ComInformationDto>
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetComInfo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetComInfo", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetComInfo")
    @ResponseWrapper(localName = "GetComInfoResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetComInfoResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleComInformation/GetComInfoRequest", output = "http://controller.tareaws.una.ac.cr/ModuleComInformation/GetComInfoResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleComInformation/GetComInfo/Fault/IOException")
    })
    public List<ComInformationDto> getComInfo()
        throws IOException_Exception
    ;

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
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleComInformation/DeleteRequest", output = "http://controller.tareaws.una.ac.cr/ModuleComInformation/DeleteResponse")
    public Boolean delete(
        @WebParam(name = "Id", targetNamespace = "")
        Integer id);

}
