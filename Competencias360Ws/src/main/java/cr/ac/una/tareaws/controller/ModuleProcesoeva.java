package cr.ac.una.tareaws.controller;

import cr.ac.una.tareaws.model.Procesoeva;
import cr.ac.una.tareaws.model.ProcesoevaDto;
import cr.ac.una.tareaws.service.ProcesoevaService;
import cr.ac.una.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        ProcesoevaDto procesoevaDto = new ProcesoevaDto((Procesoeva) respuesta.getResultado("Proceso"));
        return procesoevaDto;
    }

    @WebMethod(operationName = "Delete")
    public Boolean Delete(@WebParam(name = "Id") Integer id) {
        Respuesta respuesta = procesoevaService.DeleteProceso(id);
        return respuesta.getEstado();
    }

    @WebMethod(operationName = "setDates")
    public void setDates(@WebParam(name = "dto") ProcesoevaDto procesodto, @WebParam(name = "Aplicacion") String Aplicacion,@WebParam(name = "finalizado") String finalizado,@WebParam(name = "inicio") String inicio) {
        procesodto.setApplication(Aplicacion);
        procesodto.setFinalperiod(finalizado);
        procesodto.setInicialperiod(inicio);
        RegisterProcesova(procesodto);
    }
    
    @WebMethod(operationName = "GetProcesos")
    public List<ProcesoevaDto> GetProcesos() throws IOException {
        Respuesta respuesta = procesoevaService.getProcesos();
        List<Procesoeva> poc = (List<Procesoeva>) respuesta.getResultado("Procesos");
        List<ProcesoevaDto> procesoevaDtos = new ArrayList<>();
        for (Procesoeva j : poc) {
            ProcesoevaDto procesoevaDto = new ProcesoevaDto(j);
            procesoevaDtos.add(procesoevaDto);
        }
        return procesoevaDtos;
    }
    
}
     