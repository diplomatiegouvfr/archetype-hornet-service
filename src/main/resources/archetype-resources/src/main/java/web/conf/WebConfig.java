#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.conf;

import hornet.framework.web.conf.HornetWebConfig;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author MAEDI
 * @since 1.0 - 2 mars 2015
 */
@Configuration
@EnableWebMvc
public class WebConfig extends HornetWebConfig {

    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {

        super.configureContentNegotiation(configurer);

        // Ajouter ici les mimeTypes des contenus gérés par l'appli

    }

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {

        super.configureMessageConverters(converters);

    }

}
