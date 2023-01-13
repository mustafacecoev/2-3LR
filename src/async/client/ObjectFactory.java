
package async.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the async.client package. 
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

    private final static QName _ReserveCars_QNAME = new QName("http://asu.dgtu.donetsk.ua/ex/students", "ReserveCars");
    private final static QName _ReserveCarsResponse_QNAME = new QName("http://asu.dgtu.donetsk.ua/ex/students", "ReserveCarsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: async.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReserveCarsResponse }
     * 
     */
    public ReserveCarsResponse createReserveCarsResponse() {
        return new ReserveCarsResponse();
    }

    /**
     * Create an instance of {@link ReserveCars }
     * 
     */
    public ReserveCars createReserveCars() {
        return new ReserveCars();
    }

    /**
     * Create an instance of {@link Cars }
     * 
     */
    public Cars createCars() {
        return new Cars();
    }

    /**
     * Create an instance of {@link UserReserve }
     * 
     */
    public UserReserve createUserReserve() {
        return new UserReserve();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveCars }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://asu.dgtu.donetsk.ua/ex/students", name = "ReserveCars")
    public JAXBElement<ReserveCars> createReserveCars(ReserveCars value) {
        return new JAXBElement<ReserveCars>(_ReserveCars_QNAME, ReserveCars.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveCarsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://asu.dgtu.donetsk.ua/ex/students", name = "ReserveCarsResponse")
    public JAXBElement<ReserveCarsResponse> createReserveCarsResponse(ReserveCarsResponse value) {
        return new JAXBElement<ReserveCarsResponse>(_ReserveCarsResponse_QNAME, ReserveCarsResponse.class, null, value);
    }

}
