#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.bo;

import java.io.Serializable;

/**
 * Entité metier Utilisateur.
 * 
 * @author MAEDI
 */
public class Utilisateur implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The uti id. */
    private String utiId;

    /** The nom. */
    private String nom;

    /** The prenom. */
    private String prenom;

    /**
     * Instantiates a new utilisateur.
     */
    public Utilisateur() {

        super();
    }

    /**
     * Instantiates a new utilisateur.
     * 
     * @param utiId
     *            the uti id
     * @param nom
     *            the nom
     * @param prenom
     *            the prenom
     */
    public Utilisateur(
                final String utiId, final String nom, final String prenom) {

        super();
        this.utiId = utiId;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Gets the uti id.
     * 
     * @return Returns the utiId.
     */
    public String getUtiId() {

        return this.utiId;
    }

    /**
     * Sets the uti id.
     * 
     * @param utiId
     *            The utiId to set.
     */
    public void setUtiId(final String utiId) {

        this.utiId = utiId;
    }

    /**
     * Gets the nom.
     * 
     * @return Returns the nom.
     */
    public String getNom() {

        return this.nom;
    }

    /**
     * Sets the nom.
     * 
     * @param nom
     *            The nom to set.
     */
    public void setNom(final String nom) {

        this.nom = nom;
    }

    /**
     * Gets the prenom.
     * 
     * @return Returns the prenom.
     */
    public String getPrenom() {

        return this.prenom;
    }

    /**
     * Sets the prenom.
     * 
     * @param prenom
     *            The prenom to set.
     */
    public void setPrenom(final String prenom) {

        this.prenom = prenom;
    }

    /**
     * Retourne le nom complet d'un utilisateur (prénom + nom).
     * 
     * @return String
     */
    public String getNomComplet() {

        return this.prenom + " " + this.nom;
    }

}
