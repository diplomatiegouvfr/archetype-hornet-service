#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.business.bo.Utilisateur;
import hornet.framework.web.service.UtilisateurWebService;

/**
 * @author MAEDI
 */
public interface UtilisateurService extends UtilisateurWebService<Utilisateur> {

    /**
     * 
     * @return Utilisateur
     */
    //@Override
    Utilisateur creerUtilisateur();

    /**
     * 
     * @param utiId
     *            String
     * @return Utilisateur
     */
    @Override
    Utilisateur lireUtilisateur(String utiId);

}
