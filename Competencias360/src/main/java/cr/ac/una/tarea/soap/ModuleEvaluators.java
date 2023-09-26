
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
@WebService(name = "ModuleEvaluators", targetNamespace = "http://controller.tareaws.una.ac.cr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ModuleEvaluators {


    /**
     * 
     * @return
     *     returns java.util.List<cr.ac.una.tarea.soap.EvaluatorsDto>
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetEvaluators")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetEvaluators", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluators")
    @ResponseWrapper(localName = "GetEvaluatorsResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluatorsResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorsRequest", output = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorsResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluators/Fault/IOException")
    })
    public List<EvaluatorsDto> getEvaluators()
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
    @RequestWrapper(localName = "setAllDates", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.SetAllDates")
    @ResponseWrapper(localName = "setAllDatesResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.SetAllDatesResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/setAllDatesRequest", output = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/setAllDatesResponse")
    public void setAllDates(
        @WebParam(name = "dto", targetNamespace = "")
        Procesoeva dto,
        @WebParam(name = "Aplicacion", targetNamespace = "")
        String aplicacion,
        @WebParam(name = "finalizado", targetNamespace = "")
        String finalizado,
        @WebParam(name = "inicio", targetNamespace = "")
        String inicio);

    /**
     * 
     * @param id
     * @return
     *     returns cr.ac.una.tarea.soap.EvaluatorsDto
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetEvaluatorById")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetEvaluatorById", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluatorById")
    @ResponseWrapper(localName = "GetEvaluatorByIdResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluatorByIdResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByIdRequest", output = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByIdResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorById/Fault/IOException")
    })
    public EvaluatorsDto getEvaluatorById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id)
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "RegisterEvaluators")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "RegisterEvaluators", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.RegisterEvaluators")
    @ResponseWrapper(localName = "RegisterEvaluatorsResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.RegisterEvaluatorsResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/RegisterEvaluatorsRequest", output = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/RegisterEvaluatorsResponse")
    public Boolean registerEvaluators(
        @WebParam(name = "arg0", targetNamespace = "")
        EvaluatorsDto arg0);

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
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/DeleteRequest", output = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/DeleteResponse")
    public Boolean delete(
        @WebParam(name = "Id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param state
     * @return
     *     returns cr.ac.una.tarea.soap.EvaluatorsDto
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetEvaluatorByState")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetEvaluatorByState", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluatorByState")
    @ResponseWrapper(localName = "GetEvaluatorByStateResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluatorByStateResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByStateRequest", output = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByStateResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByState/Fault/IOException")
    })
    public EvaluatorsDto getEvaluatorByState(
        @WebParam(name = "state", targetNamespace = "")
        String state)
        throws IOException_Exception
    ;

    /**
     * 
     * @param feedBack
     * @return
     *     returns cr.ac.una.tarea.soap.EvaluatorsDto
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetEvaluatorByFeedBack")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetEvaluatorByFeedBack", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluatorByFeedBack")
    @ResponseWrapper(localName = "GetEvaluatorByFeedBackResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetEvaluatorByFeedBackResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByFeedBackRequest", output = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByFeedBackResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleEvaluators/GetEvaluatorByFeedBack/Fault/IOException")
    })
    public EvaluatorsDto getEvaluatorByFeedBack(
        @WebParam(name = "FeedBack", targetNamespace = "")
        String feedBack)
        throws IOException_Exception
    ;

}
