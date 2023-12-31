
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
@WebServiceClient(name = "ModuleResult", targetNamespace = "http://controller.tareaws.una.ac.cr/", wsdlLocation = "http://localhost:8080/Competencias360Ws/ModuleResult?wsdl")
public class ModuleResult_Service
    extends Service
{

    private static final URL MODULERESULT_WSDL_LOCATION;
    private static final WebServiceException MODULERESULT_EXCEPTION;
    private static final QName MODULERESULT_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "ModuleResult");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Competencias360Ws/ModuleResult?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MODULERESULT_WSDL_LOCATION = url;
        MODULERESULT_EXCEPTION = e;
    }

    public ModuleResult_Service() {
        super(__getWsdlLocation(), MODULERESULT_QNAME);
    }

    public ModuleResult_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MODULERESULT_QNAME, features);
    }

    public ModuleResult_Service(URL wsdlLocation) {
        super(wsdlLocation, MODULERESULT_QNAME);
    }

    public ModuleResult_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MODULERESULT_QNAME, features);
    }

    public ModuleResult_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ModuleResult_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ModuleResult
     */
    @WebEndpoint(name = "ModuleResultPort")
    public ModuleResult getModuleResultPort() {
        return super.getPort(new QName("http://controller.tareaws.una.ac.cr/", "ModuleResultPort"), ModuleResult.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ModuleResult
     */
    @WebEndpoint(name = "ModuleResultPort")
    public ModuleResult getModuleResultPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controller.tareaws.una.ac.cr/", "ModuleResultPort"), ModuleResult.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MODULERESULT_EXCEPTION!= null) {
            throw MODULERESULT_EXCEPTION;
        }
        return MODULERESULT_WSDL_LOCATION;
    }

}
