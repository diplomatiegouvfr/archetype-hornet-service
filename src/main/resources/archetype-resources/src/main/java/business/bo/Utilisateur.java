#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.bo;

import java.io.Serializable;

/**
 * Entité metier Utilisateur.
 * 
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class Utilisateur implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The uti id. */
    private Long utiId;

    /** The login. */
    private String login;

    /**
     * Instantiates a new utilisateur.
     */
    public Utilisateur() {

        super();
    }

    /**
     * @param l
     * @param string
     */
    public Utilisateur(
                final Long utiId, final String login) {

        this.utiId = utiId;
        this.login = login;
    }

    /**
     * Gets the uti id.
     *
     * @return Returns the utiId.
     */
    public Long getUtiId() {

        return this.utiId;
    }

    /**
     * Sets the uti id.
     *
     * @param utiId
     *            The utiId to set.
     */
    public void setUtiId(final Long utiId) {

        this.utiId = utiId;
    }

    /**
     * Gets the login.
     *
     * @return Returns the login.
     */
    public String getLogin() {

        return this.login;
    }

    /**
     * Sets the login.
     *
     * @param login
     *            The login to set.
     */
    public void setLogin(final String login) {

        this.login = login;
    }

    /*
     * (non-Javadoc)
     * 
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("Utilisateur [utiId=").append(utiId).append(", login=").append(login).append("]");
        return builder.toString();
    }
}
