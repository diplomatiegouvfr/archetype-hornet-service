/*
 * Copyright ou © ou Copr. Ministère des Affaires Etrangères (2012)
 *
 * Ce logiciel est un programme informatique servant de framework J2EE basé sur les normes J2EE (DAO,JDBC,MVC
 * de Struts) et les principes multi-X (multi-couches, multi-canal, multi-formats, multi-langues). Il offre la
 * possibilité de générer facilement des flux XML métier pour consulter ou mettre à jour des sources de
 * données et s'interfacer avec le client riche ACube. Ce logiciel est régi par la licence CeCILL soumise au
 * droit français et respectant les principes de diffusion des logiciels libres. Vous pouvez utiliser,
 * modifier et/ou redistribuer ce programme sous les conditions de la licence CeCILL telle que diffusée par le
 * CEA, le CNRS et l'INRIA sur le site "http://www.cecill.info".
 *
 * En contrepartie de l'accessibilité au code source et des droits de copie, de modification et de
 * redistribution accordés par cette licence, il n'est offert aux utilisateurs qu'une garantie limitée. Pour
 * les mêmes raisons, seule une responsabilité restreinte pèse sur l'auteur du programme, le titulaire des
 * droits patrimoniaux et les concédants successifs.
 *
 * A cet égard l'attention de l'utilisateur est attirée sur les risques associés au chargement, à
 * l'utilisation, à la modification et/ou au développement et à la reproduction du logiciel par l'utilisateur
 * étant donné sa spécificité de logiciel libre, qui peut le rendre complexe à manipuler et qui le réserve
 * donc à des développeurs et des professionnels avertis possédant des connaissances informatiques
 * approfondies. Les utilisateurs sont donc invités à charger et tester l'adéquation du logiciel à leurs
 * besoins dans des conditions permettant d'assurer la sécurité de leurs systèmes et ou de leurs données et,
 * plus généralement, à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.
 *
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez pris connaissance de la licence
 * CeCILL, et que vous en avez accepté les termes.
 */
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Intercepteur Spring permettant de logguer l'id de l'utilisateur effectuant une requête quand cet id est
 * fourni
 *
 * @author Hornet
 * @since 1.0 - 15 juil. 2015
 */
public class UserRequestingInterceptor extends HandlerInterceptorAdapter {

    private static final String TID = "tid";
    private static final String USER = "user";
    private static final String ROLE = "role";
    
    private static final Logger LOG = LoggerFactory.getLogger(UserRequestingInterceptor.class);

    /**
     * Log le début de l'action de l'utilisateur
     */
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                final Object handler) throws Exception {
    	
    	final Object tid = request.getParameter(TID);
        if (tid != null) {
            MDC.put("tid", tid);
        }
        
        final Object userName = request.getParameter(USER);
        if (userName != null) {
            MDC.put("user", userName);
        }

        LOG.info("DEBUT Action de la session node : {}", tid);
        LOG.info("DEBUT Action de l'utilisateur: {}", userName);

    	final Object role = request.getParameter(ROLE);
        LOG.info("Récupération des rôles : {}", role);
        
        return true;
    }

    /**
     * Log la fin de l'action de l'utilisateur
     */
    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response,
                final Object handler, final ModelAndView modelAndView) throws Exception {

        final Object tid = request.getParameter(TID);
        final Object userName = request.getParameter(USER);
        
        LOG.info("FIN Action de la session node : {}", tid);
        LOG.info("FIN Action de l'utilisateur: {}", userName);
        
        if (tid != null) {
            MDC.remove("tid");
        }
        
        if (userName != null) {
            MDC.remove("user");
        }


    }

}
