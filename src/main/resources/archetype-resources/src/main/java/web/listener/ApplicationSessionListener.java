#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.listener;

import hornet.framework.web.listener.HornetSessionListener;

import org.slf4j.LoggerFactory;

/**
 * @author MAEDI
 * @since 1.0 - 28 juil. 2014
 */
public final class ApplicationSessionListener extends HornetSessionListener {

    @Override
    protected void createSessionActions() {

        // Pas d'actions spécifiques
        LoggerFactory.getLogger(this.getClass()).info("Pas d'action spécifique");

    }

    @Override
    protected void destroySessionActions() {

        // Pas d'actions spécifiques
        LoggerFactory.getLogger(this.getClass()).info("Pas d'action spécifique");

    }

}
