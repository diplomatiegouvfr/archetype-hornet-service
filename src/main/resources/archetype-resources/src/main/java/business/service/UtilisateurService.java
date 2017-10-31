#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.business.bo.Utilisateur;
import hornet.framework.web.service.UtilisateurWebService;

/**
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public interface UtilisateurService extends UtilisateurWebService<Utilisateur> {

    /**
    *
    * @return Utilisateur
    */
   // @Override
   Utilisateur creerUtilisateur();

   /**
    *
    * @param login
    *            String
    * @return Utilisateur
    */
   @Override
   Utilisateur lireUtilisateur(String login);

   /**
    * Lecture de l'utilisateur à partir du login et du password retourn null si le password ne correspond pas
    *
    * @param login
    * @param password
    *            (préalablement encrypté par l'appelant)
    * @return
    */
   Utilisateur lireUtilisateur(String login, String password);

}
