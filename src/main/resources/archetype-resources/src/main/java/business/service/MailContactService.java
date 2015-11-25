#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

/**
 * Interface représentant les services disponibles pour les actions
 * concernant les mails.
 * 
 * @author MAEDI
 */
public interface MailContactService {

    /**
     * 
     * @param nom
     *            nom saisi de l'utilisateur
     * @param prenom
     *            prénom saisi de l'utilisateur
     * @param fromAddress
     *            adresse saisie mail de l'utilisateur
     * @param message
     *            message saisi par l'utilisateur
     */
    void envoyerMail(
            String nom, String prenom, String fromAddress, String message);
}
