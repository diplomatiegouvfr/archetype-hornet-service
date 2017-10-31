#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ws.factory;

import ${package}.ws.hello.IHelloService;
import hornet.framework.webservice.WsCallerHelper;

/**
 * Classe WebServiceFactory.
 * 
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class WebServiceFactory {

    /** The ws caller helper. */
    private final WsCallerHelper wsCallerHelper;

    /**
     * Instantiates a new web service factory.
     * 
     * @param wsCallerHelper
     *            the ws caller helper
     */
    public WebServiceFactory(
                final WsCallerHelper wsCallerHelper) {

        this.wsCallerHelper = wsCallerHelper;
    }

    /**
     * Gets the hello service port.
     * 
     * @return the hello service port
     */
    public IHelloService getHelloServicePort() {

        return this.wsCallerHelper.getWebService(IHelloService.class, "wsHelloService",
            "wsHelloServiceContextMap");
    }

}
