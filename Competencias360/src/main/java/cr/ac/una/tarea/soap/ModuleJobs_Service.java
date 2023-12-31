
package cr.ac.una.tarea.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "ModuleJobs", targetNamespace = "http://controller.tareaws.una.ac.cr/", wsdlLocation = "http://localhost:8080/Competencias360Ws/ModuleJobs?wsdl")
public class ModuleJobs_Service
    extends Service
{

    private static final URL MODULEJOBS_WSDL_LOCATION;
    private static final WebServiceException MODULEJOBS_EXCEPTION;
    private static final QName MODULEJOBS_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "ModuleJobs");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Competencias360Ws/ModuleJobs?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MODULEJOBS_WSDL_LOCATION = url;
        MODULEJOBS_EXCEPTION = e;
    }

    public ModuleJobs_Service() {
        super(__getWsdlLocation(), MODULEJOBS_QNAME);
    }

    public ModuleJobs_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MODULEJOBS_QNAME, features);
    }

    public ModuleJobs_Service(URL wsdlLocation) {
        super(wsdlLocation, MODULEJOBS_QNAME);
    }

    public ModuleJobs_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MODULEJOBS_QNAME, features);
    }

    public ModuleJobs_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ModuleJobs_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ModuleJobs
     */
    @WebEndpoint(name = "ModuleJobsPort")
    public ModuleJobs getModuleJobsPort() {
        return super.getPort(new QName("http://controller.tareaws.una.ac.cr/", "ModuleJobsPort"), ModuleJobs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ModuleJobs
     */
    @WebEndpoint(name = "ModuleJobsPort")
    public ModuleJobs getModuleJobsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controller.tareaws.una.ac.cr/", "ModuleJobsPort"), ModuleJobs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MODULEJOBS_EXCEPTION!= null) {
            throw MODULEJOBS_EXCEPTION;
        }
        return MODULEJOBS_WSDL_LOCATION;
    }

}
