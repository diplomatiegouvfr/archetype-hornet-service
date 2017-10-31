#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.business.bo.Utilisateur;
import ${package}.integration.dao.UtilisateurDAO;

/**
 * UtilisateurServiceImpl
 * 
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class UtilisateurServiceImpl implements UtilisateurService {

	/**
     * <code>utilisateurDAO</code> the utilisateurDAO
     */
    private final transient UtilisateurDAO utilisateurDAO;

    /**
     * Constructeur par défaut
     *
     */
    public UtilisateurServiceImpl() {

        super();
        this.utilisateurDAO = null;
    }

    /**
     * Constructeur
     *
     * @param utilisateurDAO
     *            UtilisateurDAO
     */
    public UtilisateurServiceImpl(
                final UtilisateurDAO utilisateurDAO) {

        super();
        this.utilisateurDAO = utilisateurDAO;
    }

    /** {@inheritDoc} */
    @Override
    public Utilisateur creerUtilisateur() {

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Utilisateur lireUtilisateur(final String login) {

        return utilisateurDAO.selectByLogin(login);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.lang.String)
     */
    @Override
    public Utilisateur lireUtilisateur(final String login, final String password) {

        return utilisateurDAO.selectByLoginPassword(login, password);
    }
}
