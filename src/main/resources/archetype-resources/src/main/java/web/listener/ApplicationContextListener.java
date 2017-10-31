#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.listener;

import hornet.framework.web.listener.HornetContextListener;

import org.slf4j.LoggerFactory;

/**
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 * @since 1.0 - 28 juil. 2014
 */
public final class ApplicationContextListener extends HornetContextListener {

    @Override
    protected void initContextActions() {

        // Pas d'actions spécifiques
        LoggerFactory.getLogger(this.getClass()).debug("Pas d'action spécifique");

    }

    @Override
    protected void destroyContextActions() {

        // Pas d'actions spécifiques
        LoggerFactory.getLogger(this.getClass()).debug("Pas d'action spécifique");

    }

    @Override
    protected String getContext() {

        return "${artifactId}";
    }

}
