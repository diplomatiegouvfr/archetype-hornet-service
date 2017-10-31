#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.dto.contact;

/**
 * Entité metier Mail.
 * 
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class ContactEnvoyerDTOIn {

    private String nom;

    private String prenom;

    private String mail;

    private String message;

    /**
     * @return nom
     */
    public String getNom() {

        return nom;
    }

    /**
     * @param nom
     *            nom
     */
    public void setNom(final String nom) {

        this.nom = nom;
    }

    /**
     * @return prenom
     */
    public String getPrenom() {

        return prenom;
    }

    /**
     * @param prenom
     *            prenom
     */
    public void setPrenom(final String prenom) {

        this.prenom = prenom;
    }

    /**
     * @return mail
     */
    public String getMail() {

        return mail;
    }

    /**
     * @param mail
     *            mail
     */
    public void setMail(final String mail) {

        this.mail = mail;
    }

    /**
     * @return message
     */
    public String getMessage() {

        return message;
    }

    /**
     * @param message
     *            message
     */
    public void setMessage(final String message) {

        this.message = message;
    }

}
