#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IHelloService", targetNamespace = "http://hello.ws.bouchonwebservice.hornet.diplomatie.gouv.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IHelloService {


    /**
     * 
     * @param caller
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "say", targetNamespace = "http://hello.ws.bouchonwebservice.hornet.diplomatie.gouv.fr/", className = "${package}.ws.hello.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://hello.ws.bouchonwebservice.hornet.diplomatie.gouv.fr/", className = "${package}.ws.hello.SayResponse")
    public String say(
        @WebParam(name = "caller", targetNamespace = "")
        String caller);

}
