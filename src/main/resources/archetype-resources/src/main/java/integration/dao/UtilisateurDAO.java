#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.integration.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Classe DAO pour les entités Utilisateur
 * 
 * @author MAEDI
 */
public class UtilisateurDAO extends SqlSessionDaoSupport {

    /**
     * Constructeur
     */
    public UtilisateurDAO() {

        super();
    }
}
