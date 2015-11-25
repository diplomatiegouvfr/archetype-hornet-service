#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.business.bo.Utilisateur;
import ${package}.integration.dao.UtilisateurDAO;

/**
 * UtilisateurServiceImpl
 * 
 * @author MAEDI
 */
public class UtilisateurServiceImpl implements UtilisateurService {

    /**
     * <code>utilisateurDAO</code> the utilisateurDAO
     */
    @SuppressWarnings("unused")
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
    public Utilisateur lireUtilisateur(final String utiId) {

        return null;
    }
}
