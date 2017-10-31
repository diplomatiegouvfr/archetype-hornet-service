#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.conf;

import hornet.framework.web.conf.HornetWebConfig;
import hornet.framework.web.converter.CsvHttpMessageConverter;
import hornet.framework.web.converter.HornetMediaType;
//import hornet.framework.web.converter.PdfHttpMessageConverter;
//import hornet.framework.web.converter.XlsHttpMessageConverter;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 * @since 1.0 - 2 mars 2015
 */
@Configuration
@EnableWebMvc
public class WebConfig extends HornetWebConfig {

//    @Resource
//    private XlsHttpMessageConverter<?> xlsConverter;
//
//    @Resource
//    private CsvHttpMessageConverter<?> csvConverter;
//
//    @Resource
//    private PdfHttpMessageConverter<?> pdfConverter;

    
    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {

        super.configureContentNegotiation(configurer);

        // Ajouter ici les mimeTypes des contenus gérés par l'appli
        configurer.mediaType("pdf", HornetMediaType.APPLICATION_PDF)
                    .mediaType("xls", HornetMediaType.APPLICATION_EXCEL)
                    .mediaType("csv", HornetMediaType.TEXT_CSV);
    }

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {

        super.configureMessageConverters(converters);

        // Ajouter ici les converter permettant de gérer les différents types de contenus
//        converters.add(xlsConverter);
//        converters.add(csvConverter);
//        converters.add(pdfConverter);
    }

}
