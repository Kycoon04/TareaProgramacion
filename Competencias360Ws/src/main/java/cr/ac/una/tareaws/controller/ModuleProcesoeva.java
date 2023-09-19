package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.model.ProcesoevaDto;
import cr.ac.una.tareaws.service.ProcesoevaService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author jomav
 */
@WebService(serviceName = "ModuleProcesoeva")
public class ModuleProcesoeva {
    
    @EJB
    ProcesoevaService procesoevaService;
    
    @WebMethod(operationName = "RegisterProcesova")
    public Boolean RegisterProcesova(ProcesoevaDto procesoevaDto) {
        Respuesta respuesta = procesoevaService.SaveProceso(procesoevaDto);
        return respuesta.getEstado();
    }
    @WebMethod(operationName = "getProcesova")
    public ProcesoevaDto getProcesova(@WebParam(name = "Name") String Name) {
        Respuesta respuesta = procesoevaService.getProceso(Name);
        ProcesoevaDto procesoevaDto = new ProcesoevaDto((Procesoeva)respuesta.getResultado("Proceso"));
        return procesoevaDto;
    }
    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = procesoevaService.DeleteProceso(id);
        return respuesta.getEstado();
    }
}
