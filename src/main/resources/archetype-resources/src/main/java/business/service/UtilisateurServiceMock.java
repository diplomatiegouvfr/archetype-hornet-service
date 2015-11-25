#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import org.springframework.transaction.annotation.Transactional;

import ${package}.business.bo.Utilisateur;

/**
 * @author MAEDI
 */
@Transactional
public class UtilisateurServiceMock implements UtilisateurService {

    /**
     * Méthode pour créer un utilisateur avec des données de test
     * 
     * @param id
     *            Long
     * @return le nouvel élément
     */
    private static Utilisateur fill(final String id) {

        final Utilisateur element = new Utilisateur();
        element.setUtiId(id);
        element.setNom("nom" + id);
        element.setPrenom("prenom" + id);

        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Utilisateur creerUtilisateur() {

        return this.lireUtilisateur(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Utilisateur lireUtilisateur(final String utiId) {

        return UtilisateurServiceMock.fill(utiId);
    }

}
