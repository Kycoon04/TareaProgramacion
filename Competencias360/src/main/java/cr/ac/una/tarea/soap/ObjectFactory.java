
package cr.ac.una.tarea.soap;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cr.ac.una.tarea.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _Delete_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "Delete");
    private static final QName _DeleteResponse_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "DeleteResponse");
    private static final QName _IOException_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "IOException");
    private static final QName _RegisterCharacteristic_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "RegisterCharacteristic");
    private static final QName _RegisterCharacteristicResponse_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "RegisterCharacteristicResponse");
    private static final QName _FindByCcName_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "findByCcName");
    private static final QName _FindByCcNameResponse_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "findByCcNameResponse");
    private static final QName _GetByCcId_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "getByCcId");
    private static final QName _GetByCcIdResponse_QNAME = new QName("http://controller.tareaws.una.ac.cr/", "getByCcIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cr.ac.una.tarea.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Delete }
     * 
     * @return
     *     the new instance of {@link Delete }
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     * @return
     *     the new instance of {@link DeleteResponse }
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     * @return
     *     the new instance of {@link IOException }
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link RegisterCharacteristic }
     * 
     * @return
     *     the new instance of {@link RegisterCharacteristic }
     */
    public RegisterCharacteristic createRegisterCharacteristic() {
        return new RegisterCharacteristic();
    }

    /**
     * Create an instance of {@link RegisterCharacteristicResponse }
     * 
     * @return
     *     the new instance of {@link RegisterCharacteristicResponse }
     */
    public RegisterCharacteristicResponse createRegisterCharacteristicResponse() {
        return new RegisterCharacteristicResponse();
    }

    /**
     * Create an instance of {@link FindByCcName }
     * 
     * @return
     *     the new instance of {@link FindByCcName }
     */
    public FindByCcName createFindByCcName() {
        return new FindByCcName();
    }

    /**
     * Create an instance of {@link FindByCcNameResponse }
     * 
     * @return
     *     the new instance of {@link FindByCcNameResponse }
     */
    public FindByCcNameResponse createFindByCcNameResponse() {
        return new FindByCcNameResponse();
    }

    /**
     * Create an instance of {@link GetByCcId }
     * 
     * @return
     *     the new instance of {@link GetByCcId }
     */
    public GetByCcId createGetByCcId() {
        return new GetByCcId();
    }

    /**
     * Create an instance of {@link GetByCcIdResponse }
     * 
     * @return
     *     the new instance of {@link GetByCcIdResponse }
     */
    public GetByCcIdResponse createGetByCcIdResponse() {
        return new GetByCcIdResponse();
    }

    /**
     * Create an instance of {@link CharacteristicDto }
     * 
     * @return
     *     the new instance of {@link CharacteristicDto }
     */
    public CharacteristicDto createCharacteristicDto() {
        return new CharacteristicDto();
    }

    /**
     * Create an instance of {@link Competences }
     * 
     * @return
     *     the new instance of {@link Competences }
     */
    public Competences createCompetences() {
        return new Competences();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "Delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "DeleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterCharacteristic }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterCharacteristic }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "RegisterCharacteristic")
    public JAXBElement<RegisterCharacteristic> createRegisterCharacteristic(RegisterCharacteristic value) {
        return new JAXBElement<>(_RegisterCharacteristic_QNAME, RegisterCharacteristic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterCharacteristicResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterCharacteristicResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "RegisterCharacteristicResponse")
    public JAXBElement<RegisterCharacteristicResponse> createRegisterCharacteristicResponse(RegisterCharacteristicResponse value) {
        return new JAXBElement<>(_RegisterCharacteristicResponse_QNAME, RegisterCharacteristicResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCcName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByCcName }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "findByCcName")
    public JAXBElement<FindByCcName> createFindByCcName(FindByCcName value) {
        return new JAXBElement<>(_FindByCcName_QNAME, FindByCcName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCcNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByCcNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "findByCcNameResponse")
    public JAXBElement<FindByCcNameResponse> createFindByCcNameResponse(FindByCcNameResponse value) {
        return new JAXBElement<>(_FindByCcNameResponse_QNAME, FindByCcNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByCcId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetByCcId }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "getByCcId")
    public JAXBElement<GetByCcId> createGetByCcId(GetByCcId value) {
        return new JAXBElement<>(_GetByCcId_QNAME, GetByCcId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByCcIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetByCcIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.tareaws.una.ac.cr/", name = "getByCcIdResponse")
    public JAXBElement<GetByCcIdResponse> createGetByCcIdResponse(GetByCcIdResponse value) {
        return new JAXBElement<>(_GetByCcIdResponse_QNAME, GetByCcIdResponse.class, null, value);
    }

}
