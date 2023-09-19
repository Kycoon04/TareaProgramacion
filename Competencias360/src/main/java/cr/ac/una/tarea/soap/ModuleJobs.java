
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
@WebService(name = "ModuleJobs", targetNamespace = "http://controller.tareaws.una.ac.cr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ModuleJobs {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "RegisterJob")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "RegisterJob", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.RegisterJob")
    @ResponseWrapper(localName = "RegisterJobResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.RegisterJobResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleJobs/RegisterJobRequest", output = "http://controller.tareaws.una.ac.cr/ModuleJobs/RegisterJobResponse")
    public Boolean registerJob(
        @WebParam(name = "arg0", targetNamespace = "")
        JobsDto arg0);

    /**
     * 
     * @return
     *     returns java.util.List<cr.ac.una.tarea.soap.JobsDto>
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetJobs")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetJobs", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetJobs")
    @ResponseWrapper(localName = "GetJobsResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetJobsResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleJobs/GetJobsRequest", output = "http://controller.tareaws.una.ac.cr/ModuleJobs/GetJobsResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleJobs/GetJobs/Fault/IOException")
    })
    public List<JobsDto> getJobs()
        throws IOException_Exception
    ;

    /**
     * 
     * @param name
     * @return
     *     returns cr.ac.una.tarea.soap.JobsDto
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getJob", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetJob")
    @ResponseWrapper(localName = "getJobResponse", targetNamespace = "http://controller.tareaws.una.ac.cr/", className = "cr.ac.una.tarea.soap.GetJobResponse")
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleJobs/getJobRequest", output = "http://controller.tareaws.una.ac.cr/ModuleJobs/getJobResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://controller.tareaws.una.ac.cr/ModuleJobs/getJob/Fault/IOException")
    })
    public JobsDto getJob(
        @WebParam(name = "Name", targetNamespace = "")
        String name)
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
    @Action(input = "http://controller.tareaws.una.ac.cr/ModuleJobs/DeleteRequest", output = "http://controller.tareaws.una.ac.cr/ModuleJobs/DeleteResponse")
    public Boolean delete(
        @WebParam(name = "Id", targetNamespace = "")
        Integer id);

}
