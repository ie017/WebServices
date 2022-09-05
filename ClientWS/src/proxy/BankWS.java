
package proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BankWS", targetNamespace = "http://WS/", wsdlLocation = "http://localhost:9091/BankWS?wsdl")
public class BankWS
    extends Service
{

    private final static URL BANKWS_WSDL_LOCATION;
    private final static WebServiceException BANKWS_EXCEPTION;
    private final static QName BANKWS_QNAME = new QName("http://WS/", "BankWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9091/BankWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANKWS_WSDL_LOCATION = url;
        BANKWS_EXCEPTION = e;
    }

    public BankWS() {
        super(__getWsdlLocation(), BANKWS_QNAME);
    }

    public BankWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANKWS_QNAME, features);
    }

    public BankWS(URL wsdlLocation) {
        super(wsdlLocation, BANKWS_QNAME);
    }

    public BankWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANKWS_QNAME, features);
    }

    public BankWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BanqueService
     */
    @WebEndpoint(name = "BanqueServicePort")
    public BanqueService getBanqueServicePort() {
        return super.getPort(new QName("http://WS/", "BanqueServicePort"), BanqueService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BanqueService
     */
    @WebEndpoint(name = "BanqueServicePort")
    public BanqueService getBanqueServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WS/", "BanqueServicePort"), BanqueService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKWS_EXCEPTION!= null) {
            throw BANKWS_EXCEPTION;
        }
        return BANKWS_WSDL_LOCATION;
    }

}
